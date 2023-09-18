package com.softwareproduct.gpmvsystem.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UsuarioDTO {

    private Boolean usuarioValido;
    private String causa;
}
