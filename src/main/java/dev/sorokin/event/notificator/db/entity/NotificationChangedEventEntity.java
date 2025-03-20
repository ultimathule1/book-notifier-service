package dev.sorokin.event.notificator.db.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "users_notifications")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NotificationChangedEventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "subscriber_id")
    private Long subscriberId;
    @Column(name = "user_changed_id")
    private Long userChangedId;
    @Column(name = "event_id", nullable = false)
    private Long eventId;
    @Column(name = "owner_event_id", nullable = false)
    private Long ownerEventId;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "is_read", nullable = false)
    private Boolean isRead;

    //TODO: Убрать fetch EAGER и сделать через NamedEntityGraph. Почему?
    // Как минимум потому что они не всегда нужны. Например, когда нам нужно будет просто прочитать isRead.
    //TODO: Также нужно проверить как будут удаляться через Scheduler все эти связанные сущности.
    // Видимо придется удалять только с subscriber а NewFields и OldFields оставлять, до тех пор, пока не будет
    // удаляться последний подписчик этих полей. Вот в этот момент придется все удалять.
    // Как реализовать?
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "new_fields_id", referencedColumnName = "id")
    private NewFieldsEntity newFieldsEntity;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "old_fields_id", referencedColumnName = "id")
    private OldFieldsEntity oldFieldsEntity;
}