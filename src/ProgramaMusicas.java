public class ProgramaMusicas {

    public static void main(String[] args) {
        DatasetMusica datasetMusica = new DatasetMusica();

        String caminhoArquivoBase = "C:\\Users\\Luan Saramago\\Documents\\Iff\\Tecnicas\\p2\\ProcessamentoDataset\\spotify_dataset.csv";
        String novoDatasetColecao = "C:\\Users\\Luan Saramago\\Documents\\Iff\\Tecnicas\\p2\\ProcessamentoDataset\\novoDatasetColecao.csv";

        ColecaoDeMusicas listaDeMusicas = datasetMusica.lerDataset(caminhoArquivoBase, new VetorDeMusicas(25000));

        //Musica musica1 = new Musica("Janja", "Alop", "35.2", "35.2", "35.2", "5.0", "2.0");
        //Musica musica2 = new Musica("Mathew", "Nunu", "35.2", "35.2", "35.2", "6.0", "8.0");
        //Musica musica3 = null;

        // Exclusão
        //listaDeMusicas.excluirMusica("PART OF ME HARDSTYLE");
        //listaDeMusicas.excluirMusica("Elevated");

        // Adição
        //listaDeMusicas.adicionarMusica(musica1);
        //listaDeMusicas.adicionarMusica(musica2);

        // Obter musica
        //System.out.println("Música: "+listaDeMusicas.obterMusica(5).getTrack());

        // Obter total de musicas
        //System.out.println("Total de musicas: "+listaDeMusicas.obterTotalDeMusicas());

        // Trocar posição entre músicas
        //listaDeMusicas.trocarPosicaoEntreMusicas(1,20017);

        // Altera musica
        //listaDeMusicas.alterarMusica(1, musica2);

        // Lista musicas
        //listar(listaDeMusicas);

        datasetMusica.escreverDatasetColecao(novoDatasetColecao, listaDeMusicas);

    }

    public static void listar(ColecaoDeMusicas colecaoDeMusicas) {

        for(int indice = 0; indice < colecaoDeMusicas.obterTotalDeMusicas(); indice++) {
            Musica musica = colecaoDeMusicas.obterMusica(indice);
            if(musica != null) {
                System.out.println("===============================");
                System.out.println("Artist: "+musica.getArtist());
                System.out.println("Track: "+musica.getTrack());
                System.out.println("Danceability: "+musica.getDanceability());
                System.out.println("Energy: "+musica.getEnergy());
                System.out.println("Duration: "+musica.getDurationMin());
                System.out.println("Views: "+musica.getViews());
                System.out.println("Likes: "+musica.getLikes());
                System.out.println(indice);
            }
        }
    }

}
