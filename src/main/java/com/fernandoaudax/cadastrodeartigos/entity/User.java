package com.fernandoaudax.cadastrodeartigos.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fernandoaudax.cadastrodeartigos.common.Common;
import com.fernandoaudax.cadastrodeartigos.schemas.UserCreateRequest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID uuid;

    @Column(unique = true, nullable = false)
    @Size(min = 3, max = 150, message = "The username must be 3 to 150 characters long")
    private String username;

    @Column(nullable = false)
    @Size(min = 8, message = "Password must contain at least 8 characters")
    private String password;

    @Column(updatable = false)
    private String registeredAt;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private Set<Article> articles = new HashSet<>();

    public User(UserCreateRequest userCreateRequest) {
        this.username = userCreateRequest.getUsername();
        this.password = userCreateRequest.getPassword();
        this.registeredAt = Common.getTime();
    }
}
