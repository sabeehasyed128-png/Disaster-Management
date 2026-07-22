package com.example.mission_service.external;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResourceDTO {

    private Integer resourceId;

    private String resourceName;

    private Integer quantity;
}