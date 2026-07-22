package com.example.mission_service.dto;

import com.example.mission_service.entity.Mission;

public class MissionMapper {

    public static Mission toEntity(MissionRequestDTO dto) {

        return Mission.builder()
                .incidentId(dto.getIncidentId())
                .teamId(dto.getTeamId())
                .resourceId(dto.getResourceId())
                .build();
    }

    public static MissionResponseDTO toResponse(Mission mission) {

        return MissionResponseDTO.builder()
                .missionId(mission.getMissionId())
                .incidentId(mission.getIncidentId())
                .teamId(mission.getTeamId())
                .resourceId(mission.getResourceId())
                .missionStatus(mission.getMissionStatus())
                .build();
    }
}