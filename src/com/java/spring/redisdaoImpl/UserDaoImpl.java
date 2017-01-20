package com.java.spring.redisdaoImpl;

import java.util.Map;

import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.stereotype.Repository;

import com.java.spring.pojo.User;
import com.java.spring.redisdao.BaseRedisDao;
import com.java.spring.redisdao.RedisUserDao;
import com.java.spring.util.utils.JsonMapper;

/**
 * @author 作者:zhaofq
 * @version 创建时间：2017年1月10日 下午3:16:16 类说明
 */
@Repository
public class UserDaoImpl extends BaseRedisDao<String, User> implements RedisUserDao {

	/**
	 * Hash类型数据的set方式：储存的是一个key-object;需要的filed的valus时需要将整个object反序列化，
	 * 操作完成需要将整个object再次序列化然后保存
	 *//*
		 * public User addUsersql(User user) { User user2 =new User();
		 * ValueOperations<String, User> valueops = redisTemplate.opsForValue();
		 * valueops.set(user.getMobile(), user); user2 =
		 * valueops.get(user.getMobile()); return user2; }
		 */

	/*
	 * public User getUserByMobile(String mobile) { ValueOperations<String,
	 * User> valueops = redisTemplate.opsForValue(); User user =
	 * valueops.get(mobile); return user; }
	 */

	/**
	 * Hash类型数据的set方式：修改某条数据的每个字段，是通过key获得整条数据，然后反序列化，从新给对应的filed赋值，再次set整体数据。
	 */
	/*
	 * public Boolean forgetPassword(User user) { Boolean ccBoolean = false;
	 * String key = user.getMobile(); if (getUserByMobile(key) == null) { throw
	 * new NullPointerException("数据行不存在, key = " + key); }else { User user2 =new
	 * User(); ValueOperations<String, User> valueops =
	 * redisTemplate.opsForValue(); valueops.set(user.getMobile(), user); user2
	 * = valueops.get(user.getMobile()); System.out.println(valueops.get(key));
	 * } return ccBoolean; }
	 */
    
	/**
	 * Hash类型数据Hmset方式：
	 */
    @SuppressWarnings("unchecked")
	public User addUser(User user) {
		Map<String, String> map = (Map<String, String>) JsonMapper.parseObject(user, Map.class);
		redisTemplate.opsForHash().putAll(user.getMobile(), map);
		return user;
	}
	
	public Map<String, User> getUserByMobile(String mobile) {
		BoundHashOperations<String, String, User> boundHashOperations = redisTemplate.boundHashOps(mobile);
		Map<String, User> users = boundHashOperations.entries();
		System.out.println(users);
		return users;
	}

	/**
	 * Hash类型数据的set方式：修改某条数据的每个字段，是通过key获得整条数据，然后反序列化，从新给对应的filed赋值，再次set整体数据。
	 */
	public void forgetPassword(String userMobile, String password, String passwordVla) {
		BoundHashOperations<String, String, Object> boundHashOperations = redisTemplate.boundHashOps(userMobile);
		boundHashOperations.put("passPhrase", passwordVla);
	}

	@Override
	public User getUserByMobilefromSql(String mobile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean forgetPassword(User user) {
		// TODO Auto-generated method stub
		return null;
	}


}
