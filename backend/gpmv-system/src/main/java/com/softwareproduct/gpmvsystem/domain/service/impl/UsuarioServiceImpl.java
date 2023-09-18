package com.softwareproduct.gpmvsystem.domain.service.impl;

import com.softwareproduct.gpmvsystem.api.dto.UsuarioDTO;
import com.softwareproduct.gpmvsystem.api.input.UsuarioInput;
import com.softwareproduct.gpmvsystem.domain.model.Contratado;
import com.softwareproduct.gpmvsystem.domain.model.Usuario;
import com.softwareproduct.gpmvsystem.domain.model.enums.Perfil;
import com.softwareproduct.gpmvsystem.domain.repository.ContratadoRepository;
import com.softwareproduct.gpmvsystem.domain.repository.UsuarioRepository;
import com.softwareproduct.gpmvsystem.domain.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;

    private final ContratadoRepository contratadoRepository;


    @Override
    public Usuario criarUsuario(Contratado contratado) {
        Perfil perfilUser = Perfil.CONTRATADO;

        if (contratado.getCargo().getCargo().equalsIgnoreCase("LIDER")) {
            perfilUser = Perfil.ADMIN;
        }

        Usuario usuario = Usuario.builder()
                .nome(contratado.getNome())
                .email(contratado.getEmail())
                .perfil(perfilUser)
                .senha("1234")
                .build();

        return repository.save(usuario);
    }

    @Override
    public UsuarioDTO login(UsuarioInput usuarioInput) {
        Contratado contratado = contratadoRepository.findByEmail(usuarioInput.getEmail());
        if (contratado == null) {
            return UsuarioDTO.builder()
                    .usuarioValido(false)
                    .causa("Email inválido")
                    .build();
        }

        if (contratado.getUsuario().getSenha().equalsIgnoreCase(usuarioInput.getSenha())) {
            return UsuarioDTO.builder()
                    .usuarioValido(true)
                    .causa("Usuário válido")
                    .build();
        } else {
            return UsuarioDTO.builder()
                    .usuarioValido(false)
                    .causa("Senha inválida")
                    .build();
        }
    }
}
