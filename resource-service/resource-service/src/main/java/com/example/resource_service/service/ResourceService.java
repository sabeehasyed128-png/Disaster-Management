package com.example.resource_service.service;

import com.example.resource_service.dto.ResourceRequestDTO;
import com.example.resource_service.dto.ResourceResponseDTO;

import java.util.List;

public interface ResourceService {

    ResourceResponseDTO addResource(ResourceRequestDTO dto);

    ResourceResponseDTO getResource(Integer id);

    List<ResourceResponseDTO> getAllResources();

    ResourceResponseDTO updateResource(Integer id,
                                       ResourceRequestDTO dto);

    String deleteResource(Integer id);
}