package com.softwareproduct.gpmvsystem.api.controller;

import com.softwareproduct.gpmvsystem.api.assamble.BeneficioAssamble;
import com.softwareproduct.gpmvsystem.api.disassembler.BeneficioInputDisassembler;
import com.softwareproduct.gpmvsystem.api.dto.BeneficioDTO;
import com.softwareproduct.gpmvsystem.api.input.BeneficioInput;
import com.softwareproduct.gpmvsystem.domain.model.Beneficio;
import com.softwareproduct.gpmvsystem.domain.model.Contratado;
import com.softwareproduct.gpmvsystem.domain.service.BeneficioService;
import com.softwareproduct.gpmvsystem.domain.service.ContratadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/beneficios")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 20)
public class BeneficioController {

    private final BeneficioService beneficioService;

    private final ContratadoService contratadoService;

    private final BeneficioAssamble beneficioAssamble;

    private final BeneficioInputDisassembler beneficioInputDisassembler;

    @PostMapping("/{matricula}/contratar")
    public ResponseEntity<List<BeneficioDTO>> cadastrarBeneficio(@PathVariable String matricula,
                                                                 @RequestBody List<BeneficioInput> beneficiosInput) {
        Contratado contratado = contratadoService.contratadoPorMatricula(matricula);
        List<Beneficio> beneficios = beneficioInputDisassembler.copyCollectionInputToCollectionEntity(beneficiosInput);

        return ResponseEntity.ok(beneficioAssamble.collectionEntityToList(
                beneficioService.cadastrarBeneficios(contratado, beneficios)));
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<List<BeneficioDTO>> consultarBeneficiosDoContratado(@PathVariable String matricula) {
        Contratado contratado = contratadoService.contratadoPorMatricula(matricula);
        return ResponseEntity.ok(beneficioAssamble.collectionEntityToList(
                beneficioService.consultarBeneficios(contratado.getMatricula())));
    }
}
