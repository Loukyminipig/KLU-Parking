package com.boot.spring.klu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.spring.klu.entity.ParkingLot;
import com.boot.spring.klu.entity.ParkingNotice;
import com.boot.spring.klu.entity.UserParking;
import com.boot.spring.klu.mapper.WxMapper;

/**
*@auth liweipeng 
*@version 2019年5月20日下午3:27:28
**/

@Service
public class WxService {
	@Autowired
	WxMapper wxMapper;
	
	public String appointment(String name, String tel, String car_no, String parking_time, String uuid, String parking_id, String open_id,String remark) {
		return wxMapper.appointment(name, tel, car_no, parking_time, uuid, parking_id, open_id,remark);
	}

	public boolean appointment(UserParking user) {
		return wxMapper.insertUser(user);
	}

	public List<UserParking> appointmentList(String open_id) {
		return wxMapper.getAllUsers(open_id);
	}
	
	public boolean cancelParking(String id) {
		return wxMapper.cancelParking(id);
	}
	
	public ParkingNotice getParkingNotice() {
		return wxMapper.getParkingNotice();
	}
	
	public ParkingLot spaceIsEmpty() {
		return wxMapper.spaceIsEmpty();
	}
	
	public ParkingLot selectVolume(String parking_id) {
		return wxMapper.selectVolume(parking_id);
	}
	
	public boolean reduceVolume(int number) {
		return wxMapper.reduceVolume(number);
	}
	
	public boolean updateParking(String username, String tel, String car_no, String parking_time, String id,String remark) {
		return wxMapper.updateParking(username, tel, car_no, parking_time,id,remark);
	}
	
}
