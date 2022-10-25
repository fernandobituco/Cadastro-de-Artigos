package com.fernandoaudax.cadastrodeartigos.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    private int id;

    @Column
    @GeneratedValue
    private UUID uuid;

    @Column(unique = true, nullable = false)
    private String username;

    @Column
    private String password;

    @Column
    private String registeredAt;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private Set<Article> articles = new HashSet<>();
}
