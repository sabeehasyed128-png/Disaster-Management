package com.example.alert_service.dto;

import com.example.alert_service.entity.AlertStatus;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlertResponseDTO {

    private Integer alertId;

    private Integer missionId;

    private String message;

    private AlertStatus status;
}