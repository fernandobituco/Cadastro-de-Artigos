package com.fernandoaudax.cadastrodeartigos.schemas;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
public class ArticleUpdateResponse {
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
}
