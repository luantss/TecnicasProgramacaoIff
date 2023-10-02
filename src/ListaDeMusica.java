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
        try {
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

        } catch (IllegalArgumentException e) {
            System.out.println("Nome da música inválido");
            return false;
        } catch (NoSuchElementException e) {
            System.out.println("Não foi possível excluir, a música "+nomeDaMusica+" não existe na lista");
            return false;
        } catch (NullPointerException e) {
            System.out.println("Não foi possível excluir, a lista de músicas está vazia");
            return false;
        }
    }

    @Override
    public Musica obterMusica(int posicaoDaMusica) {
        try {
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

        } catch (IllegalArgumentException e) {
            System.out.println("Posição da música inválida");
            return null;
        }
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
        try {
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

        } catch (IllegalArgumentException e) {
            System.out.println("Posição da música inválida");
        } catch (NullPointerException e) {
            System.out.println("A música não pode ser nula ou possuir atributos nulos");
        }
    }

    @Override
    public void ordenarMusicas(Ordenador ordenador) {

    }

    public boolean validaAtributoNulo(Musica musica) {

        return musica.getArtist() == null || musica.getTrack() == null || musica.getDanceability() == null ||
                musica.getEnergy() == null || musica.getDurationMin() == null || musica.getViews() == null || musica.getLikes() == null;
    }
}
