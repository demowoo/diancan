package com.diancan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.diancan.model.Food;

public interface FoodMapper {
	
	@Select("select * from food where restId = #{restId}")
	public List<Food> getFoodListByRestId(int restId);
	
	@Select("select * from food where id = #{foodId}")
	public Food getFoodById(int foodId);
	
	@Select("select * from food where name = #{name}")
	public Food getFoodByRestName(String name);
	
	@Insert("insert into food" +
			"(restId, name ,price, taste_grading, hot, pic, can_order, order_day_start, order_day_end, order_day_week)" +
			" values(#{restId},#{name},#{price},#{taste_grading},#{hot},#{pic},#{can_order},#{order_day_start},#{order_day_end},#{order_day_week})")
	public void addFood(Food food);
	
	@Update("update food set restId=#{restId}, name=#{name}, price=#{price}, taste_grading=#{taste_grading}, hot=#{hot}," +
			"pic=#{pic},can_order=#{can_order},order_day_start=#{order_day_start},order_day_end=#{order_day_end},order_day_week=#{order_day_week}"+
			" where id=#{id}")
	public void updateFood(Food food);
	
	@Delete("delete from food where id=#{id}")
	public void deleteFood(int id);
}
