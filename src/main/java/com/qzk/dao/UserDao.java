package com.qzk.dao;

import com.qzk.mapper.UserMapper;
import com.qzk.model.User;
import com.qzk.model.User.UserBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
	@Autowired
    private UserMapper userMapper;
    
    public int insertUser(String username, String password){
        return userMapper.insertUser(username, password);
    }
    
    public UserBuilder loginUser(String username, String password){
    	return userMapper.loginUser(username, password);
    }

    public int insertUserWithBackId(User user){    
        return userMapper.insertUserWithBackId(user);
    }
    
    public List<User> getAllUsers(){
    	return userMapper.getAllUsers();
    }
    
    public Integer deleteUserById(Integer id){
    	return userMapper.deleteUserById(id.toString());
    }
    
    public User findUserById(Long id){
    	System.out.println("findUser============================================>");
    	return userMapper.findUserById(id.toString());
    }
}
