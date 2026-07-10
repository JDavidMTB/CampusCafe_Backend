package cl.duoc.campuscafe.pedido_service.controller;

import cl.duoc.campuscafe.pedido_service.entity.Pedido;
import cl.duoc.campuscafe.pedido_service.service.PedidoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

// Importaciones estáticas para los links mágicos de HATEOAS
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Slf4j
@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService service;

    @GetMapping
    public ResponseEntity<List<EntityModel<Pedido>>> listar() {
        log.info("Solicitud REST recibida para listar todos los pedidos");

        List<EntityModel<Pedido>> pedidos = service.obtenerTodos().stream()
                .map(pedido -> EntityModel.of(pedido,
                        linkTo(methodOn(PedidoController.class).listar()).withRel("todos-los-pedidos")))
                .collect(Collectors.toList());

        return ResponseEntity.ok(pedidos);
    }

    @PostMapping
    public ResponseEntity<EntityModel<Pedido>> crear(@RequestBody Pedido pedido) {
        log.info("Solicitud REST recibida para crear un pedido del cliente ID: {}", pedido.getClienteId());

        Pedido nuevoPedido = service.procesarPedido(pedido);


        EntityModel<Pedido> recurso = EntityModel.of(nuevoPedido);


        recurso.add(linkTo(methodOn(PedidoController.class).listar()).withRel("todos-los-pedidos"));

        recurso.add(linkTo(methodOn(PedidoController.class).crear(pedido)).withSelfRel());

        return ResponseEntity.status(HttpStatus.CREATED).body(recurso);
    }
}