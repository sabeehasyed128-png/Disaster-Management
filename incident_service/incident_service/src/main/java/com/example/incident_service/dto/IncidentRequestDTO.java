package com.example.incident_service.dto;

import com.example.incident_service.entity.Severity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IncidentRequestDTO {

    @NotBlank(message = "Reporter Name is Required")
    private String reporterName;

    @Pattern(
            regexp = "^[6-9]\\d{9}$",
            message = "Mobile Number Must be 10 Digits"
    )
    private String mobile;

    @NotBlank(message = "Location is Required")
    private String location;

    @NotNull(message = "Severity is Required")
    private Severity severity;

}