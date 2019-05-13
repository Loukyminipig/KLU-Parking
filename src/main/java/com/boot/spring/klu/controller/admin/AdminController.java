package com.boot.spring.klu.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.boot.spring.klu.entity.Administrator;
import com.boot.spring.klu.service.AdminService;
import com.boot.spring.klu.utils.RetResponse;
import com.boot.spring.klu.utils.RetResult;

@RestController

public class AdminController {
	private static final Object CAN_NOT_FIND = null;

	@Autowired
	private AdminService adminService;

	/*
	 * 注意： 使用@Controller，可以直接使用return "界面名称（不含html等结尾）"的方法加载页面
	 *              使用@RestController则只能使用view类加载，不能偷懒
	 * */
	
	@RequestMapping("/")
	public ModelAndView loginEmpty() {
		ModelAndView view = new ModelAndView();
		view.setViewName("login");
		return view;
	}

	@RequestMapping("/login")
	public ModelAndView login(Model model) {
		ModelAndView view = new ModelAndView();
		view.setViewName("login");
		return view;
	}

	/**
	 * @auth 2019年5月13日下午4:10:48
	 * @param
	 * @return 
	 * @return String
	 * @description  处理登录界面逻辑
	 */

	@RequestMapping("/toLogin")
	public RetResult<Administrator> loginVerify(HttpServletRequest request) {
		Administrator adminLogin = adminService.login(request.getParameter("username"), request.getParameter("password"));
		if (adminLogin == CAN_NOT_FIND) {
			System.out.println("登录失败");
			return RetResponse.makeErrRsp("login fail");
		} else {
			System.out.println("登录成功");
			System.out.println(adminLogin.toString());
			//request.getSession().setAttribute(AdminConfg.SESSION_KEY, adminLogin);
			return RetResponse.makeOKRsp(adminLogin);
		}
	}

	@RequestMapping("/index")
	public ModelAndView index(Model model) {
		ModelAndView view = new ModelAndView();
		view.setViewName("index");
		return view;
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
