package dev.sorokin.event.notificator.config;

import dev.sorokin.event.notificator.db.repository.NotificationsRepository;
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

    public SchedulerConfig(NotificationsRepository notificationsRepository) {
        this.notificationsRepository = notificationsRepository;
    }

    @Scheduled(cron = "${scheduler.interval.cron.every-minute}")
    public void schedulerForRemoveNotifications() {
        LOGGER.info("The scheduler for removing notifications for more than seven days is launched!");
        notificationsRepository.deleteAllForLatestSevenDays();
        LOGGER.info("The scheduler for removing notifications for more than seven days is finished!");
    }


    //TODO: create scheduler for idempotency
    public void schedulerForRemoveOldIdempotentMessages() {
        LOGGER.info("The scheduler for removing idempotency messages for more than seven days is launched!");

    }
}
