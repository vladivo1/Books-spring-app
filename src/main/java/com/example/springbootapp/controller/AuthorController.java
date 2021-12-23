package com.example.springbootapp.controller;


import com.example.springbootapp.domain.Author;
import com.example.springbootapp.repository.AuthorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthorController {

    private final AuthorRepository authorRepository;
    public AuthorController (AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @PostMapping("/saveAuthor")
    @ResponseStatus(HttpStatus.CREATED)
    public Author saveAuthor(@RequestBody Author author) {
        return authorRepository.save(author);
    }

    @GetMapping("/getAllAuthors")
    @ResponseStatus(HttpStatus.OK)
    public List <Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @GetMapping("/getAuthorById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author getAuthorById(@PathVariable Integer id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Author with id" + id + "not found"));
        return author;
    }

    @PutMapping("/updateAuthor/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author updateAuthor(@PathVariable("id") Integer id, @RequestBody Author author) {

        return authorRepository.findById(id)
                .map (entity -> {
                    entity.setFirstName(author.getFirstName());
                    entity.setLastName(author.getLastName());
                    entity.setBirthDate(author.getBirthDate());
                    entity.setSex(author.getSex());
                    return authorRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Author not found with id = " + id));
    }

    @DeleteMapping("/deleteAuthor/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable Integer id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Author with id" + id + "not found"));
        authorRepository.delete(author);
    }

    @DeleteMapping("/deleteAllAuthors")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllAuthors(){
        authorRepository.deleteAll();
    }
}
