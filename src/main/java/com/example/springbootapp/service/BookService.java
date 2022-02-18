package com.example.springbootapp.service;

import com.example.springbootapp.domain.Author;
import com.example.springbootapp.domain.Book;
import com.example.springbootapp.domain.Publisher;
import com.example.springbootapp.domain.Reward;
import com.example.springbootapp.repository.AuthorRepository;
import com.example.springbootapp.repository.BookRepository;
import com.example.springbootapp.repository.PublisherRepository;
import com.example.springbootapp.repository.RewardRepository;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;
    private final RewardRepository rewardRepository;

    public BookService (BookRepository bookRepository, AuthorRepository authorRepository,
                        PublisherRepository publisherRepository,RewardRepository rewardRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
        this.rewardRepository = rewardRepository;
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> saveBooks (List<Book> books) {
        return bookRepository.saveAll(books);
    }

    public List<Book> getAllBooks () {
        return bookRepository.findAll();
    }

    public Book getBookById (Integer id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book with this id " + id + "not found"));

    }

    public  Book updateBook (Integer id, Book book) {
        return bookRepository.findById(id)
                .map (entity -> {
                    entity.setIsbn(book.getIsbn());
                    entity.setTitle(book.getTitle());
                    return bookRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id = " + id));
    }

    public void deleteBook(Integer id){
        bookRepository.deleteById(id);
    }

    public Book addAuthorToBook (Integer authorId, Integer bookId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        Author author = authorRepository.findById(authorId).orElse(null);
        book.setAuthor(author);
        return bookRepository.save(book);
    }

    public Book addPublisherToBook(Integer publisherId, Integer bookId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        Publisher publisher = publisherRepository.findById(publisherId).orElse(null);
        book.setPublisher(publisher);
        return bookRepository.save(book);
    }

    public Book addRewardToBook (Integer rewardId, Integer bookId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        Reward reward = rewardRepository.findById(rewardId).orElse(null);
        book.getRewards().add(reward);
        return bookRepository.save(book);
    }
}
