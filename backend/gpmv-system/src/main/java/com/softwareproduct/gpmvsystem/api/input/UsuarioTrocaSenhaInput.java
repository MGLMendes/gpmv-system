package com.softwareproduct.gpmvsystem.api.input;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UsuarioTrocaSenhaInput {

    private String email;
    private String senhaVelha;
    private String senhaNova;
    private String confirmaNovaSenha;
}
