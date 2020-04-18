package com.huang.spring.springWeb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huang.spring.springWeb.dao.UserMapper;
import com.huang.spring.springWeb.pojo.User;

@Service
public class UserService implements UserServiceIp
{
	@Autowired
	UserMapper userMapper;

	@Override
	public User queryUserByName(String name) 
	{
		return userMapper.queryUserByName(name);
	}
	
	
}
