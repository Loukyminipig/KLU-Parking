package com.boot.spring.klu.service;
/**
*@auth liweipeng 
*@version 2019年5月10日上午11:15:29
**/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.spring.klu.entity.Administrator;
import com.boot.spring.klu.mapper.AdminMapper;

@Service
public class AdminService {
	@Autowired
	AdminMapper adminMapper;

	public Administrator login(String userName, String passwd) {
		return adminMapper.login(userName, passwd);
	}
}
