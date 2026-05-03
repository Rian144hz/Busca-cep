package br.com.buscacep.model;

import br.com.buscacep.interfaces.ServicoLocalizacao;

public class Endereco {   // classe Endereco
    private String cep;
    private String logradouro;         // com todos os seus atributos
    private String bairro;
    private String localidade;
    private String uf;
    // construtor padrão
    public Endereco() {
    }
    // construtor com os argumentos
    public Endereco(String cep, String logradouro, String bairro, String localidade, String uf) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
    }
    // aqui todos os seus getters
    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }
}
