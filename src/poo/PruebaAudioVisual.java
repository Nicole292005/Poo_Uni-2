package poo;
import uni1a.*;

import java.util.ArrayList;
import java.util.List;

public class PruebaAudioVisual {
    public static void main(String[] args) {
        System.out.println("Hello from Eclipse!");

        // Crear instancias de las subclases y demostrar relaciones

        // 1. Película con Actores
        System.out.println("\n--- Demostración de Película y Actores ---");
        Pelicula avatar = new Pelicula("Avatar", 162, "Ciencia Ficción", "20th Century Studios");
        Actor actorAvatar1 = new Actor("Sam Worthington", "Australiana");
        Actor actorAvatar2 = new Actor("Zoe Saldaña", "Estadounidense");
        Actor actorAvatar3 = new Actor("Sigourney Weaver", "Estadounidense");

        avatar.agregarActor(actorAvatar1);
        avatar.agregarActor(actorAvatar2);
        avatar.agregarActor(actorAvatar3);
        avatar.mostrarDetalles();

        // Demostrar getters y setters para Pelicula
        System.out.println("Cambiando el estudio de 'Avatar' a 'Lightstorm Entertainment'...");
        avatar.setEstudio("Lightstorm Entertainment");
        System.out.println("Nuevo estudio de 'Avatar': " + avatar.getEstudio());
        System.out.println("Duración de 'Avatar': " + avatar.getDuracionEnMinutos() + " minutos");
        System.out.println("Género de 'Avatar': " + avatar.getGenero());

        // 2. Serie de TV con Temporadas y Episodios
        System.out.println("\n--- Demostración de SerieDeTV y Temporadas ---");
        SerieDeTV gameOfThrones = new SerieDeTV("Game of Thrones", 60, "Fantasía", 8);

        Temporada temp1 = new Temporada(1, 10);
        temp1.agregarEpisodio("Winter Is Coming");
        temp1.agregarEpisodio("The Kingsroad");
        temp1.agregarEpisodio("Lord Snow");

        Temporada temp2 = new Temporada(2, 10);
        temp2.agregarEpisodio("The North Remembers");
        temp2.agregarEpisodio("The Night Lands");

        gameOfThrones.agregarTemporada(temp1);
        gameOfThrones.agregarTemporada(temp2);
        gameOfThrones.mostrarDetalles();

        // Demostrar getters y setters para SerieDeTV y Temporada
        System.out.println("Cambiando el número de temporadas de 'Game of Thrones' a 9 (ejemplo)...");
        gameOfThrones.setTemporadas(9);
        System.out.println("Nuevo número de temporadas de 'Game of Thrones': " + gameOfThrones.getTemporadas());
        System.out.println("Número de episodios de la Temporada 1: " + temp1.getNumeroEpisodios());
        System.out.println("Título del primer episodio de la Temporada 1: " + temp1.getTitulosEpisodios().get(0));

        // 3. Documental con Investigadores
        System.out.println("\n--- Demostración de Documental e Investigadores ---");
        Documental cosmos = new Documental("Cosmos: A Spacetime Odyssey", 50, "Ciencia", "Astronomía y Física");
        Investigador inv1 = new Investigador("Carl Sagan", "Astrofísica");
        Investigador inv2 = new Investigador("Ann Druyan", "Divulgadora Científica");
        Investigador inv3 = new Investigador("Neil deGrasse Tyson", "Astrofísica");

        cosmos.agregarInvestigador(inv1);
        cosmos.agregarInvestigador(inv2);
        cosmos.agregarInvestigador(inv3);
        cosmos.mostrarDetalles();

        // Demostrar getters y setters para Documental
        System.out.println("Cambiando el tema de 'Cosmos' a 'Universo y Existencia'...");
        cosmos.setTema("Universo y Existencia");
        System.out.println("Nuevo tema de 'Cosmos': " + cosmos.getTema());
        System.out.println("Género de 'Cosmos': " + cosmos.getGenero());

        // --- Nuevas subclases para la Etapa 4 ---
        System.out.println("\n--- Demostración de Nuevas Subclases (Concierto y Podcast) ---");

        // Concierto
        Concierto conciertoRock = new Concierto("Live Aid", 240, "Rock", "Queen", "Wembley Stadium");
        conciertoRock.agregarCancion("Bohemian Rhapsody");
        conciertoRock.agregarCancion("We Are The Champions");
        conciertoRock.mostrarDetalles();
        System.out.println("Cambiando el lugar del concierto a 'Philadelphia, USA'...");
        conciertoRock.setLugar("Philadelphia, USA");
        System.out.println("Nuevo lugar: " + conciertoRock.getLugar());


        // Podcast
        Podcast cienciaAlDia = new Podcast("Ciencia al Día", 30, "Educativo", "Dr. El Saber", 120);
        cienciaAlDia.agregarTema("Física Cuántica");
        cienciaAlDia.agregarTema("Inteligencia Artificial");
        cienciaAlDia.mostrarDetalles();
        System.out.println("Cambiando el host del podcast a 'Profa. Conciencia'...");
        cienciaAlDia.setHost("Profa. Conciencia");
        System.out.println("Nuevo host: " + cienciaAlDia.getHost());

        // Demostración de polimorfismo con un array/lista de ContenidoAudiovisual (incluyendo las nuevas clases)
        System.out.println("\n--- Demostración de Polimorfismo (con todas las subclases) ---");
        List<ContenidoAudiovisual> listaContenidos = new ArrayList<>();
        listaContenidos.add(avatar);
        listaContenidos.add(gameOfThrones);
        listaContenidos.add(cosmos);
        listaContenidos.add(conciertoRock); // Añadir el nuevo Concierto
        listaContenidos.add(cienciaAlDia); // Añadir el nuevo Podcast

        for (ContenidoAudiovisual contenido : listaContenidos) {
            contenido.mostrarDetalles();
        }

        // Demostración de la asignación automática de ID
        System.out.println("\n--- Demostración de IDs ---");
        System.out.println("ID de Avatar: " + avatar.getId());
        System.out.println("ID de Game of Thrones: " + gameOfThrones.getId());
        System.out.println("ID de Cosmos: " + cosmos.getId());
        System.out.println("ID de Live Aid (Concierto): " + conciertoRock.getId());
        System.out.println("ID de Ciencia al Día (Podcast): " + cienciaAlDia.getId());
    }
}