package com.fernandoaudax.cadastrodeartigos.schemas;

import com.fernandoaudax.cadastrodeartigos.entity.Article;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
public class ArticleReadResponse {
    @NotBlank
    private UUID uuid;

    @NotBlank
    private String title;

    @NotBlank
    private String resume;

    @NotBlank
    private String text;

    private String slug;

    @NotBlank
    private String registeredAt;

    @NotBlank
    private String username;

    public ArticleReadResponse(Article article) {
        this.uuid = article.getUuid();
        this.title = article.getTitle();
        this.resume = article.getResume();
        this.text = article.getText();
        this.slug = article.getSlug();
        this.registeredAt = article.getRegisteredAt();
        this.username = article.getUser().getUsername();
    }
}
