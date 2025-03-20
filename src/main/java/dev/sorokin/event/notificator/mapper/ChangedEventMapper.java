package dev.sorokin.event.notificator.mapper;

import dev.sorokin.event.notificator.db.entity.NotificationChangedEventEntity;
import dev.sorokin.event.notificator.domain.ChangedEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ChangedEventMapper {
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "isRead", expression = "java(false)")
    @Mapping(target = "subscriberId", expression = "java(null)")
    NotificationChangedEventEntity toEntity(ChangedEvent changedEvent);

    default NotificationChangedEventEntity toEntity(ChangedEvent changedEvent, Long subscriberId) {
        NotificationChangedEventEntity notificationChangedEventEntity = toEntity(changedEvent);
        notificationChangedEventEntity.setSubscriberId(subscriberId);
        return notificationChangedEventEntity;
    }
}
