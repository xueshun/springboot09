package com.xue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.xue.component.XueJmsComponent;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JmsTest {
	
	@Autowired
	private XueJmsComponent jmsComponent;
	
	@Test
	public void send() {
		this.jmsComponent.send("hello world");
	}
}
