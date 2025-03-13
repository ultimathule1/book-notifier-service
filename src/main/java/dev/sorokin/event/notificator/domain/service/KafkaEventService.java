package dev.sorokin.event.notificator.domain.service;

import dev.sorokin.event.notificator.db.entity.ChangedEventEntity;
import dev.sorokin.event.notificator.db.repository.EventRepository;
import dev.sorokin.event.notificator.domain.ChangedEvent;
import dev.sorokin.event.notificator.mapper.ChangedEventMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KafkaEventService {
    private final EventRepository eventRepository;
    private final ChangedEventMapper changedEventMapper;
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaEventService.class);

    public KafkaEventService(EventRepository eventRepository, ChangedEventMapper changedEventMapper) {
        this.eventRepository = eventRepository;
        this.changedEventMapper = changedEventMapper;
    }

//    public ChangedEvent add(ChangedEvent changedEvent) {
//        LOGGER.info("Adding event {}", changedEvent);
//        changedEvent.eventSubscribers()
//                .stream()
//                .forEach(s -> {
//                    eventRepository.save()
//                });
//    }

    public void addAll(ChangedEvent changedEvent, List<Long> subscribers) {
        LOGGER.info("Add changed event {} to subscribers", changedEvent);
        subscribers
                .forEach((sId) -> {
                    ChangedEventEntity changedEventEntity = changedEventMapper.toEntity(changedEvent, sId);
                    eventRepository.save(changedEventEntity);
                });
    }
}