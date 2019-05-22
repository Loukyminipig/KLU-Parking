package com.boot.spring.klu.mapper;

import org.springframework.stereotype.Repository;

import com.boot.spring.klu.entity.User;

/**
*@auth liweipeng 
*@version 2019年5月22日下午9:20:12
**/

@Repository
public interface UserMapper {

	User selectByOpenId(String open_id);

	void insert(User user);

}
