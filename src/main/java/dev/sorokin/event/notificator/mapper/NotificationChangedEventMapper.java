package dev.sorokin.event.notificator.mapper;

import dev.sorokin.event.notificator.db.entity.NotificationChangedEventEntity;
import dev.sorokin.event.notificator.domain.NotificationChangedEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface NotificationChangedEventMapper {

    NotificationChangedEvent toDomain(NotificationChangedEventEntity notificationChangedEventEntity);
}
