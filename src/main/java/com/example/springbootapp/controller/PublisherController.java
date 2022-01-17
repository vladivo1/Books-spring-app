package com.example.springbootapp.controller;

import com.example.springbootapp.domain.Publisher;
import com.example.springbootapp.service.PublisherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class PublisherController {

    private final PublisherService publisherService;
    public PublisherController (PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @PostMapping("/publisher")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher savePublisher (@RequestBody Publisher publisher) {
        return publisherService.savePublisher(publisher);
    }

    @PostMapping("/publishers")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Publisher> saveAllPublishers (@RequestBody List<Publisher> publishers) {
        return publisherService.saveAllPublishers(publishers);
    }

    @PostMapping("/publisher/{publisher_id}/author/{author_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher addAuthorToPublisher(@PathVariable Integer publisher_id,@PathVariable Integer author_id) {
        return publisherService.addAuthorToPublisher(publisher_id,author_id);
    }

    @PostMapping("/publisher/{publisher_id}/book/{book_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher addBookToPublisher(@PathVariable Integer publisher_id,@PathVariable Integer book_id) {
        return publisherService.addBookToPublisher(publisher_id,book_id);
    }

    @PostMapping("/publisher/{publisher_id}/reward/{reward_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher addRewardToPublisher(@PathVariable Integer publisher_id,@PathVariable Integer reward_id) {
        return publisherService.addRewardToPublisher(publisher_id,reward_id);
    }

    @GetMapping("/publisher")
    @ResponseStatus(HttpStatus.OK)
    public List<Publisher> getAllPublishers () {
        return publisherService.getAllPublishers();
    }

    @GetMapping("/publisher/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Publisher getPublisherById (@PathVariable ("id") Integer id) {
        return publisherService.getPublisherById(id);
    }

    @PutMapping("/publisher/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Publisher updatePublisher (@PathVariable ("id") Integer id, @RequestBody Publisher publisher) {
        return publisherService.updatePublisher(id,publisher);
    }

    @DeleteMapping("/publisher/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deletePublisher (@PathVariable("id") Integer id) {
        return publisherService.deletePublisher(id);
    }
}
