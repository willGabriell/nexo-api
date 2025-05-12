package com.nexo.dto.flashcard;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FlashcardRequestDto(
        @NotBlank(message = "Campo frente não pode ser vazio")
        String frente,
        @NotBlank(message = "Campo verso não pode ser vazio")
        String verso,
        @NotNull(message = "Campo idCategoria não pode ser vazio")
        Long idCategoria) {
}
