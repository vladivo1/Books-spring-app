package com.example.springbootapp.repository;

import com.example.springbootapp.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository  extends JpaRepository<Author, Integer> {

    @Query (value = "SELECT a.firstName, a.lastName, a.birthDate" +
            " FROM Author a WHERE a.id = ?1")
     String findAuthorAndDateOfBirthById (int id);
}
