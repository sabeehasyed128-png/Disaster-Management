package com.example.incident_service.service;

import com.example.incident_service.dto.IncidentMapper;
import com.example.incident_service.dto.IncidentRequestDTO;
import com.example.incident_service.dto.IncidentResponseDTO;
import com.example.incident_service.entity.Incident;
import com.example.incident_service.exception.IncidentNotFoundException;
import com.example.incident_service.repository.IncidentRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IncidentServiceImpl implements IncidentService {

    private final IncidentRepository repository;

    private static final Logger log =
            LoggerFactory.getLogger(IncidentServiceImpl.class);

    @Override
    public IncidentResponseDTO addIncident(
            IncidentRequestDTO dto) {

        log.info("Inside addIncident()");

        Incident incident =
                IncidentMapper.toEntity(dto);

        incident.setStatus("REPORTED");

        Incident saved =
                repository.save(incident);

        log.info("Incident Added Successfully");

        return IncidentMapper.toResponse(saved);
    }

    @Override
    public IncidentResponseDTO getIncident(
            Integer id) {

        Incident incident =
                repository.findById(id)
                        .orElseThrow(() ->
                                new IncidentNotFoundException(
                                        "Incident Not Found"));

        return IncidentMapper.toResponse(incident);
    }

    @Override
    public List<IncidentResponseDTO> getAllIncidents() {

        return repository.findAll()
                .stream()
                .map(IncidentMapper::toResponse)
                .toList();
    }

    @Override
    public IncidentResponseDTO updateIncident(
            Integer id,
            IncidentRequestDTO dto) {

        Incident incident =
                repository.findById(id)
                        .orElseThrow(() ->
                                new IncidentNotFoundException(
                                        "Incident Not Found"));

        incident.setReporterName(dto.getReporterName());
        incident.setMobile(dto.getMobile());
        incident.setLocation(dto.getLocation());
        incident.setSeverity(dto.getSeverity());

        Incident updated =
                repository.save(incident);

        log.info("Incident Updated Successfully");

        return IncidentMapper.toResponse(updated);
    }

    @Override
    public String deleteIncident(
            Integer id) {

        Incident incident =
                repository.findById(id)
                        .orElseThrow(() ->
                                new IncidentNotFoundException(
                                        "Incident Not Found"));

        repository.delete(incident);

        log.info("Incident Deleted Successfully");

        return "Incident Deleted Successfully";
    }
}