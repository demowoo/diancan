package com.diancan.model;

public class Comment {
	private int id;
	private int belongid;//所评价物品id
	private int postuserid;//评价人id
	private String content;//评价内容
	private long time;//发表日期
	private String up;//赞同(账号id，用分号分隔)
	private String down;//反对
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBelongid() {
		return belongid;
	}
	public void setBelongid(int belongid) {
		this.belongid = belongid;
	}
	public int getPostuserid() {
		return postuserid;
	}
	public void setPostuserid(int postuserid) {
		this.postuserid = postuserid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public String getUp() {
		return up;
	}
	public void setUp(String up) {
		this.up = up;
	}
	public String getDown() {
		return down;
	}
	public void setDown(String down) {
		this.down = down;
	}
	
}
