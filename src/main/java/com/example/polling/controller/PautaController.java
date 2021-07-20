package com.example.polling.controller;

import com.example.polling.dto.request.SessaoPautaRequestDTO;
import com.example.polling.dto.request.PautaRequestDTO;
import com.example.polling.dto.request.VotoRequestDTO;
import com.example.polling.dto.response.MessageResponseDTO;
import com.example.polling.dto.response.PautaResponseDTO;
import com.example.polling.exception.AssociadoInvalidoException;
import com.example.polling.exception.PautaNotFoundException;
import com.example.polling.integration.ValidacaoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.polling.service.PautaService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pauta")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PautaController {

    private PautaService pautaService;
    private ValidacaoService validacaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody @Valid PautaRequestDTO pautaRequestDTO) {
        return pautaService.create(pautaRequestDTO);
    }

    @GetMapping
    public List<PautaResponseDTO> list() {
        return pautaService.list();
    }

    @PutMapping("/{id}/sessao/abrir")
    public MessageResponseDTO startSession (
            @RequestBody(required = false) @Valid SessaoPautaRequestDTO sessaoPautaRequestDTO,
            @PathVariable Long id) throws PautaNotFoundException {
        SessaoPautaRequestDTO sessao = sessaoPautaRequestDTO == null ? new SessaoPautaRequestDTO()
                : sessaoPautaRequestDTO;
        sessao.setIdPauta(id);
        return pautaService.startSession(sessao);
    }

    @PostMapping("/votar")
    public MessageResponseDTO vote(@RequestBody @Valid VotoRequestDTO votoRequestDTO) throws Exception {
        Long cpfAssociado = votoRequestDTO.getCpfAssociado();

        if (!validacaoService.isCPFValido(cpfAssociado)) {
            throw new AssociadoInvalidoException(cpfAssociado);
        }

        return pautaService.vote(votoRequestDTO);
    }
}
