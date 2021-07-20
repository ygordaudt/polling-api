package com.example.polling.dto.response;

import com.example.polling.entity.Associado;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VotoResponseDTO {

    private Long id;

    private LocalDateTime dataRegistro;

    private Associado associado;

    private String voto;

}
