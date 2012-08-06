package com.diancan.service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diancan.mapper.DayOrderMapper;
import com.diancan.model.DayOrder;

@Service
public class DayOrderService {

	@Autowired
	DayOrderMapper dayOrderMapper;
	
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
		Map timeZone = getTimeZone(time);
		return dayOrderMapper.getDayOrderByDay(timeZone);
	}
	
	private void updateStatus(boolean open, long time){
		Map timeZone = getTimeZone(time);
		timeZone.put("open", open);
		dayOrderMapper.updateDayOrderStatus(timeZone);
	}
	
	private void updateRest(int restId, long time){
		Map timeZone = getTimeZone(time);
		timeZone.put("restid", restId);
		dayOrderMapper.updateDayOrderRest(timeZone);
	}
	
	private void updateDayOrder(DayOrder dayOrder){
		dayOrderMapper.updateDayOrder(dayOrder);
	}
	
	public boolean isOpen(){
		Date date = new Date();
		Map timeZone = getTimeZone(date.getTime());
		return dayOrderMapper.getStatus(timeZone);
	}
	
	private Map getTimeZone(long time){
		Calendar calendar = Calendar.getInstance();
		Map map = new HashMap<String, Long>();
		calendar.setTimeInMillis(time);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		map.put("start", calendar.getTimeInMillis());
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		map.put("end", calendar.getTimeInMillis());
		return map;
	}
	
}
