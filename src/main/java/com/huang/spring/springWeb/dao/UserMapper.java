package com.huang.spring.springWeb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.huang.spring.springWeb.pojo.User;

//用于数据库增删改查操作user
@Mapper //这个注解表示这是一个mybatis的mapper类
@Repository //声明是dao层
public interface UserMapper 
{
	List<User> queryUserList();
	User queryUserByid(int id);
	User queryUserByName(String name);
	int addUser(User user);
	int updateUser(User user);
	int deleteUser(int id);
}
