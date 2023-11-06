package com.softwareproduct.gpmvsystem.api.disassembler;

import com.softwareproduct.gpmvsystem.api.input.ContratadoAttInput;
import com.softwareproduct.gpmvsystem.api.input.ContratadoInput;
import com.softwareproduct.gpmvsystem.api.input.FeriasInput;
import com.softwareproduct.gpmvsystem.domain.model.Contratado;
import com.softwareproduct.gpmvsystem.domain.model.Ferias;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FeriasInputDisassembler {

    private final ModelMapper modelMapper;

    public Ferias inputToEntity(FeriasInput feriasInput) {
        return modelMapper.map(feriasInput, Ferias.class);
    }

    public void copyInputToEntity(Contratado contratado, ContratadoAttInput contratadoAttInput) {
        modelMapper.map(contratadoAttInput, contratado);
    }
}
