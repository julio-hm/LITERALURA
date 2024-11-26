package com.desafio.literalura.controller;

import com.desafio.literalura.model.Book;
import com.desafio.literalura.model.Author;
import com.desafio.literalura.service.BookService;
import com.desafio.literalura.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Controller
public class LiterAluraController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    private Scanner scanner = new Scanner(System.in);

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "Bienvenido a LiterAlura";
    }

    @PostMapping("/interact")
    @ResponseBody
    public String interact() {
        while (true) {
            System.out.println("\nBienvenido a LiterAlura. Elige una opción:");
            System.out.println("1. Buscar libros por título");
            System.out.println("2. Listar libros por género literario");
            System.out.println("3. Listar autores por género literario");
            System.out.println("4. Listar autores vivos en un año específico");
            System.out.println("5. Mostrar cantidad de libros por idioma");
            System.out.println("6. Libros más buscados");
            System.out.println("7. Salir");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    searchBookByTitle();
                    break;
                case 2:
                    listBooksByGenre();
                    break;
                case 3:
                    listAuthorsByGenre();
                    break;
                case 4:
                    listAuthorsAliveInYear();
                    break;
                case 5:
                    showBookCountByLanguage();
                    break;
                case 6:
                    showMostSearchedBooks();
                    break;
                case 7:
                    return "Gracias por usar LiterAlura. ¡Hasta pronto!";
                default:
                    System.out.println("Opción no válida. Por favor, intenta de nuevo.");
            }
        }
    }

    private void searchBookByTitle() {
        System.out.println("Introduce el título del libro:");
        String title = scanner.nextLine();
        Book book = bookService.searchBookByTitle(title);
        if (book != null) {
            System.out.println("Nombre del libro: " + book.getTitle());
            System.out.println("Autor: " + (book.getAuthor() != null ? book.getAuthor().getName() : "Desconocido"));
            System.out.println("Género literario: " + book.getGenre());
            System.out.println("Idiomas: " + String.join(", ", book.getLanguages()));
            bookService.incrementSearchCount(book);
        } else {
            System.out.println("No se encontró el libro.");
        }
    }

    private void listBooksByGenre() {
        System.out.println("Introduce el género literario:");
        String genre = scanner.nextLine();
        List<String> bookTitles = bookService.getBookTitlesByGenre(genre);
        if (!bookTitles.isEmpty()) {
            System.out.println("Libros encontrados:");
            bookTitles.forEach(System.out::println);
        } else {
            System.out.println("No se encontraron libros para el género especificado.");
        }
    }

    private void listAuthorsByGenre() {
        System.out.println("Introduce el género literario:");
        String genre = scanner.nextLine();
        List<Author> authors = authorService.getAuthorsByBookGenre(genre);
        if (!authors.isEmpty()) {
            System.out.println("Autores encontrados:");
            authors.forEach(author -> System.out.println(author.getName()));
        } else {
            System.out.println("No se encontraron autores para el género especificado.");
        }
    }

    private void listAuthorsAliveInYear() {
        System.out.println("Introduce el año:");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        List<Author> authors = authorService.getAuthorsAliveInYear(year);
        if (!authors.isEmpty()) {
            System.out.println("Autores vivos en el año " + year + ":");
            for (Author author : authors) {
                System.out.println(author.getName() + " (Nacimiento: " + author.getBirthYear() +
                        ", Fallecimiento: " + (author.getDeathYear() != null ? author.getDeathYear() : "N/A") + ")");
            }
        } else {
            System.out.println("No se encontraron autores vivos en el año especificado.");
        }
    }

    private void showBookCountByLanguage() {
        System.out.println("Introduce el código de idioma (ej. en, es):");
        String language = scanner.nextLine().toLowerCase();
        Map<String, Long> bookCount = bookService.getBookCountByLanguage(language);
        if (!bookCount.isEmpty()) {
            System.out.println("Cantidad de libros en " + language + ": " + bookCount.get(language));
        } else {
            System.out.println("No se encontró información para el idioma especificado.");
        }
    }

    private void showMostSearchedBooks() {
        System.out.println("Introduce el número de libros a mostrar:");
        int limit = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        List<Book> mostSearchedBooks = bookService.getMostSearchedBooks(limit);
        if (!mostSearchedBooks.isEmpty()) {
            System.out.println("Los libros más buscados son:");
            for (Book book : mostSearchedBooks) {
                System.out.println(book.getTitle() + " - Búsquedas: " + book.getSearchCount());
            }
        } else {
            System.out.println("No hay información de libros buscados.");
        }
    }
}