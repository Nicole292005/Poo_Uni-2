package uni1a;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

// Subclase Pelicula que extiende de ContenidoAudiovisual
public class Pelicula extends ContenidoAudiovisual {
    private String estudio;
    private List<Actor> actores; // Association: A Pelicula has multiple Actors

    // Constructor existente para crear una nueva película
    public Pelicula(String titulo, int duracionEnMinutos, String genero, String estudio) {
        super(titulo, duracionEnMinutos, genero);
        this.estudio = estudio;
        this.actores = new ArrayList<>();
    }

    // Nuevo constructor para cargar desde una línea CSV
    // El formato del CSV será: "Pelicula,id,titulo,duracion,genero,estudio,actor1_nombre;actor1_nacionalidad,actor2_nombre;actor2_nacionalidad"
    public Pelicula(String csvLine) {
        String[] datos = csvLine.split(",");
        // Inicializar los atributos de la superclase
        super(Integer.parseInt(datos[1]), datos[2], Integer.parseInt(datos[3]), datos[4]);
        this.estudio = datos[5];

        this.actores = new ArrayList<>();
        // El sexto elemento de la línea CSV contiene los actores separados por punto y coma
        if (datos.length > 6) {
            String[] actoresCsv = datos[6].split(";");
            for (String actorCsv : actoresCsv) {
                // Creamos un nuevo Actor usando su constructor de CSV
                this.actores.add(new Actor(actorCsv));
            }
        }
    }

    // Nuevo método para convertir el objeto a una línea CSV
    @Override
    public String toCsvString() {
        StringJoiner sjActores = new StringJoiner(";");
        for (Actor actor : actores) {
            sjActores.add(actor.toCsvString());
        }
        return "Pelicula," + getId() + "," + getTitulo() + "," + getDuracionEnMinutos() + "," + getGenero() + "," + estudio + "," + sjActores.toString();
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public List<Actor> getActores() {
        return actores;
    }

    public void agregarActor(Actor actor) {
        this.actores.add(actor);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de la película:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Estudio: " + estudio);
        if (!actores.isEmpty()) {
            System.out.println("Actores Principales:");
            for (Actor actor : actores) {
                actor.mostrarDetalles();
            }
        }
        System.out.println();
    }
}