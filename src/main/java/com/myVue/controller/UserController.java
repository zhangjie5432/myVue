package com.myVue.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.myVue.bean.UserEntity;
import com.myVue.service.UserService;

@Controller
@RequestMapping(value = "")
public class UserController {

	@Autowired
	private UserService userService;

	
	@RequestMapping("/login")
	@ResponseBody
	public String loginAccount(@RequestParam String userId, @RequestParam String password, HttpSession session) {
		System.out.println("........登陆账号.........");
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userId, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(usernamePasswordToken); // 完成登录
			UserEntity user = (UserEntity) subject.getPrincipal();
			session.setAttribute("user", user);
			return "login success";
		} catch (Exception e) {
			return "login fail";
		}
	}
	
	@ResponseBody
	@RequestMapping("/user/getUserList.do")
	public String getUserList() {
		return JSON.toJSONString( userService.getUserList());
	}

}
