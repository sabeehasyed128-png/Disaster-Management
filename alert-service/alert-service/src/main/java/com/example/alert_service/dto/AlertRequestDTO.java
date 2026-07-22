package com.example.alert_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlertRequestDTO {

    @NotNull(message = "Mission Id is Required")
    private Integer missionId;

    @NotBlank(message = "Message is Required")
    private String message;
}