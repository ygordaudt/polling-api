package com.example.polling.utils;

import com.example.polling.dto.request.VotoRequestDTO;

public class VotoUtils {

    private static final Long CPF_ASSOCIADO = 61577282302L;
    private static final Long ID_PAUTA = 1L;

    public static VotoRequestDTO createFakeDTO() {
        return VotoRequestDTO.builder()
                .cpfAssociado(CPF_ASSOCIADO)
                .idPauta(ID_PAUTA)
                .voto(true)
                .build();
    }
}
