package br.com.miniSteam.service;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import br.com.miniSteam.service.Busca;
public class BuscaApi {

    Scanner sc = new Scanner(System.in);

    public void buscarJogo() throws IOException, InterruptedException {


        System.out.println("Digite o nome de um jogo:");
        var busca = sc.nextLine();

        String endereco = "https://www.freetogame.com/api/games";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .header("User-Agent", "Mozilla/5.0")
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        //System.out.println(response.body());

        String json = response.body();

        Gson gson = new Gson();
        DadosJogo[] lista = gson.fromJson(json, DadosJogo[].class);

        for (DadosJogo jogo : lista) {
            if (jogo.title().equalsIgnoreCase(busca)) {
                System.out.println("Nome: " + jogo.title());
                System.out.println("Genero: " + jogo.genre());


                System.out.println("------ Dados Do Jogo -------");
                System.out.println("ID: " + jogo.id());
                System.out.println("Nome: " + jogo.title());
                System.out.println("Genero: " + jogo.genre());
                break;
            }


        }
    }


    // Método para filtrar por nome
    public void filtrarPorNome() throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o gênero que deseja buscar:  (Ex: Shooter, MMORPG, Sports, Fighting");
        String generoBuscado = sc.nextLine();

        // Link para pegar TODOS os jogos
        String endereco = "https://www.freetogame.com/api/games";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        Gson gson = new Gson();
        // Transforma o texto na lista de jogos
        DadosJogo[] lista = gson.fromJson(json, DadosJogo[].class);

        System.out.println("--- Jogos do Gênero " + generoBuscado + " ---");
        for (DadosJogo jogo : lista) {
            if (jogo.genre().equalsIgnoreCase(generoBuscado)) {
                System.out.println("ID: " + jogo.id() + " | Nome: " + jogo.title());
            }
        }
    }
}
