package com.huang.spring.springWeb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huang.spring.springWeb.dao.UserMapper;
import com.huang.spring.springWeb.pojo.User;

@RestController//返回的不是html页面,而是直接输出返回的数值
public class UserController
{
	@Autowired //自动装配usermapper,即进行一系列数据库操作user
	private UserMapper userMapper;
	
	@RequestMapping("/queryList")
	public List<User> queryList()
	{
		List<User> userList=userMapper.queryUserList();
		for(User user:userList)
		{
			System.out.println(user);
		}
		return userList;
	}
	@RequestMapping("/add")
	public List<User>addUser()
	{
		User user=new User(0,"ui","1111");
		userMapper.addUser(user);
		List<User> userList=userMapper.queryUserList();
		for(User usert:userList)
		{
			System.out.println(usert);
		}
		return userList;
	}
	@RequestMapping("/del")
	public List<User>delUser()
	{
		userMapper.deleteUser(11);
		List<User> userList=userMapper.queryUserList();
		for(User user:userList)
		{
			System.out.println(user);
		}
		return userList;
	}
	@RequestMapping("/update")
	public List<User>updateUser()
	{
		User user=new User(11,"hj","1234");
		userMapper.updateUser(user);
		List<User> userList=userMapper.queryUserList();
		for(User usert:userList)
		{
			System.out.println(usert);
		}
		return userList;
	}
	@RequestMapping("/queryUserByid")
	public User queryUserByid()
	{
		User user=userMapper.queryUserByid(11);
		return user;
	}
}
