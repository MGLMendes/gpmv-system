package com.softwareproduct.gpmvsystem.domain.service;

import com.softwareproduct.gpmvsystem.api.input.BeneficioInput;
import com.softwareproduct.gpmvsystem.domain.model.Beneficio;
import com.softwareproduct.gpmvsystem.domain.model.Contratado;

import java.util.List;

public interface BeneficioService {
    List<Beneficio> cadastrarBeneficios(Contratado contratado, List<Beneficio> beneficios);

    List<Beneficio> consultarBeneficios(String matricula);

    List<BeneficioInput> removerNulos(List<BeneficioInput> beneficiosInput);

    void verificarBeneficosJaContratados(List<BeneficioInput>  beneficios, String matricula);
}
