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
@Table(name = "audit_logs", indexes =
        @Index(name = "idx_audit_target", columnList = "targetType,targetId"))
@NoArgsConstructor
@AllArgsConstructor
public class AuditLog extends BaseEntity{
    private Long actorUserId;
    @Column(length = 64)
    private String action;
    @Column(length = 32)
    private String targetType;

    private Long targetId;
    @Column(length = 1024)
    private String detail;

    @Column(length = 64)
    private String ip;
}
