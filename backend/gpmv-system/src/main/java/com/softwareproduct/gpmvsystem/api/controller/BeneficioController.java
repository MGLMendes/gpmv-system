package com.softwareproduct.gpmvsystem.api.controller;

import com.softwareproduct.gpmvsystem.domain.model.Contratado;
import com.softwareproduct.gpmvsystem.domain.service.BeneficioService;
import com.softwareproduct.gpmvsystem.domain.service.ContratadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/beneficios")
@RequiredArgsConstructor
public class BeneficioController {

    private final BeneficioService beneficioService;

    private final ContratadoService contratadoService;

    @PostMapping("/{matricula}/contratar")
    public ResponseEntity<?> cadastrarBeneficio(@PathVariable String matricula, @RequestBody List<String> beneficios) {
        Contratado contratado = contratadoService.contratadoPorMatricula(matricula);

        return ResponseEntity.ok(beneficioService.cadastrarBeneficios(contratado, beneficios));
    }
}
