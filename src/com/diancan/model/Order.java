package com.diancan.model;

public class Order {
	private int id;
	private int restId;//餐馆id
	private int foodId;//食物id
	private int userId;//订餐者id
	private int dayOrderId;//日订单id
	private String userName;//订餐者名称
	private String foodName;//食物名称
	private int price;//食物价格
	private long time;//下单日期
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRestId() {
		return restId;
	}
	public void setRestId(int restId) {
		this.restId = restId;
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getDayOrderId() {
		return dayOrderId;
	}
	public void setDayOrderId(int dayOrderId) {
		this.dayOrderId = dayOrderId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	
}
