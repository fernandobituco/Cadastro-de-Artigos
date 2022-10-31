package com.fernandoaudax.cadastrodeartigos.service;

import com.fernandoaudax.cadastrodeartigos.ExceptionHandlers.ArticleNotFoundException;
import com.fernandoaudax.cadastrodeartigos.common.Common;
import com.fernandoaudax.cadastrodeartigos.entity.Article;
import com.fernandoaudax.cadastrodeartigos.entity.User;
import com.fernandoaudax.cadastrodeartigos.repository.ArticleRepository;
import com.fernandoaudax.cadastrodeartigos.schemas.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService{
    final ArticleRepository articleRepository;

    final UserService userService;

    public ArticleServiceImpl(ArticleRepository articleRepository, UserService userService) {
        this.articleRepository = articleRepository;
        this.userService = userService;
    }

    @Transactional
    public Article save(ArticleCreateRequest articleCreateRequest) {
        User user = userService.findById(articleCreateRequest.getUserId());
        Article article = new Article(articleCreateRequest.getTitle(),
                articleCreateRequest.getResume(),
                articleCreateRequest.getText(),
                user);
        articleRepository.save(article);
        return article;
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public Article findById(UUID id) {
        Optional<Article> article = articleRepository.findById(id);
        if(article.isEmpty()) {
            throw new ArticleNotFoundException();
        }
        return article.get();
    }

    @Transactional
    public Article update(ArticleUpdateRequest articleUpdateRequest, UUID id) {
        Article article = findById(id);
        article.setTitle(articleUpdateRequest.getTitle());
        article.setResume(articleUpdateRequest.getResume());
        article.setText(articleUpdateRequest.getText());
        article.setSlug(Common.generateSlug(article.getTitle()));
        return article;
    }

    @Transactional
    public void delete(UUID id) {
        if (!articleRepository.existsById(id)) {
            throw new ArticleNotFoundException();
        } else {
            articleRepository.deleteById(id);
        }
    }
}
