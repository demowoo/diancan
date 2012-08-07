package com.diancan.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diancan.mapper.FoodMapper;
import com.diancan.model.Food;

@Service
public class FoodService {

	@Autowired
	private FoodMapper foodMapper;
	
	public List<Food> getCanOrderFoodList(int restId){
		List<Food> foodList = foodMapper.getFoodListByRestId(restId);
		Calendar calendar =  Calendar.getInstance();
		long now = calendar.getTimeInMillis();
		
		List<Food> resultList = new ArrayList<Food>();
		for(Food food : foodList){
			//是否被拉黑
			if(!food.isCan_order())
				continue;
			//是否在可以定餐日期范围内
			if(food.getOrder_day_start() + food.getOrder_day_end() > 0){
				if(now > food.getOrder_day_end()
						|| now < food.getOrder_day_start())
					continue;
			}
			//是否在可以订餐星期中
			if(food.getOrder_day_week() != null && !food.getOrder_day_week().equals("")){
				String[] weekDays = food.getOrder_day_week().split(";");
				Integer dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
				boolean canOrder = false;
				for(String day : weekDays){
					if(dayOfWeek.equals(Integer.parseInt(day)))
						canOrder = true;
				}
				if(!canOrder)
					continue;
			}
			resultList.add(food);
		}
		return resultList;
	}
	
	public Food getFoodId(int foodId){
		return foodMapper.getFoodById(foodId);
	}
}
