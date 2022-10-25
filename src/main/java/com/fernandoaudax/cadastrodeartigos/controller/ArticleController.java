package com.fernandoaudax.cadastrodeartigos.controller;

import com.fernandoaudax.cadastrodeartigos.schemas.*;
import com.fernandoaudax.cadastrodeartigos.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/article")
public class ArticleController {
    final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public List<ArticleReadResponse> findAll() {
        return articleService.findAll();
    }

    @GetMapping("/{articleUuid}")
    public ArticleReadResponse findById(@PathVariable(value = "articleUuid")UUID articleId) {
        return articleService.findById(articleId);
    }

    @PostMapping
    public ArticleCreateResponse save(@RequestBody ArticleCreateRequest article) {
        return articleService.save(article);
    }

    @PutMapping("/{articleUuid}")
    public ArticleUpdateResponse update(
            @PathVariable(value = "articleUuid") UUID articleId,
            @RequestBody ArticleUpdateRequest article) {
        return articleService.update(article, articleId);
    }

    @DeleteMapping("/{articleUuid}")
    public void delete(@PathVariable(value = "articleUuid") UUID articleId) {
        articleService.delete(articleId);
    }
}
