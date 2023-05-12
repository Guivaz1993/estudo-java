package br.alura.screenmatch.excecao;

public class ErroDeDuracaoException extends RuntimeException {
    private String mensagem;
    public ErroDeDuracaoException(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String getMessage(){
        return this.mensagem;
    }
}
