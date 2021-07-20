package com.example.polling.service;

import com.example.polling.dto.request.AssociadoRequestDTO;
import com.example.polling.dto.response.AssociadoResponseDTO;
import com.example.polling.dto.response.MessageResponseDTO;
import com.example.polling.entity.Associado;
import com.example.polling.mapper.AssociadoMapper;
import com.example.polling.repository.AssociadoRepository;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.polling.commons.MessagesUtil.*;

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

    public MessageResponseDTO create(AssociadoRequestDTO associadoRequestDTO) {
        if (exists(associadoRequestDTO.getCpf())) {
            return createMessageAssociadoResponse(associadoRequestDTO.getCpf(), MENSAGEM_ASSOCIADO_JA_EXISTE);
        }

        associadoRepository.findById(associadoRequestDTO.getCpf());
        Associado associadoSaved = associadoRepository.save(associadoMapper.toEntity(associadoRequestDTO));
        return createMessageAssociadoResponse(associadoSaved.getCpf(), MENSAGEM_ASSOCIADO_CRIADO);
    }

    public boolean exists(Long cpf) {
        if (cpf == null) {
            return true;
        }

        return associadoRepository.existsById(cpf);
    }

    public MessageResponseDTO createMessageAssociadoResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }
}
