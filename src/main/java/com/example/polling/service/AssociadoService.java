package com.example.polling.service;

import com.example.polling.dto.response.AssociadoResponseDTO;
import com.example.polling.entity.Associado;
import com.example.polling.mapper.AssociadoMapper;
import com.example.polling.repository.AssociadoRepository;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AssociadoService {

    private AssociadoRepository associadoRepository;
    private final AssociadoMapper associadoMapper = AssociadoMapper.INSTANCE;

    /**
     * Métodos Públicos
     */
    public List<AssociadoResponseDTO> list() {
        List<Associado> associados = Lists.newArrayList(associadoRepository.findAll());
        return associadoMapper.toDto(associados);
    }
}
