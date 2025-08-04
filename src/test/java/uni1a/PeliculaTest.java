package uni1a;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

class PeliculaTest {
    @Test
    void constructorDesdeCsvNoFalla() {
        // Solo verificamos que el objeto se crea sin errores con datos simples
        String csv = "Pelicula,1,Test Movie,90,Action,Test Studio";
        Pelicula p = new Pelicula(csv);
        assertNotNull(p);
        assertEquals("Test Movie", p.getTitulo());
    }

    @Test
    void toCsvStringNoFalla() {
        // Solo verificamos que el método devuelve algo
        Pelicula p = new Pelicula("Test Movie", 90, "Action", "Test Studio");
        assertNotNull(p.toCsvString());
    }
}