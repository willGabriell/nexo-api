package com.nexo.service;

import com.nexo.dto.flashcard.FlashcardRequestDto;
import com.nexo.dto.flashcard.FlashcardResponseDto;
import com.nexo.model.Categoria;
import com.nexo.model.Flashcard;
import com.nexo.model.Usuario;
import com.nexo.repository.FlashcardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FlashcardService {

    private final FlashcardRepository repository;
    private final CategoriaService categoriaService;

    public void criarFlashcard(FlashcardRequestDto dto, Usuario usuario) {
        Categoria categoria = categoriaService.buscarCategoriaPorId(dto.idCategoria());

        if (!categoria.getUsuario().equals(usuario)) {
            throw new IllegalArgumentException("Usuário não autorizado a criar flashcard nesta categoria");
        }

        Flashcard flashcard = new Flashcard(dto, categoria);
        repository.save(flashcard);
    }

    public List<FlashcardResponseDto> listarFlashcardsPorIdCategoria(Long id, Usuario usuario) {
        List<FlashcardResponseDto> flashcards = new ArrayList<>();

        Categoria categoria = categoriaService.buscarCategoriaPorId(id);

        if (!categoria.getUsuario().equals(usuario)) {
            throw new IllegalArgumentException("Usuário não autorizado a acessar flashcards desta categoria");
        }

        flashcards = repository.findAllByCategoriaId(id).stream()
                .map(f -> new FlashcardResponseDto(f.getId(), f.getFrente(), f.getVerso()))
                .toList();

        return flashcards;
    }
}
