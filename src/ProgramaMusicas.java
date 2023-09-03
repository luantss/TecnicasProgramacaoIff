import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class ProgramaMusicas {

    public static void main(String[] args) {
        DatasetMusica datasetMusica = new DatasetMusica();

        String caminhoArquivoBase = "C:\\Users\\Luan Saramago\\Documents\\Iff\\Tecnicas\\p2\\ProcessamentoDataset\\novoSpotifyDataset.csv";
        String novoDatasetColecao = "C:\\Users\\Luan Saramago\\Documents\\Iff\\Tecnicas\\p2\\ProcessamentoDataset\\novoDatasetColecao.csv";

        ColecaoDeMusicas listaDeMusicas = datasetMusica.lerDataset(caminhoArquivoBase, new VetorDeMusicas(20018));

        Musica musica1 = new Musica("Janja", "Alop", 35.2, 35.2, 35.2, 5.0, 2.0);
        Musica musica2 = new Musica("Mathew", "Nunu", 35.2, 35.2, 35.2, 6.0, 8.0);
        //Musica musica3 = null;

        // Exclusão
        listaDeMusicas.excluirMusica("PART OF ME HARDSTYLE");
        listaDeMusicas.excluirMusica("Elevated");

        // Adição
        listaDeMusicas.adicionarMusica(musica1);
        listaDeMusicas.adicionarMusica(musica2);

        // Obter musica
        System.out.println("Música: "+listaDeMusicas.obterMusica(5).getTrack());

        // Obter total de musicas
        System.out.println("Total de musicas: "+listaDeMusicas.obterTotalDeMusicas());

        // Trocar posição entre músicas
        listaDeMusicas.trocarPosicaoEntreMusicas(1,20017);

        // Altera musica
        listaDeMusicas.alterarMusica(1, musica2);

        // Lista musicas
        listar(listaDeMusicas);

        datasetMusica.escreverDatasetColecao(novoDatasetColecao, listaDeMusicas);

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
