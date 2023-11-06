package com.softwareproduct.gpmvsystem.core.exceptions.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ErrorResponseDTO {

    private OffsetDateTime timestamp;
    private String title;
    private String detail;
    private String message;
}
