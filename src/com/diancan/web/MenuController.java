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
	public String addFood(Food food, ModelMap model){
		Food tempFood = foodMapper.getFoodByRestName(food.getName());
		if(tempFood != null){
			model.put(Constant.INFO, "菜名已经存在");
			return "info";
		}
		Restaurant restaurant = restaurantMapper.getRestByRestId(food.getRestId());
		if(restaurant != null){
			model.put(Constant.INFO, "所属餐馆不存在");
			return "info";
		}
		foodMapper.addFood(food);
		return "forward:viewmenu.action";
	}
}
