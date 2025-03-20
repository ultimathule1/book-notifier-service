package dev.sorokin.event.notificator.domain.service;

import dev.sorokin.event.notificator.db.entity.NotificationChangedEventEntity;
import dev.sorokin.event.notificator.db.entity.NewFieldsEntity;
import dev.sorokin.event.notificator.db.entity.OldFieldsEntity;
import dev.sorokin.event.notificator.db.repository.NewFieldsRepository;
import dev.sorokin.event.notificator.db.repository.NotificationsRepository;
import dev.sorokin.event.notificator.db.repository.OldFieldsRepository;
import dev.sorokin.event.notificator.domain.ChangedEvent;
import dev.sorokin.event.notificator.mapper.ChangedEventMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class KafkaEventService {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaEventService.class);
    private final NotificationsRepository notificationsRepository;
    private final NewFieldsRepository newFieldsRepository;
    private final OldFieldsRepository oldFieldsRepository;

    public KafkaEventService(NotificationsRepository notificationsRepository, NewFieldsRepository newFieldsRepository, OldFieldsRepository oldFieldsRepository) {
        this.notificationsRepository = notificationsRepository;
        this.newFieldsRepository = newFieldsRepository;
        this.oldFieldsRepository = oldFieldsRepository;
    }

    public void addAll(ChangedEvent changedEvent, List<Long> subscribers) {
        LOGGER.info("Try adding changed event {} to subscribers", changedEvent);

        if (changedEvent == null) {
            LOGGER.error("Changed event is null in addAll() method");
            return;
        }

        if (subscribers.isEmpty()) {
            LOGGER.info("The notification will not be save because does not have any subscribers");
            return;
        }

        NewFieldsEntity newFieldsEntity = new NewFieldsEntity();
        initializeNewFieldEntity(newFieldsEntity, changedEvent);
        newFieldsRepository.save(newFieldsEntity);

        OldFieldsEntity oldFieldsEntity = new OldFieldsEntity();
        initializeOldFieldEntity(oldFieldsEntity, changedEvent);
        oldFieldsRepository.save(oldFieldsEntity);

        subscribers
                .forEach((sId) -> {
                    NotificationChangedEventEntity notificationChangedEventEntity = new NotificationChangedEventEntity();
                    initializeChangedEventEntity(notificationChangedEventEntity, changedEvent, sId);

                    notificationChangedEventEntity.setOldFieldsEntity(oldFieldsEntity);
                    notificationChangedEventEntity.setNewFieldsEntity(newFieldsEntity);
                    notificationsRepository.save(notificationChangedEventEntity);
                });
        LOGGER.info("SUCCESS, changed event added to subscribers = {}", changedEvent);
    }

    private void initializeChangedEventEntity(NotificationChangedEventEntity notificationChangedEventEntity, ChangedEvent changedEvent, Long subId) {
        notificationChangedEventEntity.setEventId(changedEvent.eventId());
        notificationChangedEventEntity.setOwnerEventId(changedEvent.ownerEventId());
        notificationChangedEventEntity.setIsRead(false);
        notificationChangedEventEntity.setSubscriberId(subId);
        notificationChangedEventEntity.setUserChangedId(changedEvent.userChangedId());
        notificationChangedEventEntity.setCreatedAt(LocalDateTime.now());
    }

    private void initializeNewFieldEntity(NewFieldsEntity newFieldsEntity, ChangedEvent changedEvent) {
        newFieldsEntity.setCost(changedEvent.costNew());
        newFieldsEntity.setDuration(changedEvent.durationNew());
        newFieldsEntity.setDate(changedEvent.dateNew());
        newFieldsEntity.setName(changedEvent.nameNew());
        newFieldsEntity.setLocationId(changedEvent.locationIdNew());
        newFieldsEntity.setMaxPlaces(changedEvent.maxPlacesNew());
        newFieldsEntity.setStatus(changedEvent.statusNew());
    }

    private void initializeOldFieldEntity(OldFieldsEntity oldFieldsEntity, ChangedEvent changedEvent) {
        oldFieldsEntity.setCost(changedEvent.costOld());
        oldFieldsEntity.setDuration(changedEvent.durationOld());
        oldFieldsEntity.setDate(changedEvent.dateOld());
        oldFieldsEntity.setName(changedEvent.nameOld());
        oldFieldsEntity.setLocationId(changedEvent.locationIdOld());
        oldFieldsEntity.setMaxPlaces(changedEvent.maxPlacesOld());
        oldFieldsEntity.setStatus(changedEvent.statusOld());
    }
}