package org.example.service;

import org.example.dto.AuthorDto;
import org.example.exceptions.AuthorException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Servicio encargado de conectarse con la API de SerpApi (Google Scholar)
 * para obtener información sobre un autor a partir de su identificador.
 *
 * <p>Esta clase construye la URL de consulta usando la clave API y los valores
 * configurados en el archivo de propiedades de la aplicación, realiza la petición
 * HTTP mediante {@link RestTemplate}, y devuelve un objeto {@link AuthorDto}
 * con la información obtenida. Si no se encuentra el autor o la respuesta es inválida,
 * se lanza una {@link AuthorException}.</p>
 */

@Service
public class AuthorService {

    private final RestTemplate restTemplate;


    @Value("${serpapi.base-url}")
    private String baseUrl;

    @Value("${serpapi.api-key}")
    private String apiKey;


    public AuthorService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public AuthorDto getAuthor(String authorId) throws AuthorException {
        String url = baseUrl
                + "?engine=google_scholar_author"
                + "&author_id=" + authorId
                + "&api_key=" + apiKey;

        AuthorDto response = restTemplate.getForObject(url, AuthorDto.class);

        if (response == null || response.author() == null) {
            throw new AuthorException("Autor no encontrado con ID:" + authorId);
        }

        return response;
    }
}
