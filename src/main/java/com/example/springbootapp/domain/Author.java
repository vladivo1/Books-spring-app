package com.example.springbootapp.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table(name = "authors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id", insertable = false, updatable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    @NotEmpty(message = "name cannot be empty")
    @Size(min = 2, message = "name size must be > 2 characters")
    private String firstName;

    @Column(name = "lastname", nullable = false)
    @NotEmpty(message = "lastname cannot be empty")
    @Size(min = 2, message = "lastname size must be > 2 characters")
    private String lastName;

    @Column(name = "birth_date", nullable = false)
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name = "email", nullable = false, unique = true)
    @NotEmpty
    @Email(message = "email must be correct")
    private String email;

    @Column(name = "sex", nullable = false)
    @NotEmpty
    private String sex;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Reward> rewards = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;



}
