package com.softwareproduct.gpmvsystem.api.assamble;

import com.softwareproduct.gpmvsystem.api.dto.ContratadoDTO;
import com.softwareproduct.gpmvsystem.domain.model.Contratado;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ContratadoAssamble {

    private final ModelMapper modelMapper;

    public ContratadoDTO entityToDTO(Contratado contratado) {
        return modelMapper.map(contratado, ContratadoDTO.class);
    }

    public List<ContratadoDTO> collectionEntityToList(List<Contratado> contratados) {
        return contratados.stream().map(
                this::entityToDTO
        ).collect(Collectors.toList());
    }

}
