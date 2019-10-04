package com.neusoft.main;

import com.neusoft.entity.Item;
import com.neusoft.entity.Menu;

public class ExitItem implements Item{

	@Override
	public Menu execute() {
		// TODO Auto-generated method stub
		//return null以后，主方法会接收到null，循环结束
		//退出程序
		return null;
	}

}
