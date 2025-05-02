package com.nexo.mapper;

import com.nexo.dto.usuario.UsuarioRequestDto;
import com.nexo.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario requestDtoToEntity(UsuarioRequestDto dto);

}
