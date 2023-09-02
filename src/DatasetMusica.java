import java.io.*;
import java.nio.charset.StandardCharsets;

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
                    musica = new Musica(listaDeCampo[0], listaDeCampo[1], listaDeCampo[4], listaDeCampo[5], listaDeCampo[13], listaDeCampo[16], listaDeCampo[17]);
                    numeroMusicas++;
                    colecaoDeMusicas.adicionarMusica(musica);
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

            for(int posicaoMusica = 0; posicaoMusica < listaDeMusica.obterTotalDeMusicas(); posicaoMusica++) {
                Musica musica = listaDeMusica.obterMusica(posicaoMusica);
                arquivoEscrita.write(musica.getArtist() + ",");
                arquivoEscrita.write(musica.getTrack() + ",");
                arquivoEscrita.write(musica.getDanceability() + ",");
                arquivoEscrita.write(musica.getEnergy() + ",");
                arquivoEscrita.write(musica.getDurationMin() + ",");
                arquivoEscrita.write(musica.getViews() + ",");
                arquivoEscrita.write(musica.getLikes());
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
        int[] indices = { 0, 1, 4, 5, 13, 16, 17 };

        for(int index: indices) {
            if(campos[index].isEmpty() || campos[index].equals("0") || campos[index].equals("0.0")) {
                return true;
            }
        }
        return false;
    }

    /*public ColecaoDeMusicas lerDataset(String caminhoDoDataset, ColecaoDeMusicas colecaoDeMusicas) {

        //Musica[] listaDeMusica = new Musica[20595];
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
                        Double danceability = Double.parseDouble(listaDeCampo[4]);
                        Double energy = Double.parseDouble(listaDeCampo[5]);
                        Double durationMin = Double.parseDouble(listaDeCampo[13]);
                        Double views = Double.parseDouble(listaDeCampo[16]);
                        Double likes = Double.parseDouble(listaDeCampo[17]);
                        musica = new Musica(listaDeCampo[0], listaDeCampo[1], danceability, energy, durationMin, views, likes);
                        //listaDeMusica[numeroMusicas] = musica;
                        numeroMusicas++;
                        colecaoDeMusicas.adicionarMusica(musica);

                    } catch (NumberFormatException e) {
                        System.out.println("Registro numérico incorreto");
                    }
                }

                linhaLida = bufferLeitura.readLine();
            }
            System.out.println("Numero de musicas: "+numeroMusicas);

            bufferLeitura.close();
        } catch (IOException e) {
            System.out.println("Não é possível ler");
        }
        //return Arrays.copyOf(listaDeMusica, numeroMusicas);
        return colecaoDeMusicas;
    }*/

    /*public void escreverDataset(String caminhoDoDataset, Musica[] listaDeMusica) {
        try {
            FileWriter arquivoEscrita = new FileWriter(caminhoDoDataset, StandardCharsets.UTF_8);

           for(Musica musica : listaDeMusica) {
                arquivoEscrita.write(musica.getArtist() + ",");
                arquivoEscrita.write(musica.getTrack() + ",");
                arquivoEscrita.write(musica.getDanceability() + ",");
                arquivoEscrita.write(musica.getEnergy() + ",");
                arquivoEscrita.write(musica.getDurationMin() + ",");
                arquivoEscrita.write(musica.getViews() + ",");
                arquivoEscrita.write(musica.getLikes());
                arquivoEscrita.write("\n");
            }

            arquivoEscrita.flush();
            arquivoEscrita.close();

        } catch (NullPointerException e) {
            System.out.println("Impossível escrever, a música é nula");
        } catch (IOException e) {
            System.out.println("Não é possível escrever");
        }
    }*/

}
