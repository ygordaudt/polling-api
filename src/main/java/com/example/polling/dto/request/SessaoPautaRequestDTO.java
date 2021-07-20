package com.example.polling.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;

@Getter
@Setter
public class SessaoPautaRequestDTO {

    private Long idPauta;

    // Duração de uma pauta em minutos
    @Min(1)
    private long duracao = 1;
}
