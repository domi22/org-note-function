package org.note.function.middleware.kafka;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;


@KafkaListener
@Configuration
public class KafkaConfig {

    KafkaTemplate template;



    
}
