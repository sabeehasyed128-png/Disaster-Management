package com.example.mission_service.dto;

import com.example.mission_service.entity.MissionStatus;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MissionResponseDTO {

    private Integer missionId;

    private Integer incidentId;

    private Integer teamId;

    private Integer resourceId;

    private MissionStatus missionStatus;
}