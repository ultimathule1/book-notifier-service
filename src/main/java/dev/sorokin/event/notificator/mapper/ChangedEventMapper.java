package dev.sorokin.event.notificator.mapper;

import dev.sorokin.event.notificator.db.entity.ChangedEventEntity;
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
    @Mapping(target = "userId", expression = "java(null)")
    ChangedEventEntity toEntity(ChangedEvent changedEvent);

    ChangedEvent toDomain(ChangedEventEntity changedEventEntity);

    default ChangedEventEntity toEntity(ChangedEvent changedEvent, Long subscriberId) {
        ChangedEventEntity changedEventEntity = toEntity(changedEvent);
        changedEventEntity.setUserId(subscriberId);
        return changedEventEntity;
    }
}
