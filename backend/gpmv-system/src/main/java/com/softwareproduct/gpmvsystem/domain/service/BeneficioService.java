package com.softwareproduct.gpmvsystem.domain.service;

import com.softwareproduct.gpmvsystem.domain.model.Beneficio;
import com.softwareproduct.gpmvsystem.domain.model.Contratado;

import java.util.List;

public interface BeneficioService {
    List<Beneficio> cadastrarBeneficios(Contratado contratado, List<Beneficio> beneficios);

    List<Beneficio> consultarBeneficios(String matricula);
}
