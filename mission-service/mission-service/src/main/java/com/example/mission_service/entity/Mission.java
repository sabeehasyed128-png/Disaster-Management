package com.example.mission_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MISSIONS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer missionId;

    private Integer incidentId;

    private Integer teamId;

    private Integer resourceId;

    @Enumerated(EnumType.STRING)
    private MissionStatus missionStatus;
}