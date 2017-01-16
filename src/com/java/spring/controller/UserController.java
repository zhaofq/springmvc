package com.java.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java.spring.pojo.User;
import com.java.spring.service.UserService;
import com.java.spring.util.system.Message;
import com.java.spring.vo.UserVo;

/**
* @author 作者:zhaofq
* @version 创建时间：2017年1月9日 下午5:48:32
* 类说明
*/
@Controller
public class UserController {
	
	 
	 @Autowired
	 UserService userService;
	 @RequestMapping(value = "/registerUser",method=RequestMethod.POST)
     public @ResponseBody Message registerUser(HttpServletRequest request,User user) {
		return userService.registerUser(request,user);
		
	}
	 @RequestMapping(value = "/login",method=RequestMethod.POST)
     public @ResponseBody Message login(HttpServletRequest request,UserVo userVo) {
		return userService.login(request,userVo);
		
	}
	 
	 @RequestMapping(value = "/forgetPassword",method=RequestMethod.GET)
     public @ResponseBody Message forgetPassword(HttpServletRequest request,UserVo userVo) {
		return userService.forgetPassword(request,userVo);
		
	}

	 
}
