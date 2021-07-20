package com.example.polling.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VotoRequestDTO {

    @NotNull
    private Long idPauta;

    @NotNull
    private Long cpfAssociado;

    @NotNull
    private Boolean voto;

}
