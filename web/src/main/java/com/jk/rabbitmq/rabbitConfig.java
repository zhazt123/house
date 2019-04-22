package com.jk.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class rabbitConfig {
    @Bean
    public Queue messageQueue() {
        return new Queue("queryHouse");
    }

    @Bean
    public Queue deleteQueue() {
        return new Queue("deleteHouse");
    }
}
