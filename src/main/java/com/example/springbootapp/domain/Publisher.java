package com.example.springbootapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PUBLISHERS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String country;
    private String address;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Author> authorList = new ArrayList<>();

    @OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private  List<Book> bookList = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Reward> rewardList = new ArrayList<>();

}
