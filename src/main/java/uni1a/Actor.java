package uni1a;

public class Actor {
    private String nombre;
    private String nacionalidad;

    // Constructor existente
    public Actor(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    // Nuevo constructor que toma una línea CSV
    // El formato del CSV será: "nombre,nacionalidad"
    public Actor(String csvLine) {
        // Divide la línea por la coma para obtener los datos
        String[] datos = csvLine.split(",");
        this.nombre = datos[0].trim(); // .trim() para eliminar espacios en blanco
        this.nacionalidad = datos[1].trim();
    }

    // Nuevo método para convertir el objeto a una línea CSV
    public String toCsvString() {
        return nombre + "," + nacionalidad;
    }

    // Getters y Setters existentes...
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void mostrarDetalles() {
        System.out.println("  Actor: " + nombre + " (Nacionalidad: " + nacionalidad + ")");
    }
}