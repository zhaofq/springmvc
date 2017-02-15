package com.java.spring.util.system;

/**
 * @author Matthew(于文扬)
 * @date 2015-11-24 14:44
 * @version 1.0
 * 系统操作
 */
public enum SystemEnum {
	/**
	 * 登录成功
	 */
	LOGIN_SUCCESS(1000),
	/**
	 * 用户名或密码错误
	 */
	USER_PASSWORD_VAILD_FAILURE(1001),
	/**
	 * 用户不存在  
	 */
	USER_NOT_EXISTS(1002),
	
	/**
	 * 没有登录
	 */
	USER_NOLOGIN(1003),

	/**
	 *用户名不能更改
	 */
	USERNAME_CANT_CHANGE(1004),

	/**
	 * 没有开通第三方账户
	 */
	NOREGISTERED_UMPACCOUNT(1004),
	/**
	 * 实名注册失败
	 */
    REAL_NAME_AUTHENTICATION_FAILED(1005),
    /**
	 * 手机号已经被绑定
	 */
    PHONE_NUMBER_HAS_BEEN_BOUND(1006),
    /**
	 * 登录失败
	 */
	LOGIN_ERROR(1007),
    /**
     * 没有实名认证
     */
    UN_AUTHENTICATION(1008),
    /**
     * 没有实名认证
     */
    AUTHENTICATION_FAIL(1009),
	/**
	 * 数据库连接失败
	 */
	SERVER_REFUSED(9001),
	/**
	 * MD5加密错误
	 */
	EN_CODE_MD5_EXCEPTION(9002),
	/**
	 * 文件读写错误
	 */
	FILE_READ_WRITE_EXCEPTION(9003),
	/**
	 * 存款准备失败
	 */
	PREPARE_DEPOSIT_FAILED(8001),
	/**
	 * 调用第三方失败
	 */
	UMPAT_SIG__FAILED(8002),
	/**
	 * 申请金额大约可用金额
	 */
	AMOUNT_TOO_BIG(8009),
	/**
	 * 未知异常,请与管理员联系
	 */
	UNKNOW_EXCEPTION(9999),
    /**
     * 充值遇到问题，请联系客服
     */
	RECHARGE_EXCEPTION(9901),
	
	UPDATE_MOBLE_FAILED(9902);
	 private final Integer value;  
	    
	  /**
	 * @param value
	 */
	private SystemEnum(Integer value){  
	      this.value=value;  
	  }  
	    
	  /**
	 * @return
	 */
	public Integer value(){  
	      return value;  
	  }  
}
