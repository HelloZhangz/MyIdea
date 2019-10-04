package com.neusoft.main;

import com.neusoft.entity.Item;
import com.neusoft.entity.Menu;
import com.neusoft.util.InputUtil;

public class MainMenu implements Menu{

	@Override
	public void show() {
		// TODO Auto-generated method stub
		//主菜单的显示内容
		System.out.println("欢迎使用NEUSOFT管理系统");
		System.out.println("======================");
		System.out.println("用户登录--------------1");
		System.out.println("用户注册--------------2");
		System.out.println("退出程序--------------3");
		
	}

	@Override
	public Item pickItem() {
		// TODO Auto-generated method stub
		//选择功能
		Item item = null;
		int i = InputUtil.getInt(1, 3);
		switch(i){
		case 1:
			item = new LoginItem();
			break;
		case 2:
			item = new RegistItem();
			break;
		case 3:
			item = new ExitItem();
		}
		return item;
		
	}

}
