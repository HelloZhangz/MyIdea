package com.neusoft.main;

import com.neusoft.entity.Item;
import com.neusoft.entity.Menu;

public class BackLordItem implements Item{

	@Override
	public Menu execute() {
		// TODO Auto-generated method stub
		return new MainMenu();
	}

}
