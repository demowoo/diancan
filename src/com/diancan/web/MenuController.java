package com.diancan.web;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.diancan.mapper.FoodMapper;
import com.diancan.mapper.RestaurantMapper;
import com.diancan.model.Food;
import com.diancan.model.Restaurant;
import com.diancan.service.FoodService;
import com.diancan.service.RestaurantService;
import com.diancan.util.inter.JsonUtil;
import common.Constant;

@Controller
public class MenuController {

	@Autowired
	private RestaurantMapper restaurantMapper;
	@Autowired
	private FoodService foodService;
	@Autowired
	private FoodMapper foodMapper;
	@Autowired
	private JsonUtil jsonUtil;
	
	@RequestMapping("viewmenu.action")
	public String viewMenu(ModelMap model){
		List<Restaurant> restList = restaurantMapper.getRestList();
		model.put("restList", restList);
		return "viewmenu";
	}
	
	@RequestMapping("addrest.action")
	public String addRest(Restaurant rest, ModelMap model){
		Restaurant restaurant = restaurantMapper.getRestByName(rest.getName());
		if(restaurant != null){
			model.put(Constant.INFO, "店名已经存在");
			return Constant.INFO;
		}
		Date date = new Date();
		rest.setTime(date.getTime());
		restaurantMapper.addRest(rest);
		return "forward:addfood.htm";
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
			return Constant.INFO;
		}
		if(tempFood != null){
			model.put(Constant.INFO, "菜名已经存在");
			return Constant.INFO;
		}
		Restaurant restaurant = restaurantMapper.getRestByRestId(food.getRestId());
		if(restaurant == null){
			model.put(Constant.INFO, "所属餐馆不存在");
			return Constant.INFO;
		}
		
		try{
			price = Float.parseFloat(pri);
		}catch(NumberFormatException e){
			model.put(Constant.INFO, "价格为空或格式错误");
			return Constant.INFO;
		}
		try{
			start = DateFormat.getDateInstance().parse(day_start).getTime();
		}catch(NumberFormatException e){
			start = 0L;
		} catch (ParseException e) {
			start = 0L;
		}
		try{
			end = DateFormat.getDateInstance().parse(day_end).getTime();
		}catch(NumberFormatException e){
			end = 0L;
		} catch (ParseException e) {
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
		return "forward:addfood.htm";
	}
	
	@RequestMapping("getfoodlist.do")
	@ResponseBody
	public String getFoodListByRestId(int restId){
		List<Food> foodList = foodService.getFoodListByRestId(restId);
		return jsonUtil.toJsonString(foodList);
	}
}
