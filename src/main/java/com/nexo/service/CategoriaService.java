package com.nexo.service;

import com.nexo.dto.categoria.CategoriaRequestDto;
import com.nexo.dto.categoria.CategoriaResponseDto;
import com.nexo.mapper.CategoriaMapper;
import com.nexo.model.Categoria;
import com.nexo.repository.CategoriaRepository;
import com.nexo.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository repository;
    private final UsuarioService usuarioService;
    private final UsuarioRepository usuarioRepository;
    private final CategoriaMapper categoriaMapper;

    public void cadastrarCategoria(CategoriaRequestDto dto) {
        Categoria categoria = new Categoria(dto.nome(), usuarioService.findById(dto.usuarioId()));
        repository.save(categoria);
    }

    public List<CategoriaResponseDto> listarCategoriasDoUsuario(Long usuarioId) {

        if (!usuarioRepository.existsById(usuarioId)) {
            throw new IllegalArgumentException("Usuário não encontrado");
        }

        List<Categoria> lista = repository.findAllByUsuario(usuarioService.findById(usuarioId));
        return categoriaMapper.toDto(lista);
    }

    public void excluirCategoria(Long id) {
        Categoria categoria = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada"));
        repository.delete(categoria);
    }

    public void atualizarCategoria(Long id, CategoriaRequestDto dto) {
        Categoria categoria = repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada"));
        categoria.setNome(dto.nome());
        repository.save(categoria);
    }

}
