package com.boot.spring.klu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.spring.klu.entity.User;
import com.boot.spring.klu.mapper.UserMapper;

/**
*@auth liweipeng 
*@version 2019年5月22日下午9:19:20
**/
@Service
public class UserService {
	@Autowired
	UserMapper userMapper;

	public User selectByOpenId(String open_id) {
		return userMapper.selectByOpenId(open_id);
	}

	public void insertUser(User user) {
		userMapper.insert(user);
	}
	
	
}
