package com.fernandoaudax.cadastrodeartigos.service;

import com.fernandoaudax.cadastrodeartigos.schemas.*;

import java.util.List;
import java.util.UUID;

public interface ArticleService {
    ArticleCreateResponse save(ArticleCreateRequest article);

    List<ArticleReadResponse> findAll();

    ArticleReadResponse findById(UUID id);

    ArticleUpdateResponse update(ArticleUpdateRequest article, UUID id);

    void delete(UUID id);
}
