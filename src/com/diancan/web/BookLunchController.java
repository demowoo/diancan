package com.diancan.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diancan.model.DayOrder;
import com.diancan.model.Food;
import com.diancan.service.DayOrderService;
import com.diancan.service.FoodService;
import com.diancan.util.inter.JsonUtil;

@Controller
public class BookLunchController {
	private static final String STATUS = "status";
	private static final String FOODLIST = "foodlist";
	
	@Autowired
	private DayOrderService dayOrderService;
	@Autowired
	private FoodService foodService;
	@Autowired
	JsonUtil jsonUtil;
	
	@RequestMapping("bookview.action")
	public String gotoBookPage(ModelMap model){
		DayOrder dayOrder = dayOrderService.getTodayOrder();
		if(dayOrder == null){
			model.put(STATUS, "nostart");
			return "bookview";
		}
		if(!dayOrderService.isOpen()){
			model.put(STATUS, "close");
		}else{
			model.put(STATUS, "open");
			List<Food> foodlist = foodService.getCanOrderFoodList(dayOrder.getRestId());
			String listJson = jsonUtil.toJsonString(foodlist);
			model.put(FOODLIST, listJson);
		}
			
		return "bookview";
	}
}
