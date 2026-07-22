package com.example.rescueteam_service.service;

import com.example.rescueteam_service.dto.TeamMapper;
import com.example.rescueteam_service.dto.TeamRequestDTO;
import com.example.rescueteam_service.dto.TeamResponseDTO;
import com.example.rescueteam_service.entity.Team;
import com.example.rescueteam_service.entity.TeamStatus;
import com.example.rescueteam_service.exception.TeamNotFoundException;
import com.example.rescueteam_service.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository repository;

    private static final Logger log =
            LoggerFactory.getLogger(TeamServiceImpl.class);

    @Override
    public TeamResponseDTO addTeam(TeamRequestDTO dto) {

        log.info("Inside addTeam()");

        Team team = TeamMapper.toEntity(dto);

        team.setStatus(TeamStatus.AVAILABLE);

        Team saved = repository.save(team);

        return TeamMapper.toResponse(saved);
    }

    @Override
    public TeamResponseDTO getTeam(Integer id) {

        Team team = repository.findById(id)
                .orElseThrow(() ->
                        new TeamNotFoundException("Team Not Found"));

        return TeamMapper.toResponse(team);
    }

    @Override
    public List<TeamResponseDTO> getAllTeams() {

        return repository.findAll()
                .stream()
                .map(TeamMapper::toResponse)
                .toList();
    }

    @Override
    public TeamResponseDTO updateTeam(Integer id,
                                      TeamRequestDTO dto) {

        Team team = repository.findById(id)
                .orElseThrow(() ->
                        new TeamNotFoundException("Team Not Found"));

        team.setTeamName(dto.getTeamName());
        team.setLocation(dto.getLocation());
        team.setStatus(dto.getStatus());

        Team updated = repository.save(team);

        return TeamMapper.toResponse(updated);
    }

    @Override
    public String deleteTeam(Integer id) {

        Team team = repository.findById(id)
                .orElseThrow(() ->
                        new TeamNotFoundException("Team Not Found"));

        repository.delete(team);

        return "Team Deleted Successfully";
    }
}