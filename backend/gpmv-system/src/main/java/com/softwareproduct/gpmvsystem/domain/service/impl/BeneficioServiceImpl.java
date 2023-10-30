package com.softwareproduct.gpmvsystem.domain.service.impl;

import com.softwareproduct.gpmvsystem.api.input.BeneficioInput;
import com.softwareproduct.gpmvsystem.domain.model.Beneficio;
import com.softwareproduct.gpmvsystem.domain.model.Contratado;
import com.softwareproduct.gpmvsystem.domain.repository.BeneficioRepository;
import com.softwareproduct.gpmvsystem.domain.service.BeneficioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BeneficioServiceImpl implements BeneficioService {

    private final BeneficioRepository beneficioRepository;

    @Override
    public List<Beneficio> cadastrarBeneficios(Contratado contratado, List<Beneficio> beneficios) {
         for (Beneficio beneficio : beneficios) {

             beneficio.setContratado(contratado);

             beneficioRepository.save(beneficio);
         }

         return consultarBeneficios(contratado.getMatricula());
    }

    @Override
    public List<Beneficio> consultarBeneficios(String matricula) {
        List<Beneficio> all = beneficioRepository.findAll();

        List<Beneficio> beneficios = new ArrayList<>();

        for (Beneficio b : all) {
            if (b.getContratado().getMatricula().equalsIgnoreCase(matricula)) {
                beneficios.add(b);
            }
        }

        return beneficios;
    }

    @Override
    public List<BeneficioInput> removerNulos(List<BeneficioInput> beneficiosInput) {
        List<BeneficioInput> novosBeneficiosInput = new ArrayList<>();

        for (BeneficioInput beneficioInput : beneficiosInput){
            if (beneficioInput.getBeneficio() != null) {
                novosBeneficiosInput.add(beneficioInput);
            }
        }

        return novosBeneficiosInput;
    }

    @Override
    public void verificarBeneficosJaContratados(List<BeneficioInput> beneficiosInput, String matricula) {

        List<Beneficio> beneficios = consultarBeneficios(matricula);

        List<String> beneficiosNomes = beneficios.stream().map(
                Beneficio::getBeneficio
        ).collect(Collectors.toList());

        for (BeneficioInput beneficioInput: beneficiosInput) {
            if (beneficiosNomes.contains(beneficioInput.getBeneficio())) {
                throw new RuntimeException("Benefício já cadastrado");
            }
        }


    }
}
;