package com.basic.rentcar.frontController;

import java.util.HashMap;

import com.basic.rentcar.controller.rentcar.CarInfoController;
import com.basic.rentcar.controller.rentcar.CarListController;
import com.basic.rentcar.controller.user.JoinUserController;
import com.basic.rentcar.controller.user.LoginCheckController;
import com.basic.rentcar.controller.user.LogoutController;
import com.basic.rentcar.controller.user.MainController;

public class HandlerMapping {
	private HashMap<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		
		mappings.put("/main.do", new MainController());
		mappings.put("/login.do", new LoginCheckController());
		mappings.put("/join.do", new JoinUserController());
		mappings.put("/logout.do", new LogoutController());
		mappings.put("/rentcarList.do", new CarListController());
		mappings.put("/rentcarInfo.do", new CarInfoController());
	}
	
	public Controller getController(String key) {
		return mappings.get(key);
	}
}
