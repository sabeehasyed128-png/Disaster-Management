package com.example.alert_service.service;

import com.example.alert_service.dto.AlertMapper;
import com.example.alert_service.dto.AlertRequestDTO;
import com.example.alert_service.dto.AlertResponseDTO;
import com.example.alert_service.entity.Alert;
import com.example.alert_service.entity.AlertStatus;
import com.example.alert_service.exception.AlertNotFoundException;
import com.example.alert_service.repository.AlertRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlertServiceImpl implements AlertService {

    private final AlertRepository repository;

    private static final Logger log =
            LoggerFactory.getLogger(AlertServiceImpl.class);

    @Override
    public AlertResponseDTO addAlert(AlertRequestDTO dto) {

        log.info("Inside addAlert()");

        Alert alert = AlertMapper.toEntity(dto);

        alert.setStatus(AlertStatus.SENT);

        Alert saved = repository.save(alert);

        log.info("Alert Created Successfully");

        return AlertMapper.toResponse(saved);
    }

    @Override
    public AlertResponseDTO getAlert(Integer id) {

        Alert alert = repository.findById(id)
                .orElseThrow(() ->
                        new AlertNotFoundException(
                                "Alert Not Found"));

        return AlertMapper.toResponse(alert);
    }

    @Override
    public List<AlertResponseDTO> getAllAlerts() {

        return repository.findAll()
                .stream()
                .map(AlertMapper::toResponse)
                .toList();
    }

    @Override
    public AlertResponseDTO updateAlert(Integer id,
                                        AlertRequestDTO dto) {

        Alert alert = repository.findById(id)
                .orElseThrow(() ->
                        new AlertNotFoundException(
                                "Alert Not Found"));

        alert.setMissionId(dto.getMissionId());
        alert.setMessage(dto.getMessage());

        Alert updated = repository.save(alert);

        log.info("Alert Updated Successfully");

        return AlertMapper.toResponse(updated);
    }

    @Override
    public String deleteAlert(Integer id) {

        Alert alert = repository.findById(id)
                .orElseThrow(() ->
                        new AlertNotFoundException(
                                "Alert Not Found"));

        repository.delete(alert);

        log.info("Alert Deleted Successfully");

        return "Alert Deleted Successfully";
    }
}