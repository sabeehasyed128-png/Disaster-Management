package com.example.rescueteam_service.dto;

import com.example.rescueteam_service.entity.TeamStatus;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamResponseDTO {

    private Integer teamId;

    private String teamName;

    private String location;

    private TeamStatus status;

}