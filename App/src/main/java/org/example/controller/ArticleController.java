package org.example.controller;

import org.example.entity.Article;
import org.example.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    // Obtiene los artículos desde SerpApi y los guarda automáticamente
    @PostMapping("/{authorId}/sync")
    public List<Article> syncArticles(@PathVariable String authorId) {
        return articleService.fetchAndSaveArticles(authorId);
    }

    // Obtiene los artículos ya guardados en la base de datos
    @GetMapping("/{authorId}")
    public List<Article> getArticles(@PathVariable String authorId) {
        return articleService.getArticlesByAuthor(authorId);
    }
}
