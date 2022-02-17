package com.example.springbootapp.controller;

import com.example.springbootapp.domain.Book;
import com.example.springbootapp.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/books", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {

    private final BookService bookService;
    public BookController (BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@Valid @RequestBody Book book) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(bookService.saveBook(book));
    }

    @PostMapping("/list")
    public ResponseEntity<List<Book>> saveBooks( @Valid @RequestBody List<Book> books) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(bookService.saveBooks(books));
    }

    @PostMapping("/{book_id}/author/{author_id}")
    public ResponseEntity<Book> addAuthorToBook (@PathVariable int book_id,@PathVariable int author_id) {
        return  ResponseEntity.status(HttpStatus.CREATED).body(bookService.addAuthorToBook(author_id,book_id));
    }

    @PostMapping("/{book_id}/publisher/{publisher_id}")
    public ResponseEntity<Book> addPublisherToBook (@PathVariable int book_id,@PathVariable int publisher_id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.addPublisherToBook(publisher_id, book_id));
    }

    @PostMapping("/{book_id}/reward/{reward_id}")
    public ResponseEntity<Book> addRewardToBook (@PathVariable int book_id,@PathVariable int reward_id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.addRewardToBook(reward_id,book_id));
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks());
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer id) {
      return ResponseEntity.status(HttpStatus.OK).body(bookService.getBookById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") Integer id,@Valid @RequestBody Book book) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.updateBook(id,book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Book with id + " + id + " deleted");

    }


}
