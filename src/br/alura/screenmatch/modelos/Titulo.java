package br.alura.screenmatch.modelos;

public class Titulo {
    private String nome;
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
        return this.somaAvaliacao/this.totalDeAvaliacoes;
    }

    public void getFichaTecnica(){
        String ficha = String.format("""
                Nome: %s;
                Média: %f;
                Total de avaliações: %d
                """ ,this.nome,getMedia(), this.totalDeAvaliacoes);

        System.out.println(ficha);
    }

    @Override
    public String toString() {
        return "Titulo: "+ this.nome+" ("+this.anoDeLancamento+")";
    }
}
