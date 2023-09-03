public class ListaDeMusica implements ColecaoDeMusicas{

    Musica musicaInicial = null;
    int totalDeMusicas = 0;
    @Override
    public void adicionarMusica(Musica novaMusica) {

        Musica musicaAtual = this.musicaInicial;
        if(novaMusica != null) {
            if(!validaAtributoNulo(novaMusica)) {
                if(this.musicaInicial != null) {

                    while (musicaAtual.obterProxima() != null) {
                        musicaAtual = musicaAtual.obterProxima();
                    }
                    musicaAtual.definirProxima(novaMusica);
                    this.totalDeMusicas++;
                    System.out.println("Música adicionada com sucesso");
                } else {
                    this.musicaInicial = novaMusica;
                    this.totalDeMusicas++;
                }
            } else {
                //System.out.println("A música não pode possuir atributos nulos");
                throw new IllegalArgumentException("A música não pode possuir atributos nulos");
            }
        } else {
            //System.out.println("A música não pode ser nula");
            throw new NullPointerException("A música não pode ser nula");
        }
    }

    @Override
    public boolean excluirMusica(String nomeDaMusica) {

        Musica musicaAtual = this.musicaInicial;
        Musica musicaAnterior = null;

        if(nomeDaMusica == null || nomeDaMusica.isEmpty()) {
            //System.out.println("O nome da música não pode ser nulo");
            throw new IllegalArgumentException("O nome da música não pode ser nulo ou vazio");
        }

        if(this.musicaInicial != null) {
            while ((musicaAtual.obterProxima() != null) && (!nomeDaMusica.equals(musicaAtual.getTrack()))) {
                musicaAnterior = musicaAtual;
                musicaAtual = musicaAtual.obterProxima();
            }
            if(nomeDaMusica.equals(musicaAtual.getTrack())) {
                if(musicaAnterior == null) {
                    this.musicaInicial = musicaAtual.obterProxima();
                } else {
                    musicaAnterior.definirProxima(musicaAtual.obterProxima());
                }
                System.out.println("Musica excluida com sucesso");
                this.totalDeMusicas--;
                return true;
            } else {
                System.out.println("Não foi possível excluir, a música "+nomeDaMusica+" não existe na lista");
                return false;
            }
        } else {
            System.out.println("Não foi possível excluir, a lista de músicas está vazia");
            return false;
        }
    }

    @Override
    public Musica obterMusica(int posicaoDaMusica) {

        int posicaoAtual = 0;
        Musica musicaAtual = this.musicaInicial;

        if(posicaoDaMusica >= 0) {
            while ((musicaAtual != null) && (posicaoAtual != posicaoDaMusica)) {
                musicaAtual = musicaAtual.obterProxima();
                posicaoAtual++;
            }
        } else {
            System.out.println("A posição da música não pode ser negativa");
            //throw new IllegalArgumentException("A posição da música não pode ser negativa");
        }

        if(posicaoAtual == posicaoDaMusica) {
            return musicaAtual;
        } else {
            System.out.println("A posição da música não pode ser negativa");
            //throw new IllegalArgumentException("A posição da música não existe na lista");
        }
        return null;
    }

    @Override
    public int obterTotalDeMusicas() {
        return this.totalDeMusicas;
    }

    @Override
    public void trocarPosicaoEntreMusicas(int posicaoDaMusica1, int posicaoDaMusica2) {

    }

    @Override
    public void alterarMusica(int posicaoDaMusica, Musica novaMusica) {

    }

    @Override
    public void ordenarMusicas(Ordenador ordenador) {

    }

    public boolean validaAtributoNulo(Musica musica) {

        return musica.getArtist() == null || musica.getTrack() == null || musica.getDanceability() == null ||
                musica.getEnergy() == null || musica.getDurationMin() == null || musica.getViews() == null || musica.getLikes() == null;
    }
}
