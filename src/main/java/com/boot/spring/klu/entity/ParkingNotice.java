package com.boot.spring.klu.entity;

import java.util.Date;

import com.boot.spring.klu.utils.UUIDUtils;

public class ParkingNotice {
	
	String id;
	String content;
	Date notice_time;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getNotice_time() {
		return notice_time;
	}
	public void setNotice_time(Date notice_time) {
		this.notice_time = notice_time;
	}
//	public ParkingNotice(String id) { 
//		
//	}
	public void saveNotice(String content) {
		this.content=content;
		this.id=UUIDUtils.getUUID_16();
		this.notice_time=new Date();
	}
	
}
