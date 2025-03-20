package dev.sorokin.event.notificator.config;

import dev.sorokin.event.notificator.db.repository.NotificationsRepository;
import dev.sorokin.event.notificator.db.repository.ProcessedNotificationRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.logging.Logger;

@Configuration
@EnableScheduling
@ConditionalOnProperty(name = "scheduler.enabled", matchIfMissing = true)
public class SchedulerConfig {

    private static final Logger LOGGER = Logger.getLogger(SchedulerConfig.class.getName());
    private final NotificationsRepository notificationsRepository;
    private final ProcessedNotificationRepository processedNotificationRepository;

    public SchedulerConfig(NotificationsRepository notificationsRepository, ProcessedNotificationRepository processedNotificationRepository) {
        this.notificationsRepository = notificationsRepository;
        this.processedNotificationRepository = processedNotificationRepository;
    }

    @Scheduled(cron = "${scheduler.interval.cron.every-ten-minutes}")
    public void schedulerForRemoveNotifications() {
        LOGGER.info("The scheduler for removing notifications for more than seven days is launched!");
        notificationsRepository.deleteAllForLatestSevenDays();
        LOGGER.info("The scheduler for removing notifications for more than seven days is finished!");
    }

    @Scheduled(cron = "${scheduler.interval.cron.every-hour}")
    public void schedulerForRemoveOldIdempotentMessages() {
        LOGGER.info("The scheduler for removing idempotency messages for more than seven days is launched!");
        processedNotificationRepository.deleteAllForLatestSevenDays();
        LOGGER.info("The scheduler for removing idempotency messages for more than seven days is finished!");
    }
}
