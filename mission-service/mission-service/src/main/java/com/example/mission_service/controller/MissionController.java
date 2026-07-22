package com.example.mission_service.controller;

import com.example.mission_service.dto.MissionRequestDTO;
import com.example.mission_service.dto.MissionResponseDTO;
import com.example.mission_service.service.MissionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    private static final Logger log =
            LoggerFactory.getLogger(MissionController.class);

    @PostMapping
    public MissionResponseDTO addMission(
            @Valid @RequestBody MissionRequestDTO dto) {

        log.info("Inside addMission()");

        return missionService.addMission(dto);
    }

    @GetMapping("/{id}")
    public MissionResponseDTO getMission(
            @PathVariable Integer id) {

        return missionService.getMission(id);
    }

    @GetMapping
    public List<MissionResponseDTO> getAllMissions() {

        return missionService.getAllMissions();
    }

    @PutMapping("/{id}")
    public MissionResponseDTO updateMission(
            @PathVariable Integer id,
            @Valid @RequestBody MissionRequestDTO dto) {

        return missionService.updateMission(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteMission(
            @PathVariable Integer id) {

        log.info("Inside deleteMission()");

        return missionService.deleteMission(id);
    }
}