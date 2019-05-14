package com.boot.spring.klu.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.boot.spring.klu.Interceptor.AdminInterceptor;

/**
*@auth liweipeng 
*@version 2019年5月14日上午12:36:02
**/

@Configuration
public class WebConfigurer implements WebMvcConfigurer{
	public static final String SESSION_KEY = "session_admin";
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		List<String> whiteList = new ArrayList<>();
		whiteList.add("/admin/*");
		whiteList.add("/wx/*");
		
		//参考：https://www.cnblogs.com/kangkaii/p/9023751.html
		//静态资源文件不能被屏蔽
		//index.html是springboot使用thymeleaf后的默认配置，这里我们改为main.html，否则会被访问根路径
		whiteList.add("/css/**");
		whiteList.add("/js/**");
		whiteList.add("/layui/**");
		whiteList.add("/web/**");
		
		registry.addInterceptor(new AdminInterceptor()).addPathPatterns("/**").excludePathPatterns(whiteList);
	}
}
