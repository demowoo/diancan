package com.diancan.model;

public class Restaurant {
	private int id;
	private String name; //名字
	private String intro; //介绍
	private String address; //地址
	private String phone; //联系方式
	private short ser_grading; //服务评价
	private short pri_grading; //价钱评价
	private short taste_grading; //味道评价
	private boolean can_order = true;//能否被点
	private long time;//登记日期
	
	private String pic; //图片
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public short getSer_grading() {
		return ser_grading;
	}
	public void setSer_grading(short ser_grading) {
		this.ser_grading = ser_grading;
	}
	public short getPri_grading() {
		return pri_grading;
	}
	public void setPri_grading(short pri_grading) {
		this.pri_grading = pri_grading;
	}
	public short getTaste_grading() {
		return taste_grading;
	}
	public void setTaste_grading(short taste_grading) {
		this.taste_grading = taste_grading;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public boolean isCan_order() {
		return can_order;
	}
	public void setCan_order(boolean can_order) {
		this.can_order = can_order;
	}
	
}
