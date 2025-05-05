package com.nexo.mapper;

import com.nexo.dto.categoria.CategoriaResponseDto;
import com.nexo.model.Categoria;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
    CategoriaResponseDto toDto(Categoria categoria);
    List<CategoriaResponseDto> toDto(List<Categoria> categorias);
}
