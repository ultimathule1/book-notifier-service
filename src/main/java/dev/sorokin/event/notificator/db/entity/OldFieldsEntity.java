package dev.sorokin.event.notificator.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "old_fields")
@Getter
@Setter
@NoArgsConstructor @AllArgsConstructor
public class OldFieldsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "max_places")
    private Integer maxPlaces;
    @Column(name = "date")
    private OffsetDateTime date;
    @Column(name = "cost")
    private BigDecimal cost;
    @Column(name = "duration")
    private Integer duration;
    @Column(name = "location_id")
    private Long locationId;
    @Column(name = "status")
    private String status;
}
