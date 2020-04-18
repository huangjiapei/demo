package com.huang.spring.springWeb.config;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

//请求登录时的拦截器，判断是否已经登录
@Component
public class LoginInterceptor implements HandlerInterceptor 
{
	
	//return true放行
	//return false 拦截
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception 
	{
        //登录成功应该有session
		Object loginUser=request.getSession().getAttribute("loginUser");
		if(loginUser==null)//没有登录
		{
			System.out.println("没有登录,请登录");
			request.setAttribute("msg", "没有登录,请登录");
			//跳转到登录页
			request.getRequestDispatcher("/login").forward(request, response);
			return false;
		}
		else
		{
			return true;
		}
    }
}
