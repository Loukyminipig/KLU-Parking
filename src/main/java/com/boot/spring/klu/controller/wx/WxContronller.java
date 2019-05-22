package com.boot.spring.klu.controller.wx;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
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
		String name = httpRequest.getParameter("name");
		String tel = httpRequest.getParameter("tel");
		String car_no = httpRequest.getParameter("car_no");
		String order_time = httpRequest.getParameter("order_time");
		String comments = httpRequest.getParameter("comments");
		long id = UUIDUtils.getUUIDSimple();
		System.out.println("id=-" + id);
		String parking_id = "111111";
		String open_id = "xxxxxx";
		UserParking user = new UserParking(UUIDUtils.getUUIDSimple(), open_id, name, tel, car_no, parking_id, order_time);
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
		param.put("appid", "wx306086b4a938f086");
		param.put("secret", "c5c1d6eedc547bdb33e7e8314d3915b6");
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
}
