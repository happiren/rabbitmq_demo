package com.happiren.rabbitmq;

public interface IMessageSender {
     boolean send(String exchange, String routeKey, Object message);
}
