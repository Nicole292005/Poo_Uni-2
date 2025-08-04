package uni1a;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Concierto extends ContenidoAudiovisual {
    private String artistaPrincipal;
    private String lugar;
    private List<String> cancionesInterpretadas;

    // Constructor existente
    public Concierto(String titulo, int duracionEnMinutos, String genero, String artistaPrincipal, String lugar) {
        super(titulo, duracionEnMinutos, genero);
        this.artistaPrincipal = artistaPrincipal;
        this.lugar = lugar;
        this.cancionesInterpretadas = new ArrayList<>();
    }

    // Nuevo constructor que toma una línea CSV
    // El formato del CSV será: "tipo,id,titulo,duracion,genero,artistaPrincipal,lugar,cancion1;cancion2;..."
    public Concierto(String csvLine) {
        String[] datos = csvLine.split(",");
        // Los datos básicos del ContenidoAudiovisual (id, titulo, etc.) se inicializan en la superclase
        super(datos[1], Integer.parseInt(datos[2]), datos[3]);
        this.artistaPrincipal = datos[4];
        this.lugar = datos[5];

        this.cancionesInterpretadas = new ArrayList<>();
        // El sexto elemento de la línea CSV contiene las canciones separadas por punto y coma
        if (datos.length > 6) { // Asegurarse de que hay canciones
            String[] canciones = datos[6].split(";");
            for (String cancion : canciones) {
                this.cancionesInterpretadas.add(cancion.trim());
            }
        }
    }

    // Nuevo método para convertir el objeto a una línea CSV
    // Se utilizará un delimitador diferente (como el punto y coma) para las canciones
    @Override
    public String toCsvString() {
        StringJoiner sjCanciones = new StringJoiner(";");
        for (String cancion : cancionesInterpretadas) {
            sjCanciones.add(cancion);
        }
        return "Concierto," + getId() + "," + getTitulo() + "," + getDuracionEnMinutos() + "," + getGenero() + "," + artistaPrincipal + "," + lugar + "," + sjCanciones.toString();
    }
    
    // Getters y Setters
    public String getArtistaPrincipal() {
        return artistaPrincipal;
    }
    // ... (resto de los getters y setters)
    
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
                System.out.println("  - " + cancion);
            }
        }
        System.out.println();
    }
}