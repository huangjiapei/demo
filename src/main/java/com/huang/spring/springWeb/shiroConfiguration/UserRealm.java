package com.huang.spring.springWeb.shiroConfiguration;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.huang.spring.springWeb.pojo.User;
import com.huang.spring.springWeb.service.UserServiceIp;

//自定义Realm
public class UserRealm  extends AuthorizingRealm
{
	@Autowired
	UserServiceIp userService;
	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		System.out.println("执行授权");
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		//拿到当前登录用户
		Subject subject=SecurityUtils.getSubject();
		User currentUser=(User)subject.getPrincipal();
		//auth为在数据库查询当前用户权限
		String auth="user:add";
		//只要登录成功就会经过授权
		if(currentUser.getName().equals("ui"))
		{
			info.addStringPermission(auth);
			return info;
		}
		return null;
	}

	//执行登录就会进行认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("执行认证");
		//拿到封装的用户名、密码
		UsernamePasswordToken userToken=(UsernamePasswordToken)token;
		String username=userToken.getUsername();
		//查询数据库
		User user=userService.queryUserByName(username);
		//用户名认证
		if(user==null)
		{
			return null;//抛出异常UnknownAccountException
		}
		//密码认证：shiro做,要传递密码给它
		return new SimpleAuthenticationInfo(user,user.getPassword(),"");
	}
	
}
