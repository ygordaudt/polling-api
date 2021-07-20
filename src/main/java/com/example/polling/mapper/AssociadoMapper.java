package com.example.polling.mapper;

import com.example.polling.dto.response.AssociadoResponseDTO;
import com.example.polling.entity.Associado;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AssociadoMapper {

    AssociadoMapper INSTANCE = Mappers.getMapper(AssociadoMapper.class);

    List<AssociadoResponseDTO> toDto(List<Associado> associados);

}
