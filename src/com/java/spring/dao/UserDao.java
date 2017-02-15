package com.java.spring.dao;

import com.java.spring.pojo.User;

/**
* @author 作者:zhaofq
* @version 创建时间：2017年1月10日 下午3:15:05
* 类说明
*/
public interface UserDao {
	public User getUserByMobilefromSql(String mobile);
	
	public int forgetPassword(User user);

	public int addUser(User user);

	
}
