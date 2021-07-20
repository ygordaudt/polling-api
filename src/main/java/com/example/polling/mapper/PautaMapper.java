package com.example.polling.mapper;

import com.example.polling.dto.request.PautaRequestDTO;
import com.example.polling.dto.response.PautaResponseDTO;
import com.example.polling.entity.Pauta;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PautaMapper {

    PautaMapper INSTANCE = Mappers.getMapper(PautaMapper.class);

    Pauta toEntity(PautaRequestDTO pautaRequestDTO);

    List<PautaResponseDTO> toResumoDto(List<Pauta> pauta);

}
