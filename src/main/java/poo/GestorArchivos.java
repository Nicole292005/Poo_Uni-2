package poo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import uni1a.Concierto;
import uni1a.ContenidoAudiovisual;
import uni1a.Documental;
import uni1a.Pelicula;
import uni1a.Podcast;
import uni1a.SerieDeTV;

public class GestorArchivos {

    // Nombre del archivo que se usará por defecto si no se especifica otro.
    private static final String ARCHIVO_POR_DEFECTO = "contenidos.csv";

    // --- MÉTODOS PARA EL USO NORMAL DEL PROGRAMA ---

    /**
     * Guarda la lista de contenidos en el archivo por defecto (contenidos.csv).
     */
    public static void guardarContenidos(List<ContenidoAudiovisual> contenidos) {
        // Llama al método más flexible, pasándole el nombre del archivo por defecto.
        guardarContenidos(contenidos, ARCHIVO_POR_DEFECTO);
    }

    /**
     * Lee la lista de contenidos desde el archivo por defecto (contenidos.csv).
     */
    public static List<ContenidoAudiovisual> leerContenidos() {
        // Llama al método más flexible, pasándole el nombre del archivo por defecto.
        return leerContenidos(ARCHIVO_POR_DEFECTO);
    }


    // --- MÉTODOS FLEXIBLES PARA LAS PRUEBAS UNITARIAS ---

    /**
     * Guarda una lista de contenidos en un archivo CSV con un nombre específico.
     * Este método es usado por las pruebas para no modificar el archivo real.
     *
     * @param contenidos La lista de contenidos a guardar.
     * @param nombreArchivo El nombre del archivo donde se guardarán los datos.
     */
    public static void guardarContenidos(List<ContenidoAudiovisual> contenidos, String nombreArchivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (ContenidoAudiovisual contenido : contenidos) {
                if (contenido != null) {
                    bw.write(contenido.toCsvString());
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("❌ Error al escribir en el archivo: " + e.getMessage());
        }
    }

    /**
     * Lee los contenidos de un archivo CSV con un nombre específico.
     * Este método es usado por las pruebas.
     *
     * @param nombreArchivo El nombre del archivo a leer.
     * @return Una lista de ContenidoAudiovisual.
     */
    public static List<ContenidoAudiovisual> leerContenidos(String nombreArchivo) {
        List<ContenidoAudiovisual> contenidos = new ArrayList<>();
        File archivo = new File(nombreArchivo);

        if (!archivo.exists()) {
            return contenidos; // Si el archivo no existe, devuelve una lista vacía.
        }

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue; // Ignorar líneas vacías

                String tipo = linea.split(",")[0];
                switch (tipo) {
                    case "Pelicula":
                        contenidos.add(new Pelicula(linea));
                        break;
                    case "SerieDeTV":
                        contenidos.add(new SerieDeTV(linea));
                        break;
                    case "Documental":
                        contenidos.add(new Documental(linea));
                        break;
                    case "Concierto":
                        contenidos.add(new Concierto(linea));
                        break;
                    case "Podcast":
                        contenidos.add(new Podcast(linea));
                        break;
                    default:
                        System.err.println("Tipo de contenido desconocido: " + tipo);
                        break;
                }
            }
        } catch (IOException e) {
            System.err.println("❌ Error al leer el archivo: " + e.getMessage());
        }
        return contenidos;
    }
}