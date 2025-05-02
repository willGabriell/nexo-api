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

        Usuario usuario = mapper.requestDtoToEntity(dto);
        usuario.setSenha(passwordEncoder.encode(dto.senha()));
        repository.save(usuario);
    }

    public Usuario findByLogin(String login) {
        return repository.findByEmail(login).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }

}