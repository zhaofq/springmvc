package com.java.spring.serviceImpl;

import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.spring.dao.UserDao;
import com.java.spring.pojo.User;
import com.java.spring.service.UserService;
import com.java.spring.util.system.DESTextCipher;
import com.java.spring.util.system.Message;
import com.java.spring.util.system.Password;
import com.java.spring.vo.UserVo;

/**
* @author 作者:zhaofq
* @version 创建时间：2017年1月10日 下午2:13:25
* 类说明
*/
@Service
public class UserServiceImpl implements UserService {
	
	
	private static Logger loger=Logger.getLogger(UserServiceImpl.class.getName());
	static DESTextCipher cipher = DESTextCipher.getDesTextCipher();
	@Autowired
	UserDao userDao;

	@Override
	public Message registerUser(HttpServletRequest request, User user) {
		
		Message message =new Message();
        	if (null != user) {
				try {
					String salt = Password.getSalt(null);
					user.setId(UUID.randomUUID().toString().toLowerCase());
					user.setMobile(cipher.encrypt(user.getMobile()));
					user.setPassPhrase(Password.getPassphrase(salt, user.getPassword()));
					user.setRegisterDate(new Date());
					user.setSalt(salt);
					User result = userDao.addUser(user);
					if (result != null) {
						message.setCode(0);
						message.setMessage("注册成功");
						return message;
					} else {
						message.setCode(-1);
						message.setMessage("注册失败");
						return message;
					}
				} catch (GeneralSecurityException e) {
					loger.info("register exception :"+e);
					e.printStackTrace();
				}
			}
			return message;
	}


	@SuppressWarnings("unused")
	@Override
	public Message login(HttpServletRequest request, UserVo userVo) {
		Message message = new Message();
		try {
			
			User user = this.getUserByMobile(cipher.encrypt(userVo.getMobile()));
			if (null != user) {
				user.getMobile();
				user.getPassPhrase();
				if (userVo.getMobile().equals(user.getMobile())) {
				} else {
				}
			} else {
				message.setCode(1);
				message.setMessage("用户不存在");
			}
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
		return message;
	}

   
	private User getUserByMobile(String mobile) {
		return userDao.getUserByMobile(mobile);
	}


	@Override
	public Message forgetPassword(HttpServletRequest request, UserVo userVo) {
		Message message = new Message();
		try {
			userVo.setMobile("12345678999");
			userVo.setPassword("963852741");
			User user =  getUserByMobile(cipher.encrypt(userVo.getMobile()));
			if(null != user){
				user.setMobile(user.getMobile());
				user.setPassPhrase(Password.getPassphrase(user.getSalt(),userVo.getPassword()));
				userDao.forgetPassword(user);
			}else{
				
			}
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
		return null;
	}



}
