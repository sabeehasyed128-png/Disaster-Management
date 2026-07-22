package com.example.resource_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResourceRequestDTO {

    @NotBlank(message = "Resource Name is Required")
    private String resourceName;

    @Positive(message = "Quantity must be greater than zero")
    private Integer quantity;
}