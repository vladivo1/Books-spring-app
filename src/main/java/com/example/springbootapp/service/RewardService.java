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
        return rewardRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reward with id " + id + " not found"));

    }

    public Reward updateReward (Integer id, Reward reward) {
        return rewardRepository.findById(id)
                .map (entity -> {
                    entity.setTitle(reward.getTitle());
                    entity.setDate(reward.getDate());
                    return rewardRepository.save(entity);
                })
                .orElseThrow(() -> new EntityNotFoundException("Reward not found with id  " + id));
    }

    public void deleteReward(int id) {
        if (rewardRepository.findById(id).isPresent())
             rewardRepository.deleteById(id);
        else
            throw new EntityNotFoundException("Reward not found with id = " + id);
    }

    public Reward addAuthorToReward(int authorId, int rewardId) {
        Reward reward = rewardRepository.findById(rewardId)
                .orElseThrow(() -> new EntityNotFoundException("Reward with id " + rewardId + " not found"));
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new EntityNotFoundException("Author with id " + authorId + " not found"));
        reward.setAuthor(author);
        author.getRewards().add(reward);
        return rewardRepository.save(reward);
    }

    public Reward addBookToReward(int bookId, int rewardId) {
        Reward reward = rewardRepository.findById(rewardId)
                .orElseThrow(() -> new EntityNotFoundException("Reward with id " + rewardId + " not found"));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("Book with id " + bookId + " not found"));
        reward.setBook(book);
        book.getRewards().add(reward);
        return rewardRepository.save(reward);
    }

    public Reward addPublisherToReward(int publisherId, int rewardId) {
        Reward reward = rewardRepository.findById(rewardId)
                .orElseThrow(() -> new EntityNotFoundException("Reward with id " + rewardId + " not found"));
        Publisher publisher = publisherRepository.findById(publisherId)
                .orElseThrow(() -> new EntityNotFoundException("Publisher with id " + publisherId + " not found"));
        reward.setPublisher(publisher);
        publisher.getRewardList().add(reward);
        return rewardRepository.save(reward);

    }
}
