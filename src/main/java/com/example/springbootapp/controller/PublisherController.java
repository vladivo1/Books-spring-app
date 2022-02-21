package com.example.springbootapp.controller;

import com.example.springbootapp.domain.Publisher;
import com.example.springbootapp.service.PublisherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/publishers", produces = MediaType.APPLICATION_JSON_VALUE)
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @PostMapping
    public ResponseEntity<Publisher> savePublisher(@Valid @RequestBody Publisher publisher) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(publisherService.savePublisher(publisher));
    }

    @PostMapping("/list")
    public ResponseEntity<List<Publisher>> saveAllPublishers(@Valid @RequestBody List<Publisher> publishers) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(publisherService.saveAllPublishers(publishers));
    }

    @PostMapping("/{publisher_id}/author/{author_id}")
    public ResponseEntity<Publisher> addAuthorToPublisher(@PathVariable Integer publisher_id, @PathVariable Integer author_id) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(publisherService.addAuthorToPublisher(publisher_id, author_id));
    }

    @PostMapping("/{publisher_id}/book/{book_id}")
    public ResponseEntity<Publisher> addBookToPublisher(@PathVariable Integer publisher_id, @PathVariable Integer book_id) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(publisherService.addBookToPublisher(publisher_id, book_id));
    }

    @PostMapping("/{publisher_id}/reward/{reward_id}")
    public ResponseEntity<Publisher> addRewardToPublisher(@PathVariable Integer publisher_id, @PathVariable Integer reward_id) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(publisherService.addRewardToPublisher(publisher_id, reward_id));
    }

    @GetMapping
    public ResponseEntity<List<Publisher>> getAllPublishers() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(publisherService.getAllPublishers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Publisher> getPublisherById(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(publisherService.getPublisherById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Publisher> updatePublisher(@PathVariable("id") Integer id, @Valid @RequestBody Publisher publisher) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(publisherService.updatePublisher(id, publisher));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePublisher(@PathVariable("id") Integer id) {
        publisherService.deletePublisher(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body("Publisher with id " + id + " deleted");
    }
}
