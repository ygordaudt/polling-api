package com.example.polling.utils;

import com.example.polling.dto.request.AssociadoRequestDTO;
import com.example.polling.entity.Associado;

public class AssociadoUtils {

    private static final Long CPF = 92331218013L;
    private static final String NOME = "Fulano de Tal";

    public static AssociadoRequestDTO createFakeDTO() {
        return AssociadoRequestDTO.builder()
                .cpf(CPF)
                .nome(NOME)
                .build();
    }

    public static Associado createFakeEntity() {
        return Associado.builder()
                .cpf(CPF)
                .nome(NOME)
                .build();
    }
}
