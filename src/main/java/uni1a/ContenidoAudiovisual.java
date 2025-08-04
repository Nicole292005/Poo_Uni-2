package uni1a;

public abstract class ContenidoAudiovisual {
    private static int contar = 0;
    private String titulo;
    private int duracionEnMinutos;
    private String genero;
    private int id;

    // Constructor existente (para la creación normal de objetos)
    public ContenidoAudiovisual(String titulo, int duracionEnMinutos, String genero) {
        this.id = contar++;
        this.titulo = titulo;
        this.duracionEnMinutos = duracionEnMinutos;
        this.genero = genero;
    }

    // Nuevo constructor que toma un ID existente
    // Esto es vital para cargar objetos desde archivos sin crear un nuevo ID.
    public ContenidoAudiovisual(int id, String titulo, int duracionEnMinutos, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.duracionEnMinutos = duracionEnMinutos;
        this.genero = genero;
        // No incrementamos 'contar' aquí para evitar conflictos con los IDs existentes.
        // Si quieres que el próximo ID sea el siguiente del más alto cargado,
        // tendrías que manejarlo en el gestor de archivos.
    }
    public ContenidoAudiovisual() {
        // Constructor vacío para evitar el error de compilación en subclases.
    }
    
    // Método abstracto para convertir a CSV.
    // Cada subclase debe implementar su propia versión de este método.
    public abstract String toCsvString();

    // Getter y Setter para el campo 'titulo'
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Getter y Setter para el campo 'duracionEnMinutos'
    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    // Getter y Setter para el campo 'genero'
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    // Getter y Setter para el campo 'id' (añado el setter, ya que lo necesitamos para cargar desde CSV).
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public abstract void mostrarDetalles();
}