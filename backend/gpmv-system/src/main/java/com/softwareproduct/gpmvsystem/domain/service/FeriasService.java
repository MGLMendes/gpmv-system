package com.softwareproduct.gpmvsystem.domain.service;

import com.softwareproduct.gpmvsystem.domain.model.Contratado;
import com.softwareproduct.gpmvsystem.domain.model.Ferias;

public interface FeriasService {


    Ferias programarFerias(Contratado contratado, Ferias ferias);

    Ferias visualizarFerias(Contratado contratado);
}
