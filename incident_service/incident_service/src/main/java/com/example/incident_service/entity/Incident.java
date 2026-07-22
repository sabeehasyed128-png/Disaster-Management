package com.example.incident_service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@Table(name="INCIDENTS")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer incidentId;

    @NotBlank(message="Reporter Name is Required")
    private String reporterName;

    @Pattern(
            regexp="^[6-9]\\d{9}$",
            message="Mobile Number Must be 10 Digits"
    )
    private String mobile;

    @NotBlank(message="Location is Required")
    private String location;

    @Enumerated(EnumType.STRING)

    @NotNull(message="Severity is Required")
    private Severity severity;

    private String status;

}