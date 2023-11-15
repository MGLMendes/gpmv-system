package com.softwareproduct.gpmvsystem.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ContratadoDTO {

    private Long id;
    private String matricula;
    private String nome;
    private String nomePai;
    private String nomeMae;
    private String email;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;
    private String registroGeral;
    private String cpf;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAdmissao;
    private String cargo;
}
