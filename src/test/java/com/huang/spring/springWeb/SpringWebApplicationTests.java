package com.huang.spring.springWeb;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringWebApplicationTests 
{
	@Autowired
	DataSource dataSource;
	@Test
	void contextLoads() throws SQLException 
	{
		System.out.println(dataSource.getClass());
		System.out.println(dataSource.getConnection());
	}

}
