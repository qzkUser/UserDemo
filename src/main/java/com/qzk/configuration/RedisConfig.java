package com.qzk.configuration;

import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
@EnableCaching
@Log4j
public class RedisConfig extends CachingConfigurerSupport{
	//private final Logger logger = Logger.getLogger(RedisConfig.class);

    private RelaxedPropertyResolver propertyResolver;

    @Autowired
    public void setEnvironment(Environment env) {
        this.propertyResolver = new RelaxedPropertyResolver(env, "spring.redis.");
    }
    
    
    @Bean(name= "jedis.pool.config")  
    public JedisPoolConfig jedisPoolConfig () {
    	JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(Integer.valueOf(propertyResolver.getProperty("pool.max-idle")));
        jedisPoolConfig.setMaxWaitMillis(Integer.valueOf(propertyResolver.getProperty("pool.max-wait")));
        return jedisPoolConfig;
    }
    
    @Bean
    //@SneakyThrows
    public JedisConnectionFactory redisConnectionFactory(@Qualifier("jedis.pool.config") JedisPoolConfig jedisPoolConfig) {
        JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();  
        // Defaults
        log.info("redis地址为:" + propertyResolver.getProperty("host") + ":" + propertyResolver.getProperty("port"));
        redisConnectionFactory.setHostName(propertyResolver.getProperty("host"));
        redisConnectionFactory.setPort(Integer.valueOf(propertyResolver.getProperty("port")));
        //String password = QEncodeUtil.aesDecrypt(propertyResolver.getProperty("password"), "public");
        //redisConnectionFactory.setPassword("");
        redisConnectionFactory.setPoolConfig(jedisPoolConfig);
        log.info("注入成功");
        return redisConnectionFactory;
    }
    
    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory cf) {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
        redisTemplate.setConnectionFactory(cf);
        return redisTemplate;
    }
    
    @Bean  
    public CacheManager cacheManager(@SuppressWarnings("rawtypes") RedisTemplate redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
        cacheManager.setDefaultExpiration(3000);
        return cacheManager;
    }
    
    

    /*@Bean
    @SneakyThrows
    public JedisPool redisPoolFactory(@Qualifier("jedis.pool.config") JedisPoolConfig jedisPoolConfig) {
        logger.info("redis地址：" + propertyResolver.getProperty("host") +
                ":" + propertyResolver.getProperty("port"));
        //解密密码
        String password = QEncodeUtil.aesDecrypt(propertyResolver.getProperty("password"), "public");
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, propertyResolver.getProperty("host"),
                  Integer.valueOf(propertyResolver.getProperty("port")),
                  Integer.valueOf(propertyResolver.getProperty("timeout")), password, 0);
        System.out.println("====="+Integer.valueOf(propertyResolver.getProperty("timeout")));
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, propertyResolver.getProperty("host"),
                  Integer.valueOf(propertyResolver.getProperty("port")),
                  Integer.valueOf(propertyResolver.getProperty("timeout")), password);
        logger.info("jedisPool注入成功！！");
        
        System.out.println(jedisPool.getResource().get("q1"));
        
        return jedisPool;
    }*/
}
