package com.example.polling.dto.response;

import com.example.polling.commons.JpaUtil;
import com.example.polling.entity.Voto;
import lombok.*;

import javax.persistence.Transient;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PautaResponseDTO {

    private Long id;

    private String titulo;

    private String descricao;

    private LocalDateTime dataCadastro;

    private LocalDateTime dataAberturaSessao;

    private LocalDateTime dataEncerramentoSessao;

    private List<VotoResponseDTO> votos;

    /**
     * Atributos utilizados na apuração
     */
    private long votosPositivos;

    private long votosNegativos;

    private long totalVotos;

    private String resultado;

}
