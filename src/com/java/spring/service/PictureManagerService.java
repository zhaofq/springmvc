package com.java.spring.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.java.spring.util.system.Message;
import com.java.spring.vo.PictureVo;

/**
* @author 作者:zhaofq
* @version 创建时间：2017年2月7日 下午5:22:40
* 类说明
*/
public interface PictureManagerService {
	
	
    public Message  pictureManager(MultipartFile items_pic, String name,HttpServletRequest request);

	public List<PictureVo> findPictures(HttpServletRequest request);
}
