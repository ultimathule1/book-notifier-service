package dev.sorokin.event.notificator.api.dao.event;

import dev.sorokin.event.notificator.api.dao.ChangedEventFields;
import dev.sorokin.event.notificator.api.dao.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;

import java.util.List;

public class EventChangerEvent {
    @NotNull
    @Positive
    private Long eventId;
    @Null
    private Long changedEventByUserId;
    @NotNull
    @Positive
    private Long ownerEventId;
    @NotNull
    private ChangedEventFields changedEventFields;
    @NotNull
    private List<User> eventSubscribers;
}
