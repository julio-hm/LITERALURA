### LiterAlura - Catálogo de Libros  

---  

## 📖 Descripción  
**LiterAlura** es una aplicación que permite explorar y gestionar un catálogo de libros utilizando datos de la API de **Gutendex**. Con esta herramienta, los usuarios pueden buscar libros, listar autores, consultar estadísticas y almacenar información en una base de datos **PostgreSQL**.  

## 🛠️ Funcionalidades  
- Búsqueda de libros por título.  
- Listado de libros por género literario.  
- Listado de autores y filtrado por año de vida.  
- Persistencia de datos en PostgreSQL.  
- Estadísticas de cantidad de libros por idioma y libros más buscados.  

## 🚀 Tecnologías utilizadas  
- **Java 17+**  
- **Spring Boot 3.2.3**  
- **PostgreSQL 16+**  
- **Maven 4+**  
- **Jackson** para manipulación de JSON.  

## 📂 Estructura del proyecto  
```
src/  
├── main/  
│   ├── java/com/desafio/literalura/  
│   │   ├── config/          # Configuración general (ApiConfig.java)  
│   │   ├── controller/      # Controladores (LiterAluraController.java)  
│   │   ├── model/           # Modelos de datos (Book.java, Author.java)  
│   │   ├── repository/      # Repositorios JPA (BookRepository.java, AuthorRepository.java)  
│   │   ├── service/         # Lógica de negocio (BookService.java, AuthorService.java)  
│   │   └── LiterAluraApplication.java  
│   └── resources/  
│       ├── application.properties  
│       └── templates/  
└── test/  
```  

## 🔧 Instalación y configuración  
1. Clonar el repositorio:  
   ```bash  
   git clone https://github.com/usuario/literalura.git  
   cd literalura  
   ```  
2. Configurar la base de datos en el archivo `application.properties`:  
   ```properties  
   spring.datasource.url=jdbc:postgresql://<DB_HOST>/<DB_NAME>  
   spring.datasource.username=<DB_USER>  
   spring.datasource.password=<DB_PASSWORD>  
   spring.jpa.hibernate.ddl-auto=update  
   ```  
3. Instalar dependencias:  
   ```bash  
   mvn install  
   ```  
4. Ejecutar la aplicación:  
   ```bash  
   mvn spring-boot:run  
   ```  

## 📝 Uso  
Al iniciar la aplicación, se presentará un menú interactivo en la consola con opciones como:  
1. Buscar libros por título.  
2. Listar libros por género literario.  
3. Listar autores vivos en un año específico.  
4. Mostrar cantidad de libros por idioma.  

## 🌐 Recursos adicionales  
- **API Gutendex**: [Documentación oficial](https://gutendex.com/)  
- **PostgreSQL**: [Descarga aquí](https://www.postgresql.org/download/)  

## 🤝 Contribuciones  
¡Todas las contribuciones son bienvenidas! Sigue estos pasos:  
1. Haz un *fork* del proyecto.  
2. Crea una rama para tus cambios:  
   ```bash  
   git checkout -b mi-nueva-funcionalidad  
   ```  
3. Realiza un *commit* con tus cambios:  
   ```bash  
   git commit -m "Añadí una nueva funcionalidad"  
   ```  
4. Haz un *push* a la rama:  
   ```bash  
   git push origin mi-nueva-funcionalidad  
   ```  
5. Envía un *pull request*.  

---  
¡Gracias por usar LiterAlura! 🚀
