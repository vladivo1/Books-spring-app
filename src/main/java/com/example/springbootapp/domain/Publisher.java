package com.example.springbootapp.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "publishers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id", insertable = false, updatable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    @NotEmpty(message = "name cannot be empty")
    @Size(min = 1, message = "name size must be > 1 characters")
    private String name;

    @Column(name = "country", nullable = false)
    @NotEmpty(message = "country cannot be empty")
    @Size(min = 2, message = "country size must be > 2 characters")
    private String country;

    @Column(name = "address", nullable = false)
    @NotEmpty(message = "address cannot be empty")
    @Size(min = 2, message = "address size must be > 2 characters")
    private String address;

    @OneToMany(mappedBy = "publisher", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Author> authorList = new ArrayList<>();

    @OneToMany(mappedBy = "publisher", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Book> bookList = new ArrayList<>();

    @OneToMany(mappedBy = "publisher", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Reward> rewardList = new ArrayList<>();

}
