package com.diancan.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.diancan.model.Order;

public interface OrderMapper {
	
	@Select("select * from order where time>=#{start} and time<#{end} and userId=#{userId}")
	public Order getOrderByUserId_Day(Map map);
}
