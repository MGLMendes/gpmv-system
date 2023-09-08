package com.softwareproduct.gpmvsystem.domain.service.impl;

import com.softwareproduct.gpmvsystem.domain.model.Contratado;
import com.softwareproduct.gpmvsystem.domain.repository.ContratadoRepository;
import com.softwareproduct.gpmvsystem.domain.service.ContratadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContratadoServiceImpl implements ContratadoService {

    private final ContratadoRepository repository;



    @Transactional
    @Override
    public Contratado admitir(Contratado contratadoInput) {
        return repository.save(contratadoInput);
    }

    @Override
    public List<Contratado> todosContratados() {
        return repository.findAll();
    }

}
