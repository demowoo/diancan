package com.diancan.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.diancan.model.DayOrder;

public interface DayOrderMapper {

	@Insert("insert into dayorder(restId,userId,time,open) values(#{restId},#{userId},#{time},#{open})")
	public void createDayOrder(DayOrder dayOrder);
	
	@Select("select * from dayorder where time>=#{start} and time<#{end}")
	public List<DayOrder> getDayOrderListByDay(Map map);
	
	@Select("select * from dayorder limit #{start},#{end}")
	public List<DayOrder> getDayOrderList(Map map);
	
	@Select("select * from dayorder where id=#{id}")
	public DayOrder getDayOrderById(int id);
	
	@Select("select open from dayorder where id=#{id}")
	public boolean getStatus(int id);
	
	@Update("update dayorder set open=#{open}, restId=#{restId}, time=#{time} where id=#{id}")
	public void updateDayOrder(DayOrder dayOrder);
	
	@Update("update dayorder set open=#{open} where id=#{id}")
	public void updateDayOrderStatus(Map map);
	
	@Update("update dayorder set restId=#{restId} where id=#{id}")
	public void updateDayOrderRest(Map map);
	
	@Delete("delete from dayorder where id=#{dayOrderId}")
	public void delDayOrder(int dayOrderId);
}
