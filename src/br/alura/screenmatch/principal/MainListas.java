package br.alura.screenmatch.principal;

import br.alura.screenmatch.modelos.Filme;
import br.alura.screenmatch.modelos.Serie;
import br.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;

public class MainListas {

    public static void main(String[] args) {
        Filme filme = new Filme("Meu filme favorito", 2023, true);
        filme.avaliar(9);
        filme.avaliar(8);
        Filme filme2 = new Filme("Vingadores", 2019);
        filme2.avaliar(10);
        Serie serie = new Serie("Flash", 2013, false);
        ArrayList<Titulo> listaDeAssistidos = new ArrayList<>();

        listaDeAssistidos.add(filme);
        listaDeAssistidos.add(filme2);
        listaDeAssistidos.add(serie);
        System.out.println("\r\nTamanho da lista:" + listaDeAssistidos.size());
        System.out.println("O primeiro fome é " + listaDeAssistidos.get(0).getNome() + " e ele tem avaliação de " + listaDeAssistidos.get(0).getMedia());
        for (Titulo iten:listaDeAssistidos){
            System.out.println(iten.toString());
            if(iten instanceof Filme filmeIten){
                System.out.println("Classificação: "+filmeIten.getClassificacao());
            }
        }
    }
}
