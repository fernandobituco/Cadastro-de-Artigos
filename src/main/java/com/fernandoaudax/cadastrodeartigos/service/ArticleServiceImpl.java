package com.fernandoaudax.cadastrodeartigos.service;

import com.fernandoaudax.cadastrodeartigos.repository.ArticleRepository;
import com.fernandoaudax.cadastrodeartigos.schemas.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ArticleServiceImpl implements ArticleService{
    final ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public ArticleCreateResponse save(ArticleCreateRequest article) {
        return null;
    }

    @Override
    public List<ArticleReadResponse> findAll() {
        return null;
    }

    @Override
    public ArticleReadResponse findById(UUID id) {
        return null;
    }

    @Override
    public ArticleUpdateResponse update(ArticleUpdateRequest article, UUID id) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
