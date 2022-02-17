package com.example.springbootapp.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "rewards")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reward {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reward_id",insertable = false, updatable = false)
    private Integer id;

    @Column(name = "title", nullable = false)
    @NotEmpty(message = "title cannot be empty")
    @Size(min = 1, message = "title size must be > 2 characters")
    private String title;

    @Column(name = "year", nullable = false)
    @NotEmpty(message = "year cannot be empty")
    @Size(min = 2, message = "year size must be > 2 characters")
    private String year;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;


}
