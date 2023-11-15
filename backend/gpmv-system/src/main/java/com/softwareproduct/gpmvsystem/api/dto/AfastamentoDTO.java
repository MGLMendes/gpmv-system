package com.softwareproduct.gpmvsystem.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AfastamentoDTO {

    private String motivo;

    private String descricao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate inicio;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fim;
}
