package com.example.proyectocac.controller;

import com.example.proyectocac.dto.PedidoDto;
import com.example.proyectocac.services.IPedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PedidoController {

    @Autowired
    private IPedidoService pedidosService;

    @GetMapping("/lista_pedidos")
    public ResponseEntity<?> listaPedidos() {
        return new ResponseEntity<>(pedidosService.listarPedido(), HttpStatus.OK);
    }
   @GetMapping("/pedido/{id}")
   public ResponseEntity<PedidoDto> obtenerPedidoPorId(@PathVariable Long id) {
       PedidoDto pedidoDto = pedidosService.obtenerPedidoPorId(id);
       return ResponseEntity.ok(pedidoDto);
   }
   @PostMapping("/pedido/nuevo")
   public ResponseEntity<PedidoDto> crearPedido(@Valid @RequestBody PedidoDto pedidoDto) {
       return new ResponseEntity<>(pedidosService.agregarPedido(pedidoDto)
               , HttpStatus.CREATED);
   }

   @DeleteMapping("/eliminar/{id}")
   public ResponseEntity<Void> eliminarPedido(@PathVariable Long id) {
       pedidosService.eliminarPedido(id);
       return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
   }
}
