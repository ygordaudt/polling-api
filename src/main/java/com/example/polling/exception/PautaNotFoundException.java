package com.example.polling.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PautaNotFoundException extends Exception {

    public PautaNotFoundException(Long id) {
        super("Pauta não encontrada com o ID " + id);
    }
}
