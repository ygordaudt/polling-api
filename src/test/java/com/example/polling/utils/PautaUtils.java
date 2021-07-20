package com.example.polling.utils;

import com.example.polling.dto.request.PautaRequestDTO;

public class PautaUtils {

    private static final String TITULO = "Título Teste";
    private static final String DESCRICAO = "Descrição Teste";

    public static PautaRequestDTO createFakeDTO() {
        return PautaRequestDTO.builder()
                .titulo(TITULO)
                .descricao(DESCRICAO)
                .build();
    }
}
