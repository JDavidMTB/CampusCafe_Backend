package cl.duoc.campuscafe.cliente_service.service;

import cl.duoc.campuscafe.cliente_service.entity.Cliente;
import cl.duoc.campuscafe.cliente_service.repository.ClienteRepository;
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
public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository; // Clon simulado de la BD

    @InjectMocks
    private ClienteService clienteService; // Inyecta el mock en el servicio real

    @Test
    public void dadoUnClienteNuevo_cuandoSeRegistra_entoncesRetornaClienteConId() {
        // GIVEN: Escenario simulado (Dado un cliente)
        Cliente clienteGuardado = new Cliente();
        clienteGuardado.setId(1L);
        clienteGuardado.setNombre("Juan Perez");

        when(clienteRepository.save(any(Cliente.class))).thenReturn(clienteGuardado);

        // WHEN: Acción (Cuando se ejecuta el método de negocio)
        Cliente resultado = clienteService.crearCliente(new Cliente());

        // THEN: Verificación (Entonces se comprueba el resultado esperado)
        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals("Juan Perez", resultado.getNombre());

        // Verifica que el repositorio se usó exactamente una vez
        verify(clienteRepository, times(1)).save(any(Cliente.class));
    }

    @Test
    public void dadoUnIdInexistente_cuandoSeBuscaCliente_entoncesLanzaRuntimeException() {
        // GIVEN: El repositorio simulado devolverá "Vacío" (Optional.empty()) al buscar el ID 999
        when(clienteRepository.findById(999L)).thenReturn(java.util.Optional.empty());

        // WHEN & THEN: Evaluamos que al llamar al método se dispare la excepción esperada
        RuntimeException excepcion = assertThrows(RuntimeException.class, () -> {
            clienteService.obtenerClientePorId(999L);
        });

        // Verificamos que el mensaje de error sea el correcto
        assertEquals("Error: El cliente con ID 999 no existe.", excepcion.getMessage());

        // Verificamos que se haya consultado al repositorio una sola vez
        verify(clienteRepository, times(1)).findById(999L);
    }
}