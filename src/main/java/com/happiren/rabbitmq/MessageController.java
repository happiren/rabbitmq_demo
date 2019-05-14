package com.happiren.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MessageController {


    @Autowired
    IMessageSender messageSender;

    @RequestMapping(value = "/messageTest", method = RequestMethod.GET)
    @ResponseBody
    public String  messageFanoutTest() {

        //fanout exchange 消息发送
        messageSender.send(MessageExchangeKey.EXCHANGE_FANOUT_TEST, "", "hello happiren, fanout test and there can be a Object"); //该消息需要绑定exchange,但是不要routerkey
        //direct exchange 消息发送
        messageSender.send(MessageExchangeKey.EXCHANGE_DIRECT_TEST, MessageExchangeKey.KEY_DIRECT_TEST, "hello happiren, direct test and  there can be a Object"); //direct 消息，该消息可以不需要绑定exchange,但是需要routerKey
        return "hello,demo of rabbitmq written by happiren";
    }
}
