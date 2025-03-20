package dev.sorokin.event.notificator.domain.service;

import dev.sorokin.event.notificator.db.repository.NotificationsRepository;
import dev.sorokin.event.notificator.domain.ChangedEvent;
import dev.sorokin.event.notificator.domain.NotificationChangedEvent;
import dev.sorokin.event.notificator.mapper.ChangedEventMapper;
import dev.sorokin.event.notificator.mapper.NotificationChangedEventMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationService.class);
    private final NotificationsRepository notificationsRepository;
    private final ChangedEventMapper changedEventMapper;
    private final NotificationChangedEventMapper notificationChangedEventMapper;

    public NotificationService(NotificationsRepository notificationsRepository, ChangedEventMapper changedEventMapper, NotificationChangedEventMapper notificationChangedEventMapper) {
        this.notificationsRepository = notificationsRepository;
        this.changedEventMapper = changedEventMapper;
        this.notificationChangedEventMapper = notificationChangedEventMapper;
    }

    public List<NotificationChangedEvent> getUnreadNotificationsCurrentUser() {
        Long userId = getCurrentUserId();
        return notificationsRepository.findAllBySubscriberIdIsAndIsReadFalse(userId)
                .stream()
                .map(notificationChangedEventMapper::toDomain)
                .toList();
    }

    public void markNotificationAsRead(List<Long> notificationIds) {
        Long userId = getCurrentUserId();
        notificationIds
                .forEach(notificationId -> {
                    notificationsRepository.updateIsReadAsTrueByUserIdAndId(userId, notificationId);
                });
        LOGGER.info("Notifications are Updated As Read ={}", notificationIds);
    }

    private Long getCurrentUserId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) {
            throw new SecurityException("Authentication required");
        }

        return Long.parseLong(auth.getName());
    }
}