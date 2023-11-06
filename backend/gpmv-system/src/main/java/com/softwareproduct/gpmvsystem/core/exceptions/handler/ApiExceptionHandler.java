package com.softwareproduct.gpmvsystem.core.exceptions.handler;

import com.softwareproduct.gpmvsystem.core.exceptions.dto.ErrorResponseDTO;
import com.softwareproduct.gpmvsystem.core.exceptions.model.ContratadoException;
import com.softwareproduct.gpmvsystem.core.exceptions.model.FeriasInvalidasException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.OffsetDateTime;

@ControllerAdvice
@RequiredArgsConstructor
public class ApiExceptionHandler {


    @ExceptionHandler(FeriasInvalidasException.class)
    public ResponseEntity<ErrorResponseDTO> feriasInvalidasExceptionHandler(FeriasInvalidasException e) {
        ErrorResponseDTO error = ErrorResponseDTO.builder()
                .timestamp(OffsetDateTime.now())
                .title("Erro nas férias!")
                .detail("Error ao programar perído de férias!")
                .message(e.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(ContratadoException.class)
    public ResponseEntity<ErrorResponseDTO> contratadoErrorExceptionHandler(ContratadoException e) {
        ErrorResponseDTO error = ErrorResponseDTO.builder()
                .timestamp(OffsetDateTime.now())
                .title("Erro contratado!")
                .detail("Error ao contratar funcionário!")
                .message(e.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
