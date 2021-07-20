package com.example.polling.controller;

import com.example.polling.dto.request.AssociadoRequestDTO;
import com.example.polling.dto.request.PautaRequestDTO;
import com.example.polling.dto.response.AssociadoResponseDTO;
import com.example.polling.dto.response.MessageResponseDTO;
import com.example.polling.service.AssociadoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/associado")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AssociadoController {

    private AssociadoService associadoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody @Valid AssociadoRequestDTO associadoRequestDTO) {
        return associadoService.create(associadoRequestDTO);
    }

    @GetMapping
    public List<AssociadoResponseDTO> list() {
        return associadoService.list();
    }

}
