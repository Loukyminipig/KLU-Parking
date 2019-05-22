package com.boot.spring.klu.entity;

/**
 * @auth liweipeng
 * @version 2019年5月22日下午9:21:46
 **/
public class User {
	String open_id;
	String username;

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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("user=[ ").append("id=").append(open_id);
		builder.append(", name=").append(username);
		builder.append(" ]");
		return builder.toString();
	}
}
