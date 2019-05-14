package com.happiren.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageSender implements IMessageSender{
    @Autowired
    private RabbitTemplate rabbitTemplate;


    public boolean send(String exchange, String routeKey, Object message) {

        boolean result = rabbitTemplate.invoke(operations -> {

            rabbitTemplate.convertAndSend(
                    exchange,
                    routeKey,
                    message
            );
            return rabbitTemplate.waitForConfirms(10 * 1000);
        });

        return result;
    }

}