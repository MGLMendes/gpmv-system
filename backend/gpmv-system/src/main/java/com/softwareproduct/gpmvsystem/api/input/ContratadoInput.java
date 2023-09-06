package com.softwareproduct.gpmvsystem.api.input;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.softwareproduct.gpmvsystem.domain.model.Cargos;
import com.softwareproduct.gpmvsystem.domain.model.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContratadoInput {
    private String nome;
    private String nomePai;
    private String nomeMae;
    private String email;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;
    private String registroGeral;
    private String cpf;
    private EnderecoInput endereco;
    private CargoIdInput cargo;
}
