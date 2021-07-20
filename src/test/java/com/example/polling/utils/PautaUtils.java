package com.example.polling.utils;

import com.example.polling.dto.request.PautaRequestDTO;
import com.example.polling.dto.request.SessaoPautaRequestDTO;
import com.example.polling.entity.Pauta;

import java.time.LocalDateTime;
import java.util.Collections;

public class PautaUtils {

    private static final String TITULO = "Título Teste";
    private static final String DESCRICAO = "Descrição Teste";
    private static final Long ID = 1L;

    public static PautaRequestDTO createFakeDTO() {
        return PautaRequestDTO.builder()
                .titulo(TITULO)
                .descricao(DESCRICAO)
                .build();
    }

    public static Pauta createFakeEntity() {
        return Pauta.builder()
                .id(ID)
                .titulo(TITULO)
                .descricao(DESCRICAO)
                .dataCadastro(LocalDateTime.now())
                .votos(Collections.singletonList(VotoUtils.createFakeEntity()))
                .build();
    }

    public static SessaoPautaRequestDTO createFakeSessaoPautaDTO() {
        return SessaoPautaRequestDTO.builder()
                .idPauta(ID)
                .duracao(0)
                .build();
    }
}
