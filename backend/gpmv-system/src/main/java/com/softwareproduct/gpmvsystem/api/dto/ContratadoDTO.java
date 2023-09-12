package com.softwareproduct.gpmvsystem.api.dto;

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
    private LocalDate dataNascimento;
    private String registroGeral;
    private String cpf;
    private EnderecoDTO endereco;
    private String cargo;
}
