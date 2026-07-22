package com.example.incident_service.dto;

import com.example.incident_service.entity.Incident;

public class IncidentMapper {

    public static Incident toEntity(IncidentRequestDTO dto){

        Incident incident = new Incident();

        incident.setReporterName(dto.getReporterName());
        incident.setMobile(dto.getMobile());
        incident.setLocation(dto.getLocation());
        incident.setSeverity(dto.getSeverity());

        return incident;
    }

    public static IncidentResponseDTO toResponse(Incident incident){

        IncidentResponseDTO dto = new IncidentResponseDTO();

        dto.setIncidentId(incident.getIncidentId());
        dto.setReporterName(incident.getReporterName());
        dto.setLocation(incident.getLocation());
        dto.setSeverity(incident.getSeverity());
        dto.setStatus(incident.getStatus());

        return dto;
    }

}