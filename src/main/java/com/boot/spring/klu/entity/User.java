package com.boot.spring.klu.entity;

/**
 * @auth liweipeng
 * @version 2019年5月22日下午9:21:46
 **/
public class User {
	String open_id;
	String username;

	public User(String open_id, String username) {
		this.open_id = open_id;
		this.username = username;
	}

	public String getOpenId() {
		return open_id;
	}

	public void setOpenId(String open_id) {
		this.open_id = open_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
