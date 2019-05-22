package com.boot.spring.klu.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import com.boot.spring.klu.config.WebConfigurer;

/**
*@auth liweipeng 
*@version 2019年5月14日上午12:38:41
**/

@Component
public class AdminInterceptor implements HandlerInterceptor {

	private static final boolean PASS = true;
	private static final boolean INTERCEPT  = false;
	private static final Object GET_SESSION_FAIL = null;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Object admin = request.getSession().getAttribute(WebConfigurer.SESSION_KEY);
		if(admin == GET_SESSION_FAIL) {
			response.sendRedirect("/admin/login");
			return INTERCEPT;
		} else {
			return PASS;
		}
	}
}
