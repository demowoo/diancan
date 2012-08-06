package com.diancan.mapper;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.diancan.model.DayOrder;

public interface DayOrderMapper {

	@Select("select * from dayorder where time>=#{start} and time<#{end}")
	public DayOrder getDayOrderByDay(long start, long end);
	
	@Select("select open from dayorder where time>=#{start} and time<#{end}")
	public boolean getStatus(long start, long end);
	
	@Update("update dayorder set open=#{open}, restId=#{restId}, time=#{time} where id=#{id}")
	public void updateDayOrder(DayOrder dayOrder);
	
	@Update("update dayorder set open=#{open} where time>=#{start} and time<#{end}")
	public void updateDayOrderStatus(boolean open, long start, long end);
	
	@Update("update dayorder set restId=#{restId} where time>=#{start} and time<#{end}")
	public void updateDayOrderRest(int restId, long start, long end);
}
