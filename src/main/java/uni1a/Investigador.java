package uni1a;

public class Investigador {
    private String nombre;
    private String especialidad;

    // Constructor existente
    public Investigador(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    // Nuevo constructor que toma una línea CSV
    // El formato del CSV para un investigador será: "nombre;especialidad"
    public Investigador(String csvLine) {
        // Divide la línea por el punto y coma para obtener los datos
        String[] datos = csvLine.split(";");
        this.nombre = datos[0].trim();
        this.especialidad = datos[1].trim();
    }

    // Nuevo método para convertir el objeto a una línea CSV
    public String toCsvString() {
        return nombre + ";" + especialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void mostrarDetalles() {
        System.out.println("  Investigador: " + nombre + " (Especialidad: " + especialidad + ")");
    }
}