package com.boot.spring.klu.controller.wx;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.boot.spring.klu.entity.ParkingLot;
import com.boot.spring.klu.entity.ParkingNotice;
import com.boot.spring.klu.entity.User;
import com.boot.spring.klu.entity.UserParking;
import com.boot.spring.klu.service.UserService;
import com.boot.spring.klu.service.WxService;
import com.boot.spring.klu.utils.HttpClientUtil;
import com.boot.spring.klu.utils.RetResponse;
import com.boot.spring.klu.utils.RetResult;
import com.boot.spring.klu.utils.UUIDUtils;
import com.boot.spring.klu.utils.UserCode;

@RestController
@RequestMapping("/wx")
public class WxContronller {
	private static final Object CAN_NOT_FIND = null;
	
	@Autowired
	private WxService wxService;
	
	@Autowired
	private UserService userService;

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

	@RequestMapping(value = "/appointment")
	public int appointment(HttpServletRequest httpRequest) {
		String username = httpRequest.getParameter("username");
		String tel = httpRequest.getParameter("tel");
		String car_no = httpRequest.getParameter("car_no");
		String parking_time = httpRequest.getParameter("parking_time");
		String remark = httpRequest.getParameter("remark");
		long id = UUIDUtils.getUUIDSimple();
		System.out.println("id=-" + id);
		String parking_id = "111111";
		String open_id = "xxxxxx";
		UserParking user = new UserParking(UUIDUtils.getUUIDSimple(), open_id, username, tel, car_no, parking_id, parking_time,remark);
		System.out.println(user);
		long result = wxService.appointment(user);
		System.out.println("return====>" + result);
		return UserCode.APPOINTMENT_SUCCESS;
	}

	@RequestMapping("/appointmentList")
	public List<UserParking> getUserList() {
		List<UserParking> users = wxService.appointmentList();
		if (users != null) {
			for (UserParking user : users) {
				System.out.println(user);
			}
		} else {
			System.out.println("user list is null");
		}
		return users;
	}

	@RequestMapping("/login")
	public RetResult<User> login(HttpServletRequest httpRequest) {
		String code = httpRequest.getParameter("code");
		System.out.println("wx code = " + code);

        // 配置请求参数
		Map<String, String> param = new HashMap<>();
		param.put("appid", "");
		param.put("secret", "");
		param.put("js_code", code);
		param.put("grant_type", UserCode.GRANT_TYPE);

		// 发送请求
        String wxResult = HttpClientUtil.doGet(UserCode.OPEN_ID_URL, param);
        JSONObject jsonObject = JSONObject.parseObject(wxResult);
        // 获取参数返回的
        String open_id = jsonObject.get("openid").toString();
        //TODO: 这里mybatis的返回值问题依旧存在，需要解决
        User user = userService.selectByOpenId(open_id);
        if(user == CAN_NOT_FIND){
            User insert_user = new User();
            insert_user.setOpenId(open_id);
            System.out.println("insert_user:"+insert_user.toString());
            // 添加到数据库
            userService.insertUser(insert_user);
            return RetResponse.makeOKRsp(insert_user);
        }else{
        	System.out.println("sel====>");
    		return RetResponse.makeOKRsp(user);
        }
	}
	/**
	 * @auth lijinpeng 2019年5月24日下午16:00
	 * @param
	 * @return code
	 * @description 取消预约
	 */
	
	@RequestMapping(value = "/cancelParking")
	public int cancelParking(HttpServletRequest httpRequest) {
		String id=httpRequest.getParameter("id");
		int code = -1;
		boolean result = wxService.cancelParking(id);
		if(result) {
		code = 0;
		}else {
			code = -1;
		}
		return code;
	}
	/**
	 * @auth lijinpeng 2019年5月24日下午16:20
	 * @param
	 * @return ParkingNotice notice
	 * @description 获取公告信息
	 */
	
	@RequestMapping(value = "/getParkingNotice")
	public ParkingNotice getParkingNotice() {
		ParkingNotice notice = wxService.getParkingNotice();
		int code = -1;
		if(notice != null) {
			code = 0;
		}else {
			code = -1;
		}
		return notice;
	}
	
	/**
	 * @auth lijinpeng 2019年5月24日下午18.08
	 * @param
	 * @return Volume 剩余车位
	 * @description 获取可停车的数量
	 */
	@RequestMapping(value = "/getParkingVolume")
	public ParkingLot getParkingVolume() {
		return null;
		
	}
	
}
