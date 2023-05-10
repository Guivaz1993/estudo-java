package br.alura.screenmatch.utils;

public class FiltroRecomendacoes {
    public void filtrar(Classificavel classificado){
        if(classificado.getClassificacao()>=4){
            System.out.println("Está entre os favoritos");
        } else if(classificado.getClassificacao()>=2){
            System.out.println("Muito bem avaliado");
        } else {
            System.out.println("Coloque na lista para assistir depois");
        }
    }
}
