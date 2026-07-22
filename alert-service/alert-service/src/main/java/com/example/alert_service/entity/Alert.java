package com.example.alert_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ALERTS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer alertId;

    private Integer missionId;

    private String message;

    @Enumerated(EnumType.STRING)
    private AlertStatus status;
}