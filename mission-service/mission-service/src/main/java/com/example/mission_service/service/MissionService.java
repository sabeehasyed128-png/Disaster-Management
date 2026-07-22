package com.example.mission_service.service;

import com.example.mission_service.dto.MissionRequestDTO;
import com.example.mission_service.dto.MissionResponseDTO;

import java.util.List;

public interface MissionService {

    MissionResponseDTO addMission(MissionRequestDTO dto);

    MissionResponseDTO getMission(Integer id);

    List<MissionResponseDTO> getAllMissions();

    MissionResponseDTO updateMission(Integer id,
                                     MissionRequestDTO dto);

    String deleteMission(Integer id);
}