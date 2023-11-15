package com.softwareproduct.gpmvsystem.api.input;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContratadoAttInput {
    private String nome;
    private String nomePai;
    private String nomeMae;
    private String email;
    private String cargo;
}
