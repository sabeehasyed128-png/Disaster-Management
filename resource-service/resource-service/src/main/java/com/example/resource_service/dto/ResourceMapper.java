package com.example.resource_service.dto;

import com.example.resource_service.entity.Resource;

public class ResourceMapper {

    public static Resource toEntity(ResourceRequestDTO dto) {

        return Resource.builder()
                .resourceName(dto.getResourceName())
                .quantity(dto.getQuantity())
                .build();
    }

    public static ResourceResponseDTO toResponse(Resource resource) {

        return ResourceResponseDTO.builder()
                .resourceId(resource.getResourceId())
                .resourceName(resource.getResourceName())
                .quantity(resource.getQuantity())
                .build();
    }
}