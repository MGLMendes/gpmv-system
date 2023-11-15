package com.softwareproduct.gpmvsystem.domain.service.impl;

import com.softwareproduct.gpmvsystem.core.exceptions.model.AfastamentoException;
import com.softwareproduct.gpmvsystem.domain.model.Afastamento;
import com.softwareproduct.gpmvsystem.domain.model.Contratado;
import com.softwareproduct.gpmvsystem.domain.repository.AfastamentoRepository;
import com.softwareproduct.gpmvsystem.domain.service.AfastamentoService;
import com.softwareproduct.gpmvsystem.domain.service.ContratadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AfastamentoServiceImpl implements AfastamentoService {


    private final AfastamentoRepository afastamentoRepository;

    private final ContratadoService contratadoService;

    @Override
    public Afastamento programarAfastamento(String contratadoMatricula, Afastamento afastamento) {
        Contratado contratado = contratadoService.contratadoPorMatricula(contratadoMatricula);

        if (afastamento != null && contratado != null) {
            afastamento.setContratado(contratado);

            afastamento = afastamentoRepository.save(afastamento);
            contratado.setAfastamento(afastamento);

            contratadoService.atualizar(contratado);

            return afastamento;
        }else {
            throw new AfastamentoException(String.format(
                    "%s não foi possível programar seu afastamento", contratado.getNome()
            ));
        }
    }

    @Override
    public Afastamento buscarAfastamentoPorContratadoMatricula(String matricula) {
        Contratado contratado = contratadoService.contratadoPorMatricula(matricula);

        if (contratado != null) {
            Afastamento afastamento = contratado.getAfastamento();

            if (afastamento != null) {
                return afastamento;
            } else {
                throw new AfastamentoException(String.format(
                        "%s, você não programou nenhum afastamento", contratado.getNome()
                ));
            }
        }
        throw new AfastamentoException(String.format(
                "Não foi possível achar contratado"
        ));
    }
}
