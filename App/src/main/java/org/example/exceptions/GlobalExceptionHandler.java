package org.example.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Controlador global de excepciones que gestiona los errores ocurridos en la aplicación.
 *
 * <p>Esta clase captura y maneja de forma centralizada las excepciones lanzadas
 * por los controladores REST, generando una respuesta estructurada en formato JSON
 * con información relevante del error, como el estado HTTP, la descripción,
 * el mensaje y la ruta del recurso.</p>
 *
 * <p>Entre sus funciones principales se encuentran:</p>
 * <ul>
 *   <li>Manejar los errores específicos relacionados con {@link AuthorException}.</li>
 *   <li>Manejar excepciones genéricas no controladas y devolver una respuesta estándar
 *       con código <code>500 Internal Server Error</code>.</li>
 * </ul>
 *
 * <p>Gracias a la anotación {@link RestControllerAdvice}, esta clase aplica su manejo
 * de excepciones de forma global a todos los controladores REST de la aplicación.</p>
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Maneja la excepcion en caso de que no se encuentre el autor
    @ExceptionHandler(AuthorException.class)
    public ResponseEntity<Map<String, Object>> handleAuthorNotFound(
            AuthorException ex,
            HttpServletRequest request
    ) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("error", HttpStatus.NOT_FOUND.getReasonPhrase());
        body.put("message", ex.getMessage());
        body.put("path", request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    // Maneja cualquier otro error genérico que no este controlado
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneralError(
            Exception ex,
            HttpServletRequest request
    ) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("status", status.value());
        body.put("error", status.getReasonPhrase());
        body.put("message", "Ocurrio un error inesperado");
        body.put("path", request.getRequestURI());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }
}
