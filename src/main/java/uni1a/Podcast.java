package uni1a;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Podcast extends ContenidoAudiovisual {
    private String host;
    private int numeroEpisodiosTotales;
    private List<String> temasPrincipales;

    // Constructor existente
    public Podcast(String titulo, int duracionEnMinutos, String genero, String host, int numeroEpisodiosTotales) {
        super(titulo, duracionEnMinutos, genero);
        this.host = host;
        this.numeroEpisodiosTotales = numeroEpisodiosTotales;
        this.temasPrincipales = new ArrayList<>();
    }

    // Nuevo constructor para leer desde una línea CSV
    // El formato del CSV será: "Podcast,id,titulo,duracion,genero,host,numeroEpisodios,tema1;tema2;..."
    public Podcast(String csvLine) {
        String[] datos = csvLine.split(",");
        // Inicializar los atributos de la superclase
        super(Integer.parseInt(datos[1]), datos[2], Integer.parseInt(datos[3]), datos[4]);
        this.host = datos[5];
        this.numeroEpisodiosTotales = Integer.parseInt(datos[6]);

        this.temasPrincipales = new ArrayList<>();
        // El séptimo elemento de la línea CSV contiene los temas separados por punto y coma
        if (datos.length > 7) {
            String[] temas = datos[7].split(";");
            for (String tema : temas) {
                this.temasPrincipales.add(tema.trim());
            }
        }
    }

    // Nuevo método para convertir el objeto a una línea CSV
    // Utilizaremos un StringJoiner para los temas
    @Override
    public String toCsvString() {
        StringJoiner sjTemas = new StringJoiner(";");
        for (String tema : temasPrincipales) {
            sjTemas.add(tema);
        }
        return "Podcast," + getId() + "," + getTitulo() + "," + getDuracionEnMinutos() + "," + getGenero() + "," + host + "," + numeroEpisodiosTotales + "," + sjTemas.toString();
    }
    
    // Getters y Setters
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
    // ... (resto de los getters y setters)

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
                System.out.println("  - " + tema);
            }
        }
        System.out.println();
    }
}