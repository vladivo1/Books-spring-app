package com.example.springbootapp.service;

import com.example.springbootapp.domain.Author;
import com.example.springbootapp.domain.Book;
import com.example.springbootapp.domain.Publisher;
import com.example.springbootapp.repository.AuthorRepository;
import com.example.springbootapp.repository.BookRepository;
import com.example.springbootapp.repository.PublisherRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BookService (BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    private Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> saveBooks (List<Book> books) {
        return bookRepository.saveAll(books);
    }

    public List<Book> getAllBooks () {
        return bookRepository.findAll();
    }

    public Book getBookById (int id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book with this id " + id + "not found"));

    }

    public  Book updateBook (Book book) {
        Book updatedBook = bookRepository.getById(book.getId());
        updatedBook.setAuthor(book.getAuthor());
        updatedBook.setTitle(book.getTitle());
        updatedBook.setIsbn(book.getIsbn());
        return bookRepository.save(book);
    }

    public String deleteBook(int id){
        bookRepository.deleteById(id);
        return "Book with id " + id + " was deleted";
    }

    public Book addBookToAuthor (int authorId, int bookId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        Author author = authorRepository.findById(authorId).orElse(null);
        book.assignAuthor(author);
        return bookRepository.save(book);
    }

    public Book addBookToPublisher(int publisherId, int bookId) {
        Book book = bookRepository.findById(bookId).orElse(null);
        Publisher publisher = publisherRepository.findById(publisherId).orElse(null);
        book.assignPublisher(publisher);
        return bookRepository.save(book);
    }
}
