package br.com.buscacep.exception;

import java.time.LocalDateTime;

public class CepInvalidoException extends RuntimeException { //classe de exceção CepInvalidoException
   private final String cepCulpado;       // todos os seus atributos
   private final LocalDateTime dataHora;


     // construtor com os seus argumentos
    public CepInvalidoException(String message,String cepCulpado, LocalDateTime dataHora) {
        super(message);
        this.cepCulpado = cepCulpado;
        this.dataHora = dataHora;
    }
    // todos os getters
    public String getCepCulpado() {
        return cepCulpado;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
}
