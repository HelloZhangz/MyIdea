package com.neusoft.util;

import java.util.Scanner;

public class InputUtil {
	public static String getEmail(){
		String email = null;
		while(true){
			email = getString();
			if(email.indexOf("@") == -1 || email.indexOf(".") == -1){
				System.out.println("邮箱中不包含@或.");
			}else{
				if(email.indexOf("@") != email.lastIndexOf("@") 
						|| email.indexOf(".") != email.lastIndexOf(".")){
					System.out.println("邮箱中出现了多个@或.");
				}else{
					if(email.lastIndexOf("@")>email.indexOf(".")){
						System.out.println("@出现在.后边");
					}else{
						break;
					}
				}
			}
		}
		return email;
		
	}
	//获取输入的选项
	public static int getInt(int low,int high){
		int i = 0;
		while(true){
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入选项");
			try {
				i = sc.nextInt();
				if(i<low || i>high){
					System.out.println("您输入的选项不在有效范围，请重新输入");
				}else{
					break;
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("您输入的选项不合法");
			}
			
		}
		return i;
	}
	public static String getString(){
		String str = null;
		while(true){
			Scanner sc = new Scanner(System.in);
			str = sc.next();
			if(str == null || "".trim().equals(str)){
				
			}else{
				break;
			}
		}
		return str;
	}
	public static int getInt(){
		int i = 0;
		while(true){
			Scanner sc  = new Scanner(System.in);
			try {
				i = sc.nextInt();
				break;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("您输入的账户ID不合法");
			}
		}
		return i;
	}
	public static String getPower(){
		String power = null;
		while(true){
			power = getString();
			if("管理员".equals(power)||"普通用户".equals(power)){
				break;
			}
		}
		return power;
	}
}
