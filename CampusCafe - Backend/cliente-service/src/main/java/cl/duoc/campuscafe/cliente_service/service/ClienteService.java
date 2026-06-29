package cl.duoc.campuscafe.cliente_service.service;

import cl.duoc.campuscafe.cliente_service.entity.Cliente;
import cl.duoc.campuscafe.cliente_service.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    // El constructor permite que Mockito inyecte el repositorio simulado
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    // Método para buscar un cliente. Si no lo encuentra, lanza un error.
    public Cliente obtenerClientePorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Error: El cliente con ID " + id + " no existe."));
    }
}
