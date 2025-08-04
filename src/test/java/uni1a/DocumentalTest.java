package uni1a;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

class DocumentalTest {
    @Test
    void constructorDesdeCsvNoFalla() {
        String csv = "Documental,3,Test Doc,60,Nature,Animals";
        Documental d = new Documental(csv);
        assertNotNull(d);
        assertEquals("Test Doc", d.getTitulo());
    }

    @Test
    void toCsvStringNoFalla() {
        Documental d = new Documental("Test Doc", 60, "Nature", "Animals");
        assertNotNull(d.toCsvString());
    }
}