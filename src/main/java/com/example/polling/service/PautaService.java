package com.example.polling.service;

import com.example.polling.dto.request.SessaoPautaRequestDTO;
import com.example.polling.dto.request.PautaRequestDTO;
import com.example.polling.dto.request.VotoRequestDTO;
import com.example.polling.dto.response.MessageResponseDTO;
import com.example.polling.dto.response.PautaResponseDTO;
import com.example.polling.entity.Associado;
import com.example.polling.entity.Pauta;
import com.example.polling.entity.Voto;
import com.example.polling.exception.PautaNotFoundException;
import com.example.polling.mapper.PautaMapper;
import com.example.polling.repository.PautaRepository;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import static com.example.polling.commons.MessagesUtil.*;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PautaService {

    private PautaRepository pautaRepository;

    private final PautaMapper pautaMapper = PautaMapper.INSTANCE;

    /**
     * Métodos Públicos
     */
    public List<PautaResponseDTO> list() {
        List<Pauta> pautas = Lists.newArrayList(pautaRepository.findAll());
        return pautaMapper.toResumoDto(pautas);
    }

    public MessageResponseDTO create(PautaRequestDTO pautaRequestDTO) {
        Pauta pauta = pautaMapper.toEntity(pautaRequestDTO);
        pauta.setDataCadastro(LocalDateTime.now());
        Pauta pautaSaved = pautaRepository.save(pauta);

        return createMessagePautaResponse(pautaSaved.getId(), MENSAGEM_PAUTA_CRIADA);
    }

    public MessageResponseDTO startSession(SessaoPautaRequestDTO sessaoPautaRequestDTO) throws PautaNotFoundException {
        Long idPauta = sessaoPautaRequestDTO.getIdPauta();
        Pauta pauta = findById(idPauta);

        if (isVotacaoEncerrada(pauta)) {
            return createMessagePautaResponse(idPauta, MENSAGEM_PAUTA_ENCERRADA);
        }

        if (pauta.getDataAberturaSessao() != null) {
            return createMessagePautaResponse(idPauta, MENSAGEM_VOTACAO_JA_ABERTA);
        }

        LocalDateTime dataAberturaSessao = LocalDateTime.now();
        pauta.setDataAberturaSessao(dataAberturaSessao);

        long minutosDuracao = sessaoPautaRequestDTO.getDuracao();
        LocalDateTime dataEncerramentoSessao = dataAberturaSessao.plus(Duration.ofMinutes(minutosDuracao));
        pauta.setDataEncerramentoSessao(dataEncerramentoSessao);

        Pauta pautaSaved = pautaRepository.save(pauta);

        return createMessagePautaResponse(pautaSaved.getId(), MENSAGEM_VOTACAO_INICIADA);
    }

    public MessageResponseDTO vote(VotoRequestDTO votoRequestDTO) throws PautaNotFoundException {
        // Valida Pauta
        Long idPauta = votoRequestDTO.getIdPauta();
        Pauta pauta = findById(idPauta);

        if (isVotacaoEncerrada(pauta)) {
            return createMessagePautaResponse(idPauta, MENSAGEM_PAUTA_ENCERRADA);
        }

        if (pauta.getDataAberturaSessao() == null) {
            return createMessagePautaResponse(idPauta, MENSAGEM_VOTACAO_NAO_INICIADA);
        }

        // Valida Associado
        Associado associado = new Associado();
        associado.setCpf(votoRequestDTO.getCpfAssociado());

        if (getQuantidadeVotosAssociadoPorPauta(pauta, associado.getCpf()) >= 1) {
            return createMessagePautaResponse(associado.getCpf(), MENSAGEM_VOTO_ENCONTRADO);
        }

        Voto voto = new Voto();
        voto.setAssociado(associado);
        voto.setVotoSimNao(votoRequestDTO.getVoto());
        voto.setDataRegistro(LocalDateTime.now());

        pauta.getVotos().add(voto);
        Pauta pautaSaved = pautaRepository.save(pauta);

        return createMessagePautaResponse(pautaSaved.getId(), MENSAGEM_VOTO_REGISTRADO);
    }

    /**
     *  Métodos Privados
     */
    private Pauta verifyIfExists(Long id) throws PautaNotFoundException {
        return pautaRepository.findById(id)
                .orElseThrow(() -> new PautaNotFoundException(id));
    }

    private Pauta findById(Long id) throws PautaNotFoundException {
        return verifyIfExists(id);
    }

    private boolean isVotacaoEncerrada(Pauta pauta) {
        return pauta.getDataEncerramentoSessao() != null && pauta.getDataEncerramentoSessao().isBefore(LocalDateTime.now());
    }

    private long getQuantidadeVotosAssociadoPorPauta(Pauta pauta, Long cpfAssociado) {
        return pauta.getVotos()
                .stream()
                .filter(v -> v.getAssociado().getCpf().equals(cpfAssociado))
                .count();
    }

    public MessageResponseDTO createMessagePautaResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }

}
