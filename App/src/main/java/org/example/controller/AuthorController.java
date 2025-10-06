package org.example.controller;

import org.example.dto.AuthorDto;
import org.example.service.AuthorService;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST que gestiona las solicitudes relacionadas con autores.
 *
 * <p>Se encarga de recibir las peticiones del cliente,
 * comunicarse con el servicio {@link AuthorService} para obtener la información
 * correspondiente desde la API externa, y devolver los datos en formato JSON.</p>
 */

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/{id}")
    public AuthorDto getAuthor(@PathVariable String id) {
        return authorService.getAuthor(id);
    }
    }