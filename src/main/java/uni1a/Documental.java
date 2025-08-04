package uni1a;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Documental extends ContenidoAudiovisual {
    private String tema;
    private List<Investigador> investigadores;

    // Constructor existente
    public Documental(String titulo, int duracionEnMinutos, String genero, String tema) {
        super(titulo, duracionEnMinutos, genero);
        this.tema = tema;
        this.investigadores = new ArrayList<>();
    }

    // Nuevo constructor que toma un ID y datos de un Documental
    public Documental(int id, String titulo, int duracionEnMinutos, String genero, String tema) {
        super(id, titulo, duracionEnMinutos, genero);
        this.tema = tema;
        this.investigadores = new ArrayList<>();
    }

    // Nuevo constructor para leer desde una línea CSV
    // El formato del CSV será: "Documental,id,titulo,duracion,genero,tema,inv1_nombre;inv1_campo,inv2_nombre;inv2_campo"
    public Documental(String csvLine) {
        String[] datos = csvLine.split(",");
        // Inicializar los atributos de la superclase
        super(Integer.parseInt(datos[1]), datos[2], Integer.parseInt(datos[3]), datos[4]);
        this.tema = datos[5];

        this.investigadores = new ArrayList<>();
        // El sexto elemento de la línea CSV contiene los investigadores separados por coma
        if (datos.length > 6) {
            String[] investigadoresCsv = datos[6].split(";");
            for (String invCsv : investigadoresCsv) {
                // Creamos un nuevo Investigador usando su constructor de CSV
                this.investigadores.add(new Investigador(invCsv));
            }
        }
    }

    // Nuevo método para convertir el objeto a una línea CSV
    // Utilizaremos un StringJoiner para las relaciones de agregación.
    @Override
    public String toCsvString() {
        StringJoiner sjInvestigadores = new StringJoiner(";");
        for (Investigador inv : investigadores) {
            sjInvestigadores.add(inv.toCsvString());
        }

        return "Documental," + getId() + "," + getTitulo() + "," + getDuracionEnMinutos() + "," + getGenero() + "," + tema + "," + sjInvestigadores.toString();
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public void agregarInvestigador(Investigador investigador) {
        this.investigadores.add(investigador);
    }
    
    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles del Documental:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Tema: " + this.tema);
        if (!investigadores.isEmpty()) {
            System.out.println("Investigadores Principales:");
            for (Investigador inv : investigadores) {
                inv.mostrarDetalles();
            }
        }
        System.out.println();
    }
}