package com.fernandoaudax.cadastrodeartigos.schemas;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

public class ArticleCreateRequest {
    @NotBlank
    @Size(min = 30, max = 70)
    private String title;

    @NotBlank
    @Size(min = 50, max = 100)
    private String resume;

    @NotBlank
    @Size(min = 200)
    private String text;

    @NotBlank
    private UUID userId;
}
