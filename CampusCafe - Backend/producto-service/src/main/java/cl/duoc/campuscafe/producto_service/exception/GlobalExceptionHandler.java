package cl.duoc.campuscafe.producto_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.validation.FieldError;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductoNoEncontradoException.class)
    public ResponseEntity<Object> manejarProductoNoEncontrado(
            ProductoNoEncontradoException ex) {

        Map<String, Object> error = new HashMap<>();

        error.put("fecha", LocalDateTime.now());
        error.put("mensaje", ex.getMessage());
        error.put("estado", HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(error);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> manejarValidaciones(MethodArgumentNotValidException ex) {
        Map<String, String> errores = new HashMap<>();

        // Recorremos cada error de validación y lo guardamos en un mapa (Campo -> Mensaje)
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String nombreCampo = ((FieldError) error).getField();
            String mensajeError = error.getDefaultMessage();
            errores.put(nombreCampo, mensajeError);
        });

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errores);
    }
}