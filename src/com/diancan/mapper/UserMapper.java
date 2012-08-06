package com.diancan.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.diancan.model.User;

public interface UserMapper {
		
	@Select("select * from user where loginname = #{loginName}")
	public User getUserByLoginName(String loginName);

	@Select("select * from user where realname = #{realName}")
	public User getUserByRealName(String realName);
	
	@Delete("delete from user where id=#{id}")
	public void deleteUser(int userId);
	
	@Insert("insert into user (loginname, password, realname, type, active) " +
			"values(#{loginname}, #{password}, #{realname}, #{type}, #{active})")
	public void addUser(User user);
	
	@Update("update user set loginname=#{loginname}, realname=#{realname}, password=#{password}, type=#{type}, active=#{active} where id=#{id}")
	public void updateUser(User user);
}
