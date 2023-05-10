package br.alura.screenmatch.modelos;

public class Titulo {
    private String nome;
    private int anoDeLancamento;
    private double somaAvaliacao;
    private int totalDeAvaliacoes;
    private  boolean incluidoNoPlano;

    private int duracaoEmMinutos;

    public int getDuracaoEmMinutos() {
        return this.duracaoEmMinutos;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoDeLancamento() {
        return this.anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
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
}
