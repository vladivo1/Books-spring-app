package com.example.springbootapp.domain;
import javax.persistence.*;

@Entity
@Table(name = "REWARDS")
public class Reward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reward_id",insertable = false, updatable = false)
    private Integer id;
    @Column(name = "REWARD_NAME", length = 50)
    private String title;
    @Column(name = "REWARD_YEAR")
    private Integer year;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
