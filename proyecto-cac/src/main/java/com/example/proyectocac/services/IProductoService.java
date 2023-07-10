package com.example.proyectocac.services;

import com.example.proyectocac.dto.ProductoDto;

import java.util.List;

public interface IProductoService {
    public ProductoDto agregarProducto(ProductoDto productoDto);
    public ProductoDto obtenerProductoPorId(Long id);
    public List<ProductoDto> listarProductos();
    public ProductoDto actualizarProducto(Long id, ProductoDto productoDto);
    public void eliminarProducto(Long id);


}
