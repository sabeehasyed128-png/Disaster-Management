package com.example.resource_service.service;

import com.example.resource_service.dto.ResourceMapper;
import com.example.resource_service.dto.ResourceRequestDTO;
import com.example.resource_service.dto.ResourceResponseDTO;
import com.example.resource_service.entity.Resource;
import com.example.resource_service.exception.ResourceNotFoundException;
import com.example.resource_service.repository.ResourceRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResourceServiceImpl implements ResourceService {

    private final ResourceRepository repository;

    private static final Logger log =
            LoggerFactory.getLogger(ResourceServiceImpl.class);

    @Override
    public ResourceResponseDTO addResource(ResourceRequestDTO dto) {

        log.info("Inside addResource()");

        Resource resource = ResourceMapper.toEntity(dto);

        Resource saved = repository.save(resource);

        log.info("Resource Added Successfully");

        return ResourceMapper.toResponse(saved);
    }

    @Override
    public ResourceResponseDTO getResource(Integer id) {

        Resource resource = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Resource Not Found"));

        return ResourceMapper.toResponse(resource);
    }

    @Override
    public List<ResourceResponseDTO> getAllResources() {

        return repository.findAll()
                .stream()
                .map(ResourceMapper::toResponse)
                .toList();
    }

    @Override
    public ResourceResponseDTO updateResource(Integer id,
                                              ResourceRequestDTO dto) {

        Resource resource = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Resource Not Found"));

        resource.setResourceName(dto.getResourceName());
        resource.setQuantity(dto.getQuantity());

        Resource updated = repository.save(resource);

        log.info("Resource Updated Successfully");

        return ResourceMapper.toResponse(updated);
    }

    @Override
    public String deleteResource(Integer id) {

        Resource resource = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Resource Not Found"));

        repository.delete(resource);

        log.info("Resource Deleted Successfully");

        return "Resource Deleted Successfully";
    }
}