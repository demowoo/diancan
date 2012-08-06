package com.diancan.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.diancan.model.DayOrder;

public interface DayOrderMapper {

	@Select("select * from dayorder where time>=#{start} and time<#{end}")
	public DayOrder getDayOrderByDay(Map map);
	
	@Select("select open from dayorder where time>=#{start} and time<#{end}")
	public boolean getStatus(Map map);
	
	@Update("update dayorder set open=#{open}, restId=#{restId}, time=#{time} where id=#{id}")
	public void updateDayOrder(DayOrder dayOrder);
	
	@Update("update dayorder set open=#{open} where time>=#{start} and time<#{end}")
	public void updateDayOrderStatus(Map map);
	
	@Update("update dayorder set restId=#{restId} where time>=#{start} and time<#{end}")
	public void updateDayOrderRest(Map map);
}
