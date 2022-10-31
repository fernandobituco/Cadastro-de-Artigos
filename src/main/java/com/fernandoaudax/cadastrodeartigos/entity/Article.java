package com.fernandoaudax.cadastrodeartigos.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fernandoaudax.cadastrodeartigos.common.Common;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.text.DateFormat;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type="org.hibernate.type.UUIDCharType")
    private UUID uuid;

    @Column
    @Size(min = 30, max = 70, message ="Title must be 30 to 70 characters long")
    private String title;

    @Column
    @Size(min = 50, max = 100, message ="Resume must be 50 to 100 characters long")
    private String resume;

    @Column
    @Lob
    @Size(min = 200, message ="Text must be at least 200 characters long")
    private String text;

    @Column
    @Lob
    private String slug;

    @Column(updatable = false)
    private String registeredAt;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Article(String title, String resume, String text, User user) {
        this.title = title;
        this.resume = resume;
        this.text = text;
        this.slug = Common.generateSlug(title);
        this.registeredAt = Common.getTime();
        this.user = user;
    }


}
