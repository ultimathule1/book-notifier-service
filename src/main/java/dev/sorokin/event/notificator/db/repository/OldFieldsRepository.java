package dev.sorokin.event.notificator.db.repository;

import dev.sorokin.event.notificator.db.entity.OldFieldsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OldFieldsRepository extends JpaRepository<OldFieldsEntity, Long> {
}
