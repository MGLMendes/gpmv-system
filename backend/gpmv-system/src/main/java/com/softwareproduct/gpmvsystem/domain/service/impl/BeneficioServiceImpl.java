package com.softwareproduct.gpmvsystem.domain.service.impl;

import com.softwareproduct.gpmvsystem.domain.model.Beneficio;
import com.softwareproduct.gpmvsystem.domain.model.Contratado;
import com.softwareproduct.gpmvsystem.domain.repository.BeneficioRepository;
import com.softwareproduct.gpmvsystem.domain.service.BeneficioService;
import com.softwareproduct.gpmvsystem.domain.service.ContratadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BeneficioServiceImpl implements BeneficioService {

    private final BeneficioRepository beneficioRepository;

    private final ContratadoService contratadoService;

    @Transactional
    @Override
    public List<Beneficio> cadastrarBeneficios(Contratado contratado, List<String> beneficios) {
        List<Beneficio> beneficiosSalvos = new ArrayList<>();

        for (String b : beneficios) {
            Beneficio beneficio = new Beneficio(b);

            beneficiosSalvos.add(beneficio);
        }

        beneficioRepository.saveAll(beneficiosSalvos);

        contratado.setBeneficios(beneficiosSalvos);

        contratadoService.atualizar(contratado);

        return contratado.getBeneficios();
    }
}
