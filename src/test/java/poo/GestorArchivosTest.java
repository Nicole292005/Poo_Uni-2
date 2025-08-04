package poo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uni1a.ContenidoAudiovisual;
import uni1a.Pelicula;

class GestorArchivosTest {

    private static final String ARCHIVO_PRUEBA = "test_temp_file.csv";

    @BeforeEach
    @AfterEach
    void limpiarArchivo() throws IOException {
        // Este método se ejecuta antes y después de cada prueba para asegurar que no hay archivos basura
        Files.deleteIfExists(Paths.get(ARCHIVO_PRUEBA));
    }

    @Test
    void testGuardarYLeerFuncionaSinErrores() {
        // ARRANGE: Creamos un objeto muy simple
        List<ContenidoAudiovisual> listaOriginal = new ArrayList<>();
        listaOriginal.add(new Pelicula("Test Movie", 10, "Test", "Test Studio"));

        // ACT & ASSERT: Verificamos que al guardar y leer, no se produzca un error
        assertDoesNotThrow(() -> {
            GestorArchivos.guardarContenidos(listaOriginal, ARCHIVO_PRUEBA);
            List<ContenidoAudiovisual> listaCargada = GestorArchivos.leerContenidos(ARCHIVO_PRUEBA);
            
            // Verificación mínima: la lista no está vacía
            assertFalse(listaCargada.isEmpty());
        });
    }
}