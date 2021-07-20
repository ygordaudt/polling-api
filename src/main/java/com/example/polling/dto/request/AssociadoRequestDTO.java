package com.example.polling.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssociadoRequestDTO {

    @NotNull
    private Long cpf;

    @NotEmpty
    private String nome;

}
