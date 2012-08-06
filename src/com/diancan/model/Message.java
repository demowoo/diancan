package com.diancan.model;

public class Message {
	
	//邮件类型
	public static byte SYSTEM = 0;//系统邮件
	public static byte COMMON = 1;//普通邮件
	//邮件状态
	public static byte ACTIVE = 0;//可用的，未被标记删除
	public static byte SEND_DEL = 1;//发送者删除
	public static byte RECV_DEL =2;//接收者删除
	
	private int id;
	private int sendId;//发送者id
	private int recvId;//接收者id
	private long time;//发送时间
	private boolean isRead;//是否已读
	private byte type;//邮件类型
	private String content;//邮件内容
	private byte isDelete;//是否删除
	
	public static byte getSYSTEM() {
		return SYSTEM;
	}
	public static void setSYSTEM(byte sYSTEM) {
		SYSTEM = sYSTEM;
	}
	public static byte getCOMMON() {
		return COMMON;
	}
	public static void setCOMMON(byte cOMMON) {
		COMMON = cOMMON;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSendId() {
		return sendId;
	}
	public void setSendId(int sendId) {
		this.sendId = sendId;
	}
	public int getRecvId() {
		return recvId;
	}
	public void setRecvId(int recvId) {
		this.recvId = recvId;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public boolean isRead() {
		return isRead;
	}
	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}
	public byte getType() {
		return type;
	}
	public void setType(byte type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public byte getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(byte isDelete) {
		this.isDelete = isDelete;
	}
	
}
