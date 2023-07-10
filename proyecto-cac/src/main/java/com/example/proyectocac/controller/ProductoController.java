package com.example.proyectocac.controller;

import com.example.proyectocac.dto.ProductoDto;
import com.example.proyectocac.services.IProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoService productosService;

    //listado de productos
    @GetMapping("/lista_productos")
    public ResponseEntity<?> listaProductos() {
        return new ResponseEntity<>(productosService.listarProductos(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDto> obtenerProductoPorId(@PathVariable Long id) {
        ProductoDto productoDto = productosService.obtenerProductoPorId(id);
        return ResponseEntity.ok(productoDto);
    }

    @PostMapping("/nuevo")
    public ResponseEntity<ProductoDto> crearProducto(@Valid @RequestBody ProductoDto productoDto) {
        ProductoDto producto = productosService.agregarProducto(productoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(producto);
    }

    //actualizar
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ProductoDto> actualizarProducto(@Valid @PathVariable Long id,
                                                          @RequestBody ProductoDto productosDto) {
        ProductoDto productoDto = productosService.actualizarProducto(id, productosDto);
        return ResponseEntity.ok(productoDto);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        productosService.eliminarProducto(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
