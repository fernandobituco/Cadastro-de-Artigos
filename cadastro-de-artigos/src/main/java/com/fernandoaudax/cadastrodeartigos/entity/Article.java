package com.fernandoaudax.cadastrodeartigos.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Article {
    @Id
    @GeneratedValue
    private int id;

    @Column
    @GeneratedValue
    private UUID uuid;

    @Column
    private String title;

    @Column
    private String resume;

    @Column
    private String text;

    @Column
    private String slug;

    @Column
    private String registeredAt;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
