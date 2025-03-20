package dev.sorokin.event.notificator.db.repository;

import dev.sorokin.event.notificator.db.entity.NotificationChangedEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface NotificationsRepository extends JpaRepository<NotificationChangedEventEntity, Long> {

    List<NotificationChangedEventEntity> findAllBySubscriberIdIsAndIsReadFalse(Long userId);

    @Modifying
    @Transactional
    @Query("""
                UPDATE NotificationChangedEventEntity e
                SET e.isRead=true
                WHERE e.subscriberId=:subscriberId AND e.id = :id AND e.isRead=false
            """)
    void updateIsReadAsTrueByUserIdAndId(Long subscriberId, Long id);

    @Modifying
    @Transactional
    @Query(value = """
            DELETE FROM users_notifications e
            WHERE (e.created_at + INTERVAL '1 WEEK') < CURRENT_TIMESTAMP
            """, nativeQuery = true)
    void deleteAllForLatestSevenDays();
}
