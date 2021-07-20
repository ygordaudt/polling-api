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

    private ResponseService responseService;

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
            return responseService.createMessageResponse(associadoRequestDTO.getCpf(), MENSAGEM_ASSOCIADO_JA_EXISTE);
        }

        associadoRepository.findById(associadoRequestDTO.getCpf());
        Associado associadoSaved = associadoRepository.save(associadoMapper.toEntity(associadoRequestDTO));
        return responseService.createMessageResponse(associadoSaved.getCpf(), MENSAGEM_ASSOCIADO_CRIADO);
    }

    public boolean exists(Long cpf) {
        Associado associado = new Associado();
        associado = associadoRepository.getById(cpf);
        return associado.getCpf() != null;
    }
}
