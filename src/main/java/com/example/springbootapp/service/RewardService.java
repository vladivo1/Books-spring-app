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
public class RewardService {

    private final RewardRepository rewardRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public RewardService (RewardRepository rewardRepository, AuthorRepository authorRepository, BookRepository bookRepository,
    PublisherRepository publisherRepository) {
        this.rewardRepository = rewardRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    public Reward saveReward (Reward reward) {
        return  rewardRepository.save(reward);
    }

    public List<Reward> saveAllRewards(List<Reward> rewards) {
        return  rewardRepository.saveAll(rewards);
    }

    public List<Reward> getAllRewards() {
        return rewardRepository.findAll();
    }

    public Reward getRewardById(int id) {
        return rewardRepository.findById(id).orElse(null);

    }

    public Reward updateReward (Integer id, Reward reward) {
        return rewardRepository.findById(id)
                .map (entity -> {
                    entity.setTitle(reward.getTitle());
                    entity.setYear(reward.getYear());
                    return rewardRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Reward not found with id = " + id));
    }


    public String deleteReward(int id) {
        rewardRepository.deleteById(id);
        return "Reward with " + id + " was deleted";
    }

//    public Reward addAuthorToReward(int authorId, int rewardId) {
//        Reward reward = rewardRepository.findById(rewardId).orElse(null);
//        Author author = authorRepository.findById(authorId).orElse(null);
//        reward.setAuthor(author);
//        return rewardRepository.save(reward);
//    }
//
//    public Reward addBookToReward(int bookId, int rewardId) {
//        Reward reward = rewardRepository.findById(rewardId).orElse(null);
//        Book book = bookRepository.findById(bookId).orElse(null);
//        reward.setBook(book);
//        return rewardRepository.save(reward);
//    }
//
//    public Reward addPublisherToReward(int publisherId, int rewardId) {
//        Reward reward = rewardRepository.findById(rewardId).orElse(null);
//        Publisher publisher = publisherRepository.findById(publisherId).orElse(null);
//        reward.setPublisher(publisher);
//        return rewardRepository.save(reward);
//
//    }
}
