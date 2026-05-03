package br.com.buscacep.interfaces;

import br.com.buscacep.model.Endereco;

public interface ServicoLocalizacao { // interface ServicoLocalizacao

    // método que DEVE ser implementado caso alguma classe assine o contrato com ServicoLocalizacao
    Endereco buscarPorCep(String cep) throws Exception;
}
