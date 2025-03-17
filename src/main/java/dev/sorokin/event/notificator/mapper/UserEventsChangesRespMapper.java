package dev.sorokin.event.notificator.mapper;

import dev.sorokin.event.notificator.api.dto.UserEventChangesDto;
import dev.sorokin.event.notificator.domain.ChangedEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface UserEventsChangesRespMapper {
    @Mapping(target = "fieldChangeName.oldValue", source = "nameOld")
    @Mapping(target = "fieldChangeName.newValue", source = "nameNew")
    @Mapping(target = "fieldChangeMaxPlaces.oldValue", source = "maxPlacesOld")
    @Mapping(target = "fieldChangeMaxPlaces.newValue", source = "maxPlacesNew")
    @Mapping(target = "fieldChangeDate.oldValue", source = "dateOld")
    @Mapping(target = "fieldChangeDate.newValue", source = "dateNew")
    @Mapping(target = "fieldChangeCost.oldValue", source = "costOld")
    @Mapping(target = "fieldChangeCost.newValue", source = "costNew")
    @Mapping(target = "fieldChangeDuration.oldValue", source = "durationOld")
    @Mapping(target = "fieldChangeDuration.newValue", source = "durationNew")
    @Mapping(target = "fieldChangeLocationId.oldValue", source = "locationIdOld")
    @Mapping(target = "fieldChangeLocationId.newValue", source = "locationIdNew")
    @Mapping(target = "fieldChangeStatus.oldValue", source = "statusOld")
    @Mapping(target = "fieldChangeStatus.newValue", source = "statusNew")
    UserEventChangesDto toDto(ChangedEvent changedEvent);
}
