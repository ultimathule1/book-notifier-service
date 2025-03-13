package dev.sorokin.event.notificator.mapper;

import dev.sorokin.event.notificator.api.dto.event.EventChangerEvent;
import dev.sorokin.event.notificator.domain.ChangedEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EventKafkaMapper {

    @Mapping(target = "eventId", source = "eventId")
    @Mapping(target = "nameOld", source = "fieldEventName.oldValue")
    @Mapping(target = "nameNew", source = "fieldEventName.newValue")
    @Mapping(target = "maxPlacesOld", source = "fieldMaxPlaces.oldValue")
    @Mapping(target = "maxPlacesNew", source = "fieldMaxPlaces.newValue")
    @Mapping(target = "dateOld", source = "fieldEventData.oldValue")
    @Mapping(target = "dateNew", source = "fieldEventData.newValue")
    @Mapping(target = "costOld", source = "fieldEventCost.oldValue")
    @Mapping(target = "costNew", source = "fieldEventCost.newValue")
    @Mapping(target = "durationOld", source = "fieldDuration.oldValue")
    @Mapping(target = "durationNew", source = "fieldDuration.newValue")
    @Mapping(target = "locationIdOld", source = "fieldLocationId.oldValue")
    @Mapping(target = "locationIdNew", source = "fieldLocationId.newValue")
    @Mapping(target = "statusOld", source = "fieldStatus.oldValue")
    @Mapping(target = "statusNew", source = "fieldStatus.newValue")
    ChangedEvent toChangedEvent(EventChangerEvent eventChangerEvent);
}