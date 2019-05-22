package com.boot.spring.klu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.spring.klu.entity.User;
import com.boot.spring.klu.mapper.WxMapper;

/**
*@auth liweipeng 
*@version 2019年5月20日下午3:27:28
**/

@Service
public class WxService {
	@Autowired
	WxMapper wxMapper;
	
	public String appointment(String name, String tel, String car_no, String order_time, String uuid, String parking_id, String open_id) {
		return wxMapper.appointment(name, tel, car_no, order_time, uuid, parking_id, open_id);
	}

	public long appointment(User user) {
		return wxMapper.insertUser(user);
	}
}
