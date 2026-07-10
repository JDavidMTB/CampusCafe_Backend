package cl.duoc.campuscafe.categoria_service.service;

import cl.duoc.campuscafe.categoria_service.entity.Categoria;
import cl.duoc.campuscafe.categoria_service.repository.CategoriaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CategoriaServiceTest {

    @Mock
    private CategoriaRepository categoriaRepository;

    @InjectMocks
    private CategoriaService categoriaService;

    @Test
    public void dadoUnaCategoriaNueva_cuandoSeRegistra_entoncesRetornaCategoriaConId() {
        Categoria categoriaGuardada = new Categoria();
        categoriaGuardada.setId(1L);
        categoriaGuardada.setNombre("Bebidas");

        when(categoriaRepository.save(any(Categoria.class))).thenReturn(categoriaGuardada);

        Categoria resultado = categoriaService.guardar(new Categoria());

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals("Bebidas", resultado.getNombre());
        verify(categoriaRepository, times(1)).save(any(Categoria.class));
    }

    @Test
    public void dadoUnIdInexistente_cuandoSeBuscaCategoria_entoncesLanzaRuntimeException() {
        when(categoriaRepository.findById(999L)).thenReturn(Optional.empty());

        RuntimeException excepcion = assertThrows(RuntimeException.class, () -> {
            categoriaService.obtenerPorId(999L);
        });

        assertEquals("Error: La categoria con ID 999 no existe.", excepcion.getMessage());
        verify(categoriaRepository, times(1)).findById(999L);
    }
}