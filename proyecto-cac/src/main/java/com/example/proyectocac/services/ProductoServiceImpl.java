package com.example.proyectocac.services;

import com.example.proyectocac.dto.ProductoDto;
import com.example.proyectocac.entity.Producto;
import com.example.proyectocac.exception.ResourceNotFoundException;
import com.example.proyectocac.repository.IProductoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IProductoRepository productosRepository;


    @Override
    public ProductoDto agregarProducto(ProductoDto productoDto) {
        Producto productos = mapearEntidad(productoDto);
        Producto otroProducto = productosRepository.save(productos);
        ProductoDto productoFinal = mapearDTO(otroProducto);
        return productoFinal;
    }

    @Override
    public ProductoDto obtenerProductoPorId(Long id) {
        Producto productos = productosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto inexistente con id: " + id));
        return mapearDTO(productos);
    }

    @Override
    public List<ProductoDto> listarProductos() {
        List<Producto> listaProductos = productosRepository.findAll();
        List<ProductoDto> productoDtos = listaProductos.stream().map
                (producto -> mapearDTO(producto)).collect(Collectors.toList());
        return productoDtos;
    }

    @Override
    public ProductoDto actualizarProducto(Long id, ProductoDto productoDto) {
        Producto productos = productosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto inexistente con id: " + id));

        productos.setNombre(productoDto.getNombre());
        productos.setCategoria(productoDto.getCategoria());
        productos.setDescripcion(productoDto.getDescripcion());
        productos.setTamanio(productoDto.getTamanio());
        productos.setTipo(productoDto.getTipo());
        productos.setCantidad(productoDto.getCantidad());
        productos.setPrecio(productoDto.getPrecio());
        productos.setTotal(productoDto.getTotal());
        productos.setPedido(productoDto.getPedido());

        Producto productoActualizado = productosRepository.save(productos);
        return mapearDTO(productoActualizado);
    }

    @Override
    public void eliminarProducto(Long id) {
        //primero busco el producto que vamos a eliminar x id:
        Producto productos = productosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto inexistente con id: " + id));

        productosRepository.delete(productos);

    }

    private ProductoDto mapearDTO(Producto productos) {
        ProductoDto productoDto = modelMapper.map(productos, ProductoDto.class);
        return productoDto;
    }

    private Producto mapearEntidad(ProductoDto productoDto) {
        Producto productos = modelMapper.map(productoDto, Producto.class);
        return productos;
    }
}
