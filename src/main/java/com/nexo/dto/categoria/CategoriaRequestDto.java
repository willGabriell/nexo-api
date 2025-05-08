package com.nexo.dto.categoria;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CategoriaRequestDto(@NotBlank(message = "Nome não pode ser vazio") String nome) {
}
