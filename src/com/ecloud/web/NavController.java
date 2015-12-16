package com.ecloud.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * @author liuzhilun
 * @20151020
 * 页面跳转 
 */
@Controller
public class NavController{
	@Autowired
	
	@RequestMapping("/query.do")
	public String query(){
		//返回指向页面 http://localhost:8080/wsll/test/test.wsll
		//指向 page/test/test.jsp页面 解析配置文件 dispatcher-servlet.xml
		/*
		 * <!-- 自动搜索@Controller标注的类 -->
		   <context:component-scan base-package="com.ecloud.web" />
		   <!-- 对模型视图名称的解析，即在模型视图名称添加前后缀 -->
		   <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver" p:prefix="/WEB-INF/page/" p:suffix=".jsp" />
		 * 
		 * */
		return "/query/query";
	}
	//跳转到登陆页面
	@RequestMapping("/login.do")
	public String login(){
		return "/login";
	}
    // 跳转到注册页面
	@RequestMapping("/toRegist.do")
	public String toRegist(){
		return "/regist/register";
	}
	
	@RequestMapping("/toUserUpdate.do")
	public String userUpdate(){
		return "/regist/userUpdate";
	}
	@RequestMapping("/changePwd.do")
	public String changePwd(){
		return "/changePwd/changePwd";
	}
	@RequestMapping("/home.do")
	public String home(){
		return "/bootstrap/home";
	}
	
}
