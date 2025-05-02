package com.nexo.config;

import com.nexo.model.Usuario;
import com.nexo.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UsuarioService service;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = service.findByLogin(username);
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + usuario.getRole());
        return new User(usuario.getUsername(), usuario.getSenha(), Collections.singletonList(authority));
    }
}
