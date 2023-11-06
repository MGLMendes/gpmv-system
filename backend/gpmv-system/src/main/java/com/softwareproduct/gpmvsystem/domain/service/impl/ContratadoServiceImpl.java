package com.softwareproduct.gpmvsystem.domain.service.impl;

import com.softwareproduct.gpmvsystem.api.input.ContratadoAttInput;
import com.softwareproduct.gpmvsystem.core.exceptions.model.ContratadoException;
import com.softwareproduct.gpmvsystem.domain.model.Beneficio;
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

        Contratado contratado = repository.findByEmail(contratadoInput.getEmail());

        if (contratado != null) {
            throw new IllegalArgumentException("Contratado já admitido");
        }

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
        throw new ContratadoException("Não existe contratado de ID " + matricula);
    }

    @Override
    @Transactional
    public Contratado atualizar(Contratado entity) {
        return repository.save(entity);
    }

    @Override
    public List<Beneficio> consultarBeneficios(String matricula) {
        Contratado contratado = contratadoPorMatricula(matricula);
        List<Beneficio> beneficios = contratado.getBeneficios();
        return beneficios;
    }

}
