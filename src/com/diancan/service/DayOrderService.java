package com.diancan.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diancan.mapper.DayOrderMapper;
import com.diancan.model.DayOrder;
import com.diancan.util.DateUtil;

@Service
public class DayOrderService {

	@Autowired
	private DayOrderMapper dayOrderMapper;
	@Autowired
	private DateUtil dateUtil;
	
	public static boolean OPEN = true;
	public static boolean CLOSE = false;
	
	public void close(int dayOrderId){
		updateStatus(CLOSE, dayOrderId);
	}
	
	public void open(int dayOrderId){
		updateStatus(OPEN, dayOrderId);
	}
	
	public List<DayOrder> getTodayOrder(){
		Date date = new Date();
		return getDayOrder(date.getTime());
	}
	
	public void createDayOrder(int restId, int userId){
		Date date = new Date();
		DayOrder dayOrder = new DayOrder();
		dayOrder.setRestId(restId);
		dayOrder.setUserId(userId);
		dayOrder.setTime(date.getTime());
		dayOrderMapper.createDayOrder(dayOrder);
	}
	
	public List<DayOrder> getOrderList(int limit){
		return getOrderList(0, limit);
	}
	
	public List<DayOrder> getOrderList(int startIndex, int endIndex){
		Map map = new HashMap();
		map.put("start", startIndex);
		map.put("end", endIndex);
		return dayOrderMapper.getDayOrderList(map);
	}
	/////////////////////////////////////////////////////////////////////////////////////////
	public List<DayOrder> getDayOrder(long time){
		Map timeZone = dateUtil.getTimeZone(time);
		return dayOrderMapper.getDayOrderListByDay(timeZone);
	}
	
	private void updateStatus(boolean open, int dayOrderId){
		Map map = new HashMap();
		map.put("open", open);
		map.put("id", dayOrderId);
		dayOrderMapper.updateDayOrderStatus(map);
	}
	
	private void updateRest(int restId, int dayOrderId){
		Map map = new HashMap();
		map.put("restId", restId);
		map.put("id", dayOrderId);
		dayOrderMapper.updateDayOrderRest(map);
	}
	
	private void updateDayOrder(DayOrder dayOrder){
		dayOrderMapper.updateDayOrder(dayOrder);
	}
	
	public DayOrder getDayOrderById(int dayOrderId){
		return dayOrderMapper.getDayOrderById(dayOrderId);
	}
	
}
