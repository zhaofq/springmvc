package com.java.spring.util.utils;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

/**
 * @author 作者:zhaofq
 * @version 创建时间：2017年1月13日 上午10:49:23 类说明
 */
public class ByteToObject {
	public Object byteToObject(byte[] bytes) {
		Object obj = null;
		try {
			ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
			ObjectInputStream oi = new ObjectInputStream(bi);
			obj = oi.readObject();
			bi.close();
			oi.close();
		} catch (Exception e) {
			System.out.println("translation" + e.getMessage());
			e.printStackTrace();
		}
		return obj;
	}
}
