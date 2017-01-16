package com.java.spring.daoImpl;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;

import com.java.spring.dao.BaseRedisDao;
import com.java.spring.dao.UserDao;
import com.java.spring.pojo.User;
import com.java.spring.vo.UserVo;

/**
* @author 作者:zhaofq
* @version 创建时间：2017年1月10日 下午3:16:16
* 类说明
*/
@Repository
public class UserDaoImpl extends BaseRedisDao<String, User> implements UserDao {
    
	@Override
	public User addUser(User user) {
		User user2 =new User();
		ValueOperations<String, User> valueops = redisTemplate.opsForValue();
		valueops.set(user.getMobile(), user);
		user2 = valueops.get(user.getMobile());
		return user2;
	}

	@Override
	public User getUserByMobile(String mobile) {
		ValueOperations<String, User> valueops = redisTemplate.opsForValue();
		User user = valueops.get(mobile);
	   return user;
	}

	@Override
	public Boolean forgetPassword(User user) {
		 String key = user.getMobile();
	        if (getUserByMobile(key) == null) {  
	            throw new NullPointerException("数据行不存在, key = " + key);  
	        }
	        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {  
	            public Boolean doInRedis(RedisConnection connection)
	                    throws DataAccessException {
	                RedisSerializer<String> serializer = getRedisSerializer();
	                byte[] key  = serializer.serialize(user.getMobile());
	                byte[] value = serializer.serialize(user.getPassword());
	                byte[] password = serializer.serialize("password");
	                connection.hSet(key, password, value);  
	                return true;  
	            }
	        });  
	        return result;  
		
		
	}

}
