package com.neusoft.main;

import com.neusoft.admin.AddItem;
import com.neusoft.admin.DeleteItem;
import com.neusoft.admin.QueryItem;
import com.neusoft.admin.UpdateItem;
import com.neusoft.entity.Item;
import com.neusoft.entity.Menu;
import com.neusoft.start.Start;
import com.neusoft.util.InputUtil;

public class AdminMenu implements Menu{

	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println(Start.currUser.getUsername()+"您好:         您的权限是: 管理员");
		System.out.println("===================================");
		System.out.println("添加用户---------------1");
		System.out.println("删除用户---------------2");
		System.out.println("修改用户---------------3");
		System.out.println("查询用户---------------4");
		System.out.println("返回主菜单 -------------5");
		System.out.println("退出程序---------------6");
		
	}

	@Override
	public Item pickItem() {
		// TODO Auto-generated method stub
		Item item = null;
		int i = InputUtil.getInt(1, 6);
		switch(i){
			case 1 : 
				item = new AddItem();
				break;
			case 2 :
				item = new DeleteItem();
				break;
			case 3 :
				item = new UpdateItem();
				break;
			case 4 :
				item = new QueryItem();
				break;
			case 5 :
				item = new BackLordItem();
				break;
			case 6 :
				item = new ExitItem();
				break;
		}
		return item;
	}

}
