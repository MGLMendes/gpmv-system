package com.softwareproduct.gpmvsystem.api.controller;

import com.softwareproduct.gpmvsystem.api.assamble.ContratadoAssamble;
import com.softwareproduct.gpmvsystem.api.disassembler.ContratatoInputDisassembler;
import com.softwareproduct.gpmvsystem.api.dto.ContratadoDTO;
import com.softwareproduct.gpmvsystem.api.dto.ContratadoResumoDTO;
import com.softwareproduct.gpmvsystem.api.input.ContratadoAttInput;
import com.softwareproduct.gpmvsystem.api.input.ContratadoInput;
import com.softwareproduct.gpmvsystem.domain.model.Beneficio;
import com.softwareproduct.gpmvsystem.domain.model.Contratado;
import com.softwareproduct.gpmvsystem.domain.service.ContratadoService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 20)
@RestController
@RequestMapping("/contratados")
@RequiredArgsConstructor
public class ContratadoController {

    private final ContratadoService contratadoService;

    private final ContratatoInputDisassembler disassembler;

    private final ContratadoAssamble assamble;

    @PostMapping
    public ResponseEntity<ContratadoDTO> admitirContratado(@RequestBody ContratadoInput contratadoInput) {
        Contratado contratadoToSave = disassembler.inputToEntity(contratadoInput);
        Contratado contratadoSalved = contratadoService.admitir(contratadoToSave);
        ContratadoDTO contratoToReturn = assamble.entityToDTO(contratadoSalved);
        return ResponseEntity.status(HttpStatus.CREATED).body(contratoToReturn);
    }

    @GetMapping
    public ResponseEntity<List<ContratadoDTO>> todosContratados() {
        return ResponseEntity.ok(assamble.collectionEntityToList(contratadoService.todosContratados()));
    }

    @GetMapping("/resumo")
    public ResponseEntity<List<ContratadoResumoDTO>> todosContratadoResumo() {
        return ResponseEntity.ok(assamble.collectionEntityToResumeList(contratadoService.todosContratados()));
    }

    @GetMapping("{matricula}")
    public ResponseEntity<ContratadoDTO> pegarContratadoPorMatricula(@PathVariable String matricula) {
        return  ResponseEntity.ok(assamble.entityToDTO(contratadoService.contratadoPorMatricula(matricula)));
    }

    @PutMapping("{matricula}")
    public ResponseEntity<ContratadoDTO> atualizarContratado(@PathVariable String matricula,
                                                             @RequestBody ContratadoAttInput contratadoAttInput) {

        Contratado contratado = contratadoService.contratadoPorMatricula(matricula);
        disassembler.copyInputToEntity(contratado, contratadoAttInput);

        return ResponseEntity.ok(assamble.entityToDTO(contratadoService.atualizar(contratado)));
    }


}
