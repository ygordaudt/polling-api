package com.example.polling.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import static com.example.polling.commons.MessagesUtil.*;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AssociadoInvalidoException extends Exception {

    public AssociadoInvalidoException(Long cpf) {
        super(MENSAGEM_CPF_INVALIDO + cpf);
    }
}
