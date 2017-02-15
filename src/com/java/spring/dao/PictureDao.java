package com.java.spring.dao;

import java.util.List;

import com.java.spring.pojo.Picture;
import com.java.spring.vo.PictureVo;

/**
* @author 作者:zhaofq
* @version 创建时间：2017年2月10日 下午4:45:07
* 类说明
*/
public interface PictureDao {

	public int addPicture(Picture picture) throws Exception;

	public List<PictureVo> findPictures(Picture picture)throws Exception;
}
