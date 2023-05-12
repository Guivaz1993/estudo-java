package br.alura.screenmatch.modelos;

import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo>{
    @SerializedName("Title")
    private String nome;
    @SerializedName("Year")
    private int anoDeLancamento;
    private double somaAvaliacao;
    private int totalDeAvaliacoes;
    private  boolean incluidoNoPlano;
    private int duracaoEmMinutos;

    public Titulo(String nome, int anoDeLancamento, boolean incluidoNoPlano){
        this.nome=nome;
        this.anoDeLancamento=anoDeLancamento;
        this.incluidoNoPlano=incluidoNoPlano;
    }

    public Titulo(TituloOmdb meuTitulo) {
        this.nome = meuTitulo.title();
        this.anoDeLancamento = Integer.valueOf(meuTitulo.year().replace("–","").replace(" ",""));

        this.duracaoEmMinutos = Integer.valueOf(meuTitulo.runtime().substring(0, meuTitulo.runtime().length()-4));
    }

    public int getDuracaoEmMinutos() {
        return this.duracaoEmMinutos;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }


    public String getNome() {
        return this.nome;
    }

    public int getAnoDeLancamento() {
        return this.anoDeLancamento;
    }

    public int getTotalDeAvaliacoes() {
        return this.totalDeAvaliacoes;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void avaliar(double avaliacao) {
        this.somaAvaliacao += avaliacao;
        this.totalDeAvaliacoes++;
    }

    public double getMedia(){
        if(this.totalDeAvaliacoes == 0 ) return 0;
        return this.somaAvaliacao/this.totalDeAvaliacoes;
    }

    public void getFichaTecnica(){
        String ficha = String.format("""
                Nome: %s;
                Média: %f;
                Total de avaliações: %d;
                Duração: %d min;
                """ ,this.nome,getMedia(), this.totalDeAvaliacoes,this.duracaoEmMinutos);

        System.out.println(ficha);
    }

    @Override
    public String toString() {
        return "Titulo: "+ this.nome+" ("+this.anoDeLancamento+")";
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }
}
