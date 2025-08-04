package poo;

import java.util.ArrayList;
import java.util.List;

import uni1a.Actor;
import uni1a.ContenidoAudiovisual;
import uni1a.Documental;
import uni1a.Investigador;
import uni1a.Pelicula;
import uni1a.SerieDeTV;
import uni1a.Temporada;

public class PruebaAudioVisual {
    public static void main(String[] args) {
        // Opción 1: Crear datos y guardarlos
        List<ContenidoAudiovisual> misContenidos = crearContenidosDePrueba();
        GestorArchivos.guardarContenidos(misContenidos);

    }

    private static List<ContenidoAudiovisual> crearContenidosDePrueba() {
        List<ContenidoAudiovisual> lista = new ArrayList<>();

        // Crear una Película
        Pelicula avatar = new Pelicula("Avatar", 162, "Ciencia Ficción", "20th Century Studios");
        avatar.agregarActor(new Actor("Sam Worthington", "Australiana"));
        avatar.agregarActor(new Actor("Zoe Saldaña", "Estadounidense"));
        lista.add(avatar);

        // Crear una Serie de TV
        SerieDeTV gameOfThrones = new SerieDeTV("Game of Thrones", 60, "Fantasía", 8);
        Temporada temp1 = new Temporada(1, 10);
        temp1.agregarEpisodio("Winter Is Coming");
        temp1.agregarEpisodio("The Kingsroad");
        gameOfThrones.agregarTemporada(temp1);
        lista.add(gameOfThrones);

        // Crear un Documental
        Documental cosmos = new Documental("Cosmos: A Spacetime Odyssey", 50, "Ciencia", "Astronomía y Física");
        cosmos.agregarInvestigador(new Investigador("Carl Sagan", "Astrofísica"));
        cosmos.agregarInvestigador(new Investigador("Neil deGrasse Tyson", "Astrofísica"));
        lista.add(cosmos);

        return lista;
    }
}