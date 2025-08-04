package uni1a;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

// Subclase SerieDeTV que extiende de ContenidoAudiovisual
public class SerieDeTV extends ContenidoAudiovisual {
    private int temporadas;
    private List<Temporada> listaTemporadas;

    // Constructor existente
    public SerieDeTV(String titulo, int duracionEnMinutos, String genero, int temporadas) {
        super(titulo, duracionEnMinutos, genero);
        this.temporadas = temporadas;
        this.listaTemporadas = new ArrayList<>();
    }

    // Nuevo constructor para cargar desde una línea CSV
    // El formato del CSV será: "SerieDeTV,id,titulo,duracion,genero,temporadas,temp1_num;temp1_episodios,temp2_num;temp2_episodios"
    // Los datos de la temporada se guardarán como una sub-cadena dentro de la línea.
    public SerieDeTV(String csvLine) {
        String[] datos = csvLine.split(",");
        // Inicializar los atributos de la superclase
        super(Integer.parseInt(datos[1]), datos[2], Integer.parseInt(datos[3]), datos[4]);
        this.temporadas = Integer.parseInt(datos[5]);

        this.listaTemporadas = new ArrayList<>();
        // Los elementos a partir del sexto (índice 6) son las temporadas
        if (datos.length > 6) {
            String[] temporadasCsv = datos[6].split(";");
            for (String tempCsv : temporadasCsv) {
                // Creamos un nuevo objeto Temporada usando su constructor de CSV
                this.listaTemporadas.add(new Temporada(tempCsv));
            }
        }
    }

    // Nuevo método para convertir el objeto a una línea CSV
    @Override
    public String toCsvString() {
        StringJoiner sjTemporadas = new StringJoiner(";");
        for (Temporada temp : listaTemporadas) {
            sjTemporadas.add(temp.toCsvString());
        }
        return "SerieDeTV," + getId() + "," + getTitulo() + "," + getDuracionEnMinutos() + "," + getGenero() + "," + temporadas + "," + sjTemporadas.toString();
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public List<Temporada> getListaTemporadas() {
        return listaTemporadas;
    }

    public void agregarTemporada(Temporada temporada) {
        this.listaTemporadas.add(temporada);
    }
    
    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de la Serie de TV:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Número total de temporadas (original attribute): " + this.temporadas);
        if (!listaTemporadas.isEmpty()) {
            System.out.println("Detalles por Temporada:");
            for (Temporada temp : listaTemporadas) {
                temp.mostrarDetalles();
            }
        }
        System.out.println();
    }
}