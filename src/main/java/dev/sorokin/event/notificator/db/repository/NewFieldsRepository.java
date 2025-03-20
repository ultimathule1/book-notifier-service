package dev.sorokin.event.notificator.db.repository;

import dev.sorokin.event.notificator.db.entity.NewFieldsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewFieldsRepository extends JpaRepository<NewFieldsEntity, Long> {
}
