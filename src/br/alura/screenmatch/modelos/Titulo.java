package br.alura.screenmatch.modelos;

import com.google.gson.annotations.SerializedName;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        final String regex = "\\D";

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcherAno = pattern.matcher(meuTitulo.year());
        final Matcher matcherDuracao = pattern.matcher(meuTitulo.runtime());

        this.nome = meuTitulo.title();
        this.anoDeLancamento = Integer.valueOf(matcherAno.replaceAll(""));

        if(matcherDuracao.replaceAll("").length()==0){
            this.duracaoEmMinutos=0;
        } else{
            this.duracaoEmMinutos = Integer.valueOf(matcherDuracao.replaceAll(""));
        }
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
                Nome: %s - %d;
                Média: %f;
                Total de avaliações: %d;
                Duração: %d min;
                """ ,this.nome,this.anoDeLancamento, getMedia(), this.totalDeAvaliacoes,this.duracaoEmMinutos);

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
