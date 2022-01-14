package com.example.springbootapp.controller;

import com.example.springbootapp.repository.PublisherRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class PublisherController {

    private final PublisherRepository publisherRepository;
    public PublisherController (PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }
}
