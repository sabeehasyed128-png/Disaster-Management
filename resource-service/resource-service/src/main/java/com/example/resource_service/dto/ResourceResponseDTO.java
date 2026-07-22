package com.example.resource_service.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResourceResponseDTO {

    private Integer resourceId;

    private String resourceName;

    private Integer quantity;
}