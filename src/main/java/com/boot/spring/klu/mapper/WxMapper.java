package com.boot.spring.klu.mapper;

import org.springframework.stereotype.Repository;

import com.boot.spring.klu.entity.User;

/**
*@auth liweipeng 
*@version 2019年5月14日下午7:36:11
**/

@Repository
public interface WxMapper {

	public String appointment(String name, String tel, String car_no, String order_time, String uuid, String parking_id, String open_id);

	public long insertUser(User user);

}
