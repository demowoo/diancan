package com.diancan.service;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diancan.mapper.DayOrderMapper;
import com.diancan.model.DayOrder;
import com.diancan.util.DateUtil;

@Service
public class DayOrderService {

	@Autowired
	DayOrderMapper dayOrderMapper;
	@Autowired
	DateUtil dateUtil;
	
	public static boolean OPEN = true;
	public static boolean CLOSE = false;
	
	public void close(){
		Date date = new Date();
		updateStatus(CLOSE, date.getTime());
	}
	
	public void open(){
		Date date = new Date();
		updateStatus(OPEN, date.getTime());
	}
	
	public DayOrder getTodayOrder(){
		Date date = new Date();
		return getDayOrder(date.getTime());
	}
	/////////////////////////////////////////////////////////////////////////////////////////
	public DayOrder getDayOrder(long time){
		Map timeZone = dateUtil.getTimeZone(time);
		return dayOrderMapper.getDayOrderByDay(timeZone);
	}
	
	private void updateStatus(boolean open, long time){
		Map timeZone = dateUtil.getTimeZone(time);
		timeZone.put("open", open);
		dayOrderMapper.updateDayOrderStatus(timeZone);
	}
	
	private void updateRest(int restId, long time){
		Map timeZone = dateUtil.getTimeZone(time);
		timeZone.put("restid", restId);
		dayOrderMapper.updateDayOrderRest(timeZone);
	}
	
	private void updateDayOrder(DayOrder dayOrder){
		dayOrderMapper.updateDayOrder(dayOrder);
	}
	
	public boolean isOpen(){
		Date date = new Date();
		Map timeZone = dateUtil.getTimeZone(date.getTime());
		return dayOrderMapper.getStatus(timeZone);
	}
	
	
}
