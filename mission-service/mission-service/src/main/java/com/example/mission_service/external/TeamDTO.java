package com.example.mission_service.external;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamDTO {

    private Integer teamId;

    private String teamName;

    private String location;

    private String status;
}