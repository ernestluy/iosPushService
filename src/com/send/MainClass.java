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
//			payLoad.addAlert("����������Ϣ����");
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
//			 �������ͷ�������ַ��gateway.sandbox.push.apple.com /2195 
//			 ��Ʒ���ͷ�������ַ��gateway.push.apple.com / 2195 
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
//			System.out.println("���ͳɹ�");
//		} catch (Exception e) {
//			System.out.println("�����쳣");
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
			
			PushNotificationPayload payload = new PushNotificationPayload();  //����һ���յ�payload  
			//payload.setExpiry(1);  //����payload�Ĺ���ʱ��  
			//payload.addAlert("alert message");  //����alert��Ϣ  
			payload.addBadge(3);  //����badgeֵ  
			//payload.addCustomAlertBody("body message");
			payload.addSound("default");  //��������  
			payload.addCustomAlertActionLocKey("launch apns");  //����ActionLocKey  ����Ӧ����Ҫ�Ĺؼ�������Ϣ
			payload.addCustomAlertLocKey("show text");  //����LocKey  ��������ʾ����
//			payload.addCustomDictionary("sdf", 23);
			//payload.addCustomDictionary("sdfsd", "sdf");
			
			payload.addCustomDictionary("custom1", "value1");  //����һ���Զ����ֵ��  
			List<String> tmpList = new ArrayList<String>();
			tmpList.add(deviceToken);
			//tmpList.add(deviceToken);
			List<PushedNotification> notifications = Push.payload(payload, certificatePath, certificatePassword,   false,   tmpList);  //����Push.payload�����������payload������һ���ѷ��͵�notification���б�
			
			System.out.println("���ͳɹ�");
		} catch (Exception e) {
			System.out.println("�����쳣");
			e.printStackTrace();
		}
	}
	
	
}



