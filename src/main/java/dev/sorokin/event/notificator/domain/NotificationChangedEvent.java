package dev.sorokin.event.notificator.domain;

import dev.sorokin.event.notificator.db.entity.NewFieldsEntity;
import dev.sorokin.event.notificator.db.entity.OldFieldsEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public record NotificationChangedEvent(
        Long id,
        Long subscriberId,
        Long userChangedId,
        Long eventId,
        Long ownerEventId,
        LocalDateTime createdAt,
        Boolean isRead,
        NewFieldsEntity newFieldsEntity,
        OldFieldsEntity oldFieldsEntity
) {
}
