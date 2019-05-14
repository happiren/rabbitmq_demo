package com.happiren.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqApplicationTests {

	@Autowired
	MessageSender messageSender;

	@Test
	public void contextLoads() {
		//messageSender.send(MessageExchangeKey.EXCHANGE_TEST, MessageExchangeKey.ROUTER_TEST, "hello happiren, there can be a Object");
	}

}
