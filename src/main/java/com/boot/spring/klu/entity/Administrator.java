package com.boot.spring.klu.entity;

/**
 * @auth liweipeng
 * @version 2019年5月9日下午2:39:44
 **/
public class Administrator {
	private int id;
	private String name;
	private int level;
	private String passwd;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Amdin [ name=");
		builder.append(this.name);
		builder.append(" level=");
		builder.append(this.level);
		builder.append(" ]");
		return builder.toString();
	}
}
