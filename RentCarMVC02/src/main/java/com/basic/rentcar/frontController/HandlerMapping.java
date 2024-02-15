package com.basic.rentcar.frontController;

import java.util.HashMap;

import com.basic.rentcar.controller.rentcar.AdminCarListController;
import com.basic.rentcar.controller.rentcar.CarInfoController;
import com.basic.rentcar.controller.rentcar.CarListController;
import com.basic.rentcar.controller.rentcar.DeleteRentcarController;
import com.basic.rentcar.controller.rentcar.DeleteResController;
import com.basic.rentcar.controller.rentcar.InsertCarController;
import com.basic.rentcar.controller.rentcar.RentcarInfoController;
import com.basic.rentcar.controller.rentcar.ReservateCarController;
import com.basic.rentcar.controller.rentcar.SelectCarOptionController;
import com.basic.rentcar.controller.rentcar.UpdateRentcarController;
import com.basic.rentcar.controller.rentcar.UploadCarImgController;
import com.basic.rentcar.controller.rentcar.UserReserveListController;
import com.basic.rentcar.controller.user.AdminUserListController;
import com.basic.rentcar.controller.user.DeleteUserController;
import com.basic.rentcar.controller.user.JoinUserController;
import com.basic.rentcar.controller.user.LoginCheckController;
import com.basic.rentcar.controller.user.LogoutController;
import com.basic.rentcar.controller.user.MainController;
import com.basic.rentcar.controller.user.UpdateUserController;
import com.basic.rentcar.controller.user.UserInfoController;
import com.basic.rentcar.controller.user.VaildateldController;

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
		mappings.put("/carOption.do", new SelectCarOptionController());
		mappings.put("/reserveView.do", new ReservateCarController());
		mappings.put("/userReserveList.do", new UserReserveListController());
		mappings.put("/deleteRes.do", new DeleteResController());
		mappings.put("/idCheck.do", new VaildateldController());
		mappings.put("/userInfo.do", new UserInfoController());
		mappings.put("/deleteUser.do", new DeleteUserController());
		mappings.put("/updateUser.do", new UpdateUserController());
		mappings.put("/insertCar.do", new InsertCarController());
		mappings.put("/uploadCarImg.do", new UploadCarImgController());
		mappings.put("/adminUserList.do", new AdminUserListController());
		mappings.put("/adminCarList.do", new AdminCarListController());
		mappings.put("/updateRentcarInfo.do", new RentcarInfoController());
		mappings.put("/updateRentcar.do", new UpdateRentcarController());
		mappings.put("/deleteRentcar.do", new DeleteRentcarController());
	}
	
	public Controller getController(String key) {
		return mappings.get(key);
	}
}
