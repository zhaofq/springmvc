package com.java.spring.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.spring.dao.SystemLogDao;
import com.java.spring.pojo.SystemLog;
import com.java.spring.service.SystemLogService;

/**
* @author 作者:zhaofq
* @version 创建时间：2017年1月24日 下午4:42:48
* 类说明
*/
@Service
public class SystemLogServicImpl implements SystemLogService {
    
	@Autowired
	SystemLogDao systemLogDao;
	
	@Override
	public int save(SystemLog log) {
		try {
			return systemLogDao.save(log);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
