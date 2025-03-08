package dev.sorokin.event.notificator.api.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.HashMap;

@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public class ChangedEventFields {
    private HashMap<String, String> eventName;
    private HashMap<Integer, Integer> maxPlaces;
    private HashMap<OffsetDateTime, OffsetDateTime> startTime;
    private HashMap<BigDecimal, BigDecimal> cost;
    private HashMap<Integer, Integer> duration;
    private HashMap<Long, Long> locationId;
}