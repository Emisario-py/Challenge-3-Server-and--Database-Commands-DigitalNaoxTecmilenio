package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.AuthorDto;

/**
 * Entidad JPA que representa un artículo del autor en la base de datos.
 *
 * Este modelo se usa únicamente para la persistencia local.
 * El campo 'authorId' no proviene de la API de SerpApi, sino que se agrega
 * manualmente para mantener la relación entre artículos y autores.
 */
@Entity
@Table(name = "articles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String link;
    private String authors;
    private String publication;

    /**
     * ID del autor usado en la solicitud a SerpApi.
     * Este campo no existe en la API, pero se guarda localmente
     * para identificar los artículos por autor.
     */
    @Column(name = "author_id")
    private String authorId;

    @Column(name = "cited_by")
    private Integer citedBy;

    // Constructor auxiliar sin 'id' (para crear artículos nuevos)
    public Article(String title, String link, String authors, String publication, Integer citedBy, String authorId) {
        this.title = title;
        this.link = link;
        this.authors = authors;
        this.publication = publication;
        this.citedBy = citedBy;
        this.authorId = authorId;
    }
}
