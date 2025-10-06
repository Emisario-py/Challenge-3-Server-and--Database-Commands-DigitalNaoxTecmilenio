package org.example.dto;

import java.util.List;

/**
 * Objeto de transferencia de datos (DTO) que representa la información
 * de un autor y sus artículos obtenidos desde una fuente externa.
 *
 * <p>Esta clase agrupa los datos principales del autor, sus intereses
 * y la lista de publicaciones asociadas, con el propósito de facilitar
 * el intercambio de información entre las capas de la aplicación.</p>
 */

public record AuthorDto(
        Author author,
        List<Articles> articles
) {
    public record Author(
            String name,
            String affiliations,
            String email,
            String thumbnail,
            List<Interest> interests

    ) {}

    public record Interest(
            String title,
            String link
    ) {}

    public record Articles(
            String title,
            String link,
            String authors,
            String publication
    ){}
}
