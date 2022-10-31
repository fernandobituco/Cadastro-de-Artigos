package com.fernandoaudax.cadastrodeartigos.schemas;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Getter
@Setter
public class ArticleCreateRequest {

    private String title;

    private String resume;

    private String text;

    private UUID userId;
}
