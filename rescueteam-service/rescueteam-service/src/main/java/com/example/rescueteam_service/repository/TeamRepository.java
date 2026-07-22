package com.example.rescueteam_service.repository;

import com.example.rescueteam_service.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository
        extends JpaRepository<Team, Integer> {
}