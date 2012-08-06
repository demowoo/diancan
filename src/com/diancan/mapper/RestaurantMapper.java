package com.diancan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.diancan.model.Restaurant;

public interface RestaurantMapper {
	
	@Insert("insert into restaurant(name,intro, address,phone,ser_grading,pri_grading,taste_grading,can_order,time)" +
			" values(#{name},#{intro},#{address},#{phone},#{ser_grading},#{pri_grading},#{taste_grading},#{can_order},#{time})")
	public void addRest(Restaurant rest);
	
	@Select("select * from restaurant where name=#{name}")
	public Restaurant getRestByName(String name);
	
	@Select("select * from restaurant where id=#{restId}")
	public Restaurant getRestByRestId(int restId);
	
	@Select("select * from restaurant")
	public List<Restaurant> getRestList();
			
}
