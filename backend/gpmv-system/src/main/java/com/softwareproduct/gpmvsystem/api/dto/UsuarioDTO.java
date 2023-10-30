package com.softwareproduct.gpmvsystem.api.dto;

import com.softwareproduct.gpmvsystem.domain.model.enums.Perfil;
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
    private Boolean primeiroAcesso;
    private String causa;
    private String perfil;
    private String contratadoNome;

    private String contratadoMatricula;
}
