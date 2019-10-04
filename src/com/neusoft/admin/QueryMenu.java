package com.neusoft.admin;

import com.neusoft.entity.Item;
import com.neusoft.entity.Menu;
import com.neusoft.main.AdminMenu;
import com.neusoft.main.BackAdminItem;
import com.neusoft.util.InputUtil;

public class QueryMenu implements Menu{

	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println("查询全部用户---------------1");
		System.out.println("根据ID查询用户-------------2");
		System.out.println("根据姓名查询用户------------3");
		System.out.println("返回上一级菜单 -------------4");
	}

	@Override
	public Item pickItem() {
		// TODO Auto-generated method stub
		int i = InputUtil.getInt(1, 4);
		Item item = null;
		switch(i){
		case 1 :
			item = new QueryAllItem();
			break;
		case 2 :
			item = new QueryByIDItem();
			break;
		case 3 :
			item = new QueryByNameItem();
			break;
		case 4 :
			item = new BackAdminItem();
			break;
		}
		return item;
	}
	
}
