package com.send;

import java.util.ArrayList;
import java.util.List;

import javapns.Push;

import javapns.notification.PushNotificationPayload;
import javapns.notification.PushedNotification;

public class MainClass {
	public static void main(String[] args) throws Exception {
		System.out.println("haha");

//		try {
//			String deviceToken = "47569b1253cfb960a1ee175706c4308064d09465d9d0c92eb18fe4f8b1634ba1";
//
//			PayLoad payLoad = new PayLoad();
//			payLoad.addAlert("测试推送消息发送");
//			payLoad.addBadge(6);
//			payLoad.addSound("default");
//			
//			List defaultInfo = new ArrayList();
//			defaultInfo.add("luyi");
//			defaultInfo.add("15");
//			payLoad.addCustomDictionary("info", defaultInfo);
//
//			PushNotificationManager pushManager = PushNotificationManager
//					.getInstance();
//			pushManager.addDevice("iPhone", deviceToken);
//
//			// Connect to APNs
//			/************************************************
//			 测试推送服务器地址：gateway.sandbox.push.apple.com /2195 
//			 产品推送服务器地址：gateway.push.apple.com / 2195 
//			 ***************************************************/
//			String host = "gateway.sandbox.push.apple.com";
//			int port = 2195;
//			String certificatePath = "/Users/luyi/Documents/iosKey/push_cer.p12";
//			String certificatePassword = "123456";
//			pushManager.initializeConnection(host, port, certificatePath,
//					certificatePassword,
//					SSLConnectionHelper.KEYSTORE_TYPE_PKCS12);
//
//			// Send Push
//			Device client = pushManager.getDevice("iPhone");
//			pushManager.sendNotification(client, payLoad);
//			pushManager.stopConnection();
//
//			pushManager.removeDevice("iPhone");
//			
//			
//			
//			System.out.println("发送成功");
//		} catch (Exception e) {
//			System.out.println("发送异常");
//			e.printStackTrace();
//		}
		
	    push();
		
		
	}
	
	
	public static  void push() throws Exception {
		System.out.println("haha");

		try {
			//47569b1253cfb960a1ee175706c4308064d09465d9d0c92eb18fe4f8b1634ba1
			String deviceToken = "6a839d8ef30c9afb55018f20cbfd53bd4a84c9b6e7c3c2fd98f20c6bcebf687f";

			String certificatePath = "/Users/luyi/Documents/iosKey/push_cer.p12";
			String certificatePassword = "123456";
			
			PushNotificationPayload payload = new PushNotificationPayload();  //声明一个空的payload  
			//payload.setExpiry(1);  //设置payload的过期时间  
			//payload.addAlert("alert message");  //设置alert消息  
			payload.addBadge(3);  //设置badge值  
			//payload.addCustomAlertBody("body message");
			payload.addSound("default");  //设置声音  
			payload.addCustomAlertActionLocKey("launch apns");  //设置ActionLocKey  本地应用需要的关键处理信息
			payload.addCustomAlertLocKey("show text");  //设置LocKey  弹出的提示内容
//			payload.addCustomDictionary("sdf", 23);
			//payload.addCustomDictionary("sdfsd", "sdf");
			
			payload.addCustomDictionary("custom1", "value1");  //增加一个自定义键值对  
			List<String> tmpList = new ArrayList<String>();
			tmpList.add(deviceToken);
			//tmpList.add(deviceToken);
			List<PushedNotification> notifications = Push.payload(payload, certificatePath, certificatePassword,   false,   tmpList);  //调用Push.payload方法发送这个payload，发回一个已发送的notification的列表
			
			System.out.println("发送成功");
		} catch (Exception e) {
			System.out.println("发送异常");
			e.printStackTrace();
		}
	}
	
	
}



