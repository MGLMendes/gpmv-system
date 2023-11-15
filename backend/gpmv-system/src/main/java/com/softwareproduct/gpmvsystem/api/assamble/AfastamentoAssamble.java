package com.softwareproduct.gpmvsystem.api.assamble;

import com.softwareproduct.gpmvsystem.api.dto.AfastamentoDTO;
import com.softwareproduct.gpmvsystem.api.dto.BeneficioDTO;
import com.softwareproduct.gpmvsystem.domain.model.Afastamento;
import com.softwareproduct.gpmvsystem.domain.model.Beneficio;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AfastamentoAssamble {

    private final ModelMapper modelMapper;

    public AfastamentoDTO entityToDTO(Afastamento contratado) {
        return modelMapper.map(contratado, AfastamentoDTO.class);
    }

}
