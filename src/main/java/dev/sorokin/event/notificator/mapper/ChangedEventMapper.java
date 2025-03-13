package dev.sorokin.event.notificator.mapper;

import dev.sorokin.event.notificator.db.entity.ChangedEventEntity;
import dev.sorokin.event.notificator.domain.ChangedEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ChangedEventMapper {
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "isRead", expression = "java(false)")
    ChangedEventEntity toEntity(ChangedEvent changedEvent);

    default ChangedEventEntity toEntity(ChangedEvent changedEvent, Long id) {
        ChangedEventEntity changedEventEntity = toEntity(changedEvent);
        changedEventEntity.setUserId(id);
        return changedEventEntity;
    }
}
