package dev.sorokin.event.notificator.domain.service;

import dev.sorokin.event.notificator.db.entity.ChangedEventEntity;
import dev.sorokin.event.notificator.db.repository.NotificationsRepository;
import dev.sorokin.event.notificator.domain.ChangedEvent;
import dev.sorokin.event.notificator.mapper.ChangedEventMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KafkaEventService {
    private final NotificationsRepository notificationsRepository;
    private final ChangedEventMapper changedEventMapper;
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaEventService.class);

    public KafkaEventService(NotificationsRepository notificationsRepository, ChangedEventMapper changedEventMapper) {
        this.notificationsRepository = notificationsRepository;
        this.changedEventMapper = changedEventMapper;
    }

    public void addAll(ChangedEvent changedEvent, List<Long> subscribers) {
        LOGGER.info("Try adding changed event {} to subscribers", changedEvent);
        subscribers
                .forEach((sId) -> {
                    ChangedEventEntity changedEventEntity = changedEventMapper.toEntity(changedEvent, sId);
                    notificationsRepository.save(changedEventEntity);
                });
        LOGGER.info("SUCCESS, changed event added to subscribers = {}", changedEvent);
    }
}