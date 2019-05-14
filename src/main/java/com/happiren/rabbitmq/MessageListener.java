package com.happiren.rabbitmq;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;


@Component
public class MessageListener {

    /**
     * fanout exchange 模式消息接收
     * @param message
     * @param channel
     * @param tag
     */
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(value = MessageExchangeKey.QUEUE_FANOUT_TEST, durable = "true"),
                    exchange = @Exchange(value = MessageExchangeKey.EXCHANGE_FANOUT_TEST, durable = "true", type = ExchangeTypes.FANOUT)
            )
    })
    public void testMessageFANOUTListener(Object message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        System.out.println(String.valueOf(message));
    }

    /**
     * direct exchange 模式消息接收
     * @param message
     * @param channel
     * @param tag
     */
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue(value = MessageExchangeKey.QUEUE_DIRECT_TEST, durable = "true"),
                    exchange = @Exchange(value = MessageExchangeKey.EXCHANGE_DIRECT_TEST, durable = "true", type = ExchangeTypes.DIRECT),
                    key = MessageExchangeKey.KEY_DIRECT_TEST
            )
    })
    public void testMessageDierctListener(Object message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        System.out.println(String.valueOf(message));
    }
}
