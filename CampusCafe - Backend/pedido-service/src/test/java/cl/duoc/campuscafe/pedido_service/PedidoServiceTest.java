package cl.duoc.campuscafe.pedido_service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import cl.duoc.campuscafe.pedido_service.entity.Pedido;
import cl.duoc.campuscafe.pedido_service.repository.PedidoRepository;
import cl.duoc.campuscafe.pedido_service.service.PedidoService;
import cl.duoc.campuscafe.pedido_service.dto.ClienteRemoteDTO;

@ExtendWith(MockitoExtension.class)
public class PedidoServiceTest {

    // 1. Simulamos la Base de Datos
    @Mock
    private PedidoRepository repository;

    // 2. Simulamos la conexión con el microservicio de clientes
    @Mock
    private RestTemplate restTemplate;

    // 3. Inyectamos los simulacros en tu servicio real
    @InjectMocks
    private PedidoService pedidoService;

    @Test
    void testProcesarPedido_Exito() {
        // --- GIVEN (Preparar el escenario) ---
        Pedido pedidoInput = new Pedido();
        pedidoInput.setClienteId(5L);
        pedidoInput.setTotal(15000.0);

        // Simulamos un cliente falso que el RestTemplate va a "encontrar"
        ClienteRemoteDTO clienteFalso = new ClienteRemoteDTO();
        clienteFalso.setNombre("Lucas Avendaño");
        clienteFalso.setEmail("lucas@duocuc.cl");

        // Simulamos el pedido ya guardado con su ID generado
        Pedido pedidoGuardado = new Pedido();
        pedidoGuardado.setId(1L);
        pedidoGuardado.setClienteId(5L);
        pedidoGuardado.setTotal(15000.0);

        // Le enseñamos a Mockito qué responder cuando tu servicio pregunte
        when(restTemplate.getForObject(anyString(), eq(ClienteRemoteDTO.class))).thenReturn(clienteFalso);
        when(repository.save(any(Pedido.class))).thenReturn(pedidoGuardado);

        // --- WHEN (Ejecutar el método real) ---
        Pedido resultado = pedidoService.procesarPedido(pedidoInput);

        // --- THEN (Validar que hizo lo correcto) ---
        assertNotNull(resultado, "El pedido no debería ser nulo");
        assertEquals(1L, resultado.getId(), "El ID debe coincidir");
        assertEquals(15000.0, resultado.getTotal(), "El total debe ser exacto");

        // Verificamos que tu servicio llamó al RestTemplate y al Repository exactamente 1 vez
        verify(restTemplate, times(1)).getForObject(anyString(), eq(ClienteRemoteDTO.class));
        verify(repository, times(1)).save(any(Pedido.class));
    }
}