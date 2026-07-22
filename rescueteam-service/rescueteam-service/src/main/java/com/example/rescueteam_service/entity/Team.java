package com.example.rescueteam_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="TEAMS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teamId;

    private String teamName;

    private String location;

    @Enumerated(EnumType.STRING)
    private TeamStatus status;

}