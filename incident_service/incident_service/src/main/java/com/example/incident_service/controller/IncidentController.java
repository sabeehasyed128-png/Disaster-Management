package com.example.incident_service.controller;

import com.example.incident_service.dto.IncidentRequestDTO;
import com.example.incident_service.dto.IncidentResponseDTO;
import com.example.incident_service.service.IncidentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/incidents")
@RequiredArgsConstructor
public class IncidentController {

    private final IncidentService incidentService;

    private static final Logger log =
            LoggerFactory.getLogger(IncidentController.class);

    @PostMapping
    public IncidentResponseDTO addIncident(
            @Valid @RequestBody IncidentRequestDTO dto) {

        log.info("Inside addIncident()");

        return incidentService.addIncident(dto);
    }

    @GetMapping("/{id}")
    public IncidentResponseDTO getIncident(
            @PathVariable Integer id) {

        return incidentService.getIncident(id);
    }

    @GetMapping
    public List<IncidentResponseDTO> getAllIncidents() {

        return incidentService.getAllIncidents();
    }

    @PutMapping("/{id}")
    public IncidentResponseDTO updateIncident(
            @PathVariable Integer id,
            @Valid @RequestBody IncidentRequestDTO dto) {

        return incidentService.updateIncident(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteIncident(
            @PathVariable Integer id) {

        log.info("Inside deleteIncident()");

        return incidentService.deleteIncident(id);
    }
}