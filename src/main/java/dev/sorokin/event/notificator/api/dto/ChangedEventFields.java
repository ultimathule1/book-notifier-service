package dev.sorokin.event.notificator.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.HashMap;

@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@ToString
public class ChangedEventFields {
    /**
     * First is new value, Second is old value
     * Values can be null!!!
     */
    private HashMap<String, String> eventName;
    private HashMap<Integer, Integer> maxPlaces;
    private HashMap<OffsetDateTime, OffsetDateTime> startTime;
    private HashMap<BigDecimal, BigDecimal> cost;
    private HashMap<Integer, Integer> duration;
    private HashMap<Long, Long> locationId;
}