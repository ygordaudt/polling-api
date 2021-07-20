package com.example.polling.dto.request;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PautaRequestDTO {

    @NotEmpty
    @Size(min = 2, max = 100)
    private String titulo;

    @Size(min = 2, max = 100)
    private String descricao;

}
