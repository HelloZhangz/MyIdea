package com.neusoft.start;

import com.neusoft.entity.Item;
import com.neusoft.entity.Menu;
import com.neusoft.entity.User;
import com.neusoft.main.MainMenu;

public class Start {
//	当前登录的用户
	public static User currUser;
	public static void main(String[] args) {
		//创建主菜单对象
		Menu menu = new MainMenu();
		//利用多态，由于是MainMenu类型的对象所
		//以走MainMenu的show()方法
		while(menu != null){
			menu.show();
			Item item = menu.pickItem();
			menu = item.execute();
		}
		System.out.println("感谢使用，再见！");
	}

}
