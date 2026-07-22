package com.example.mission_service.service;

import com.example.mission_service.dto.MissionMapper;
import com.example.mission_service.dto.MissionRequestDTO;
import com.example.mission_service.dto.MissionResponseDTO;
import com.example.mission_service.entity.Mission;
import com.example.mission_service.entity.MissionStatus;
import com.example.mission_service.exception.MissionNotFoundException;
import com.example.mission_service.external.IncidentDTO;
import com.example.mission_service.external.ResourceDTO;
import com.example.mission_service.external.TeamDTO;
import com.example.mission_service.repository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService {

    private final MissionRepository repository;
    private final RestTemplate restTemplate;

    private static final Logger log =
            LoggerFactory.getLogger(MissionServiceImpl.class);

    @Override
    public MissionResponseDTO addMission(MissionRequestDTO dto) {

        log.info("Inside addMission()");

        // Verify Incident Service
        IncidentDTO incident = restTemplate.getForObject(
                "http://localhost:8081/incidents/" + dto.getIncidentId(),
                IncidentDTO.class);

        // Verify Team Service
        TeamDTO team = restTemplate.getForObject(
                "http://localhost:8082/teams/" + dto.getTeamId(),
                TeamDTO.class);

        // Verify Resource Service
        ResourceDTO resource = restTemplate.getForObject(
                "http://localhost:8083/resources/" + dto.getResourceId(),
                ResourceDTO.class);

        if (incident == null || team == null || resource == null) {
            throw new RuntimeException("One or more services are unavailable.");
        }

        Mission mission = MissionMapper.toEntity(dto);
        mission.setMissionStatus(MissionStatus.CREATED);

        Mission saved = repository.save(mission);

        log.info("Mission Created Successfully");

        return MissionMapper.toResponse(saved);
    }

    @Override
    public MissionResponseDTO getMission(Integer id) {

        Mission mission = repository.findById(id)
                .orElseThrow(() ->
                        new MissionNotFoundException("Mission Not Found"));

        return MissionMapper.toResponse(mission);
    }

    @Override
    public List<MissionResponseDTO> getAllMissions() {

        return repository.findAll()
                .stream()
                .map(MissionMapper::toResponse)
                .toList();
    }

    @Override
    public MissionResponseDTO updateMission(Integer id,
                                            MissionRequestDTO dto) {

        Mission mission = repository.findById(id)
                .orElseThrow(() ->
                        new MissionNotFoundException("Mission Not Found"));

        mission.setIncidentId(dto.getIncidentId());
        mission.setTeamId(dto.getTeamId());
        mission.setResourceId(dto.getResourceId());

        Mission updated = repository.save(mission);

        log.info("Mission Updated Successfully");

        return MissionMapper.toResponse(updated);
    }

    @Override
    public String deleteMission(Integer id) {

        Mission mission = repository.findById(id)
                .orElseThrow(() ->
                        new MissionNotFoundException("Mission Not Found"));

        repository.delete(mission);

        log.info("Mission Deleted Successfully");

        return "Mission Deleted Successfully";
    }
}