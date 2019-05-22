package com.boot.spring.klu.controller.wx;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.boot.spring.klu.entity.User;
import com.boot.spring.klu.entity.UserParking;
import com.boot.spring.klu.service.UserService;
import com.boot.spring.klu.service.WxService;
import com.boot.spring.klu.utils.UUIDUtils;
import com.boot.spring.klu.utils.UserCode;

@RestController
@RequestMapping("/wx")
public class WxContronller {
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
	public String login(HttpServletRequest httpRequest) {
		String code = httpRequest.getParameter("code");
		System.out.println("wx code = " + code);

		Map<String, String> param = new HashMap<>();
		param.put("appid", "");
		param.put("secret", "");
		param.put("js_code", code);
		param.put("grant_type", "authorization_code");

		CloseableHttpClient httpclient = HttpClients.createDefault();
		String resultString = "";
		CloseableHttpResponse response = null;
		try {
			// 创建http GET请求
			URIBuilder builder = new URIBuilder("https://api.weixin.qq.com/sns/jscode2session");
			for (String key : param.keySet()) {
				builder.addParameter(key, param.get(key));
			}
			URI uri = builder.build();
			System.out.println(uri.toString());
			// 创建http GET请求
			HttpGet httpGet = new HttpGet(uri);
			// 执行请求
			response = httpclient.execute(httpGet);
			// 判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == 200) {
				resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
				System.out.println("resultString===>" + resultString);
				JSONObject jsonObject = JSONObject.parseObject(resultString);
				String session_key = jsonObject.get("session_key").toString();
				String open_id = jsonObject.get("openid").toString();
				User user = userService.selectByOpenId(open_id);
				if(user!= null) {
					System.out.println("user select");
					resultString = open_id;
				} else {
					System.out.println("user insert");
					resultString = open_id;
					User user_insert = new User(open_id, null);
					userService.insertUser(user_insert);
				}
			} else {
				System.out.println("fail=============");
			}
			System.out.println("final=" + resultString);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;
	}
}
