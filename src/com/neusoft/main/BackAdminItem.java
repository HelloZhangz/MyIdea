package com.neusoft.main;

import com.neusoft.entity.Item;
import com.neusoft.entity.Menu;

public class BackAdminItem implements Item{

	@Override
	public Menu execute() {
		// TODO Auto-generated method stub
		return new AdminMenu();
	}

}
