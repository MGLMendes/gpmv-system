package com.softwareproduct.gpmvsystem.domain.service.impl;

import com.softwareproduct.gpmvsystem.core.exceptions.model.FeriasInvalidasException;
import com.softwareproduct.gpmvsystem.domain.model.Contratado;
import com.softwareproduct.gpmvsystem.domain.model.Ferias;
import com.softwareproduct.gpmvsystem.domain.repository.FeriasRepository;
import com.softwareproduct.gpmvsystem.domain.service.FeriasService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FeriasServiceImpl implements FeriasService {

    private final FeriasRepository feriasRepository;


    @Override
    public Ferias programarFerias(Contratado contratado, Ferias ferias) {

        if (ferias.getInicio() == null || ferias.getFim() == null) {
            throw new FeriasInvalidasException("As datas não podem estar vazias");
        }

        if (ferias.getFim().isBefore(ferias.getInicio())) {
            throw new FeriasInvalidasException("A data de início deve ser antes da data de fim!");
        }

        System.out.println(ferias.getInicio().plusDays(30));

        if (ferias.getFim().isAfter(ferias.getInicio().plusDays(30))) {
            throw new FeriasInvalidasException("O período de férias deve ser de no máximo 30 dias");
        }

        Optional<Ferias> feriasJaContratadas = feriasRepository.findByContratadoMatricula(contratado.getMatricula());

        if (feriasJaContratadas.isPresent()) {
            throw new FeriasInvalidasException(contratado.getNome()+ ", você já programou suas férias");
        }

        ferias.setContratado(contratado);

        return feriasRepository.save(ferias);
    }

    @Override
    public Ferias visualizarFerias(Contratado contratado) {
        Optional<Ferias> feriasJaContratadas = feriasRepository.findByContratadoMatricula(contratado.getMatricula());
        if (feriasJaContratadas.isPresent()) {
            return feriasJaContratadas.get();
        }
        throw new FeriasInvalidasException( contratado.getNome() + " suas férias não foram programadas");
    }
}
