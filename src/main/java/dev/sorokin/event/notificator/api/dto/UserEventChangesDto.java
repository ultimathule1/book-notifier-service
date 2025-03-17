package dev.sorokin.event.notificator.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class UserEventChangesDto {
    @NotNull
    private Long eventId;
    @JsonProperty(value = "name")
    private FieldChange<String> fieldChangeName;
    @JsonProperty(value = "maxPlaces")
    private FieldChange<Integer> fieldChangeMaxPlaces;
    @JsonProperty(value = "date")
    private FieldChange<OffsetDateTime> fieldChangeDate;
    @JsonProperty(value = "cost")
    private FieldChange<BigDecimal> fieldChangeCost;
    @JsonProperty(value = "duration")
    private FieldChange<Integer> fieldChangeDuration;
    @JsonProperty(value = "locationId")
    private FieldChange<Long> fieldChangeLocationId;
    @JsonProperty(value = "status")
    private FieldChange<String> fieldChangeStatus;
}