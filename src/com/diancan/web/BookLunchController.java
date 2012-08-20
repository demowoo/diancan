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
import org.springframework.web.bind.annotation.ResponseBody;

import com.diancan.mapper.RestaurantMapper;
import com.diancan.model.DayOrder;
import com.diancan.model.Food;
import com.diancan.model.Order;
import com.diancan.model.Restaurant;
import com.diancan.model.User;
import com.diancan.service.DayOrderService;
import com.diancan.service.FoodService;
import com.diancan.service.OrderService;
import com.diancan.service.RestaurantService;
import com.diancan.service.UserService;
import com.diancan.util.inter.JsonUtil;
import common.Constant;

@Controller
public class BookLunchController {
	
	@Autowired
	private DayOrderService dayOrderService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;
	@Autowired
	private FoodService foodService;
	@Autowired
	private RestaurantService restaurantService;
	@Autowired
	private RestaurantMapper restaurantMapper;
	@Autowired
	private JsonUtil jsonUtil;
	
	@RequestMapping("welcome.action")
	public String gotoWelcome(ModelMap model, HttpSession httpSession){
		User loginUser = (User)httpSession.getAttribute(Constant.LOGININFO);
		Order userOrder = orderService.getTodayOrderByUserId(loginUser.getId()); 

		List<DayOrder> dayOrderList = dayOrderService.getTodayOrder();
		boolean isOpen = true;
		
		List resultList = null;
		if(dayOrderList.size() > 0){
			resultList = new ArrayList();
			for(DayOrder dayOrder : dayOrderList){
				if(userOrder != null && userOrder.getDayOrderId() == dayOrder.getId())
					isOpen = dayOrder.isOpen();
				boolean isOwn = false;
				if(dayOrder.getUserId() == loginUser.getId())
					isOwn = true;
				User user = userService.getUserById(dayOrder.getUserId());
				Restaurant rest = restaurantService.getRestById(dayOrder.getRestId());
				Map resultMap = new HashMap();
				resultMap.put("dayOrderId", dayOrder.getId());
				resultMap.put("time", dayOrder.getTime());
				resultMap.put("open", dayOrder.isOpen());
				resultMap.put("restName", rest.getName());
				resultMap.put("restId", rest.getId());
				resultMap.put("userName", user.getRealname());
				resultMap.put("isown", isOwn);
				resultList.add(resultMap);
			}
		}
		model.put("open", isOpen);
		model.put("userorder", userOrder);
		model.put("dayorderlist", resultList);
		return "welcome";
	}
	
	@RequestMapping("createdayorder.action")
	public String createDayOrder(int restId, HttpSession httpSession, ModelMap model){
		User loginUser = (User)httpSession.getAttribute(Constant.LOGININFO);
		List<DayOrder> dayOrderList = dayOrderService.getTodayOrder();
		boolean booked = false;
		for(DayOrder dayOrder : dayOrderList){
			if((dayOrder.getRestId() == restId) && (dayOrder.getUserId() == loginUser.getId())) {
				booked = true;
				break;
			}
		}
		if(booked){
			model.put(Constant.INFO, "你已经建立过此餐馆的订单");
			return Constant.INFO;
		}
		dayOrderService.createDayOrder(restId, loginUser.getId());
//		List<DayOrder> resultList = dayOrderService.getOrderList(10);
//		model.put("dayorderlist", resultList);
//		return "welcome";
		return "forward:welcome.action";
	}
	
	@RequestMapping("getrestlist.do")
	@ResponseBody
	public String getRestList(){
		List<Restaurant> restList = new ArrayList<Restaurant>();
		restList = restaurantMapper.getRestList();
		return jsonUtil.toJsonString(restList);
	}
	
	@RequestMapping("delorder.action")
	public String delOrder(int orderId, ModelMap model){
		Order order = orderService.getOrderById(orderId);
		int dayOrderId = order.getDayOrderId();
		DayOrder dayOrder = dayOrderService.getDayOrderById(dayOrderId);
		if(dayOrder.isOpen()){
			orderService.delOrder(orderId);
			return "forward:welcome.action";
		}else{
			model.put(Constant.INFO, "你加入的订单已经关闭，不能取消订餐");
			return Constant.INFO;
		}
	}
	
	@RequestMapping("choosefood.action")
	public String getCanOrderList(int restId, int dayOrderId, ModelMap model){
		List<Food> foodList = foodService.getCanOrderFoodList(restId);
		model.put("foodlist", foodList);
		model.put("dayorderid", dayOrderId);
		return "choosefood";
	}
	
	@RequestMapping("book.action")
	public String bookLuanch(int foodId, int dayOrderId, HttpSession httpSession, ModelMap model){
		Food food = foodService.getFoodId(foodId);
		DayOrder dayOrder = dayOrderService.getDayOrderById(dayOrderId);
		if(food.getRestId() != dayOrder.getRestId()){
			model.put(Constant.INFO, "你加入的订单所属餐馆没有你所点的菜");
			return Constant.INFO;
		}
		
		User loginUser = (User)httpSession.getAttribute(Constant.LOGININFO);
		
		Order orderToday = orderService.getTodayOrderByUserId(loginUser.getId());
		if(orderToday != null){
			model.put(Constant.INFO, "你今天已经点过餐，不能重复点餐");
			return Constant.INFO;
		}
		
		Date date = new Date();
		
		Order order = new Order();
		order.setDayOrderId(dayOrderId);
		order.setFoodId(foodId);
		order.setFoodName(food.getName());
		order.setPrice(food.getPrice());
		order.setRestId(dayOrder.getRestId());
		order.setTime(date.getTime());
		order.setUserId(loginUser.getId());
		order.setUserName(loginUser.getRealname());
		
		orderService.addOrder(order);
		foodService.addBookCount(foodId);
		return "redirect:welcome.action";
	}
	
	@RequestMapping("viewdayorder.action")
	public String viewDayOrder(int dayOrderId, ModelMap model){
		DayOrder dayOrder = dayOrderService.getDayOrderById(dayOrderId);
		List<Order> orderList = orderService.getOrderListByDayOrderId(dayOrderId);
		Restaurant rest = restaurantService.getRestById(dayOrder.getRestId());
		User user = userService.getUserById(dayOrder.getUserId());
		
		Map<Integer,Integer> countMap = new HashMap<Integer,Integer>();
		float totalPrice = 0;
		for(Order order : orderList){
			totalPrice += order.getPrice();
			Integer foodCount = countMap.get(order.getFoodId());
			if(foodCount == null){
				countMap.put(order.getFoodId(), 1);
			}else{
				countMap.put(order.getFoodId(), foodCount+1);
			}
		}
		
		List<Map> summaryList = new ArrayList<Map>();
		for(Integer foodId : countMap.keySet()){
			Order order = getOrderFromList(foodId, orderList);
			Map summaryMap = new HashMap();
			summaryMap.put("foodname", order.getFoodName());
			summaryMap.put("count", countMap.get(foodId));
			summaryList.add(summaryMap);
		}
		
		model.put("dayorder", dayOrder);
		model.put("orderlist", orderList);
		model.put("rest", rest);
		model.put("user", user);
		model.put("summarylist", summaryList);
		model.put("totalprice", totalPrice);
		
		return "viewdayorder";
	}
	private Order getOrderFromList(int foodId, List<Order> orderList){
		for(Order order : orderList){
			if(order.getFoodId() == foodId)
				return order;
		}
		return null;	
	}
	
	@RequestMapping("deldayorder.action")
	public String delDayOrder(int dayOrderId){
		dayOrderService.delDayOrder(dayOrderId);
		List<Order> foodList = orderService.getOrderListByDayOrderId(dayOrderId);
		for(Order order : foodList){
			foodService.subtractBookCount(order.getFoodId());
		}
		return "forward:welcome.action";
	}
	
	@RequestMapping("closedayorder.action")
	public String closeDayOrder(int dayOrderId, HttpSession httpSession, ModelMap model){
		User loginUser = (User)httpSession.getAttribute(Constant.LOGININFO);
		DayOrder dayOrder = dayOrderService.getDayOrderById(dayOrderId);
		if(dayOrder.getUserId() != loginUser.getId()){
			model.put(Constant.INFO, "此订单不是你创建，你没有权限执行此操作！");
			return Constant.INFO;
		}
		dayOrderService.close(dayOrderId);
		return "forward:welcome.action";
	}
	
	@RequestMapping("opendayorder.action")
	public String openDayOrder(int dayOrderId, HttpSession httpSession, ModelMap model){
		User loginUser = (User)httpSession.getAttribute(Constant.LOGININFO);
		DayOrder dayOrder = dayOrderService.getDayOrderById(dayOrderId);
		if(dayOrder.getUserId() != loginUser.getId()){
			model.put(Constant.INFO, "此订单不是你创建，你没有权限执行此操作！");
			return Constant.INFO;
		}
		dayOrderService.open(dayOrderId);
		return "forward:welcome.action";
	}
}
