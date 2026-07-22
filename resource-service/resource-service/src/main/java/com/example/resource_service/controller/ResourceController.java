package com.example.resource_service.controller;

import com.example.resource_service.dto.ResourceRequestDTO;
import com.example.resource_service.dto.ResourceResponseDTO;
import com.example.resource_service.service.ResourceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resources")
@RequiredArgsConstructor
public class ResourceController {

    private final ResourceService resourceService;

    private static final Logger log =
            LoggerFactory.getLogger(ResourceController.class);

    @PostMapping
    public ResourceResponseDTO addResource(
            @Valid @RequestBody ResourceRequestDTO dto) {

        log.info("Inside addResource()");

        return resourceService.addResource(dto);
    }

    @GetMapping("/{id}")
    public ResourceResponseDTO getResource(
            @PathVariable Integer id) {

        return resourceService.getResource(id);
    }

    @GetMapping
    public List<ResourceResponseDTO> getAllResources() {

        return resourceService.getAllResources();
    }

    @PutMapping("/{id}")
    public ResourceResponseDTO updateResource(
            @PathVariable Integer id,
            @Valid @RequestBody ResourceRequestDTO dto) {

        return resourceService.updateResource(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteResource(
            @PathVariable Integer id) {

        log.info("Inside deleteResource()");

        return resourceService.deleteResource(id);
    }
}