package uni1a;

import java.util.ArrayList;
import java.util.List;

public class Concierto extends ContenidoAudiovisual {
    private String artistaPrincipal;
    private String lugar;
    private List<String> cancionesInterpretadas; // Agregación de canciones

    public Concierto(String titulo, int duracionEnMinutos, String genero, String artistaPrincipal, String lugar) {
        super(titulo, duracionEnMinutos, genero);
        this.artistaPrincipal = artistaPrincipal;
        this.lugar = lugar;
        this.cancionesInterpretadas = new ArrayList<>();
    }

    // Getters y Setters
    public String getArtistaPrincipal() {
        return artistaPrincipal;
    }

    public void setArtistaPrincipal(String artistaPrincipal) {
        this.artistaPrincipal = artistaPrincipal;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public List<String> getCancionesInterpretadas() {
        return cancionesInterpretadas;
    }

    public void agregarCancion(String cancion) {
        this.cancionesInterpretadas.add(cancion);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles del Concierto:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Artista Principal: " + this.artistaPrincipal);
        System.out.println("Lugar: " + this.lugar);
        if (!cancionesInterpretadas.isEmpty()) {
            System.out.println("Canciones Interpretadas:");
            for (String cancion : cancionesInterpretadas) {
                System.out.println("  - " + cancion);
            }
        }
        System.out.println();
    }
}