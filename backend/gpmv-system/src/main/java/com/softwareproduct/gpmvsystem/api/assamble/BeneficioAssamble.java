package com.softwareproduct.gpmvsystem.api.assamble;

import com.softwareproduct.gpmvsystem.api.dto.BeneficioDTO;
import com.softwareproduct.gpmvsystem.api.dto.ContratadoDTO;
import com.softwareproduct.gpmvsystem.api.dto.ContratadoResumoDTO;
import com.softwareproduct.gpmvsystem.domain.model.Beneficio;
import com.softwareproduct.gpmvsystem.domain.model.Contratado;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BeneficioAssamble {

    private final ModelMapper modelMapper;

    public BeneficioDTO entityToDTO(Beneficio contratado) {
        return modelMapper.map(contratado, BeneficioDTO.class);
    }

    public List<BeneficioDTO> collectionEntityToList(List<Beneficio> contratados) {
        return contratados.stream().map(
                this::entityToDTO
        ).collect(Collectors.toList());
    }



}
