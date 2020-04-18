package com.huang.spring.springWeb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//自定义扩展springmvc
@Configuration
public class MyMvcConfig implements WebMvcConfigurer
{
	// 可以代替url访问的controller
	// 访问"/"时跳转到"index.html/"
	// 访问页面---->真实页面
	@Override
	public void addViewControllers(ViewControllerRegistry registry)
	{ 
		registry.addViewController("/").setViewName("/index"); // 访问"/"时跳转到"/index.html"
		registry.addViewController("/index.html").setViewName("/index"); // 访问"/index.html"时跳转到"/index.html"
		registry.addViewController("/login").setViewName("/login"); // 访问"/login"时跳转到"/login.html"
		registry.addViewController("/about").setViewName("/about"); // 访问"/about"时跳转到"/about.html"
		registry.addViewController("/list").setViewName("/list"); // 访问"/list"时跳转到"/list.html"
		registry.addViewController("/bar").setViewName("/bar");
		registry.addViewController("/toLogin").setViewName("/login");
	}
	
	//添加拦截器
	@Override
	public void addInterceptors(InterceptorRegistry  registry)
	{
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/about");
		//registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/index").excludePathPatterns("/","/css/*","/images/*","/login.html","/index.html","/fonts/*");
	}
}
