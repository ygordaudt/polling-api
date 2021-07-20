package com.example.polling.controller;

import com.example.polling.dto.response.AssociadoResponseDTO;
import com.example.polling.service.AssociadoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/associado")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AssociadoController {

    private AssociadoService associadoService;

    @GetMapping
    public List<AssociadoResponseDTO> list() {
        return associadoService.list();
    }

}
