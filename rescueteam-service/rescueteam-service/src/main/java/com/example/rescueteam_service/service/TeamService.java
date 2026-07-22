package com.example.rescueteam_service.service;

import com.example.rescueteam_service.dto.TeamRequestDTO;
import com.example.rescueteam_service.dto.TeamResponseDTO;

import java.util.List;

public interface TeamService {

    TeamResponseDTO addTeam(TeamRequestDTO dto);

    TeamResponseDTO getTeam(Integer id);

    List<TeamResponseDTO> getAllTeams();

    TeamResponseDTO updateTeam(Integer id,
                               TeamRequestDTO dto);

    String deleteTeam(Integer id);
}