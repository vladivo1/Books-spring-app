package com.example.springbootapp.service;

import com.example.springbootapp.domain.Publisher;
import com.example.springbootapp.repository.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;
    public PublisherService (PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public Publisher savePublisher( Publisher publisher) {
         return publisherRepository.save(publisher);
    }

    public List<Publisher> saveAllPublishers(List<Publisher> publishers){
        return publisherRepository.saveAll(publishers);
    }

    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    public Publisher getPublisherById(int id) {
        return publisherRepository.findById(id).orElse(null);
    }

    public Publisher updatePublisher(Publisher publisher) {
        Publisher updatedPublisher = publisherRepository.findById(publisher.getId()).orElse(null);
        updatedPublisher.setName(publisher.getName());
        updatedPublisher.setCountry(publisher.getCountry());
        updatedPublisher.setAddress(publisher.getAddress());
        return publisherRepository.save(updatedPublisher);
    }

    public String deletePublisher(int id) {
        publisherRepository.deleteById(id);
        return "Publisher with id " + id + " was deleted";
    }
}
