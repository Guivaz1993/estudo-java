import br.alura.screenmatch.modelos.Episodio;
import br.alura.screenmatch.modelos.Filme;
import br.alura.screenmatch.modelos.Serie;
import br.alura.screenmatch.utils.CalculadoraDeTempo;
import br.alura.screenmatch.utils.FiltroRecomendacoes;

public class Main {
    public static void main(String[] args) {
        Filme filme = new Filme();
        filme.setNome("Meu filme favorito");
        filme.avaliar(7);
        filme.avaliar(9);
        filme.avaliar(8);
        filme.avaliar(8);
        filme.getFichaTecnica();
        filme.setDuracaoEmMinutos(120);
        Filme filme2 = new Filme();
        filme2.setDuracaoEmMinutos(100);

        Serie serie = new Serie();
        serie.setNome("Flash");
        serie.setTemporadas(9);
        serie.setEpisodios(20);
        serie.setDuracaoPorEpisodio(41);


        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.incluir(filme);
        System.out.println(calculadora.getTempoTotal());
        calculadora.incluir(filme2);
        System.out.println(calculadora.getTempoTotal());
        calculadora.incluir(serie);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacoes filtro = new FiltroRecomendacoes();

        filtro.filtrar(filme);
        filtro.filtrar(filme2);

        Episodio episodio = new Episodio();
        episodio.setNome("Primeiro Ep");
        episodio.setNumero(1);
        episodio.setTotalDeVisualizacoes(450);

        filtro.filtrar(episodio);


    }
}