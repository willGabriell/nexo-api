package com.nexo.controller;

import com.nexo.dto.auth.AuthenticationDto;
import com.nexo.dto.usuario.UsuarioRequestDto;
import com.nexo.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authManager;
    private final UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationDto dto) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dto.username(), dto.senha());
        var authentication = authManager.authenticate(authenticationToken);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UsuarioRequestDto dto) {
        usuarioService.cadastrarUsuario(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
