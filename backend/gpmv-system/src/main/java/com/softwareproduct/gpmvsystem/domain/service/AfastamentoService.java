package com.softwareproduct.gpmvsystem.domain.service;

import com.softwareproduct.gpmvsystem.domain.model.Afastamento;
import com.softwareproduct.gpmvsystem.domain.model.Contratado;
import com.softwareproduct.gpmvsystem.domain.model.Ferias;

public interface AfastamentoService {

    Afastamento programarAfastamento(String contratadoMatricula, Afastamento Afastamento);

}
