package com.diancan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diancan.mapper.RestaurantMapper;
import com.diancan.model.Restaurant;

@Service
public class RestaurantService {

	@Autowired
	private RestaurantMapper restaurantMapper;
	
	public Restaurant getRestById(int restId){
		return restaurantMapper.getRestByRestId(restId);
	}
}
