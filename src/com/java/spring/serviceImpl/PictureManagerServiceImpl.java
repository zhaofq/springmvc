package com.java.spring.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.java.spring.dao.PictureDao;
import com.java.spring.pojo.Picture;
import com.java.spring.pojo.User;
import com.java.spring.service.PictureManagerService;
import com.java.spring.util.Fileupload;
import com.java.spring.util.system.FormatUtils;
import com.java.spring.util.system.Message;
import com.java.spring.vo.PictureVo;

/**
* @author 作者:zhaofq
* @version 创建时间：2017年2月7日 下午5:24:42
* 类说明
*/
@Service
public class PictureManagerServiceImpl implements PictureManagerService{
	
	
	private static Logger loger = Logger.getLogger(PictureManagerServiceImpl.class.getName());
	
	
	@Autowired
	PictureDao pictureDao;
	
	public Message pictureManager(MultipartFile items_pic, String name,HttpServletRequest request){
		Fileupload fp = new Fileupload();
		User user = (User)request.getSession().getAttribute("userInfo");
		String uploadResult= fp.pictureManagerUpload(items_pic, name);
		Message message = new Message();
		if (null != user) {
			if ( uploadResult != "filed") {
				Picture picture = new Picture();
				picture.setId(UUID.randomUUID().toString().toUpperCase());
				picture.setCreateadate((FormatUtils.millisDateFormat(new Date())).toString());
				picture.setUserId(user.getId());
				picture.setUrl(uploadResult);
				picture.setDiscription(request.getParameter("discription"));
				int i = this.addPicture(picture);
				if (i != 0) {
					message.setCode(0);
					message.setMessage("成功");
				} else {
					message.setCode(1);
					message.setMessage("失败");
				}
			} else {
				message.setCode(1);
				message.setMessage("上传图片失败");
			}
		} else {
			message.setCode(1);
			message.setMessage("用户登录过期,请从新登录");
		}
		
		return message;
	}

	private int addPicture(Picture picture) {
		int i = 0;
		try {
			i = pictureDao.addPicture(picture);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List<PictureVo> findPictures(HttpServletRequest request) {
		List<PictureVo> pictureVos = new ArrayList<>();
		List<PictureVo> pictureVo = new ArrayList<>();
				Picture picture = new Picture();
				try {
					pictureVos = pictureDao.findPictures(picture);
					if (pictureVos.size() > 0) {
						for (int i = 0; i < pictureVos.size(); i++) {
							PictureVo picture1 = new PictureVo();
							picture1.setUrl("https://localhost"+pictureVos.get(i).getUrl());
							pictureVo.add(picture1);
						}
					} else {
					}
					
				} catch (Exception e) {
					loger.info("findPictures is Exception"+e);
					e.printStackTrace();
				}
		return  pictureVo;
	}

}
