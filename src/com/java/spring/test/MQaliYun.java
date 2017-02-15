package com.java.spring.test;

import java.util.Properties;

import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.Producer;
import com.aliyun.openservices.ons.api.PropertyKeyConst;
import com.aliyun.openservices.ons.api.SendResult;

/**
* @author 作者:zhaofq
* @version 创建时间：2017年1月23日 下午1:48:07
* 类说明
*/
public class MQaliYun {

	public static void main(String[] args) {
		 Properties properties = new Properties();
	     properties.put(PropertyKeyConst.ProducerId, "qf_zhao");// 您在MQ控制台创建的Producer ID
	     properties.put(PropertyKeyConst.AccessKey,"LTAIfKP34NGQasTi");// 鉴权用AccessKey，在阿里云服务器管理控制台创建
	     properties.put(PropertyKeyConst.SecretKey, "EhGinGOPscFsiUkwFukXOaTAK4O3Xh");// 鉴权用SecretKey，在阿里云服务器管理控制台创建
	     Producer producer = ONSFactory.createProducer(properties);
	     producer.start();
	   //循环发送消息
	     while(true){
	         Message msg = new Message( //
	             // Message Topic
	             "qf_zhao",
	             // Message Tag,
	             // 可理解为Gmail中的标签，对消息进行再归类，方便Consumer指定过滤条件在MQ服务器过滤
	             "TagA",
	             // Message Body
	             // 任何二进制形式的数据， MQ不做任何干预，
	             // 需要Producer与Consumer协商好一致的序列化和反序列化方式
	             "Hello MQ".getBytes());
	         // 设置代表消息的业务关键属性，请尽可能全局唯一，以方便您在无法正常收到消息情况下，可通过MQ控制台查询消息并补发
	         // 注意：不设置也不会影响消息正常收发
	         msg.setKey("ORDERID_100");
	         // 发送消息，只要不抛异常就是成功
	         // 打印Message ID，以便用于消息发送状态查询
	         SendResult sendResult = producer.send(msg);
	         System.out.println("Send Message success. Message ID is: " + sendResult.getMessageId());
	     }

	}

}
