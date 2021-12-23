package com.example.springbootapp.repository;

import com.example.springbootapp.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository  extends JpaRepository<Author, Integer> {
}
