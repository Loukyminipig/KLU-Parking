package com.boot.spring.klu.entity;
/**
 * 
 * @author lijinpeng
 *
 */
public class ParkingLot {

		String id;
		int parking_volume;
		String image;
		String describe;
		int parking_max;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public int getParking_volume() {
			return parking_volume;
		}
		public void setParking_volume(int parking_volume) {
			this.parking_volume = parking_volume;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public String getDescribe() {
			return describe;
		}
		public void setDescribe(String describe) {
			this.describe = describe;
		}
		public int getParking_max() {
			return parking_max;
		}
		public void setParking_max(int parking_max) {
			this.parking_max = parking_max;
		}
		
		
}
