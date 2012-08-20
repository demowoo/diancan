package com.diancan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diancan.mapper.UserMapper;
import com.diancan.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;

	public User getUserById(int userId) {
		return userMapper.getUserByUserId(userId);
	}
	
	public User getUserByLoginName(String loginName) {
		return userMapper.getUserByLoginName(loginName);
	}
	
	public List<User> getUserList(){
		return userMapper.getUserList();
	}
	
	public User getUserByRealName(String realName) {
		return userMapper.getUserByRealName(realName);
	}
	
	public void updateUserInfo(User user){
		userMapper.updateUser(user);
	}
	
	public void addUser(User user){
		userMapper.addUser(user);
	}
	
	public void activeUser(int userId){
		userMapper.activeUser();
	}
}
