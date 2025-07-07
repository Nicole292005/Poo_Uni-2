package uni1a;

import java.util.ArrayList;
import java.util.List;

public class Temporada {
    private int numeroTemporada;
    private int numeroEpisodios;
    private List<String> titulosEpisodios; // Example of a simple aggregation

    public Temporada(int numeroTemporada, int numeroEpisodios) {
        this.numeroTemporada = numeroTemporada;
        this.numeroEpisodios = numeroEpisodios;
        this.titulosEpisodios = new ArrayList<>();
    }

    public int getNumeroTemporada() {
        return numeroTemporada;
    }

    public void setNumeroTemporada(int numeroTemporada) {
        this.numeroTemporada = numeroTemporada;
    }

    public int getNumeroEpisodios() {
        return numeroEpisodios;
    }

    public void setNumeroEpisodios(int numeroEpisodios) {
        this.numeroEpisodios = numeroEpisodios;
    }

    public List<String> getTitulosEpisodios() {
        return titulosEpisodios;
    }

    public void agregarEpisodio(String tituloEpisodio) {
        this.titulosEpisodios.add(tituloEpisodio);
    }

    public void mostrarDetalles() {
        System.out.println("  Temporada #" + numeroTemporada + " (Episodios: " + numeroEpisodios + ")");
        if (!titulosEpisodios.isEmpty()) {
            System.out.println("    Títulos de episodios:");
            for (String episodio : titulosEpisodios) {
                System.out.println("      - " + episodio);
            }
        }
    }
}