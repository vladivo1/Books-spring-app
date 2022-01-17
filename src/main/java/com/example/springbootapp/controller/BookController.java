package com.example.springbootapp.controller;

import com.example.springbootapp.domain.Book;
import com.example.springbootapp.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookController {

    private final BookService bookService;
    public BookController (BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/book")
    @ResponseStatus(HttpStatus.CREATED)
    public Book saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Book> saveBooks(@RequestBody List<Book> books) {
        return bookService.saveBooks(books);
    }

    @PostMapping("/book/{book_id}/author/{author_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Book addAuthorToBook (@PathVariable int book_id,@PathVariable int author_id) {
        return bookService.addAuthorToBook(author_id,book_id);
    }

    @PostMapping("/book/{book_id}/publisher/{publisher_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Book addPublisherToBook (@PathVariable int book_id,@PathVariable int publisher_id) {
        return bookService.addPublisherToBook(publisher_id, book_id);
    }

    @PostMapping("/book/{book_id}/reward/{reward_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Book addRewardToBook (@PathVariable int book_id,@PathVariable int reward_id) {
        return bookService.addRewardToBook(reward_id,book_id);
    }

    @GetMapping("/books")
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/book/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBookById(@PathVariable Integer id) {
      return bookService.getBookById(id);
    }

    @PutMapping("/book/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book updateBook(@PathVariable("id") Integer id, @RequestBody Book book) {
        return bookService.updateBook(id,book);
    }

    @DeleteMapping("/book/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteBook(@PathVariable Integer id) {
        return bookService.deleteBook(id);

    }


}
