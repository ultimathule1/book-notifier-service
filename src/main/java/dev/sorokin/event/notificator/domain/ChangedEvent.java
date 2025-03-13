package dev.sorokin.event.notificator.domain;

import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Builder
public record ChangedEvent (
     Long eventId,
     String nameOld,
     String nameNew,
     Integer maxPlacesOld,
     Integer maxPlacesNew,
     OffsetDateTime dateOld,
     OffsetDateTime dateNew,
     BigDecimal costOld,
     BigDecimal costNew,
     Integer durationOld,
     Integer durationNew,
     Long locationIdOld,
     Long locationIdNew,
     String statusOld,
     String statusNew
) {}
