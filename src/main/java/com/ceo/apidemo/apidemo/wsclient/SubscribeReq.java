package com.ceo.apidemo.apidemo.wsclient;

/**
 * 订阅请求
 * @author Administrator
 *
 */
public class SubscribeReq {

	private String event;
	private String channel;
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	
}
