package com.nexo.repository;

import com.nexo.model.Categoria;
import com.nexo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    List<Categoria> findAllByUsuario(Usuario usuario);
}
