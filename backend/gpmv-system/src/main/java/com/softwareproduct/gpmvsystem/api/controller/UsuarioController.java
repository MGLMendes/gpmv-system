package com.softwareproduct.gpmvsystem.api.controller;

import com.softwareproduct.gpmvsystem.api.dto.UsuarioDTO;
import com.softwareproduct.gpmvsystem.api.input.UsuarioInput;
import com.softwareproduct.gpmvsystem.domain.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
@CrossOrigin(maxAge = 20)
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<UsuarioDTO> login(@RequestBody UsuarioInput usuarioInput) {

        UsuarioDTO usuarioDTO = usuarioService.login(usuarioInput);

        if (usuarioDTO.getUsuarioValido()) {
            return ResponseEntity.ok(usuarioDTO);
        } else {
            return ResponseEntity.badRequest().body(usuarioDTO);

        }

    }
}
