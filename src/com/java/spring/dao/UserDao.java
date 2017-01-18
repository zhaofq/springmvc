package com.java.spring.dao;

import java.util.Map;

import com.java.spring.pojo.User;

/**
* @author 作者:zhaofq
* @version 创建时间：2017年1月10日 下午3:15:05
* 类说明
*/
public interface UserDao {
   
	public User addUser(User user);

//	public User getUserByMobile(String mobile);
    
	public Map<String, User> getUserByMobile(String mobile);
	
	public Boolean forgetPassword(User user);

	public void forgetPassword(String userMobile, String password, String passwordVla);
}
