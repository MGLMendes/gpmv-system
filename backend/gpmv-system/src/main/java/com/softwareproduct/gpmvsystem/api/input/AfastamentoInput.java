package com.softwareproduct.gpmvsystem.api.input;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
public class AfastamentoInput {

    private String motivo;

    private String descricao;

    private LocalDate inicio;

    private LocalDate fim;
}
