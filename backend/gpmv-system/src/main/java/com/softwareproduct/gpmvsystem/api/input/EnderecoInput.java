package com.softwareproduct.gpmvsystem.api.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoInput {
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
}
