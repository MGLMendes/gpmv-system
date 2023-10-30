package com.softwareproduct.gpmvsystem.domain.service.impl;

import com.softwareproduct.gpmvsystem.domain.model.Beneficio;
import com.softwareproduct.gpmvsystem.domain.model.Contratado;
import com.softwareproduct.gpmvsystem.domain.repository.BeneficioRepository;
import com.softwareproduct.gpmvsystem.domain.service.BeneficioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}
