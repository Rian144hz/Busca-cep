# Busca-CEP

Projeto de estudo desenvolvido para explorar a integração de sistemas Java com serviços externos através de APIs REST. Este projeto marca meu primeiro contato com o consumo de dados em tempo real e a manipulação do protocolo HTTP via código.

## Sobre o Projeto
O **Busca-CEP** é uma ferramenta de backend que consulta o serviço público do ViaCEP para retornar dados de endereçamento a partir de um CEP fornecido. O foco principal não foi apenas obter o dado, mas entender como a informação trafega da internet até a aplicação local.

## Desafios de Aprendizado
A maior dificuldade encontrada neste estágio foi compreender o funcionamento do **HttpClient** e as nuances das requisições HTTP dentro do Java. Entender que uma requisição não é apenas enviar uma URL, mas sim um conjunto de etapas, foi o ponto chave:

*   **Build da Request**: Configuração da URI correta e do método (GET).
*   **Envio Síncrono**: Lidar com o tempo de espera até que o servidor externo responda (bloqueio da thread).
*   **Tratamento de Response**: Compreender que o status code (ex: 200) e o corpo da mensagem (JSON) são informações distintas que precisam de validações separadas.

## Tecnologias Utilizadas
*   **Java**: Linguagem principal utilizada no desenvolvimento.
*   **HttpClient API**: Para comunicação nativa com o servidor externo (Java 11+).
*   **Custom Exceptions**: Implementação de tratamento de erros personalizado (`ConexaoApiException` e `CepInvalidoException`) para lidar com falhas de rede e dados inexistentes.
*   **Regex**: Utilizado para a sanitização da entrada do usuário (limpeza de caracteres não numéricos).

## Fluxo de Execução
1. O usuário informa o CEP via terminal.
2. O sistema realiza a limpeza de caracteres especiais.
3. É estabelecida uma conexão HTTP com o endpoint do ViaCEP.
4. O sistema valida se o status da resposta é positivo (200 OK) e se o corpo contém erro de negócio (`"erro": "true"`).
5. O resultado é exibido no console em formato JSON bruto.

## Próximos Passos
- [ ] Implementar a biblioteca **Gson** para converter o JSON em um objeto Java (POJO).
- [ ] Persistir as consultas em um banco de dados para evitar requisições repetidas.
- [ ] Adicionar suporte a logs mais detalhados para monitoramento de falhas.
