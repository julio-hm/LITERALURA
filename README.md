LiterAlura - Catálogo de Libros
Descripción
LiterAlura es una aplicación diseñada para crear y gestionar un catálogo de libros. Este proyecto combina tecnologías de desarrollo backend para realizar solicitudes a una API de libros, manipular datos JSON, almacenarlos en una base de datos PostgreSQL y proporcionar un sistema de interacción textual para explorar libros y autores.

Funcionalidades principales
Búsqueda de libros por título utilizando la API de Gutendex.
Listado de libros por género literario e idioma.
Listado de autores, con opción de filtrar autores vivos en un año específico.
Persistencia de datos de libros y autores en PostgreSQL.
Estadísticas sobre el catálogo, como libros más buscados y cantidad de libros por idioma.
Requisitos del sistema
Java JDK : Versión 17 o superior.
Maven : Versión 4 o superior.
Spring Boot : Versión 3.2.3.
PostgreSQL : Versión 16 o superior.
IDE recomendado : IntelliJ IDEA.

Ejecución del proyecto
Iniciar la aplicación:
Siga las instrucciones en la consola para interactuar con el sistema:
Buscar libros por título.
Listar libros por idioma o género.
Consultar autores vivos en un año específico.
Tecnologías utilizadas
Java : lenguaje principal.
Spring Boot : Framework para la construcción del backend.
PostgreSQL : Base de datos para almacenar libros y autores.
Gutendex API : Fuente de datos de libros y autores.
Jackson : Procesamiento de datos JSON.
Estructura del proyecto
src/
├── main/
│   ├── java/com/desafio/literalura/
│   │   ├── config/          # Configuración (ApiConfig.java)
│   │   ├── controller/      # Controladores (LiterAluraController.java)
│   │   ├── model/           # Modelos de datos (Book.java, Author.java)
│   │   ├── repository/      # Repositorios JPA (BookRepository.java, AuthorRepository.java)
│   │   ├── service/         # Servicios de negocio (BookService.java, AuthorService.java)
│   │   └── LiterAluraApplication.java
│   └── resources/
│       ├── application.properties
│       └── templates/
└── test/
Recursos adicionales
API Gutendex :
Documentación: Gutendex
PostgreSQL :
Descarga: PostgreSQL
Contribuciones
Las contribuciones son bienvenidas. Para colaborar:
¡Gracias por usar LiterAlura! 🚀
