package br.alura.screenmatch.principal;

import br.alura.screenmatch.modelos.Episodio;
import br.alura.screenmatch.modelos.Filme;
import br.alura.screenmatch.modelos.Serie;
import br.alura.screenmatch.modelos.Titulo;
import br.alura.screenmatch.utils.CalculadoraDeTempo;
import br.alura.screenmatch.utils.FiltroRecomendacoes;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Filme filme = new Filme("Meu filme favorito",2023,true);
        filme.avaliar(7);
        filme.avaliar(9);
        filme.avaliar(8);
        filme.avaliar(8);
        filme.getFichaTecnica();
        filme.setDuracaoEmMinutos(120);
        Filme filme2 = new Filme("Vingadores",2019);
        filme2.setDuracaoEmMinutos(100);

        Serie serie = new Serie("Flash",2013,false);
        serie.setTemporadas(9);
        serie.setEpisodios(20);
        serie.setDuracaoPorEpisodio(41);


        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.incluir(filme);
        System.out.println(calculadora.getTempoTotal());
        calculadora.incluir(filme2);
        System.out.println(calculadora.getTempoTotal());
        calculadora.incluir(serie);
        System.out.println(calculadora.getTempoTotal()+ "\r\n");

        FiltroRecomendacoes filtro = new FiltroRecomendacoes();

        filtro.filtrar(filme);
        filtro.filtrar(filme2);

        Episodio episodio = new Episodio();
        episodio.setNome("Primeiro Ep");
        episodio.setNumero(1);
        episodio.setTotalDeVisualizacoes(450);

        filtro.filtrar(episodio);

        ArrayList<Titulo> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filme);
        listaDeFilmes.add(filme2);
        listaDeFilmes.add(serie);
        System.out.println("\r\nTamanho da lista:"+listaDeFilmes.size());
        System.out.println("O primeiro fome é " + listaDeFilmes.get(0).getNome() + " e ele tem avaliação de " + listaDeFilmes.get(0).getMedia());
        System.out.println(listaDeFilmes);

    }
}