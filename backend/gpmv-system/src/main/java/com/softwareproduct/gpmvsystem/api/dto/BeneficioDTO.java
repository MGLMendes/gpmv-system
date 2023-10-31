package com.softwareproduct.gpmvsystem.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BeneficioDTO {

    private String beneficio;

    private String contratadoMatricula;

    private String contratadoNome;

    private String preco;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataContratacao;
}
