# Proyecto de Gestión de Contenidos Audiovisuales

Este proyecto es un sistema de gestión de contenidos audiovisuales desarrollado en Java, que utiliza la Programación Orientada a Objetos (POO) para modelar diferentes tipos de contenidos y sus relaciones.

Originalmente enfocado en la modelación de clases, el proyecto ha sido ampliado para incluir **persistencia de datos**, permitiendo guardar el estado del sistema en archivos y cargarlo posteriormente. Además, se ha realizado una refactorización para aplicar principios de **código limpio**, mejorando la legibilidad, mantenibilidad y escalabilidad del sistema.

## Estructura del Proyecto

El proyecto está organizado en paquetes para una clara separación de responsabilidades:

*   **`uni1a`**: Contiene las clases del **modelo de datos**.
    *   `ContenidoAudiovisual` (Clase base abstracta)
    *   `Pelicula`, `SerieDeTV`, `Documental`, `Concierto`, `Podcast` (Clases heredadas)
    *   `Actor`, `Temporada`, `Investigador` (Clases de apoyo para las relaciones)
*   **`poo`**: Contiene las clases de **lógica y ejecución**.
    *   `PruebaAudioVisual`: Clase principal para la ejecución y demostración del sistema.
    *   `GestorArchivos` (NUEVA): Clase de utilidad responsable de toda la lógica de lectura y escritura de archivos.

## Funcionalidades Clave

### 1. Modelo de Datos Orientado a Objetos
El sistema utiliza herencia, polimorfismo y composición para modelar las entidades:
*   Una clase `ContenidoAudiovisual` abstracta define la base para todos los contenidos.
*   Clases como `Pelicula`, `SerieDeTV`, etc., heredan de ella y añaden atributos y comportamientos específicos.
*   Las relaciones de agregación y asociación se usan para vincular contenidos con otras entidades (ej. `Pelicula` con `Actor`, `SerieDeTV` con `Temporada`).

### 2. Persistencia de Datos con Archivos CSV (NUEVO)
Para que la información no se pierda al cerrar el programa, se ha implementado un sistema de guardado y carga de datos.
*   **Escritura a CSV**: Cada objeto del modelo puede convertirse a una línea en formato CSV (`toCsvString()`). Las relaciones complejas (como una lista de actores) se serializan utilizando un delimitador secundario (`;`).
*   **Lectura desde CSV**: Cada clase del modelo tiene un constructor que puede recibir una línea CSV y reconstruir el objeto con sus datos y relaciones.
*   **Gestor Centralizado**: La clase `GestorArchivos` se encarga de orquestar el proceso, leyendo un archivo línea por línea, identificando el tipo de contenido y usando el constructor adecuado para instanciar el objeto correcto.

### 3. Principios de Código Limpio Aplicados (Refactorización)
Se ha mejorado la calidad del código aplicando los siguientes principios:
*   **Nombres Claros**: Se han renombrado variables (ej. `contar` a `siguienteId`) para que su propósito sea autoevidente.
*   **Separación de Responsabilidades**: La lógica de persistencia se ha extraído a la clase `GestorArchivos`, dejando las clases del modelo enfocadas en representar datos y las clases de prueba en demostrar la funcionalidad.
*   **Constructores Específicos**: Se crearon constructores dedicados para la carga desde archivos, lo que evita la mezcla de lógicas y previene errores de inicialización de IDs.

## Clases y Relaciones (Actualizado)

*   **`ContenidoAudiovisual` (Abstracta)**: Ahora incluye un constructor para cargar objetos con un ID preexistente desde un archivo y declara el método abstracto `toCsvString()`.
*   **`Pelicula`**, **`SerieDeTV`**, **`Documental`**, **`Concierto`**, **`Podcast`**: Implementan `toCsvString()` y tienen un nuevo constructor para instanciarse desde una línea CSV, manejando la reconstrucción de sus listas de objetos asociados (`Actor`, `Temporada`, etc.).
*   **`Actor`**, **`Temporada`**, **`Investigador`**: También han sido adaptadas para ser serializables a y desde una cadena de texto, facilitando su almacenamiento como parte de un objeto contenedor.

## Diagrama de Clases

Se ha actualizado el diagrama de clases para reflejar el estado actual del proyecto, incluyendo las nuevas clases y sus relaciones.