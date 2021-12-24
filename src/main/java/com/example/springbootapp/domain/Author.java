package com.example.springbootapp.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "AUTHORS")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
