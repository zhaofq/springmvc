package com.java.spring.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.java.spring.util.system.Message;

/**
* @author 作者:zhaofq
* @version 创建时间：2017年2月13日 下午1:58:57
* 类说明
*/
public abstract class CC {
	 public abstract Message  pictureManager(MultipartFile items_pic, String name,HttpServletRequest request);
}
