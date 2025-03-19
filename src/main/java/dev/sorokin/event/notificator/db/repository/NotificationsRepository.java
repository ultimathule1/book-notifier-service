package dev.sorokin.event.notificator.db.repository;

import dev.sorokin.event.notificator.db.entity.ChangedEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface NotificationsRepository extends JpaRepository<ChangedEventEntity, Long> {

    List<ChangedEventEntity> findAllByUserIdIsAndIsReadFalse(Long userId);

    @Query("""
        UPDATE ChangedEventEntity e
        SET e.isRead=true
        WHERE e.userId=:userId AND e.id = :id AND e.isRead=false
    """)
    @Modifying
    @Transactional
    void updateIsReadAsTrueByUserIdAndId(Long userId, Long id);

    @Modifying
    @Transactional
    @Query(value = """
    DELETE FROM users_notifications e
    WHERE (e.created_at + INTERVAL '1 WEEK') < CURRENT_TIMESTAMP
    """, nativeQuery = true)
    void deleteAllForLatestSevenDays();
}
