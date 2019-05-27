package com.boot.spring.klu.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.boot.spring.klu.entity.ParkingLot;
import com.boot.spring.klu.entity.ParkingNotice;
import com.boot.spring.klu.entity.UserParking;

/**
*@auth liweipeng 
*@version 2019年5月14日下午7:36:11
**/

@Repository
public interface WxMapper {

	public String appointment(String name, String tel, String car_no, String parking_time, String uuid, String parking_id, String open_id,String remark);

	public boolean insertUser(UserParking user);

	public List<UserParking> getAllUsers(String open_id);
	
	public boolean cancelParking(String id);
	
	public ParkingNotice getParkingNotice();
	
	public ParkingLot spaceIsEmpty();
	
	public ParkingLot selectVolume(String parking_id);
	
	public boolean reduceVolume(int number);
	
	public boolean updateParking(String username, String tel, String car_no, String parking_time, String id,String remark);

}
