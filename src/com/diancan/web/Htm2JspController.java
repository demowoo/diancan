package com.diancan.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diancan.mapper.RestaurantMapper;
import com.diancan.model.Restaurant;
import com.diancan.util.inter.JsonUtil;

@Controller
public class Htm2JspController {
	
	@Autowired
	JsonUtil jsonUtil;
	@Autowired
	RestaurantMapper restaurantMapper;
	
	@RequestMapping("addrest.htm")
	public String addRest(){
		return "addrest";
	}
	
	@RequestMapping("addfood.htm")
	public String addFood(ModelMap model){
		List<Restaurant> restList = new ArrayList<Restaurant>();
		restList = restaurantMapper.getRestList();
		model.put("restlist", restList);
		return "addfood";
	}
	
	@RequestMapping("createorder.htm")
	public String createOrder(ModelMap model){
		List<Restaurant> restList = new ArrayList<Restaurant>();
		restList = restaurantMapper.getRestList();
		model.put("restlist", restList);
		return "createorder";
	}
}
