package com.example.springbootapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "AUTHORS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id", insertable = false, updatable = false)
    private Integer id;
    @Column(name = "AUTHOR_FIRST_NAME")
    private String firstName;
    @Column(name = "AUTHOR_LAST_NAME")
    private String lastName;
    @Column(name = "AUTHOR_BIRTHDAY")
    private Date birthDate;
    @Column(name = "AUTHOR_SEX")
    private String sex;


    @JsonIgnore
    @OneToMany( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

    @JsonIgnore
    @OneToMany (fetch = FetchType.EAGER, cascade =  CascadeType.ALL)
    private List <Reward> rewards = new ArrayList<>();
    @JsonIgnore
    @ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Publisher publisher;



}
