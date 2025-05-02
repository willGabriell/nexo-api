package com.nexo.dto.usuario;

import com.nexo.enums.UsuarioRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioRequestDto(@NotBlank String username,
                                @NotBlank @Email String email,
                                @NotBlank String senha,
                                @NotBlank UsuarioRole role) {
}
