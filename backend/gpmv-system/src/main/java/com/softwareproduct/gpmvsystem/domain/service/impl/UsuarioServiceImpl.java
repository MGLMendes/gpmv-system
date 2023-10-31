package com.softwareproduct.gpmvsystem.domain.service.impl;

import com.softwareproduct.gpmvsystem.api.dto.UsuarioDTO;
import com.softwareproduct.gpmvsystem.api.input.UsuarioInput;
import com.softwareproduct.gpmvsystem.api.input.UsuarioTrocaSenhaInput;
import com.softwareproduct.gpmvsystem.domain.model.Contratado;
import com.softwareproduct.gpmvsystem.domain.model.Usuario;
import com.softwareproduct.gpmvsystem.domain.model.enums.Perfil;
import com.softwareproduct.gpmvsystem.domain.repository.ContratadoRepository;
import com.softwareproduct.gpmvsystem.domain.repository.UsuarioRepository;
import com.softwareproduct.gpmvsystem.domain.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;

    private final ContratadoRepository contratadoRepository;


    @Transactional
    @Override
    public Usuario criarUsuario(Contratado contratado) {
        Perfil perfilUser = Perfil.CONTRATADO;

        if (contratado.getCargo().getCargo().equalsIgnoreCase("LIDER")
            || contratado.getCargo().getCargo().equalsIgnoreCase("SCRUM MASTER")) {
            perfilUser = Perfil.ADMIN;
        }

        Usuario usuario = Usuario.builder()
                .nome(contratado.getNome())
                .email(contratado.getEmail())
                .perfil(perfilUser)
                .senha("1234")
                .primeiroAcesso(true)
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
                    .primeiroAcesso(contratado.getUsuario().getPrimeiroAcesso())
                    .causa("Usuário válido")
                    .contratadoNome(contratado.getNome())
                    .perfil(contratado.getCargo().getCargo())
                    .contratadoMatricula(contratado.getMatricula())
                    .build();
        } else {
            return UsuarioDTO.builder()
                    .usuarioValido(false)
                    .primeiroAcesso(contratado.getUsuario().getPrimeiroAcesso())
                    .causa("Senha inválida")
                    .build();
        }
    }

    @Transactional
    public UsuarioDTO trocarSenhaPrimeiroAcesso(UsuarioTrocaSenhaInput input) {
        Contratado contratado = contratadoRepository.findByEmail(input.getEmail());

        if (contratado == null) {
            return UsuarioDTO.builder()
                    .usuarioValido(false)
                    .causa("Email inválido")
                    .build();
        }

        if (!contratado.getUsuario().getSenha().equalsIgnoreCase(input.getSenhaVelha())) {
            return UsuarioDTO.builder()
                    .usuarioValido(false)
                    .primeiroAcesso(contratado.getUsuario().getPrimeiroAcesso())
                    .causa("Senha inválida")
                    .build();
        }

        if (input.getSenhaVelha().equalsIgnoreCase(input.getSenhaNova())
                && contratado.getUsuario().getPrimeiroAcesso()) {
            return UsuarioDTO.builder()
                    .usuarioValido(false)
                    .primeiroAcesso(contratado.getUsuario().getPrimeiroAcesso())
                    .causa("Não use a mesma senha")
                    .build();
        }

        if (!input.getSenhaNova().equalsIgnoreCase(input.getConfirmaNovaSenha())) {
            return UsuarioDTO.builder()
                    .usuarioValido(false)
                    .primeiroAcesso(contratado.getUsuario().getPrimeiroAcesso())
                    .causa("Senhas não são iguais")
                    .build();
        }


        contratado.getUsuario().setSenha(input.getSenhaNova());
        contratado.getUsuario().setPrimeiroAcesso(false);

        repository.save(contratado.getUsuario());

        return UsuarioDTO.builder()
                .usuarioValido(true)
                .primeiroAcesso(contratado.getUsuario().getPrimeiroAcesso())
                .causa("Usuário válido")
                .perfil(contratado.getUsuario().getPerfil().getDescricao())
                .contratadoNome(contratado.getNome())
                .contratadoMatricula(contratado.getMatricula())
                .build();
    }

    @Override
    public UsuarioDTO pegarUsuario(String matricula) {
        Contratado contratado = contratadoRepository.findByMatricula(matricula);

        if (contratado!= null) {
            return UsuarioDTO.builder()
                    .usuarioValido(true)
                    .primeiroAcesso(contratado.getUsuario().getPrimeiroAcesso())
                    .causa("Usuário válido")
                    .perfil(contratado.getUsuario().getPerfil().getDescricao())
                    .build();
        }

        return null;
    }


}
