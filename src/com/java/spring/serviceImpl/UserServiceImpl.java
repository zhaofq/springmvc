package com.java.spring.serviceImpl;

import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.spring.dao.UserDao;
import com.java.spring.pojo.User;
import com.java.spring.redisdao.RedisUserDao;
import com.java.spring.service.UserService;
import com.java.spring.util.system.DESTextCipher;
import com.java.spring.util.system.Message;
import com.java.spring.util.system.Password;
import com.java.spring.vo.UserVo;

/**
 * @author 作者:zhaofq
 * @version 创建时间：2017年1月10日 下午2:13:25 类说明
 */
@Service
public class UserServiceImpl implements UserService {

	private static Logger loger = Logger.getLogger(UserServiceImpl.class.getName());
	static DESTextCipher cipher = DESTextCipher.getDesTextCipher();

	@Autowired
	UserDao userDao;

	@Autowired
	RedisUserDao redisUserDao;

	@Override
	public Message registerUser(HttpServletRequest request, User user) {
		Message message = new Message();
		if (null != user) {
			try {
				String mobile = cipher.encrypt(user.getMobile());
				Map<String, User> mapuser = this.getUserByMobile(mobile);
				if (!mapuser.isEmpty()) {
					return new Message(0, "用户已经存在");
				} else {
					User userR = this.getUserByMobilefromSql(mobile);
					if (null != userR) {
						return new Message(0, "用户已经存在");
					} else {
						String salt = Password.getSalt(null);
						user.setId(UUID.randomUUID().toString().toUpperCase());
						user.setMobile(mobile);
						user.setPassPhrase(Password.getPassphrase(salt, user.getPassword()));
						user.setRegisterDate(new Date());
						user.setSalt(salt);
						int result = userDao.addUser(user);
						if (result != 0) {
							redisUserDao.addUser(user);
							return new Message(1, "注册成功");
						} else {

							return new Message(0, "注册失败");
						}
					}
				}
			} catch (GeneralSecurityException e) {
				loger.info("register exception :" + e);
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
			String mobile = cipher.encrypt(userVo.getMobile());
			Map<String, User> usermap = this.getUserByMobile(cipher.encrypt(userVo.getMobile()));
			if (usermap.isEmpty()) {
				User user = getUserByMobilefromSql(mobile);
				if (null == user) {
					return new Message(1, "用户不存在");
				} else {
					String salt = user.getSalt();
					if (user.getPassPhrase().endsWith(Password.getPassphrase(salt, userVo.getPassword()))) {
						return new Message(0, "登录成功");
					} else {
						return new Message(0, "密码错误");
					}
				}
			} else {
				String salt = String.valueOf(usermap.get("salt"));
				String passPhrase = String.valueOf(usermap.get("passPhrase"));
				if (passPhrase.endsWith(Password.getPassphrase(salt, userVo.getPassword()))) {
					return new Message(0, "登录成功");
				} else {
					return new Message(0, "密码错误");
				}
			}
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
		}
		return message;
	}

	private Map<String, User> getUserByMobile(String mobile) {
		return redisUserDao.getUserByMobile(mobile);
	}

	private User getUserByMobilefromSql(String mobile) {
		return userDao.getUserByMobilefromSql(mobile);
	}

	@Override
	public Message forgetPassword(HttpServletRequest request, UserVo userVo) {
		Message message = new Message();
		/*
		 * User user = getUserByMobile(cipher.encrypt(userVo.getMobile())); User
		 * user = getUserByMobile(cipher.encrypt(userVo.getMobile())); if(null
		 * != user){ user.setMobile(cipher.encrypt(userVo.getMobile()));
		 * user.setPassPhrase(Password.getPassphrase(user.getSalt(),userVo.
		 * getPassword())); userDao.forgetPassword(user); }else{
		 * 
		 * }
		 */

		try {
			Map<String, User> user = getUserByMobile(cipher.encrypt(userVo.getMobile()));
			String salt = String.valueOf(user.get("salt"));
			String userMobile = String.valueOf(user.get("mobile"));
			if (null != user) {
				String password = null;
				String passwordVla = Password.getPassphrase(salt, "123456456789");
				int result = userDao.forgetPassword(userMobile, password, passwordVla);
				// int result = userDao.forgetPassword(userMobile, password,
				// passwordVla);
			}
		} catch (GeneralSecurityException e) {

			e.printStackTrace();
		}

		return null;
	}

}
