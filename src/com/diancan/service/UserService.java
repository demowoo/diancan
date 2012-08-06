package com.diancan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diancan.mapper.UserMapper;
import com.diancan.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;

	public User getUserByLoginName(String loginName) {
		return userMapper.getUserByLoginName(loginName);
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
}
