package com.example.alert_service.dto;

import com.example.alert_service.entity.Alert;

public class AlertMapper {

    public static Alert toEntity(AlertRequestDTO dto) {

        return Alert.builder()
                .missionId(dto.getMissionId())
                .message(dto.getMessage())
                .build();
    }

    public static AlertResponseDTO toResponse(Alert alert) {

        return AlertResponseDTO.builder()
                .alertId(alert.getAlertId())
                .missionId(alert.getMissionId())
                .message(alert.getMessage())
                .status(alert.getStatus())
                .build();
    }
}