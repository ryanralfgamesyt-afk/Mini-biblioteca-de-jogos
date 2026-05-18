package br.com.miniSteam.service;
import br.com.miniSteam.service.BuscaApi;

import java.util.Scanner;

public class Busca {

    Scanner sc = new Scanner(System.in);


    public void Duvida(){

        System.out.println("Digite o nome de um jogo:");
        var busca = sc.nextLine();

        String endereco = "https://www.freetogame.com/" + busca;

    }

}
