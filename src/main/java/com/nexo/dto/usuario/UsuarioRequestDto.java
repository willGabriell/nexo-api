package com.nexo.dto.usuario;

import com.nexo.enums.UsuarioRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioRequestDto(@NotBlank(message = "Campo username não pode ser vazio")
                                String username,
                                @Email @NotBlank(message = "Campo email não pode ser vazio")
                                String email,
                                @NotBlank(message = "Campo senha não pode ser vazio")
                                String senha,
                                UsuarioRole role) {
}
