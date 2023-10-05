public class No {

    private Musica musica;
    private No proximo;

    public No(Musica musica) {
        this.musica = musica;
        this.proximo = obterProximo();
    }

    public Musica obterMusica() {
        return this.musica;
    }

    public void definirDado(Musica musica) {
        this.musica = musica;
    }

    public No obterProximo() {
        return proximo;
    }

    public void definirProximo(No proximo) {
        this.proximo = proximo;
    }
}
