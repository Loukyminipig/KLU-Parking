package com.boot.spring.klu.controller.admin;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.boot.spring.klu.entity.Administrator;
import com.boot.spring.klu.service.AdminService;

import utils.RetResponse;
import utils.RetResult;

@RestController

public class AdminController {
	private static final Object CAN_NOT_FIND_USER = null;

	@Autowired
	private AdminService adminService;

	@RequestMapping("/")
	public String loginEmpty() {
		return "index";
	}

	@RequestMapping("/login")
	public ModelAndView index(Model model) {
		ModelAndView view = new ModelAndView();
		view.setViewName("login");
		return view;
	}

	/**
	 * @auth 2019年5月13日下午4:10:48
	 * @param
	 * @return 
	 * @return String
	 * @description
	 */

	@RequestMapping("/toLogin")
	public RetResult<Administrator> loginVerify(HttpServletRequest request) {
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("name=" + name + " pswd=" + password);
		Administrator adminLogin = adminService.login(name, password);
		if (adminLogin == null) {
			System.out.println("登录失败");
		} else {
			System.out.println("登录成功");
			System.out.println(adminLogin.toString());
			// request.getSession().setAttribute("session_admin", adminLogin);
		}
		return RetResponse.makeOKRsp(adminLogin);
	}

	/**
	 * @auth 2019年5月13日下午4:10:28
	 * @param
	 * @return String
	 * @description 测试用
	 */
	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
}
