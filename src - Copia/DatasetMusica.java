import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class DatasetMusica {

    public ColecaoDeMusicas lerDataset(String caminhoDoDataset, ColecaoDeMusicas colecaoDeMusicas) {

        int numeroMusicas = 0;

        try {
            BufferedReader bufferLeitura = new BufferedReader(new FileReader(caminhoDoDataset));

            String[] listaDeCampo;
            Musica musica;
            String linhaLida = bufferLeitura.readLine();

            while (linhaLida != null) {
                listaDeCampo = linhaLida.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                if(!validaCampoNulo(listaDeCampo)) {

                    try {
                        Double danceability = Double.parseDouble(listaDeCampo[2]);
                        Double energy = Double.parseDouble(listaDeCampo[3]);
                        Double durationMin = Double.parseDouble(listaDeCampo[4]);
                        Double views = Double.parseDouble(listaDeCampo[5]);
                        Double likes = Double.parseDouble(listaDeCampo[6]);
                        musica = new Musica(listaDeCampo[0], listaDeCampo[1], danceability, energy, durationMin, views, likes);
                        numeroMusicas++;
                        colecaoDeMusicas.adicionarMusica(musica);
                    } catch (NumberFormatException e) {
                        System.out.println("Resgistro numérico incorreto");
                    }
                }

                linhaLida = bufferLeitura.readLine();
            }
            System.out.println("Numero de musicas: "+numeroMusicas);

            bufferLeitura.close();
        } catch (IOException e) {
            System.out.println("Não é possível ler");
        }
        return colecaoDeMusicas;
    }

    public void escreverDatasetColecao(String caminhoDoDataset, ColecaoDeMusicas listaDeMusica) {
        try {
            FileWriter arquivoEscrita = new FileWriter(caminhoDoDataset, StandardCharsets.UTF_8);
            DecimalFormat decimalFormat = new DecimalFormat("#.###", new DecimalFormatSymbols(Locale.US));

            for(int posicaoMusica = 0; posicaoMusica < listaDeMusica.obterTotalDeMusicas(); posicaoMusica++) {
                Musica musica = listaDeMusica.obterMusica(posicaoMusica);
                arquivoEscrita.write(musica.getArtist() + ",");
                arquivoEscrita.write(musica.getTrack() + ",");
                arquivoEscrita.write(decimalFormat.format(musica.getDanceability()) + ",");
                arquivoEscrita.write(decimalFormat.format(musica.getEnergy()) + ",");
                arquivoEscrita.write(decimalFormat.format(musica.getDurationMin()) + ",");
                arquivoEscrita.write(decimalFormat.format(musica.getViews()) + ",");
                arquivoEscrita.write(decimalFormat.format(musica.getLikes())+"");
                arquivoEscrita.write("\n");
            }

            arquivoEscrita.flush();
            arquivoEscrita.close();

        } catch (NullPointerException e) {
            System.out.println("Impossível escrever, a música é nula");
        } catch (IOException e) {
            System.out.println("Não é possível escrever");
        }
    }

    boolean validaCampoNulo(String[] campos) throws NullPointerException {
        int[] indices = { 0, 1, 2, 3, 4, 5, 6 };

        for(int index: indices) {
            if(campos[index].isEmpty() || campos[index].equals("0") || campos[index].equals("0.0")) {
                return true;
            }
        }
        return false;
    }
}
