package com.example.polling.dto.request;

import lombok.*;

import javax.validation.constraints.Min;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SessaoPautaRequestDTO {

    private Long idPauta;

    // Duração de uma pauta em minutos
    @Min(1)
    private long duracao = 1;
}
