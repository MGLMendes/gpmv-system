package com.softwareproduct.gpmvsystem.domain.service;

import com.softwareproduct.gpmvsystem.api.dto.UsuarioDTO;
import com.softwareproduct.gpmvsystem.api.input.UsuarioInput;
import com.softwareproduct.gpmvsystem.api.input.UsuarioTrocaSenhaInput;
import com.softwareproduct.gpmvsystem.domain.model.Contratado;
import com.softwareproduct.gpmvsystem.domain.model.Usuario;

public interface UsuarioService {

    Usuario criarUsuario(Contratado contratado);

    UsuarioDTO login(UsuarioInput usuarioInput);

    UsuarioDTO trocarSenhaPrimeiroAcesso(UsuarioTrocaSenhaInput input);

}
