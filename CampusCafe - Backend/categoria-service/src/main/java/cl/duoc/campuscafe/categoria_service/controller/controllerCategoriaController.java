package cl.duoc.campuscafe.categoria_service.controller;

import cl.duoc.campuscafe.categoria_service.dto.CategoriaDTO;
import cl.duoc.campuscafe.categoria_service.entity.Categoria;
import cl.duoc.campuscafe.categoria_service.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
@Tag(name = "Categorías", description = "Operaciones para gestionar categorías del CampusCafe")
public class controllerCategoriaController {

    private final CategoriaService service;

    @GetMapping
    @Operation(summary = "Listar todas las categorías",
            description = "Retorna la lista completa de categorías registradas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categorías obtenidas exitosamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Categoria.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor",
                    content = @Content)
    })
    public List<Categoria> listar() {
        return service.obtenerTodas();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar categoría por ID",
            description = "Retorna una categoría específica por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoría encontrada",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Categoria.class))),
            @ApiResponse(responseCode = "404", description = "Categoría no encontrada",
                    content = @Content)
    })
    public ResponseEntity<Categoria> buscarPorId(
            @Parameter(description = "ID de la categoría", required = true, example = "1")
            @PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerPorId(id));
    }

    @PostMapping
    @Operation(summary = "Crear nueva categoría",
            description = "Registra una nueva categoría en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Categoría creada exitosamente",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Categoria.class))),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos",
                    content = @Content)
    })
    public ResponseEntity<Categoria> crear(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos de la nueva categoría", required = true)
            @Valid @RequestBody CategoriaDTO dto) {
        Categoria categoria = Categoria.builder()
                .nombre(dto.getNombre())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(categoria));
    }
}