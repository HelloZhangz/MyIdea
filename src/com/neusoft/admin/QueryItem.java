package com.neusoft.admin;

import com.neusoft.entity.Item;
import com.neusoft.entity.Menu;

public class QueryItem implements Item{

	@Override
	public Menu execute() {
		// TODO Auto-generated method stub
		
		return new QueryMenu();
	}

}
