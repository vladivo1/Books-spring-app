package com.example.springbootapp.controller;


import com.example.springbootapp.domain.Author;
import com.example.springbootapp.domain.Book;
import com.example.springbootapp.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthorController {

    private final AuthorService authorService;
    public AuthorController (AuthorService authorService) {
        this.authorService = authorService;

    }

    @PostMapping("/author")
    @ResponseStatus(HttpStatus.CREATED)
    public Author saveAuthor(@RequestBody Author author) {
        return authorService.saveAuthor(author);
    }

    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Author> saveAuthors (@RequestBody List<Author> authors) {
        return authorService.saveAuthors(authors);
    }

    @PostMapping("/author/{id}/book")
        @ResponseStatus(HttpStatus.CREATED)
        public Author addBook (@PathVariable ("id") Integer id, @RequestBody Book book) {
            return authorService.addBook(id,book);
    }

    @GetMapping("/authors")
    @ResponseStatus(HttpStatus.OK)
    public List <Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/author/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author getAuthorById(@PathVariable Integer id) {
      return authorService.getAuthorById(id);
    }
    @GetMapping("/author/birthday/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String getAuthorBirthdayById(@PathVariable Integer id) {
        return authorService.getAuthorDateOfBirthdayById(id);
    }

    @PutMapping  ("/author/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author updateAuthor(@PathVariable("id") Integer id, @RequestBody Author author) {
         return authorService.updateAuthor(id, author);
    }

    @DeleteMapping("/author/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteAuthor(@PathVariable Integer id) {
        return authorService.deleteAuthor(id);


    }

}
