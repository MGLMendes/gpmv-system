package com.softwareproduct.gpmvsystem.api.disassembler;

import com.softwareproduct.gpmvsystem.api.input.AfastamentoInput;
import com.softwareproduct.gpmvsystem.api.input.ContratadoAttInput;
import com.softwareproduct.gpmvsystem.domain.model.Afastamento;
import com.softwareproduct.gpmvsystem.domain.model.Contratado;
import com.softwareproduct.gpmvsystem.domain.model.Ferias;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AfastamentoInputDisassembler {

    private final ModelMapper modelMapper;

    public Afastamento inputToEntity(AfastamentoInput feriasInput) {
        return modelMapper.map(feriasInput, Afastamento.class);
    }
}
