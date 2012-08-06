package com.diancan.util;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class DateUtil {
	
	public Map getTimeZone(long time){
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
