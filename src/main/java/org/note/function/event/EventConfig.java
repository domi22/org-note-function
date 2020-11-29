package org.note.function.event;

import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.*;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * https://www.cnblogs.com/nizuimeiabc1/p/12492538.html
 */
@Component
public class EventConfig {

    @Autowired
    RedissonClient redissonClient;

    @EventListener(ContextRefreshedEvent.class)
    @Order(1)
    public void evenPreparedEvent(ContextRefreshedEvent event) {
        System.out.println("ContextRefreshedEvent------" + event);
    }

    @EventListener(ServletWebServerInitializedEvent.class)
    public void failed(ServletWebServerInitializedEvent event) {
        System.out.println("ServletWebServerInitializedEvent------" + event);
    }

    @EventListener(ApplicationStartedEvent.class)
    public void preparedEvent(ApplicationStartedEvent event) {
        System.out.println("ApplicationStartedEvent------" + event);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void ready(ApplicationReadyEvent event) {
        System.out.println("ApplicationReadyEvent------" + event);
    }

}
