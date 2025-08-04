package uni1a;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

class PodcastTest {
    @Test
    void constructorDesdeCsvNoFalla() {
        String csv = "Podcast,5,Test Cast,30,Talk,Mr. Test,50";
        Podcast p = new Podcast(csv);
        assertNotNull(p);
        assertEquals("Test Cast", p.getTitulo());
    }

    @Test
    void toCsvStringNoFalla() {
        Podcast p = new Podcast("Test Cast", 30, "Talk", "Mr. Test", 50);
        assertNotNull(p.toCsvString());
    }
}