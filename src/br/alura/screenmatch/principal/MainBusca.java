package br.alura.screenmatch.principal;

import br.alura.screenmatch.excecao.ErroDeDuracaoException;
import br.alura.screenmatch.modelos.Titulo;
import br.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.Scanner;

public class MainBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        var busca = "";
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!busca.equalsIgnoreCase("sair")){

            System.out.println("Digite um nome de filme para adicionar ou 'sair' para sair.");
            busca = scanner.nextLine();
            if(busca.equalsIgnoreCase("sair")){
                break;
            }

            //Gson gson = new Gson();

        String url = "http://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=bfea45bb";

        try {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            TituloOmdb meuTitulo = gson.fromJson(response.body(), TituloOmdb.class);

            Titulo classeTitulo = new Titulo(meuTitulo);

            classeTitulo.getFichaTecnica();

            titulos.add(classeTitulo);

            System.out.println(titulos);

            FileWriter escrita = new FileWriter("filmes.json");

            escrita.write(gson.toJson(titulos));
            escrita.close();
        } catch (NumberFormatException | ErroDeDuracaoException e) {
            System.out.println("Aconteceu um erro: ");
            System.out.println(e.getMessage());
        } catch (IllegalFormatException e) {
            System.out.println("Aconteceu um erro: Verifique o nome do filme se está correto");
        } finally {
            System.out.println("O programa finalizou corretamente.");
        }
    }
}
}
