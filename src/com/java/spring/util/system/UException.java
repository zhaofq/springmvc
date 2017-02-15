package com.java.spring.util.system;

/**
* @author 作者:zhaofq
* @version 创建时间：2017年1月19日 下午4:48:56
* 类说明
*/
public class UException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private SystemEnum code;
	private String message;
	public SystemEnum getCode() {
		return code;
	}
	public void setCode(SystemEnum code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public UException(SystemEnum code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	
}
