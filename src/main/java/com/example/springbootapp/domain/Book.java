package com.example.springbootapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table (name = "BOOKS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", insertable = false, updatable = false)
    private Integer id;

    @Column(name = "BOOK_TITLE")
    @Size(min = 2, max = 30)
    private String title;

    @Column(name = "BOOK_ISBN")
    private String isbn;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;


    @OneToMany( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Reward> rewards = new ArrayList<>();

}
