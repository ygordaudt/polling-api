package com.example.polling.service;

import com.example.polling.dto.request.PautaRequestDTO;
import com.example.polling.dto.response.MessageResponseDTO;
import com.example.polling.entity.Pauta;
import com.example.polling.repository.PautaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.polling.utils.PautaUtils.*;
import static org.mockito.Mockito.*;
import static com.example.polling.commons.MessagesUtil.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PautaServiceTest {

    @Mock
    private PautaRepository pautaRepository;

    @InjectMocks
    private PautaService pautaService;

    @Test
    void testGivenPautaDTOThenReturnSavedMessage() {
        PautaRequestDTO pautaRequestDTO = createFakeDTO();
        Pauta expectedSavedPauta = createFakeEntity();

        when(pautaRepository.save(any(Pauta.class))).thenReturn(expectedSavedPauta);

        MessageResponseDTO expectedSuccessMessage = createExpectedMessageCreationResponse(expectedSavedPauta.getId());
        MessageResponseDTO successMessage = pautaService.create(pautaRequestDTO);

        assertEquals(expectedSuccessMessage, successMessage);
    }

    private MessageResponseDTO createExpectedMessageCreationResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message(MENSAGEM_PAUTA_CRIADA + id)
                .build();
    }

}
