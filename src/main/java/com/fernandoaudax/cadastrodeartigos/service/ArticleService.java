package com.fernandoaudax.cadastrodeartigos.service;

import com.fernandoaudax.cadastrodeartigos.entity.Article;
import com.fernandoaudax.cadastrodeartigos.schemas.*;

import java.util.List;
import java.util.UUID;

public interface ArticleService {
    Article save(ArticleCreateRequest article);

    List<Article> findAll();

    Article findById(UUID id);

    Article update(ArticleUpdateRequest article, UUID id);

    void delete(UUID id);
}
