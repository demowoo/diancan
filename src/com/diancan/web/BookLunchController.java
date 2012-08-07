package com.diancan.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diancan.model.DayOrder;
import com.diancan.model.Order;
import com.diancan.model.Restaurant;
import com.diancan.model.User;
import com.diancan.service.DayOrderService;
import com.diancan.service.OrderService;
import com.diancan.service.RestaurantService;
import com.diancan.service.UserService;
import com.diancan.util.inter.JsonUtil;
import common.Constant;

@Controller
public class BookLunchController {
	
	private static final String STATUS = "status";
	
	@Autowired
	private DayOrderService dayOrderService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;
	@Autowired
	private RestaurantService restaurantService;
	@Autowired
	private JsonUtil jsonUtil;
	
	@RequestMapping("welcome.action")
	public String gotoWelcome(ModelMap model, HttpSession httpSession){
		User loginUser = (User)httpSession.getAttribute(Constant.LOGININFO);
		Order userOrder = orderService.getTodayOrderByUserId(loginUser.getId()); 
		
		if(userOrder != null){//定过餐
			model.put(STATUS, "booked");
			model.put("userorder", userOrder);
			return "welcome";
		}else{
			List<DayOrder> dayOrderList = dayOrderService.getTodayOrder();
			if(dayOrderList == null){
				model.put(STATUS, "nostart");
				return "welcome";
			}
			
			List resultList = new ArrayList();
			for(DayOrder dayOrder : dayOrderList){
				User user = userService.getUserById(dayOrder.getUserId());
				Restaurant rest = restaurantService.getRestById(dayOrder.getRestId());
				Map resultMap = new HashMap();
				resultMap.put("dayOrderId", dayOrder.getId());
				resultMap.put("time", dayOrder.getTime());
				resultMap.put("open", dayOrder.isOpen());
				resultMap.put("restName", rest.getName());
				resultMap.put("restId", rest.getId());
				resultMap.put("userName", user.getRealname());
				resultList.add(dayOrder);
			}
			model.put("dayorderlist", resultList);
			model.put(STATUS, "open");
			return "welcome";
		}
	}
	
	@RequestMapping("createdayorder.action")
	public String createDayOrder(int restId, HttpSession httpSession, ModelMap model){
		User loginUser = (User)httpSession.getAttribute(Constant.LOGININFO);
		Date date = new Date();
		List<DayOrder> dayOrderList = dayOrderService.getDayOrder(date.getTime());
		boolean booked = false;
		for(DayOrder dayOrder : dayOrderList){
			if(dayOrder.getRestId() == restId){
				booked = true;
				break;
			}
		}
		if(booked){
			model.put(Constant.INFO, "你已经建立过此餐馆的订单");
			return "info";
		}
		dayOrderService.createDayOrder(restId, loginUser.getId());
		List<DayOrder> resultList = dayOrderService.getOrderList(10);
		model.put("dayorderlist", resultList);
		return "dayorderlist";
	}
	
}
