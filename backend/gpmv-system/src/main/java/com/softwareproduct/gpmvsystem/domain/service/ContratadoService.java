package com.softwareproduct.gpmvsystem.domain.service;

import com.softwareproduct.gpmvsystem.domain.model.Contratado;

import java.util.List;

public interface ContratadoService {


    Contratado admitir(Contratado contratadoInput);

    List<Contratado> todosContratados();
}
