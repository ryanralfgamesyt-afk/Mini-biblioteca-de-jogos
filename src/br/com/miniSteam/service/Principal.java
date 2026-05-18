package br.com.miniSteam.service;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        BuscaApi buscaApi = new BuscaApi();

        Scanner sc = new Scanner(System.in);

        int opcao = 0;
        while (opcao != 3) {
            System.out.println("---------------Mini-Steam--------------");
            System.out.println("Menu:");
            System.out.println("1 - Pesquisar jogo");
            System.out.println("2 - Escolher por genero");
            System.out.println("3 - Sair");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    buscaApi.buscarJogo();
                    break;
                case 2:
                    buscaApi.filtrarPorNome();
                    break;
                case 3:
                    System.out.println("Fechando Mini STEAM");
                    break;
                default:
                    System.out.println("Opção invalida escolha ou 1,2,3");
                    break;
            }

        }
    }
}
