package com.fernandoaudax.cadastrodeartigos.controller;

import com.fernandoaudax.cadastrodeartigos.ExceptionHandlers.ArticleNotFoundException;
import com.fernandoaudax.cadastrodeartigos.ExceptionHandlers.MultipleErrorResponse;
import com.fernandoaudax.cadastrodeartigos.entity.Article;
import com.fernandoaudax.cadastrodeartigos.schemas.*;
import com.fernandoaudax.cadastrodeartigos.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/article")
public class ArticleController {
    final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public List<ArticleReadResponse> findAll() {
        return articleService.findAll().stream().map(ArticleReadResponse::new).collect(Collectors.toList());
    }

    @GetMapping("/{articleUuid}")
    public ResponseEntity<Object> findById(@PathVariable(value = "articleUuid")UUID articleId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ArticleReadResponse(articleService.findById(articleId)));
        } catch (Throwable e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody ArticleCreateRequest article) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(new ArticleCreateResponse(articleService.save(article)));
        } catch (Throwable e) {
            MultipleErrorResponse error = new MultipleErrorResponse("Check input", e);
            return ResponseEntity.badRequest().body(error);
        }
    }

    @PutMapping("/{articleUuid}")
    public ResponseEntity<Object> update(
            @PathVariable(value = "articleUuid") UUID articleId,
            @RequestBody ArticleUpdateRequest article) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(new ArticleUpdateResponse(articleService.update(article, articleId)));
        } catch (ArticleNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Throwable e) {
            MultipleErrorResponse error = new MultipleErrorResponse("Check input", e);
            return ResponseEntity.badRequest().body(error);
        }
    }

    @DeleteMapping("/{articleUuid}")
    public ResponseEntity<Object> delete(@PathVariable(value = "articleUuid") UUID articleId) {
        try {
            articleService.delete(articleId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (ArticleNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
