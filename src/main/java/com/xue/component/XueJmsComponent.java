package com.xue.component;


import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class XueJmsComponent {
	
	@Autowired
	private JmsMessagingTemplate jmsMEssagingTemplate;
	@Autowired
	private Queue queue;
	
	public void send(String msg){
		this.jmsMEssagingTemplate.convertAndSend(this.queue,msg);
	}
	
	@JmsListener(destination="xue.queue")
	public void receiveQueue(String text) {
		System.out.println("接受到：" + text);
	}
}
