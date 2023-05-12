package br.alura.screenmatch.principal;

import br.alura.screenmatch.modelos.Titulo;
import br.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MainBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um nome de filme");
        var filme = scanner.nextLine();

        //Gson gson = new Gson();
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();

        String url = "http://www.omdbapi.com/?t=" + filme + "&apikey=bfea45bb";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        // Titulo meuTitulo = gson.fromJson(response.body(), Titulo.class);
        TituloOmdb meuTitulo = gson.fromJson(response.body(),TituloOmdb.class);

        System.out.println("Api: "+meuTitulo);

        Titulo classeTitulo = new Titulo(meuTitulo);

        classeTitulo.getFichaTecnica();

    }
}
