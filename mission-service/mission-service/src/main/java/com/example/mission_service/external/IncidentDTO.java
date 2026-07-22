package com.example.mission_service.external;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IncidentDTO {

    private Integer incidentId;

    private String reporterName;

    private String mobile;

    private String location;

    private String severity;

    private String status;
}