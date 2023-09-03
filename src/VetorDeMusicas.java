import java.util.Arrays;
import java.util.Scanner;

public class VetorDeMusicas implements ColecaoDeMusicas {

    private Musica[] vetorMusica;
    private int indice;
    private int tamanhoVetor;

    public VetorDeMusicas(int tamanhoVetor) {

        if(tamanhoVetor <= 0) {
            throw new IllegalArgumentException("O tamanho do vetor deve ser um valor maior do que zero");
        }
        this.vetorMusica = new Musica[tamanhoVetor];
        this.indice = 0;
        this.tamanhoVetor = tamanhoVetor;
    }

    /**
     * Adiciona uma nova musica ao vetor caso haja espaço no mesmo
     *
     * @param novaMusica Novo objeto Musica a ser adicionado no vetor
     * @exception NullPointerException Caso o objeto musica for nulo
     */
    @Override
    public void adicionarMusica(Musica novaMusica) {

        Scanner entradaTeclado = new Scanner(System.in);
        String resposta;
        if(novaMusica != null) {

            if(!validaAtributoNulo(novaMusica)) {

                if(this.indice < this.tamanhoVetor) {

                    this.vetorMusica[this.indice] = novaMusica;
                    this.indice++;
                    System.out.println("Música adicionada com sucesso");

                } else {
                    System.out.println("O vetor não possui mais espaço para armazenamento");
                    System.out.println("Deseja aumentar o tamanho do vetor? Sim ou Não?");
                    resposta = entradaTeclado.nextLine();
                    if(resposta.equals("Sim")) {
                        aumentarVetor(this.vetorMusica);
                        System.out.println("Novo tamanho: " + this.tamanhoVetor);
                    } else {
                        throw new IndexOutOfBoundsException("O vetor não possui mais espaço para armazenamento");
                    }
                }
            } else {
                System.out.println("A música não pode possuir valores nulos");
            }
        } else {
            throw new NullPointerException("A música não pode ser nula");
        }

    }

    /**
     * Exclui uma musica percorrendo todas as musicas que existem no vetor e caso achar alguma que tenha o nome da exclusão,
     * irá diminuir o indicice do vetor e mudar o valor de retorno. No fim o vetor irá receber o novo vetor sem a música
     *
     * @param nomeDaMusica Nome(track) da musica que será excluida
     * @return caso tiver sido encontrado uma musica no vetor que tenha o mesmo nome da que deseja ser exluida irá retornar true
     */
    @Override
    public boolean excluirMusica(String nomeDaMusica) {

        if (nomeDaMusica == null) {
            System.out.println("O nome da música não pode ser nulo");
            return false;
        }

        boolean musicaExcluida = false;
        Musica[] novoVetor = new Musica[this.tamanhoVetor];

        int novoIndice = 0;

        for (int indiceMusica = 0; indiceMusica < this.indice; indiceMusica++) {
            Musica musica = this.vetorMusica[indiceMusica];

            if (!musica.getTrack().equals(nomeDaMusica)) {
                novoVetor[novoIndice] = musica;
                novoIndice++;
            } else {
                System.out.println("Musica " + musica.getTrack() + " excluida");
                musicaExcluida = true;
            }
        }

        if (musicaExcluida) {
            this.vetorMusica = novoVetor;
            this.indice--;
        }

        return musicaExcluida;

    }

    /**
     * Obtem a musica validando se a posição passada no parametro está de acordo com o tamanho do vetor
     *
     * @param posicaoDaMusica posição no vetor da musica desejada
     * @return retorna o vetor na posicao que se encontra o objeto
     */
    @Override
    public Musica obterMusica(int posicaoDaMusica) {

        if (posicaoDaMusica < 0 || posicaoDaMusica >= this.indice) {
            throw new IndexOutOfBoundsException("Posição da música inválida");
        } else {
            return this.vetorMusica[posicaoDaMusica];
        }
    }

    @Override
    public int obterTotalDeMusicas() {
        return this.indice;
    }

    /**
     * Troca a posição entre duas musicas utilizando um vetor auxiliar
     *
     * @param primeiraPosicao posição da primeira musica a ser trocada
     * @param segundaPosicao posição da segunda musica a ser trocada
     * @exception IndexOutOfBoundsException caso as posições informadas estejam fora do tamanho do vetor
     */
    @Override
    public void trocarPosicaoEntreMusicas(int primeiraPosicao, int segundaPosicao) {

        if(primeiraPosicao >= 0 && primeiraPosicao < this.indice && segundaPosicao >= 0 && segundaPosicao < this.indice) {
            Musica auxiliar = this.vetorMusica[primeiraPosicao];
            this.vetorMusica[primeiraPosicao] = this.vetorMusica[segundaPosicao];
            this.vetorMusica[segundaPosicao] = auxiliar;
            System.out.println("Troca realizada com sucesso");
        } else {
            throw new IndexOutOfBoundsException("Posição da música inválida");
            //System.out.println("Posição da música inválida");
        }

    }

    /**
     * Altera uma musica no vetor substituindo a musica na posicao desejada pelo objeto musica informado como parametro
     *
     * @param posicaoDaMusica posição da musica no vetor a ser alterada
     * @param novaMusica novo objeto musica com as alterações desejadas
     */
    @Override
    public void alterarMusica(int posicaoDaMusica, Musica novaMusica) {

        if(novaMusica != null) {

            if(!validaAtributoNulo(novaMusica)) {

                if (posicaoDaMusica < 0 || posicaoDaMusica >= this.indice) {
                    //throw new IndexOutOfBoundsException("Posição da música inválida");
                    System.out.println("Posição da música inválida");
                } else {
                    this.vetorMusica[posicaoDaMusica] = novaMusica;
                    System.out.println("Música alterada com sucesso");
                }

            } else {
                System.out.println("A música não pode possuir valores nulos");
            }

        } else {
            //throw new NullPointerException("A música não pode ser nula");
            System.out.println("A música não pode ser nula");
        }

    }

    @Override
    public void ordenarMusicas(Ordenador ordenador) {

    }

    /**
     * Valida se existe algum atributo nulo no objeto musica passado como parametro
     *
     * @param musica musica para validar os atributos
     * @return caso algum dos atributos seja nulo irá retornar true
     */
    public boolean validaAtributoNulo(Musica musica) {

        return musica.getArtist() == null || musica.getTrack() == null || musica.getDanceability() == null ||
                musica.getEnergy() == null || musica.getDurationMin() == null || musica.getViews() == null || musica.getLikes() == null;
    }

    public void aumentarVetor(Musica[] vetor) {
        int novoTamanho = this.tamanhoVetor + 500;
        this.vetorMusica = Arrays.copyOf(this.vetorMusica, novoTamanho);
        this.tamanhoVetor = novoTamanho;
    }
}
