package com.softwareproduct.gpmvsystem.domain.service.impl;

import com.softwareproduct.gpmvsystem.api.input.ContratadoAttInput;
import com.softwareproduct.gpmvsystem.domain.model.Contratado;
import com.softwareproduct.gpmvsystem.domain.model.Usuario;
import com.softwareproduct.gpmvsystem.domain.repository.ContratadoRepository;
import com.softwareproduct.gpmvsystem.domain.service.ContratadoService;
import com.softwareproduct.gpmvsystem.domain.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ContratadoServiceImpl implements ContratadoService {

    private final ContratadoRepository repository;

    private final UsuarioService usuarioService;


    @Transactional
    @Override
    public Contratado admitir(Contratado contratadoInput) {
        var numero = new Random().nextInt(999999 - 100000 + 1) + 100000;
        contratadoInput.setMatricula("T"+numero);
        Usuario usuario = usuarioService.criarUsuario(contratadoInput);
        contratadoInput.setUsuario(usuario);
        return repository.save(contratadoInput);
    }

    @Override
    public List<Contratado> todosContratados() {
        return repository.findAll();
    }

    @Override
    public Contratado contratadoPorMatricula(String matricula) {
        Contratado contratado = repository.findByMatricula(matricula);
        if(contratado != null ) {
            return contratado;
        }
        throw new IllegalArgumentException("Não existe contratado de ID " + matricula);
    }

    @Override
    @Transactional
    public Contratado atualizar(Contratado entity) {
        return repository.save(entity);
    }

}
