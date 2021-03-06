package com.diancan.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.diancan.model.Order;

public interface OrderMapper {
	
	@Select("select * from `order` where time>=#{start} and time<#{end} and userId=#{userId}")
	public Order getOrderByUserId_Day(Map map);
	
	@Select("select * from `order` where dayOrderId = #{dayOrderId}")
	public List<Order> getOrderListByDayOrderId(int dayOrderId);
	
	@Select("select * from `order` where id = #{orderId}")
	public Order getOrderById(int rderId);
	
	@Select("select * from `order` where userId = #{userId}")
	public List<Order> getOrderListByUserId(int userId);
	
	@Insert("insert into `order`(dayOrderId,restId,foodId,userId,userName,foodName,price,time)" +
			" values(#{dayOrderId},#{restId},#{foodId},#{userId},#{userName},#{foodName},#{price},#{time})")
	public void addOrder(Order order);
	
	@Delete("delete from `order` where dayOrderId=#{dayOrderId}")
	public void delDayOrder(int dayOrderId);
	
	@Delete("delete from `order` where id=#{orderId}")
	public void delOrder(int orderId);
}
