package uni1a;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

class SerieDeTVTest {
    @Test
    void constructorDesdeCsvNoFalla() {
        String csv = "SerieDeTV,2,Test Series,45,Drama,5";
        SerieDeTV s = new SerieDeTV(csv);
        assertNotNull(s);
        assertEquals("Test Series", s.getTitulo());
    }

    @Test
    void toCsvStringNoFalla() {
        SerieDeTV s = new SerieDeTV("Test Series", 45, "Drama", 5);
        assertNotNull(s.toCsvString());
    }
}