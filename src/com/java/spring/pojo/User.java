package com.java.spring.pojo;

import java.io.Serializable;
import java.util.Date;

/**
* @author 作者:zhaofq
* @version 创建时间：2017年1月10日 下午2:14:01
* 类说明
*/
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6568316157487332053L;
	private String userId;
	private String userName;
    private String password;
    private String Id;
    private String email;
    private String IdNumber;
    private Date birthDate;
    private Date lastLoginDate;
    private String loginName;
    private String mobile;
    private String name;
    private String passPhrase;
    private Date registerDate;
    private String salt;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIdNumber() {
		return IdNumber;
	}
	public void setIdNumber(String idNumber) {
		IdNumber = idNumber;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Date getLastLoginDate() {
		return lastLoginDate;
	}
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassPhrase() {
		return passPhrase;
	}
	public void setPassPhrase(String passPhrase) {
		this.passPhrase = passPhrase;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", Id=" + Id
				+ ", email=" + email + ", IdNumber=" + IdNumber + ", birthDate=" + birthDate + ", lastLoginDate="
				+ lastLoginDate + ", loginName=" + loginName + ", mobile=" + mobile + ", name=" + name + ", passPhrase="
				+ passPhrase + ", registerDate=" + registerDate + ", salt=" + salt + "]";
	}

	
    
    
    
}
