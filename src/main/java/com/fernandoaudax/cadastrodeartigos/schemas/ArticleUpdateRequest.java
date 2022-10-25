package com.fernandoaudax.cadastrodeartigos.schemas;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleUpdateRequest {
    private String title;

    private String resume;

    private String text;
}
