package com.softwareproduct.gpmvsystem.api.controller;

import com.softwareproduct.gpmvsystem.api.assamble.AfastamentoAssamble;
import com.softwareproduct.gpmvsystem.api.disassembler.AfastamentoInputDisassembler;
import com.softwareproduct.gpmvsystem.api.dto.AfastamentoDTO;
import com.softwareproduct.gpmvsystem.api.helper.ResourceUriHelper;
import com.softwareproduct.gpmvsystem.api.input.AfastamentoInput;
import com.softwareproduct.gpmvsystem.domain.model.Afastamento;
import com.softwareproduct.gpmvsystem.domain.model.Contratado;
import com.softwareproduct.gpmvsystem.domain.service.AfastamentoService;
import com.softwareproduct.gpmvsystem.domain.service.ContratadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/afastamento")
@RequiredArgsConstructor
public class AfastamentoController {

    private final AfastamentoService afastamentoService;

    private final AfastamentoAssamble afastamentoAssamble;

    private final AfastamentoInputDisassembler afastamentoInputDisassembler;


    @PostMapping("/{matricula}")
    public ResponseEntity<AfastamentoDTO> programarAfastamento(@PathVariable String matricula,
                                                  @RequestBody AfastamentoInput afastamentoInput) {
        Afastamento afastamento = afastamentoInputDisassembler.inputToEntity(afastamentoInput);
        Afastamento afastamentoResponse = afastamentoService.programarAfastamento(matricula, afastamento);

        ResourceUriHelper.addUriInResponseHeader(afastamentoResponse.getId());

        return ResponseEntity.status(HttpStatus.CREATED).body(afastamentoAssamble.entityToDTO(afastamentoResponse));
    }


}
