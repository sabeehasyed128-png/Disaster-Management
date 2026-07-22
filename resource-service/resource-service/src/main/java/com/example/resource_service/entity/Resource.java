package com.example.resource_service.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "RESOURCES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer resourceId;

    private String resourceName;

    private Integer quantity;
}