package com.softwareproduct.gpmvsystem.api.controller;

import com.softwareproduct.gpmvsystem.api.assamble.ContratadoAssamble;
import com.softwareproduct.gpmvsystem.api.disassembler.ContratatoInputDisassembler;
import com.softwareproduct.gpmvsystem.api.input.ContratadoInput;
import com.softwareproduct.gpmvsystem.api.dto.ContratadoDTO;
import com.softwareproduct.gpmvsystem.domain.model.Cargos;
import com.softwareproduct.gpmvsystem.domain.model.Contratado;
import com.softwareproduct.gpmvsystem.domain.service.ContratadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contratados")
@RequiredArgsConstructor
public class ContratadoController {

    private final ContratadoService contratadoService;

    private final ContratatoInputDisassembler disassembler;

    private final ContratadoAssamble assamble;

    @PostMapping
    public ResponseEntity<ContratadoDTO> admitirContratado(@Valid @RequestBody ContratadoInput contratadoInput) {
        Contratado contratadoToSave = disassembler.inputToEntity(contratadoInput);
        Contratado contratadoSalved = contratadoService.admitir(contratadoToSave);
        ContratadoDTO contratoToReturn = assamble.entityToDTO(contratadoSalved);
        return ResponseEntity.status(HttpStatus.CREATED).body(contratoToReturn);
    }

    @GetMapping
    public ResponseEntity<List<ContratadoDTO>> todosContratados() {
        return ResponseEntity.ok(assamble.collectionEntityToList(contratadoService.todosContratados()));
    }

}
