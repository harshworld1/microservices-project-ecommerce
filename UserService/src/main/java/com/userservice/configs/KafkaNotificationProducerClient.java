package com.userservice.configs;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.userservice.dtos.SendNotificationMessageDTO;

@Component
public class KafkaNotificationProducerClient {
    private static final String TOPIC_NAME = "notification-topic";
    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(KafkaNotificationProducerClient.class);
    private final KafkaTemplate<String, SendNotificationMessageDTO> kafkaTemplate;

    public KafkaNotificationProducerClient(KafkaTemplate<String, SendNotificationMessageDTO> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishNotiificationEvent(SendNotificationMessageDTO sendNotificationMessageDTO) {
        kafkaTemplate.send(TOPIC_NAME, sendNotificationMessageDTO);
        logger.info("Notification event was published: {}", sendNotificationMessageDTO);
    }
}