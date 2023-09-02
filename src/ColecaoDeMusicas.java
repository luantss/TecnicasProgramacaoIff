public interface ColecaoDeMusicas {

    void adicionarMusica(Musica novaMusica);

    boolean excluirMusica(String nomeDaMusica);

    Musica obterMusica(int posicaoDaMusica);

    int obterTotalDeMusicas();

    void trocarPosicaoEntreMusicas(int posicaoDaMusica1, int posicaoDaMusica2);

    void alterarMusica(int posicaoDaMusica, Musica novaMusica);

    void ordenarMusicas(Ordenador ordenador);
}
