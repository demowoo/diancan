package com.diancan.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diancan.mapper.OrderMapper;
import com.diancan.model.DayOrder;
import com.diancan.model.Order;
import com.diancan.util.DateUtil;

@Service
public class OrderService {
	
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private DayOrderService dayOrderService;
	@Autowired
	private DateUtil dateUtil;
	
	public Order getTodayOrderByUserId(int userId){
		Date date = new Date();
		Map timeMap = dateUtil.getTimeZone(date.getTime());
		timeMap.put("userId", userId);
		return orderMapper.getOrderByUserId_Day(timeMap);
	}
	
	public void addOrder(Order order){
		orderMapper.addOrder(order);
	}
	
	public List<Order> getOrderListByDayOrderId(int dayOrderId){
		return orderMapper.getOrderListByDayOrderId(dayOrderId);
	}
	
	/**
	 * 获取用户今天所属的订单
	 * @param userId
	 * @return
	 */
	public DayOrder getUserBelongDayOrder(int userId){
		Order order = getTodayOrderByUserId(userId);
		if(order == null)
			return null;
		else{
			return dayOrderService.getDayOrderById(order.getDayOrderId());
		}
	}
}
