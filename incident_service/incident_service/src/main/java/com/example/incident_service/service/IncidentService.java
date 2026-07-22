package com.example.incident_service.service;

import com.example.incident_service.dto.IncidentRequestDTO;
import com.example.incident_service.dto.IncidentResponseDTO;

import java.util.List;

public interface IncidentService {

    IncidentResponseDTO addIncident(
            IncidentRequestDTO dto);

    IncidentResponseDTO getIncident(
            Integer id);

    List<IncidentResponseDTO> getAllIncidents();

    IncidentResponseDTO updateIncident(
            Integer id,
            IncidentRequestDTO dto);

    String deleteIncident(
            Integer id);
}