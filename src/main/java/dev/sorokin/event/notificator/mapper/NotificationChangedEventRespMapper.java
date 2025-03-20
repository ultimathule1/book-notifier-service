package dev.sorokin.event.notificator.mapper;

import dev.sorokin.event.notificator.api.dto.UserEventChangesDto;
import dev.sorokin.event.notificator.domain.NotificationChangedEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface NotificationChangedEventRespMapper {
    @Mapping(target = "fieldChangeName.oldValue", source = "oldFieldsEntity.name")
    @Mapping(target = "fieldChangeName.newValue", source = "newFieldsEntity.name")
    @Mapping(target = "fieldChangeMaxPlaces.oldValue", source = "oldFieldsEntity.maxPlaces")
    @Mapping(target = "fieldChangeMaxPlaces.newValue", source = "newFieldsEntity.maxPlaces")
    @Mapping(target = "fieldChangeDate.oldValue", source = "oldFieldsEntity.date")
    @Mapping(target = "fieldChangeDate.newValue", source = "newFieldsEntity.date")
    @Mapping(target = "fieldChangeCost.oldValue", source = "oldFieldsEntity.cost")
    @Mapping(target = "fieldChangeCost.newValue", source = "newFieldsEntity.cost")
    @Mapping(target = "fieldChangeDuration.oldValue", source = "oldFieldsEntity.duration")
    @Mapping(target = "fieldChangeDuration.newValue", source = "newFieldsEntity.duration")
    @Mapping(target = "fieldChangeLocationId.oldValue", source = "oldFieldsEntity.locationId")
    @Mapping(target = "fieldChangeLocationId.newValue", source = "newFieldsEntity.locationId")
    @Mapping(target = "fieldChangeStatus.oldValue", source = "oldFieldsEntity.status")
    @Mapping(target = "fieldChangeStatus.newValue", source = "newFieldsEntity.status")
    UserEventChangesDto toDto(NotificationChangedEvent notificationChangedEvent);
}
