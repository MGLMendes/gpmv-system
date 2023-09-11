package com.softwareproduct.gpmvsystem.api.disassembler;

import com.softwareproduct.gpmvsystem.api.input.ContratadoAttInput;
import com.softwareproduct.gpmvsystem.api.input.ContratadoInput;
import com.softwareproduct.gpmvsystem.domain.model.Contratado;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ContratatoInputDisassembler {

    private final ModelMapper modelMapper;

    public Contratado inputToEntity(ContratadoInput contratadoInput) {
        return modelMapper.map(contratadoInput, Contratado.class);
    }

    public void copyInputToEntity(Contratado contratado, ContratadoAttInput contratadoAttInput) {
        modelMapper.map(contratadoAttInput, contratado);
    }
}
