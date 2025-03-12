package dev.sorokin.event.notificator.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name="users_notifications")
@AllArgsConstructor
@NoArgsConstructor
public class ChangedEventEntity {
    @Id
    @Column(name="user_id")
    private Long userId;
    @Column(name = "event_id")
    private Long eventId;
    @Column(name = "name_old")
    private String nameOld;
    @Column(name = "name_new")
    private String nameNew;
    @Column(name = "max_places_old")
    private Integer maxPlacesOld;
    @Column(name = "max_places_new")
    private Integer maxPlacesNew;
    @Column(name = "date_old")
    private OffsetDateTime dateOld;
    @Column(name = "date_new")
    private OffsetDateTime dateNew;
    @Column(name = "cost_old")
    private BigDecimal costOld;
    @Column(name = "cost_new")
    private BigDecimal costNew;
    @Column(name = "duration_old")
    private Integer durationOld;
    @Column(name = "duration_new")
    private Integer durationNew;
    @Column(name = "location_id_old")
    private Long locationIdOld;
    @Column(name = "location_id_new")
    private Long locationIdNew;
}