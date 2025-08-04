package uni1a;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Temporada {
    private int numeroTemporada;
    private int numeroEpisodios;
    private List<String> titulosEpisodios; // Example of a simple aggregation

    // Constructor existente para crear una nueva temporada
    public Temporada(int numeroTemporada, int numeroEpisodios) {
        this.numeroTemporada = numeroTemporada;
        this.numeroEpisodios = numeroEpisodios;
        this.titulosEpisodios = new ArrayList<>();
    }

    // Nuevo constructor para cargar desde una línea CSV
    // El formato del CSV será: "numero_temp;num_episodios;titulo1;titulo2;..."
    public Temporada(String csvLine) {
        String[] datos = csvLine.split(";");
        this.numeroTemporada = Integer.parseInt(datos[0].trim());
        this.numeroEpisodios = Integer.parseInt(datos[1].trim());

        this.titulosEpisodios = new ArrayList<>();
        // Los elementos a partir del índice 2 son los títulos de los episodios
        if (datos.length > 2) {
            for (int i = 2; i < datos.length; i++) {
                this.titulosEpisodios.add(datos[i].trim());
            }
        }
    }

    // Nuevo método para convertir el objeto a una línea CSV
    public String toCsvString() {
        StringJoiner sjEpisodios = new StringJoiner(";");
        for (String titulo : titulosEpisodios) {
            sjEpisodios.add(titulo);
        }
        return numeroTemporada + ";" + numeroEpisodios + ";" + sjEpisodios.toString();
    }

    // Getters y setters
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
        System.out.println("  Temporada #" + numeroTemporada + " (Episodios: " + numeroEpisodios + ")");
        if (!titulosEpisodios.isEmpty()) {
            System.out.println("    Títulos de episodios:");
            for (String episodio : titulosEpisodios) {
                System.out.println("      - " + episodio);
            }
        }
    }
}