package com.java.spring.service;

import javax.servlet.http.HttpServletRequest;

import com.java.spring.pojo.User;
import com.java.spring.util.system.Message;
import com.java.spring.vo.UserVo;

/**
* @author 作者:zhaofq
* @version 创建时间：2017年1月10日 下午2:11:27
* 类说明
*/
public interface UserService {

	public Message registerUser(HttpServletRequest request, User user);

	public Message login(HttpServletRequest request, UserVo userVo);

	public Message forgetPassword(HttpServletRequest request, UserVo userVo);
}
