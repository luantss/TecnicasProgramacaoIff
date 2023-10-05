import java.util.NoSuchElementException;

public class ListaDeMusica implements ColecaoDeMusicas{

    No musicaInicial = null;
    int totalDeMusicas = 0;
    @Override
    public void adicionarMusica(Musica novaMusica) {

        if(novaMusica != null && !validaAtributoNulo(novaMusica)) {
            No novoNo = new No(novaMusica);
            No noAtual = this.musicaInicial;
            if(this.musicaInicial != null) {
                while (noAtual.obterProximo() != null) {
                    noAtual = noAtual.obterProximo();
                }
                noAtual.definirProximo(novoNo);
            } else {
                this.musicaInicial = novoNo;
            }
            this.totalDeMusicas++;
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public boolean excluirMusica(String nomeDaMusica) {

        No musicaAtual = this.musicaInicial;
        No musicaAnterior = null;

        if(nomeDaMusica != null && !nomeDaMusica.isEmpty()) {
            if(this.musicaInicial != null) {
                while ((musicaAtual.obterProximo() != null) && (!nomeDaMusica.equals(musicaAtual.obterMusica().getTrack()))) {
                    musicaAnterior = musicaAtual;
                    musicaAtual = musicaAtual.obterProximo();
                }
                if(nomeDaMusica.equals(musicaAtual.obterMusica().getTrack())) {
                    if(musicaAnterior == null) {
                        this.musicaInicial = musicaAtual.obterProximo();
                    } else {
                        musicaAnterior.definirProximo(musicaAtual.obterProximo());
                    }
                    System.out.println("Musica excluida com sucesso");
                    this.totalDeMusicas--;
                    return true;
                } else {
                    throw new NoSuchElementException();
                }
            } else {
                throw new NullPointerException();
            }
        } else {
            throw new IllegalArgumentException();
        }

    }

    @Override
    public Musica obterMusica(int posicaoDaMusica) {

        int posicaoAtual = 0;
        No musicaAtual = this.musicaInicial;

        while ((musicaAtual != null) && (posicaoAtual != posicaoDaMusica)) {
            musicaAtual = musicaAtual.obterProximo();
            posicaoAtual++;
        }

        if(posicaoAtual == posicaoDaMusica) {
            return musicaAtual.obterMusica();
        } else {
            throw new IllegalArgumentException();
        }

    }

    @Override
    public int obterTotalDeMusicas() {
        return this.totalDeMusicas;
    }

    @Override
    public void trocarPosicaoEntreMusicas(int posicaoDaMusica1, int posicaoDaMusica2) {

        No musica1 = null;
        No musica2 = null;
        No musicaAnterior1 = null;
        No musicaAnterior2 = null;

        No musicaAtual = this.musicaInicial;
        int posicao = 0;
        while (musicaAtual != null) {
            if(posicao == posicaoDaMusica1) {
                musica1 = musicaAtual;
            } else {
                if(posicao == posicaoDaMusica2) {
                    musica2 = musicaAtual;
                }
            }
            if(musica1 == null) {
                musicaAnterior1 = musicaAtual;
            }
            if(musica2 == null) {
                musicaAnterior2 = musicaAtual;
            }
            musicaAtual = musicaAtual.obterProximo();
            posicao++;
        }

        if (posicaoDaMusica1 >= 0 && posicaoDaMusica2 >= 0 && posicaoDaMusica1 < totalDeMusicas && posicaoDaMusica2 < totalDeMusicas) {
            if (musicaAnterior1 != null) {
                musicaAnterior1.definirProximo(musica2);
            } else {
                musicaInicial = musica2;
            }

            if (musicaAnterior2 != null) {
                musicaAnterior2.definirProximo(musica1);
            } else {
                musicaInicial = musica1;
            }
        } else {
            throw new IndexOutOfBoundsException();
        }

        No musicaTemporaria = musica1.obterProximo();
        musica1.definirProximo(musica2.obterProximo());
        musica2.definirProximo(musicaTemporaria);
        System.out.println("Posição das músicas alteradas.");

    }

    @Override
    public void alterarMusica(int posicaoDaMusica, Musica novaMusica) {

        No musicaAtual = this.musicaInicial;
        int posicaoAtual = 0;
        if(posicaoDaMusica >= 0 && posicaoDaMusica < totalDeMusicas) {
            if(novaMusica != null && !validaAtributoNulo(novaMusica)) {
                if(this.musicaInicial != null) {
                    while (musicaAtual != null) {
                        if(posicaoAtual == posicaoDaMusica) {
                            musicaAtual.definirDado(novaMusica);
                        }
                        musicaAtual = musicaAtual.obterProximo();
                        posicaoAtual++;
                    }
                }
            } else {
                throw new NullPointerException();
            }
        }else {
            throw new IndexOutOfBoundsException();
        }

    }

    @Override
    public void ordenarMusicas(Ordenador ordenador) {
        ordenador.ordenar(this);
    }

    @Override
    public Iterador obterIterador(){
        Iterador iterador = new IteradorMusica(this);
        return iterador;
    }

    public boolean validaAtributoNulo(Musica musica) {
        return musica.getArtist() == null || musica.getTrack() == null || musica.getDanceability() == null ||
                musica.getEnergy() == null || musica.getDurationMin() == null || musica.getViews() == null || musica.getLikes() == null;
    }
}
