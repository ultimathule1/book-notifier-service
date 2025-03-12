package dev.sorokin.event.notificator.handler;

import dev.sorokin.event.notificator.api.dto.event.EventChangerEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@KafkaListener(topics = {
        "${events.notifications.topic.name}"
})
public class KafkaEventHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaEventHandler.class);

    @KafkaHandler
    void handler(@Payload EventChangerEvent event) {
        LOGGER.info("Received event {}", event);
    }
}
