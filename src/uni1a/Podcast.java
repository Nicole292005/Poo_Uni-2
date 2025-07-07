package uni1a;

import java.util.ArrayList;
import java.util.List;

public class Podcast extends ContenidoAudiovisual {
    private String host;
    private int numeroEpisodiosTotales;
    private List<String> temasPrincipales; // Agregación de temas

    public Podcast(String titulo, int duracionEnMinutos, String genero, String host, int numeroEpisodiosTotales) {
        super(titulo, duracionEnMinutos, genero);
        this.host = host;
        this.numeroEpisodiosTotales = numeroEpisodiosTotales;
        this.temasPrincipales = new ArrayList<>();
    }

    // Getters y Setters
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getNumeroEpisodiosTotales() {
        return numeroEpisodiosTotales;
    }

    public void setNumeroEpisodiosTotales(int numeroEpisodiosTotales) {
        this.numeroEpisodiosTotales = numeroEpisodiosTotales;
    }

    public List<String> getTemasPrincipales() {
        return temasPrincipales;
    }

    public void agregarTema(String tema) {
        this.temasPrincipales.add(tema);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles del Podcast:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración promedio por episodio: " + getDuracionEnMinutos() + " minutos");
        System.out.println("Género: " + getGenero());
        System.out.println("Host: " + this.host);
        System.out.println("Número de Episodios Totales: " + this.numeroEpisodiosTotales);
        if (!temasPrincipales.isEmpty()) {
            System.out.println("Temas Principales:");
            for (String tema : temasPrincipales) {
                System.out.println("  - " + tema);
            }
        }
        System.out.println();
    }
}