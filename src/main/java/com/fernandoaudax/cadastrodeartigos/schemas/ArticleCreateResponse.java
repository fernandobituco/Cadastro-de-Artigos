package com.fernandoaudax.cadastrodeartigos.schemas;

import com.fernandoaudax.cadastrodeartigos.entity.Article;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
public class ArticleCreateResponse {
    private UUID uuid;

    private String title;

    private String resume;

    private String text;

    private String slug;

    private String registeredAt;

    private String username;

    public ArticleCreateResponse(Article article) {
        this.uuid = article.getUuid();
        this.title = article.getTitle();
        this.resume = article.getResume();
        this.text = article.getText();
        this.slug = article.getSlug();
        this.registeredAt = article.getRegisteredAt();
        this.username = article.getUser().getUsername();
    }
}
