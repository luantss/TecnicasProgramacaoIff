import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class ProgramaMusicas {

    public static void main(String[] args) {
        DatasetMusica datasetMusica = new DatasetMusica();

        String caminhoArquivoBase = "C:\\Users\\Luan Saramago\\Documents\\Iff\\Tecnicas\\p2\\ProcessamentoDataset\\novoSpotifyDataset.csv";
        String novoDatasetColecao = "C:\\Users\\Luan Saramago\\Documents\\Iff\\Tecnicas\\p2\\ProcessamentoDataset\\novoDatasetColecao.csv";

        //Vetor
        ColecaoDeMusicas vetorDeMusicas = datasetMusica.lerDataset(caminhoArquivoBase, new VetorDeMusicas(20500));

        Musica musica1 = new Musica("Janja", "Alop", 35.2, 35.2, 35.2, 5.0, 2.0);
        Musica musica2 = new Musica("Mathew", "Nunu", 35.2, 35.2, 35.2, 6.0, 8.0);
        Musica musica3 = null;

        // Exclusão
        //vetorDeMusicas.excluirMusica("PART OF ME HARDSTYLE");
        //vetorDeMusicas.excluirMusica("Elevated");

        // Adição
        vetorDeMusicas.adicionarMusica(musica1);
        //vetorDeMusicas.adicionarMusica(musica2);

        // Obter musica
        //System.out.println("Música: "+vetorDeMusicas.obterMusica(20500).getTrack());

        // Obter total de musicas
        System.out.println("Total de musicas: "+vetorDeMusicas.obterTotalDeMusicas());

        // Trocar posição entre músicas
        vetorDeMusicas.trocarPosicaoEntreMusicas(1,2);

        // Altera musica
        //vetorDeMusicas.alterarMusica(50000, musica2);

        // Lista musicas
        //listar(vetorDeMusicas);

        datasetMusica.escreverDatasetColecao(novoDatasetColecao, vetorDeMusicas);



        // Lista encadeada
        ColecaoDeMusicas listaDeMusica = datasetMusica.lerDataset(caminhoArquivoBase, new ListaDeMusica());

        //Adicionar
        //listaDeMusica.adicionarMusica(musica1);

        //Exclusão
        //listaDeMusica.excluirMusica("PART OF ME HARDSTYLE");

        //Obter
        //System.out.println(listaDeMusica.obterMusica(50000).getTrack());;

        //Obter total
        //System.out.println(listaDeMusica.obterTotalDeMusicas());

        //Alterar
        //listaDeMusica.alterarMusica(-1, musica2);

        //Trocar posição
        //listaDeMusica.trocarPosicaoEntreMusicas(-5, 3);

        //datasetMusica.escreverDatasetColecao(novoDatasetColecao, listaDeMusica);

    }

    public static void listar(ColecaoDeMusicas colecaoDeMusicas) {

        DecimalFormat decimalFormat = new DecimalFormat("#.###", new DecimalFormatSymbols(Locale.US));
        for(int indice = 0; indice < colecaoDeMusicas.obterTotalDeMusicas(); indice++) {
            Musica musica = colecaoDeMusicas.obterMusica(indice);
            if(musica != null) {
                System.out.println("===============================");
                System.out.println("Artist: "+musica.getArtist());
                System.out.println("Track: "+musica.getTrack());
                System.out.println("Danceability: "+decimalFormat.format(musica.getDanceability()));
                System.out.println("Energy: "+decimalFormat.format(musica.getEnergy()));
                System.out.println("Duration: "+decimalFormat.format(musica.getDurationMin()));
                System.out.println("Views: "+decimalFormat.format(musica.getViews()));
                System.out.println("Likes: "+decimalFormat.format(musica.getLikes()));
                //System.out.println(indice);
            }
        }
    }

}
