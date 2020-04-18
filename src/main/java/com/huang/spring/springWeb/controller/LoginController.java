package com.huang.spring.springWeb.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController
{
//	@RequestMapping("/userlogin")
////	public String login()
////	{
////		return "/login";
////	}
//	public String login(@RequestParam("username")String username,@RequestParam("password")String password,
//									  Model model,HttpSession session)
//	{
//		if(username.equals("root") && password.equals("root"))
//		{
//			session.setAttribute("loginUser", username);
//			return "redirect:/about";//登录成功重定向到about,不显示任何东西
//		}
//		else
//		{
//			model.addAttribute("msg","密码错误或者用户名不存在");
//			return "redirect:/login";
//		}
//	}
	
	//测试shiro登录
	@RequestMapping("/userlogin")
	public String login(String username,String password,Model model)
	{
		//获取当前用户
		Subject subject=SecurityUtils.getSubject();
		//封装用户的登录数据
		UsernamePasswordToken token=new UsernamePasswordToken(username,password);
		try
		{
			//进行认证用户信息
			subject.login(token);
			//获得session
			Subject currenSubject=SecurityUtils.getSubject();
			Session session=currenSubject.getSession();
			session.setAttribute("loginUser", username);
			return "/about";
		}catch(UnknownAccountException e)
		{
			model.addAttribute("msg","用户名错误");
			return "/login";
		}catch(IncorrectCredentialsException e)
		{
			model.addAttribute("msg","密码错误");
			return "/login";
		}
	}
	
	@RequestMapping("/noauth")
	@ResponseBody
	public String unauth()
	{
		return "未经授权无法访问此页面";
	}
}
