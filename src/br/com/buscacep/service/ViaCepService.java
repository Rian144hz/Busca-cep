// Importações: trazendo as ferramentas de rede e a suas exceções personalizadas
package br.com.buscacep.service;
import br.com.buscacep.exception.CepInvalidoException;
import br.com.buscacep.exception.ConexaoApiException;
import br.com.buscacep.interfaces.ServicoLocalizacao;
import br.com.buscacep.model.Endereco;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
 // classe ViaCepService que implementa o método buscarPorCep da interface ServicoLocalizacao
public class ViaCepService implements ServicoLocalizacao {
    // notação @override para dizer que o método esta sendo sobre escrito
    @Override
    public Endereco buscarPorCep(String cep) throws CepInvalidoException,Exception {
        //tirando o que não é número para não dar erro na URL ex: '-'
        String cepLimpo = cep.replaceAll("\\D", "");
        //montando o Endereço (URL): Onde o "entregador" vai buscar a informação
        String url = "https://viacep.com.br/ws/" + cepLimpo + "/json/";

        //criando o cliente: é como abrir o App de entrega no celular
        HttpClient client = HttpClient.newHttpClient();
        // criando a requisição: é basicamente preenchendo um formulário
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        // aqui faço uma condição que um cep deve ter no mínimo 8 dígitos, caso contrario o formato de CEP é inválido
        if (cepLimpo.length() !=8){
            throw new CepInvalidoException("Formato de CEP inválido", cep, LocalDateTime.now());
        }

        try{
            // aqui o próprio java espera o servidor responder
            HttpResponse<String> response = client.send(request,HttpResponse.BodyHandlers.ofString());
            // o servidor atendeu? (Status 200 = OK), caso contrario servidor ViaCEP retornou erro
            if (response.statusCode()!=200){
                throw new ConexaoApiException(
                        "Servidor ViaCEP retornou erro",
                        String.valueOf(response.statusCode()),
                        LocalDateTime.now());
            }
            // variável que vai receber o response.body() para tratar o erro invisível do JSON
            String respostaCorpo = response.body();

            //caso se no JSON aconteça isso "\"erro\": \"true\"", vou transformá-lo numa mensagem personalizada cep informado não encontrado
            if (respostaCorpo.contains("\"erro\": \"true\"") ||respostaCorpo.contains("\"erro\": true")){
                throw new CepInvalidoException("Cep informado não encontrado",cep,LocalDateTime.now());
            }
            // aqui eu printo o JSON com o response.body()
            System.out.println("JSON recebido: " + response.body());
            return null;
        }
        // aqui eu trato algum erro inesperado.
        catch (IOException | InterruptedException e){
            throw new Exception("Falha de conexão com a internet ou servidor indisponível.", e);
        }

    }
}
