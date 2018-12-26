package com.spring.boot.study;

public class Message {

	private int msgId;	
	private String msg;
	public Message(int msgId, String msg) {
		super();
		this.msgId = msgId;
		this.msg = msg;
	}
	public int getMsgId() {
		return msgId;
	}
	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "Message [msgId=" + msgId + ", msg=" + msg + "]";
	}
	
}
