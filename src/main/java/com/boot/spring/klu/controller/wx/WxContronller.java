package com.boot.spring.klu.controller.wx;

import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boot.spring.klu.entity.User;
import com.boot.spring.klu.service.WxService;
import com.boot.spring.klu.utils.UUIDUtils;
import com.boot.spring.klu.utils.UserCode;

@RestController
@RequestMapping("/wx")
public class WxContronller {
	@Autowired
	private WxService wxService;
	
	/**
	 * @auth liweipeng 2019年5月14日下午7:37:28
	 * @param
	 * @return String
	 * @description 测试微信访问端口
	 */
	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome: ";
	}
	
	@RequestMapping(value="/appointment", method= RequestMethod.GET) 
	public int appointment(HttpServletRequest httpRequest) {
	    String name = httpRequest.getParameter("name");
	    String tel = httpRequest.getParameter("tel");
	    String car_no = httpRequest.getParameter("car_no");
	    String order_time = httpRequest.getParameter("order_time");
	    String comments = httpRequest.getParameter("comments");
	    long id = UUIDUtils.getUUIDSimple();
	    System.out.println("id=-" + id);
	    String parking_id = "111111";
	    String open_id = "xxxxxx";
	    User user = new User(UUIDUtils.getUUIDSimple(), open_id, name, tel, car_no, parking_id, order_time);
	    System.out.println(user);
	    long result = wxService.appointment(user);
	    System.out.println("return====>" + result);
	    return UserCode.APPOINTMENT_SUCCESS;
	}
}
