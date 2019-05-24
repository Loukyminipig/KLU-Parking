package com.boot.spring.klu.entity;

/**
 * @auth liweipeng
 * @version 2019年5月22日下午3:42:10
 **/
public class UserParking {
	long id;
	String open_id;
	String username;
	String tel;
	String car_no;
	String parking_id;
	String parking_time;
	String remark;

	public String getOpen_id() {
		return open_id;
	}

	public void setOpen_id(String open_id) {
		this.open_id = open_id;
	}

	public String getCar_no() {
		return car_no;
	}

	public void setCar_no(String car_no) {
		this.car_no = car_no;
	}

	public String getParking_time() {
		return parking_time;
	}

	public void setParking_time(String parking_time) {
		this.parking_time = parking_time;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public UserParking(long id, String open_id, String username, String tel, String car_no, String parking_id,
			String parking_time,String remark) {
		this.id = id;
		this.open_id = open_id;
		this.username = username;
		this.tel = tel;
		this.car_no = car_no;
		this.parking_id = parking_id;
		this.parking_time = parking_time;
		this.remark=remark;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCarNo() {
		return car_no;
	}

	public void setCarNo(String car_no) {
		this.car_no = car_no;
	}

	public String getParking_id() {
		return parking_id;
	}

	public void setParking_id(String parking_id) {
		this.parking_id = parking_id;
	}

	public String getParkingTime() {
		return parking_time;
	}

	public void setParkingTime(String parking_time) {
		this.parking_time = parking_time;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("user_parking=[ ").append("id=").append(id);
		builder.append(", openId=").append(open_id);
		builder.append(", name=").append(username);
		builder.append(", tel=").append(tel);
		builder.append(", carNo=").append(car_no);
		builder.append(", parkingId=").append(parking_id);
		builder.append(", parkingTime=").append(parking_time);
		builder.append(" ]");
		return builder.toString();
	}
}
