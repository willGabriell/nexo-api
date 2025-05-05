package com.nexo.service;

import com.nexo.dto.usuario.UsuarioRequestDto;
import com.nexo.exceptions.UserAlreadyExistsException;
import com.nexo.mapper.UsuarioMapper;
import com.nexo.model.Usuario;
import com.nexo.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioMapper mapper;

    public void cadastrarUsuario(UsuarioRequestDto dto) {
        if(repository.existsByEmail(dto.email())) {
            throw new UserAlreadyExistsException();
        }

        if (repository.existsByUsername(dto.username())) {
            throw new UserAlreadyExistsException("Usuário já existe");
        }
        Usuario usuario = new Usuario();
        usuario.setUsername(dto.username());
        usuario.setEmail(dto.email());
        usuario.setSenha(passwordEncoder.encode(dto.senha()));
        usuario.setRole(dto.role());
        repository.save(usuario);
    }

    public Usuario findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
    }

    public Usuario findByLogin(String login) {
        return repository.findByUsername(login).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }

}