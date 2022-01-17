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
public class PublisherService {

    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final RewardRepository rewardRepository;

    public PublisherService (PublisherRepository publisherRepository, AuthorRepository authorRepository,
                             BookRepository bookRepository, RewardRepository rewardRepository) {
        this.publisherRepository = publisherRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.rewardRepository = rewardRepository;
    }

    public Publisher savePublisher( Publisher publisher) {
         return publisherRepository.save(publisher);
    }

    public List<Publisher> saveAllPublishers(List<Publisher> publishers){
        return publisherRepository.saveAll(publishers);
    }

//    public Publisher addAuthorToPublisher (Integer author_id, Integer publisher_id) {
//         Publisher publisher = publisherRepository.findById(publisher_id)
//                .orElseThrow(() -> new EntityNotFoundException("Publisher with id " + " not found"));
//        Author author = authorRepository.findById(author_id)
//                .orElseThrow(() -> new EntityNotFoundException("Author with id " + " not found"));
//       publisher.getAuthorList().add(author);
//       return publisherRepository.save(publisher);
//    }
//
//    public Publisher addBookToPublisher (Integer book_id, Integer publisher_id) {
//        Book book = bookRepository.findById(book_id)
//                .orElseThrow(() -> new EntityNotFoundException("Publisher with id " + " not found"));
//        Publisher publisher = publisherRepository.findById(publisher_id)
//                .orElseThrow(() -> new EntityNotFoundException("Author with id " + " not found"));
//        publisher.getBookList().add(book);
//        return publisherRepository.save(publisher);
//    }
//
//    public Publisher addRewardToPublisher (Integer reward_id, Integer publisher_id) {
//        Reward reward = rewardRepository.findById(reward_id)
//                .orElseThrow(() -> new EntityNotFoundException("Publisher with id " + " not found"));
//        Publisher publisher = publisherRepository.findById(publisher_id)
//                .orElseThrow(() -> new EntityNotFoundException("Author with id " + " not found"));
//        publisher.getRewardList().add(reward);
//        return publisherRepository.save(publisher);
//    }

    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    public Publisher getPublisherById(Integer id) {
        return publisherRepository.findById(id).orElse(null);
    }

    public Publisher updatePublisher(Integer id, Publisher publisher) {
        return publisherRepository.findById(id)
                .map (entity -> {
                    entity.setName(publisher.getName());
                    entity.setCountry(publisher.getCountry());
                    entity.setAddress(publisher.getAddress());
                    return publisherRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id = " + id));
    }

    public String deletePublisher(Integer id) {
        publisherRepository.deleteById(id);
        return "Publisher with id " + id + " was deleted";
    }
}
