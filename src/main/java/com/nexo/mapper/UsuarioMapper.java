package com.nexo.mapper;

import com.nexo.dto.usuario.UsuarioRequestDto;
import com.nexo.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario requestDtoToEntity(UsuarioRequestDto dto);

}
