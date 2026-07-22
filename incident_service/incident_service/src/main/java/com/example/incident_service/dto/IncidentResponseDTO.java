package com.example.incident_service.dto;

import com.example.incident_service.entity.Severity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IncidentResponseDTO {

    private Integer incidentId;

    private String reporterName;

    private String location;

    private Severity severity;

    private String status;

}