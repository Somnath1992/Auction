package com.fse.product.query.infrastructure.consumers;


import com.fse.product.common.events.ProductOpenedEvent;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.messaging.handler.annotation.Payload;

public interface EventConsumer {
    void consume(@Payload ProductOpenedEvent event, Acknowledgment ack);

}
