public class IteradorMusica implements Iterador{
    No musicaAtual;
    No musicaInicial;
    int indice=0;

    public IteradorMusica(ColecaoDeMusicas colecao) {
        this.musicaAtual = new No(colecao.obterMusica(0));
        this.musicaInicial = this.musicaAtual;
    }

    @Override
    public boolean temProximo() {
        if(this.musicaAtual != null) {
            return true;
        }
        return false;
    }

    @Override
    public No obterProximoElemento() {
        this.indice++;
        No noAuxiliar = this.musicaAtual;
        this.musicaAtual = this.musicaAtual.obterProximo();
        return noAuxiliar;
    }

    public No obterElementoAtual() {
        return this.musicaAtual;
    }

    @Override
    public int obterIndice() {
        return this.indice;
    }

    @Override
    public void reiniciar() {
        this.musicaAtual = this.musicaInicial;

    }
}
