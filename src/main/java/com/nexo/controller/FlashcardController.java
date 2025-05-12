package com.nexo.controller;

import com.nexo.dto.flashcard.FlashcardRequestDto;
import com.nexo.dto.flashcard.FlashcardResponseDto;
import com.nexo.model.Usuario;
import com.nexo.service.FlashcardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flashcards")
@RequiredArgsConstructor
public class FlashcardController {

    private final FlashcardService service;

    @PostMapping
    public ResponseEntity cadastrarFlashcard(@RequestBody @Valid FlashcardRequestDto dto, @AuthenticationPrincipal Usuario usuario) {
        service.criarFlashcard(dto, usuario);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<FlashcardResponseDto>> listarFlashcardsPorIdCategoria(@PathVariable Long id, @AuthenticationPrincipal Usuario usuario) {
        List<FlashcardResponseDto> flashcards = service.listarFlashcardsPorIdCategoria(id, usuario);
        return ResponseEntity.ok(flashcards);
    }
}
