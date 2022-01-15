package com.example.springbootapp.controller;

import com.example.springbootapp.domain.Book;
import com.example.springbootapp.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {

    private final BookRepository bookRepository;
    public BookController (BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping("/book")
    @ResponseStatus(HttpStatus.CREATED)
    public Book saveBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @GetMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/book/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBookById(@PathVariable Integer id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book with id" + id + "not found"));
        return book;
    }

    @PutMapping("/book/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book updateBook(@PathVariable("id") Integer id, @RequestBody Book book) {

        return bookRepository.findById(id)
                .map (entity -> {
                    entity.setIsbn(book.getIsbn());
                    entity.setTitle(book.getTitle());
                    return bookRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id = " + id));
    }

    @DeleteMapping("/book/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Integer id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book with id" + id + "not found"));
        bookRepository.delete(book);
    }

    @DeleteMapping("/books")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllBooks(){
        bookRepository.deleteAll();
    }

}
