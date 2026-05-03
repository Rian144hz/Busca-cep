package br.com.buscacep.exception;

import java.time.LocalDateTime;

public class ConexaoApiException extends RuntimeException { //classe de exceção CepInvalidoException
    private final String erroApi;  // todos os seus atributos
    private final LocalDateTime hora;

    // construtor com os seus argumentos
    public ConexaoApiException(String message, String erroApi, LocalDateTime hora) {
        super(message);
        this.erroApi = erroApi;
        this.hora = hora;
    }

    // todos os getters
    public String getErroApi() {
        return erroApi;
    }

    public LocalDateTime getHora() {
        return hora;
    }
}
