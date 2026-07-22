package com.example.alert_service.service;

import com.example.alert_service.dto.AlertRequestDTO;
import com.example.alert_service.dto.AlertResponseDTO;

import java.util.List;

public interface AlertService {

    AlertResponseDTO addAlert(AlertRequestDTO dto);

    AlertResponseDTO getAlert(Integer id);

    List<AlertResponseDTO> getAllAlerts();

    AlertResponseDTO updateAlert(Integer id,
                                 AlertRequestDTO dto);

    String deleteAlert(Integer id);

}