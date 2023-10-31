package com.softwareproduct.gpmvsystem.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.softwareproduct.gpmvsystem.api.input.CargosDTO;
import com.softwareproduct.gpmvsystem.api.input.EnderecoDTO;
import com.softwareproduct.gpmvsystem.domain.model.Endereco;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
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
