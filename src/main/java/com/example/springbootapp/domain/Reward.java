package com.example.springbootapp.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "REWARDS")
@Data
@NoArgsConstructor
public class Reward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reward_id",insertable = false, updatable = false)
    private Integer id;

    @Column(name = "REWARD_NAME", length = 50)
    private String title;

    @Column(name = "REWARD_YEAR")
    private Integer year;

    @JsonIgnore
    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @JsonIgnore
    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book book;

    @JsonIgnore
    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;

}
