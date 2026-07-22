package com.example.mission_service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MissionRequestDTO {

    @NotNull(message = "Incident Id is Required")
    private Integer incidentId;

    @NotNull(message = "Team Id is Required")
    private Integer teamId;

    @NotNull(message = "Resource Id is Required")
    private Integer resourceId;
}