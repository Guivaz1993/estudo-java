package br.alura.screenmatch.utils;

import br.alura.screenmatch.modelos.Titulo;

public class CalculadoraDeTempo {
    private int tempoTotal;

    public int getTempoTotal() {
        return this.tempoTotal;
    }

    public void incluir(Titulo titulo){
        this.tempoTotal+= titulo.getDuracaoEmMinutos();
    }

}
