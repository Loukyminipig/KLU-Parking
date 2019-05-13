package com.boot.spring.klu.mapper;

import org.springframework.stereotype.Repository;

import com.boot.spring.klu.entity.Administrator;

/**
 * @auth liweipeng
 * @version 2019年5月9日下午2:54:27
 **/

@Repository
public interface AdminMapper {
	public Administrator login(String userName, String passWord);
}
