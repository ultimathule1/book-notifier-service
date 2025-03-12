package dev.sorokin.event.notificator.db.repository;

import dev.sorokin.event.notificator.db.entity.ChangedEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Long, ChangedEventEntity> {
}
