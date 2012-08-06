package com.diancan.service;

import java.util.Date;
import java.util.Calendar;

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
		long[] timeZone = getTimeZone(time);
		return dayOrderMapper.getDayOrderByDay(timeZone[0], timeZone[1]);
	}
	
	private void updateStatus(boolean status, long time){
		long[] timeZone = getTimeZone(time);
		dayOrderMapper.updateDayOrderStatus(status, timeZone[0], timeZone[1]);
	}
	
	private void updateRest(int restId, long time){
		long[] timeZone = getTimeZone(time);
		dayOrderMapper.updateDayOrderRest(restId, timeZone[0], timeZone[1]);
	}
	
	private void updateDayOrder(DayOrder dayOrder){
		dayOrderMapper.updateDayOrder(dayOrder);
	}
	
	public boolean isOpen(){
		Date date = new Date();
		long[] timeZone = getTimeZone(date.getTime());
		return dayOrderMapper.getStatus(timeZone[0], timeZone[1]);
	}
	
	private long[] getTimeZone(long time){
		Calendar calendar = Calendar.getInstance();
		long[] timeZone = new long[2];
		calendar.setTimeInMillis(time);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		timeZone[0] = calendar.getTimeInMillis();
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		timeZone[1] = calendar.getTimeInMillis();
		return timeZone;
	}
	
}
