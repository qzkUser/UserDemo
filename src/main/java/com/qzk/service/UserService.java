package com.qzk.service;

import com.qzk.dao.UserDao;
import com.qzk.exception.ServiceRuntimeException;
import com.qzk.model.User;
import com.qzk.model.User.UserBuilder;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	@SneakyThrows(ServiceRuntimeException.class)
	public boolean addUser(String username, String password) {
		return userDao.insertUser(username, password) == 1 ? true : false;
	}

	@SneakyThrows(ServiceRuntimeException.class)
	public UserBuilder loginUser(String username, String password) {
		return userDao.loginUser(username, password);
	}

	@SneakyThrows(ServiceRuntimeException.class)
	public User addUserWithBackId(String username, String password) {
		UserBuilder user = User.builder();
		user.userName("张三").passWord(password).account(username).authorize("0")
				.email("123qq@.com").ip("192.1.1.1").phone("123123123");
		userDao.insertUserWithBackId(user.build());// 该方法后，主键已经设置到user中了
		return user.build();
	}

	@SneakyThrows(ServiceRuntimeException.class)

	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

	@SneakyThrows(ServiceRuntimeException.class)
	@CacheEvict(value = "id", key = "'u_id_' + #id")//删除缓存
	public boolean deleteUserById(Integer id) {
		return userDao.deleteUserById(id) > 0 ? true : false;
	}

	@SneakyThrows
	@Cacheable(value = "id", key = "'u_id_' + #id")// 添加缓存到redis
	public User findUseById(Long id) {
		return userDao.findUserById(id);
	}
}
