package com.java.spring.redisdao;

import java.util.Map;

import com.java.spring.pojo.User;

/**
* @author 作者:zhaofq
* @version 创建时间：2017年1月10日 下午3:15:05
* 类说明
*/
public interface RedisUserDao {

	//访问redis
   public User addUser(User user);
	
	//访问redis
	public Map<String, User> getUserByMobile(String mobile);
	   //访问mysql
	public User getUserByMobilefromSql(String mobile);
	
	public Boolean forgetPassword(User user);

	public void forgetPassword(String userMobile, String password, String passwordVla);

	
}
