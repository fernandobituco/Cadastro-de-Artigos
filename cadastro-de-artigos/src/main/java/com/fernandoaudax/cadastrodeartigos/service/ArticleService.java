package com.fernandoaudax.cadastrodeartigos.service;

import com.fernandoaudax.cadastrodeartigos.schemas.*;

import java.util.UUID;

public interface ArticleService {
    ArticleCreateResponse save(ArticleCreateRequest article);

    ArticleReadResponse findAll();

    ArticleReadResponse findById(UUID id);

    ArticleUpdateResponse update(ArticleUpdateRequest article, UUID id);

    void delete(UUID id);
}
