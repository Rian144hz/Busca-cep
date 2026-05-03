package br.com.buscacep.main;

import br.com.buscacep.exception.CepInvalidoException;
import br.com.buscacep.exception.ConexaoApiException;
import br.com.buscacep.model.Endereco;
import br.com.buscacep.service.ViaCepService;

import java.util.Scanner;

public class BuscadorDeCep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // instancio o escanner
        ViaCepService service = new ViaCepService(); // instancio o serviço ViaCepService
        System.out.println("---SEJA BEM-VINDO(A) AO BUSCA-CEP!---");
        System.out.print("Digite seu CEP: "); // peço o cep ao usuário
        String cep = sc.nextLine(); // leio o cep

        // aqui eu trato todas as possíveis exceções conforme as classes de exceções que eu criei
        try {
         service.buscarPorCep(cep);
            System.out.println("Busca realizada com sucesso!");
        }
        catch (CepInvalidoException e){
            System.out.println("Erro de validação: "+e.getMessage());
            System.out.println("Cep digitado: "+e.getCepCulpado());
        }
        catch (ConexaoApiException e){
            System.out.println("Erro de conexão ou da própria api: "+e.getMessage());
            System.out.println("Código de erro da api"+e.getErroApi());
            System.out.println("Data e hora que o erro aconteceu: "+e.getHora());
        }
        catch (Exception e){
            System.out.println("Erro inesperado: "+e.getMessage());
        }
        finally {
            sc.close();
        }

    }
}
