package com.example.rescueteam_service.controller;

import com.example.rescueteam_service.dto.TeamRequestDTO;
import com.example.rescueteam_service.dto.TeamResponseDTO;
import com.example.rescueteam_service.service.TeamService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService service;

    @PostMapping
    public TeamResponseDTO addTeam(
            @Valid @RequestBody TeamRequestDTO dto) {

        return service.addTeam(dto);
    }

    @GetMapping("/{id}")
    public TeamResponseDTO getTeam(
            @PathVariable Integer id) {

        return service.getTeam(id);
    }

    @GetMapping
    public List<TeamResponseDTO> getAllTeams() {

        return service.getAllTeams();
    }

    @PutMapping("/{id}")
    public TeamResponseDTO updateTeam(
            @PathVariable Integer id,
            @RequestBody TeamRequestDTO dto) {

        return service.updateTeam(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteTeam(
            @PathVariable Integer id) {

        return service.deleteTeam(id);
    }
}