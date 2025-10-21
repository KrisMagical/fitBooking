package com.fitness.booking.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@Table(name = "system_config", indexes =
@Index(name = "uk_config_key", columnList = "cfgKey", unique = true))
@NoArgsConstructor
@AllArgsConstructor
public class SystemConfig extends BaseEntity {
    @Column(name = "cfg_key", length = 24, nullable = false, unique = true)
    private String key;
    @Column(length = 1024,nullable = false)
    private String value;
    private Long updatedBy;
}
