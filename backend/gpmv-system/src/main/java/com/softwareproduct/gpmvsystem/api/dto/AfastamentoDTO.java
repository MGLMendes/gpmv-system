package com.softwareproduct.gpmvsystem.api.dto;

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

    private LocalDate inicio;

    private LocalDate fim;
}
