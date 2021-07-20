package com.example.polling.integration;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
    Ferramenta online para validação de CPF
*/
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ValidacaoService {

    public boolean isCPFValido(Long cpf) {
        if (cpf == null) {
            return false;
        }

        String URL_VALIDATE = "https://user-info.herokuapp.com/users/";
        String STATUS_VALIDO = "ABLE_TO_VOTE";

        RestTemplate restTemplate = new RestTemplate();
        Validacao validacao = restTemplate.getForObject(URL_VALIDATE + cpf, Validacao.class);

        return validacao != null && validacao.getStatus().equals(STATUS_VALIDO);
    }
}
