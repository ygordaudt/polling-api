package com.example.polling.utils;

import com.example.polling.dto.request.VotoRequestDTO;
import com.example.polling.entity.Voto;

import java.time.LocalDateTime;

public class VotoUtils {

    private static final Long CPF_ASSOCIADO = 61577282302L;
    private static final Long ID_PAUTA = 1L;
    private static final Long ID = 1L;
    private static final String SIM = "Sim";

    public static VotoRequestDTO createFakeDTO() {
        return VotoRequestDTO.builder()
                .cpfAssociado(CPF_ASSOCIADO)
                .idPauta(ID_PAUTA)
                .voto(true)
                .build();
    }

    public static Voto createFakeEntity() {
        return Voto.builder()
                .id(ID)
                .associado(AssociadoUtils.createFakeEntity())
                .voto(SIM)
                .dataRegistro(LocalDateTime.now())
                .build();
    }
}
