package com.diancan.model;

public class Food {
	private int id;
	private int restId;//所属餐馆id
	private String name;//菜名
	private float price;//价钱
	private short taste_grading;//味道评价
	private boolean hot;//是否辣
	private String pic;//图片
	private boolean can_order=true;//能否被点
	private long order_day_start;//可以点餐其实日期(确切的日期)
	private long order_day_end;//可以点餐终止日期(确切的日期)
	private byte order_range_start;//可以点餐日期范围的日期(每个月中的几号)
	private byte order_range_end;//可以点餐范围的终止日期(每个月中的几号)
	private String order_day_week;//一周中可以点餐的日子（分号分隔，1;2;3;4;5）起始日期为星期日，即1代表星期日
	private int book_count;
	
	public boolean isCan_order() {
		return can_order;
	}
	public void setCan_order(boolean can_order) {
		this.can_order = can_order;
	}
	public long getOrder_day_start() {
		return order_day_start;
	}
	public void setOrder_day_start(long order_day_start) {
		this.order_day_start = order_day_start;
	}
	public long getOrder_day_end() {
		return order_day_end;
	}
	public void setOrder_day_end(long order_day_end) {
		this.order_day_end = order_day_end;
	}
	public String getOrder_day_week() {
		return order_day_week;
	}
	public void setOrder_day_week(String order_day_week) {
		this.order_day_week = order_day_week;
	}
	private long time;//登记日期
	
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public short getTaste_grading() {
		return taste_grading;
	}
	public void setTaste_grading(short taste_grading) {
		this.taste_grading = taste_grading;
	}
	public boolean isHot() {
		return hot;
	}
	public void setHot(boolean hot) {
		this.hot = hot;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public int getRestId() {
		return restId;
	}
	public void setRestId(int restId) {
		this.restId = restId;
	}
	public int getBook_count() {
		return book_count;
	}
	public void setBook_count(int book_count) {
		this.book_count = book_count;
	}
	public byte getOrder_range_start() {
		return order_range_start;
	}
	public void setOrder_range_start(byte order_range_start) {
		this.order_range_start = order_range_start;
	}
	public byte getOrder_range_end() {
		return order_range_end;
	}
	public void setOrder_range_end(byte order_range_end) {
		this.order_range_end = order_range_end;
	}
	
}
