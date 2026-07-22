package com.example.rescueteam_service.dto;

import com.example.rescueteam_service.entity.Team;

public class TeamMapper {

    public static Team toEntity(TeamRequestDTO dto) {

        return Team.builder()
                .teamName(dto.getTeamName())
                .location(dto.getLocation())
                .status(dto.getStatus())
                .build();
    }

    public static TeamResponseDTO toResponse(Team team) {

        return TeamResponseDTO.builder()
                .teamId(team.getTeamId())
                .teamName(team.getTeamName())
                .location(team.getLocation())
                .status(team.getStatus())
                .build();
    }

}