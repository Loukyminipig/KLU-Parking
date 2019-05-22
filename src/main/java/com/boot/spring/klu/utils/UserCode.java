package com.boot.spring.klu.utils;
/**
*@auth liweipeng 
*@version 2019年5月22日下午6:04:26
**/
public class UserCode {
	public static final int APPOINTMENT_SUCCESS = 0;
	public static final int APPOINTMENT_FAIL = -1;
	
	public static final String OPEN_ID_URL = "https://api.weixin.qq.com/sns/jscode2session";
	public static final String GRANT_TYPE = "authorization_code";
}
