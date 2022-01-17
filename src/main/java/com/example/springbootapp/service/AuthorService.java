package com.example.springbootapp.service;

import com.example.springbootapp.domain.Author;
import com.example.springbootapp.domain.Book;
import com.example.springbootapp.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    public List<Author> saveAuthors(List<Author> authors) {
        return authorRepository.saveAll(authors);
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author addBook(Integer id, Book book) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Author with id " + id + "not found"));
        author.getBooks().add(book);
//        book.setAuthor(author);
        return authorRepository.save(author);
    }

    public Author getAuthorById(Integer id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Author with id " + id + "not found"));
    }

    public Author updateAuthor(Integer id, Author author) {
        return authorRepository.findById(id)
                .map(entity -> {
                    entity.setFirstName(author.getFirstName());
                    entity.setLastName(author.getLastName());
                    entity.setBirthDate(author.getBirthDate());
                    entity.setSex(author.getSex());
                    return authorRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Author not found with id = " + id));
    }

     public String deleteAuthor(Integer id) {
        authorRepository.deleteById(id);
        return "Author with id + " + id + "was deleted";
    }

}
