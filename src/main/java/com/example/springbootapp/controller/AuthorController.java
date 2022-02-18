package com.example.springbootapp.controller;

import com.example.springbootapp.domain.Author;
import com.example.springbootapp.domain.Book;
import com.example.springbootapp.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/authors", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthorController {

    private final AuthorService authorService;
    public AuthorController (AuthorService authorService) {
        this.authorService = authorService;

    }

    @PostMapping()
    public ResponseEntity<Author> saveAuthor(@Valid @RequestBody Author author)  {
        authorService.saveAuthor(author);
        return ResponseEntity.status(HttpStatus.CREATED).body(author);
    }

    @PostMapping("/list")
    public ResponseEntity<List<Author>> saveAuthors (@Valid @RequestBody List<Author> authors) {
        authorService.saveAuthors(authors);
        return ResponseEntity.status(HttpStatus.CREATED).body(authors);
    }

    @PostMapping("/{id}/book")
        public ResponseEntity<Author> addBook (@PathVariable ("id") Integer id, @Valid @RequestBody Book book) {
            Author author = authorService.addBook(id,book);
            return ResponseEntity.status(HttpStatus.OK).body(author);
    }

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors() {
        return ResponseEntity.status(HttpStatus.OK).body(authorService.getAllAuthors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Integer id) {
      return ResponseEntity.status(HttpStatus.OK).body(authorService.getAuthorById(id));
    }

    @GetMapping("/birthday/{id}")
    public ResponseEntity<String> getAuthorBirthdayById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(authorService.getAuthorAndDateOfBirthdayById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable("id") Integer id, @Valid @RequestBody Author author) {
         return ResponseEntity.status(HttpStatus.OK).body(authorService.updateAuthor(id, author));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable Integer id) {
        authorService.deleteAuthor(id);
       return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Author with id " + id + " deleted");

    }

}
