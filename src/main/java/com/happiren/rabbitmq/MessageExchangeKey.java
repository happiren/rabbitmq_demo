package com.happiren.rabbitmq;

import org.springframework.stereotype.Component;


public class MessageExchangeKey {
    public static final String QUEUE_FANOUT_TEST = "queue_fanout_test";
    public static final String QUEUE_DIRECT_TEST = "queue_direct_test";
    public static final String EXCHANGE_DIRECT_TEST = "exchange_direct_test";
    public static final String EXCHANGE_FANOUT_TEST = "exchange_fanout_test";
    public static final String KEY_DIRECT_TEST = "key_direct_test";
}
