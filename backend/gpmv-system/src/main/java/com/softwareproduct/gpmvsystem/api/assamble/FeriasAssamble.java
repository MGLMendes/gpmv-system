package com.softwareproduct.gpmvsystem.api.assamble;

import com.softwareproduct.gpmvsystem.api.dto.FeriasDTO;
import com.softwareproduct.gpmvsystem.domain.model.Ferias;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FeriasAssamble {

    private final ModelMapper modelMapper;

    public FeriasDTO entityToDTO(Ferias ferias) {
        return modelMapper.map(ferias, FeriasDTO.class);
    }

    public FeriasDTO entityToResumo(Ferias contratado) {
        return modelMapper.map(contratado, FeriasDTO.class);
    }

    public List<FeriasDTO> collectionEntityToList(List<Ferias> contratados) {
        return contratados.stream().map(
                this::entityToDTO
        ).collect(Collectors.toList());
    }

    public List<FeriasDTO> collectionEntityToResumeList(List<Ferias> contratados) {
        return contratados.stream().map(
                this::entityToResumo
        ).collect(Collectors.toList());
    }



}
