package org.example.exceptions;

/**
 * Excepción personalizada que se utiliza para manejar errores relacionados
 * con la obtención o procesamiento de información de autores.
 *
 * <p>Se lanza cuando no se encuentra un autor.</p>
 */

public class AuthorException extends RuntimeException {
    public AuthorException(String message) {
        super(message);
    }
}
