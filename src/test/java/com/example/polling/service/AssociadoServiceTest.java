package com.example.polling.service;

import com.example.polling.dto.request.AssociadoRequestDTO;
import com.example.polling.dto.response.MessageResponseDTO;
import com.example.polling.entity.Associado;
import com.example.polling.repository.AssociadoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.polling.commons.MessagesUtil.MENSAGEM_ASSOCIADO_CRIADO;
import static com.example.polling.utils.AssociadoUtils.createFakeDTO;
import static com.example.polling.utils.AssociadoUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AssociadoServiceTest {

    @Mock
    private AssociadoRepository associadoRepository;

    @InjectMocks
    private AssociadoService associadoService;

    @Test
    void testGivenAssociadoDTOThenReturnSavedMessage() {
        AssociadoRequestDTO associadoRequestDTO = createFakeDTO();
        Associado expectedAssociadoSaved = createFakeEntity();

        when(associadoRepository.save(any(Associado.class))).thenReturn(expectedAssociadoSaved);

        MessageResponseDTO expectedSuccessMessage = createExpectedMessageCreationResponse(expectedAssociadoSaved.getCpf());
        MessageResponseDTO successMessage = associadoService.create(associadoRequestDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedMessageCreationResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message(MENSAGEM_ASSOCIADO_CRIADO + id)
                .build();
    }

}
