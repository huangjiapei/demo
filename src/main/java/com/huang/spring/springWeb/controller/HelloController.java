//package com.huang.spring.springWeb.controller;
//
//
//import java.util.Arrays;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
///**
// * @RestController :表示本类所有的方法都是直接做内容返回到浏览器
// * @Controller :用户控制层
// */
//@Controller
//public class HelloController 
//{
//	//响应hello.do的请求
//	@RequestMapping("hello")
//	public String test(Model model)
//	{
//		model.addAttribute("msg","hello world");
//		model.addAttribute("users",Arrays.asList("xiaohong","xiaoming","xiaoli"));
//		//跳转到test.html页面中
//		return "/test";
//	}
//}
