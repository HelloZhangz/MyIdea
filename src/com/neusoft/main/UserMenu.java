package com.neusoft.main;

import com.neusoft.entity.Item;
import com.neusoft.entity.Menu;
import com.neusoft.start.Start;
import com.neusoft.user.QueryItem;
import com.neusoft.user.UpdateItem;
import com.neusoft.util.InputUtil;

public class UserMenu implements Menu{

	@Override
	public void show() {
		// TODO Auto-generated method stub
		System.out.println(Start.currUser.getUsername()+"您好:         您的权限是: 普通用户");
		System.out.println("=============================================");
		System.out.println("修改自己信息-------------------1");
		System.out.println("查询自己信息-------------------2");
		System.out.println("返回主菜 单--------------------3");
		System.out.println("程序退 出 ---------------------4");
	}

	@Override
	public Item pickItem() {
		// TODO Auto-generated method stub
		Item item = null;
		int i= InputUtil.getInt(1, 4);
		if(i == 1){
			item = new UpdateItem();
		}
		if(i == 2){
			item = new QueryItem();
		}
		if(i == 3){
			item = new BackLordItem();
		}if(i == 4){
			item = new ExitItem();
		}
		return item;
	}

}
