package com.java.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;

/**
* @author 作者:zhaofq
* @version 创建时间：2017年1月10日 下午5:35:31
* 类说明
*/
@Repository
public abstract class BaseRedisDao<K,V> {
	
	@Autowired(required=true)  
    protected RedisTemplate<K, V> redisTemplate;
	
	
	@Autowired(required=true)  
    protected StringRedisTemplate stringRedisTemplate ;
	/** 
     * 设置redisTemplate 
     * @param redisTemplate the redisTemplate to set 
     */  
    public void setRedisTemplate(RedisTemplate<K, V> redisTemplate) {  
        this.redisTemplate = redisTemplate;  
    }  
      
    /** 
     * 获取 RedisSerializer 
     * <br>------------------------------<br> 
     */  
    protected RedisSerializer<String> getRedisSerializer() {  
        return redisTemplate.getStringSerializer();  
    }

	public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
		this.stringRedisTemplate = stringRedisTemplate;
	}
    
}