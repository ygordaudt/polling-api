package com.example.polling.commons;

/**
 * Variáveis Estáticas - Mensagens do sistema
 */
public abstract class MessagesUtil {

    public static final String MENSAGEM_PAUTA_CRIADA = "Foi criada a Pauta com o ID ";
    public static final String MENSAGEM_PAUTA_ENCERRADA = "Já foi encerrada a votação para a Pauta com o ID ";
    public static final String MENSAGEM_VOTACAO_JA_ABERTA = "Já existe uma votação em aberto para a Pauta com o ID ";
    public static final String MENSAGEM_VOTACAO_NAO_INICIADA = "Ainda não foi aberta a votação para a Pauta com o ID ";
    public static final String MENSAGEM_VOTACAO_INICIADA = "Foi iniciada a sessão de votação da Pauta com o ID ";
    public static final String MENSAGEM_VOTO_REGISTRADO = "Voto registrado com sucesso na Pauta com ID ";
    public static final String MENSAGEM_VOTO_ENCONTRADO = "Foi encontrado pelo menos um voto nesta Pauta pelo associado com o CPF ";
    public static final String MENSAGEM_CPF_INVALIDO = "O seguinte CPF é inválido: ";
}
