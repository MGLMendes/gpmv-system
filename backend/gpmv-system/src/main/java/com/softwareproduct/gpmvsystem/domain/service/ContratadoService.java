package com.softwareproduct.gpmvsystem.domain.service;

import com.softwareproduct.gpmvsystem.api.dto.ContratadoDTO;
import com.softwareproduct.gpmvsystem.api.input.ContratadoAttInput;
import com.softwareproduct.gpmvsystem.domain.model.Contratado;

import java.util.List;

public interface ContratadoService {


    Contratado admitir(Contratado contratadoInput);

    List<Contratado> todosContratados();

    Contratado contratadoPorMatricula(String matricula);

    Contratado atualizar(Contratado entity);
}
