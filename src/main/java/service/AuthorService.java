package com.desafio.literalura.service;

import com.desafio.literalura.model.Author;
import com.desafio.literalura.model.Book;
import com.desafio.literalura.repository.AuthorRepository;
import com.desafio.literalura.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @Transactional(readOnly = true)
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Author> getAuthorsAliveInYear(int year) {
        return authorRepository.findAll().stream()
                .filter(author -> (author.getBirthYear() == null || author.getBirthYear() <= year) &&
                        (author.getDeathYear() == null || author.getDeathYear() >= year))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<Author> getAuthorsByBookGenre(String genre) {
        List<Book> books = bookService.getBooksByGenre(genre);
        return books.stream()
                .map(Book::getAuthor)
                .filter(author -> author != null)
                .distinct()
                .collect(Collectors.toList());
    }
}