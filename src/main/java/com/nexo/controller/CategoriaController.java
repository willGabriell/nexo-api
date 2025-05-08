package com.nexo.controller;

import com.nexo.dto.categoria.CategoriaRequestDto;
import com.nexo.dto.categoria.CategoriaResponseDto;
import com.nexo.model.Categoria;
import com.nexo.model.Usuario;
import com.nexo.service.CategoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService service;

    @PostMapping
    public ResponseEntity<Void> cadastrarCategoria(@RequestBody @Valid CategoriaRequestDto dto, @AuthenticationPrincipal Usuario user) {
        service.cadastrarCategoria(dto, user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDto>> listarCategorias(@AuthenticationPrincipal Usuario user) {
        return ResponseEntity.ok(service.listarCategoriasDoUsuario(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCategoria(@PathVariable Long id) {
        service.excluirCategoria(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarCategoria(@PathVariable Long id, @RequestBody @Valid CategoriaRequestDto dto) {
        service.atualizarCategoria(id, dto);
        return ResponseEntity.noContent().build();
    }

}
