package com.softwareproduct.gpmvsystem.api.controller;

import com.softwareproduct.gpmvsystem.api.assamble.ContratadoAssamble;
import com.softwareproduct.gpmvsystem.api.assamble.FeriasAssamble;
import com.softwareproduct.gpmvsystem.api.disassembler.FeriasInputDisassembler;
import com.softwareproduct.gpmvsystem.api.dto.FeriasDTO;
import com.softwareproduct.gpmvsystem.api.input.FeriasInput;
import com.softwareproduct.gpmvsystem.domain.model.Contratado;
import com.softwareproduct.gpmvsystem.domain.model.Ferias;
import com.softwareproduct.gpmvsystem.domain.service.ContratadoService;
import com.softwareproduct.gpmvsystem.domain.service.FeriasService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ferias")
@RequiredArgsConstructor
public class FeriasController {

    private final FeriasService feriasService;

    private final ContratadoService contratadoService;

    private final FeriasInputDisassembler feriasInputDisassembler;

    private final FeriasAssamble feriasAssamble;

    @PostMapping("/programar/{matricula}")
    public ResponseEntity<FeriasDTO> programarFerias(@PathVariable String matricula,
                                             @RequestBody FeriasInput feriasInput) {

        Contratado contratado = contratadoService.contratadoPorMatricula(matricula);
        Ferias ferias = feriasInputDisassembler.inputToEntity(feriasInput);

        Ferias feriasContratadas = feriasService.programarFerias(contratado, ferias);

        return ResponseEntity.ok(feriasAssamble.entityToDTO(feriasContratadas));
    }


    @GetMapping("/visualizar/{matricula}")
    public ResponseEntity<FeriasDTO> visualizarFerias(@PathVariable String matricula) {
        Contratado contratado = contratadoService.contratadoPorMatricula(matricula);

        Ferias ferias = feriasService.visualizarFerias(contratado);

        return ResponseEntity.ok(feriasAssamble.entityToDTO(ferias));
    }
}
