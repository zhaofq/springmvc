package com.java.spring.util;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import com.java.spring.util.system.Message;
import com.java.spring.util.system.SystemEnum;
import com.java.spring.util.system.UException;

/**
* @author 作者:zhaofq
* @version 创建时间：2017年2月7日 下午5:03:46
* 类说明
*/
public class Fileupload {
	private static Logger logger = Logger.getLogger(Fileupload.class);
	static{
//		Map<String, Object> sysMap = SystemPro.getProperties();
		
//		comPhoto=(String) sysMap.get("PHOTOURL");
		comPhoto="F:/";
	}
	String filepath = null;
	String picUlr = null;
	private static String comPhoto;
	
	@SuppressWarnings("unused")
	public String pictureManagerUpload(MultipartFile items_pic,String name){
		Message ms = new Message();
		try {
			String pictureFile_name =  items_pic.getOriginalFilename();
			//新文件名称
			String newFileName = System.currentTimeMillis()+pictureFile_name.substring(pictureFile_name.lastIndexOf("."));

			//上传图片
			File uploadPic = null;
			String filepath ="/appVersion/"+newFileName;
			picUlr = comPhoto+filepath;
		    uploadPic = new java.io.File(picUlr);
			if(uploadPic == null){
				throw new UException(SystemEnum.FILE_READ_WRITE_EXCEPTION, "上传文件出错");
			}
			if(!uploadPic.exists()){
				uploadPic.mkdirs();
			}
			//向磁盘写文件
			items_pic.transferTo(uploadPic);
//			String script="<script>parent.callback('/"+"corporateImage/"+newFileName+"','"+name+"')</script>";
			return filepath;
		} catch (IllegalStateException |IOException | UException e) {
			e.printStackTrace();
			logger.info(e,e.fillInStackTrace());
			return "filed";
		} 
	}

}
