package com.example.springbootapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", insertable = false, updatable = false)
    private Integer id;

    @Column(name = "title", nullable = false)
    @NotEmpty(message = "title cannot be empty")
    @Size(min = 1, message = "title size must be > 1 characters")
    private String title;

    @Column(name = "isbn", nullable = false, unique = true)
    @NotEmpty(message = "isbn cannot be empty")
    @Size(min = 1, message = "isbn size must be > 1 characters")
    private String isbn;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Reward> rewards = new ArrayList<>();

}
