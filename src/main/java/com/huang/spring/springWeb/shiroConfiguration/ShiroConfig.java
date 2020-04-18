package com.huang.spring.springWeb.shiroConfiguration;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

@Configuration
public class ShiroConfig 
{
	//shiroFilterFactoryBean
	@Bean
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager defaultWebSecurityManager)
	{
		ShiroFilterFactoryBean bean=new ShiroFilterFactoryBean();
		//设置安全管理器
		bean.setSecurityManager(defaultWebSecurityManager);
		
		//添加shiro内置过滤器
		/*
		 anon：无需认证就可以访问
		 authc：必须认证了才能访问
		 user：必须拥有 "记住我"功能才能访问
		 perms：拥有对某个资源的权限才能访问
		 role：拥有某个角色的权限才能访问
		 */
		
		//设置controller请求访问权限
		Map<String,String>filterMap=new LinkedHashMap();
		
		//只有有user:add权限的用户才能使用add
		filterMap.put("/add", "perms[user:add]");
		filterMap.put("/update", "authc");
		
		bean.setFilterChainDefinitionMap(filterMap);
		
		//设置拦截后的跳转页面
		bean.setLoginUrl("/toLogin");
		
		//设置未授权页面
		bean.setUnauthorizedUrl("/noauth");
		return bean;
	}
	//DefaultWebSecurityManager
	//关联UseeRealm
	@Bean(name="securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm)
	{
		DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();	
		securityManager.setRealm(userRealm);
		return securityManager;
	}
	//创建realm对象,自定义的类
	@Bean(name="userRealm")
	public UserRealm userRealm()
	{
		return new UserRealm();
	}
	
	//整合shiro和thymeleaf
	@Bean
	public ShiroDialect getShiroDialect()
	{
		return new ShiroDialect();
	}

}
