package dev.sorokin.event.notificator.handler;

import dev.sorokin.event.notificator.api.dto.event.EventChangerEvent;
import dev.sorokin.event.notificator.domain.service.KafkaEventService;
import dev.sorokin.event.notificator.mapper.EventKafkaMapper;
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
    private final KafkaEventService kafkaEventService;
    private final EventKafkaMapper kafkaMapper;

    public KafkaEventHandler(KafkaEventService kafkaEventService, EventKafkaMapper kafkaMapper) {
        this.kafkaEventService = kafkaEventService;
        this.kafkaMapper = kafkaMapper;
    }

    @KafkaHandler
    void handler(@Payload EventChangerEvent event) {
        LOGGER.info("Received event {}", event);
        kafkaEventService.addAll(kafkaMapper.toChangedEvent(event), event.getEventSubscribers());
    }
}
