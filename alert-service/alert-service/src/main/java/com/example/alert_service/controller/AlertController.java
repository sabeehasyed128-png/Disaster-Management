package com.example.alert_service.controller;

import com.example.alert_service.dto.AlertRequestDTO;
import com.example.alert_service.dto.AlertResponseDTO;
import com.example.alert_service.service.AlertService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alerts")
@RequiredArgsConstructor
public class AlertController {

    private final AlertService alertService;

    private static final Logger log =
            LoggerFactory.getLogger(AlertController.class);

    @PostMapping
    public AlertResponseDTO addAlert(
            @Valid @RequestBody AlertRequestDTO dto) {

        log.info("Inside addAlert()");

        return alertService.addAlert(dto);
    }

    @GetMapping("/{id}")
    public AlertResponseDTO getAlert(
            @PathVariable Integer id) {

        return alertService.getAlert(id);
    }

    @GetMapping
    public List<AlertResponseDTO> getAllAlerts() {

        return alertService.getAllAlerts();
    }

    @PutMapping("/{id}")
    public AlertResponseDTO updateAlert(
            @PathVariable Integer id,
            @Valid @RequestBody AlertRequestDTO dto) {

        return alertService.updateAlert(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteAlert(
            @PathVariable Integer id) {

        log.info("Inside deleteAlert()");

        return alertService.deleteAlert(id);
    }
}