package com.softwareproduct.gpmvsystem.api.disassembler;

import com.softwareproduct.gpmvsystem.api.input.BeneficioInput;
import com.softwareproduct.gpmvsystem.api.input.ContratadoAttInput;
import com.softwareproduct.gpmvsystem.api.input.ContratadoInput;
import com.softwareproduct.gpmvsystem.domain.model.Beneficio;
import com.softwareproduct.gpmvsystem.domain.model.Contratado;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BeneficioInputDisassembler {

    private final ModelMapper modelMapper;

    public Beneficio inputToEntity(BeneficioInput beneficioInput) {
        return modelMapper.map(beneficioInput, Beneficio.class);
    }

    public List<Beneficio> copyCollectionInputToCollectionEntity(List<BeneficioInput> beneficioInputs) {
        return beneficioInputs.stream().map(
                this::inputToEntity
        ).collect(Collectors.toList());
    }

    public void copyInputToEntity(Beneficio contratado, BeneficioInput beneficioInput) {
        modelMapper.map(beneficioInput, contratado);
    }


}
