package com.diancan.web;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diancan.mapper.FoodMapper;
import com.diancan.mapper.RestaurantMapper;
import com.diancan.model.Food;
import com.diancan.model.Restaurant;
import com.diancan.util.JsonUtil;
import common.Constant;

@Controller
public class MenuController {

	@Autowired
	private RestaurantMapper restaurantMapper;
	@Autowired
	private FoodMapper foodMapper;
	
	@Autowired
	private JsonUtil jsonUtil;
	
	@RequestMapping("viewmenu.action")
	public String viewMenu(ModelMap model){
		List<Restaurant> restList = restaurantMapper.getRestList();
		String restListJson = jsonUtil.toJsonString(restList);
		model.put("restList", restListJson);
		return "viewmenu";
	}
	
	@RequestMapping("addrest.action")
	public String addRest(Restaurant rest, ModelMap model){
		Restaurant restaurant = restaurantMapper.getRestByName(rest.getName());
		if(restaurant != null){
			model.put(Constant.INFO, "店名已经存在");
			return "info";
		}
		Date date = new Date();
		rest.setTime(date.getTime());
		restaurantMapper.addRest(rest);
		return "forward:viewmenu.action";
	}
	
	@RequestMapping("addfood.action")
	public String addFood(Food food, String pri, String day_start, String day_end, int[] day_week, ModelMap model){
		Food tempFood = foodMapper.getFoodByRestName(food.getName());
		long start = 0L;
		long end = 0L;
		float price = 0;
		String day_week_str = "";
		
		if(food.getName().equals("")){
			model.put(Constant.INFO, "菜单名不能为空");
			return "info";
		}
		if(tempFood != null){
			model.put(Constant.INFO, "菜名已经存在");
			return "info";
		}
		Restaurant restaurant = restaurantMapper.getRestByRestId(food.getRestId());
		if(restaurant == null){
			model.put(Constant.INFO, "所属餐馆不存在");
			return "info";
		}
		
		try{
			price = Float.parseFloat(pri);
		}catch(NumberFormatException e){
			model.put(Constant.INFO, "价格为空或格式错误");
			return "info";
		}
		try{
			start = Long.parseLong(day_start);
		}catch(NumberFormatException e){
			start = 0L;
		}
		try{
			end = Long.parseLong(day_end);
		}catch(NumberFormatException e){
			end = 0L;
		}
		
		if(day_week == null)
			day_week_str = "";
		else{
			for(int day : day_week){
				day_week_str = day + ";";
			}
			day_week_str = day_week_str.substring(0, day_week_str.length()-1);
		}
		
		food.setPrice(price);
		food.setOrder_day_start(start);
		food.setOrder_day_end(end);
		food.setOrder_day_week(day_week_str);
		
		foodMapper.addFood(food);
		return "forward:viewmenu.action";
	}
}
