package org.example.service;

import org.example.dto.AuthorDto;
import org.example.entity.Article;
import org.example.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    private final AuthorService authorService;
    private final ArticleRepository articleRepository;

    public ArticleService(AuthorService authorService, ArticleRepository articleRepository) {
        this.authorService = authorService;
        this.articleRepository = articleRepository;
    }

    public List<Article> fetchAndSaveArticles(String authorId) {
        AuthorDto authorData = authorService.getAuthor(authorId);

        List<Article> articles = authorData.articles().stream()
                // Ordena por número de citas (mayor a menor)
                .sorted((a, b) -> Integer.compare(
                        b.cited_by() != null ? b.cited_by().value() : 0,
                        a.cited_by() != null ? a.cited_by().value() : 0
                ))
                // Toma solo los 3 primeros
                .limit(3)
                // Convierte a entidad JPA
                .map(a -> new Article(
                        a.title(),
                        a.link(),
                        a.authors(),
                        a.publication(),
                        a.cited_by() != null ? a.cited_by().value() : 0,
                        authorId
                ))
                .collect(Collectors.toList());

        return articleRepository.saveAll(articles);
    }

    public List<Article> getArticlesByAuthor(String authorId) {
        return articleRepository.findByAuthorId(authorId);
    }
}
