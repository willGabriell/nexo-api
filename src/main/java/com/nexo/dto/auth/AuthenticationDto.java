package com.nexo.dto.auth;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationDto(@NotBlank String username,
                                @NotBlank String senha) {
}
