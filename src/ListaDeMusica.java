import java.util.NoSuchElementException;

public class ListaDeMusica implements ColecaoDeMusicas{

    Musica musicaInicial = null;
    int totalDeMusicas = 0;
    @Override
    public void adicionarMusica(Musica novaMusica) {
        try {
            Musica musicaAtual = this.musicaInicial;
            if(novaMusica != null && !validaAtributoNulo(novaMusica)) {

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
                throw new NullPointerException();
            }
        } catch (NullPointerException e) {
            System.out.println("A música não pode ser nula ou possuir atributos nulos");
        }
    }

    @Override
    public boolean excluirMusica(String nomeDaMusica) {
        try {
            Musica musicaAtual = this.musicaInicial;
            Musica musicaAnterior = null;

            if(nomeDaMusica != null && !nomeDaMusica.isEmpty()) {
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
            Musica musicaAtual = this.musicaInicial;

            while ((musicaAtual != null) && (posicaoAtual != posicaoDaMusica)) {
                musicaAtual = musicaAtual.obterProxima();
                posicaoAtual++;
            }

            if(posicaoAtual == posicaoDaMusica) {
                return musicaAtual;
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
        try {
            Musica musica1 = obterMusica(posicaoDaMusica1);
            Musica musica2 = obterMusica(posicaoDaMusica2);
            Musica musicaAnterior1 = null;
            Musica musicaAnterior2 = null;

            if(posicaoDaMusica1 != 0) {
                musicaAnterior1 = obterMusica(posicaoDaMusica1 -1);
            }
            if(posicaoDaMusica2 != 0) {
                musicaAnterior2 = obterMusica(posicaoDaMusica2 -1);
            }

            if (posicaoDaMusica1 >= 0 && posicaoDaMusica2 >= 0 && posicaoDaMusica1 < totalDeMusicas && posicaoDaMusica2 < totalDeMusicas) {
                if (musicaAnterior1 != null) {
                    musicaAnterior1.definirProxima(musica2);
                } else {
                    musicaInicial = musica2;
                }

                if (musicaAnterior2 != null) {
                    musicaAnterior2.definirProxima(musica1);
                } else {
                    musicaInicial = musica1;
                }
            } else {
                throw new IndexOutOfBoundsException();
            }

            Musica musicaTemporaria = musica1.obterProxima();
            musica1.definirProxima(musica2.obterProxima());
            musica2.definirProxima(musicaTemporaria);
            System.out.println("Posição das músicas alteradas.");

        } catch (IndexOutOfBoundsException e) {
            System.out.println("Posição da música inválida");
        }
    }

    @Override
    public void alterarMusica(int posicaoDaMusica, Musica novaMusica) {
        try {
            Musica musicaAtual = this.musicaInicial;
            Musica musicaAnterior = null;
            int posicaoAtual = 0;

            if(posicaoDaMusica >= 0 && posicaoDaMusica < totalDeMusicas) {
                if(novaMusica != null && !validaAtributoNulo(novaMusica)) {
                    while((musicaAtual != null) && (posicaoAtual != posicaoDaMusica)) { //em duvida se é necessario checar a musicaAtual != null
                        musicaAnterior = musicaAtual;
                        musicaAtual = musicaAtual.obterProxima();
                        posicaoAtual++;
                    }
                    if (posicaoAtual == posicaoDaMusica) {
                        musicaAnterior.definirProxima(novaMusica);
                        novaMusica.definirProxima(musicaAtual.obterProxima());
                        System.out.println("Música alterada com sucesso");
                    }
                } else {
                    throw new NullPointerException();
                }
            }else {
                throw new IllegalArgumentException();
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
