package com.example.springbootapp.service;

import com.example.springbootapp.domain.Author;
import com.example.springbootapp.domain.Book;
import com.example.springbootapp.repository.AuthorRepository;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    
    public void saveAuthor(Author author)  {
        authorRepository.save(author);
    }

    public void saveAuthors(List<Author> authors) {
        authorRepository.saveAll(authors);
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author addBook(Integer id, Book book) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Author with id " + id + " not found"));
        author.getBooks().add(book);
        book.setAuthor(author);
        return authorRepository.save(author);
    }

    public Author getAuthorById(Integer id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Author with id " + id + " not found"));
    }

    public String getAuthorAndDateOfBirthdayById(Integer id) {
        if (authorRepository.findById(id).isPresent())
        return authorRepository.findAuthorAndDateOfBirthById(id);
        else
            throw new EntityNotFoundException("Author with id" + id + " not found");
    }

    public Author updateAuthor(Integer id, Author author) {
        return authorRepository.findById(id)
                .map(entity -> {
                    entity.setFirstName(author.getFirstName());
                    entity.setLastName(author.getLastName());
                    entity.setBirthDate(author.getBirthDate());
                    entity.setEmail(author.getEmail());
                    entity.setSex(author.getSex());
                    return authorRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Author not found with id = " + id));
    }

     public void deleteAuthor(Integer id) {
        if (authorRepository.findById(id).isPresent())
          authorRepository.deleteById(id);
        else
            throw new EntityNotFoundException("Author not found with id = " + id);
     }

}
