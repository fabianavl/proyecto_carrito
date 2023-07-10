package com.example.proyectocac.services;

import com.example.proyectocac.dto.PedidoDto;
import com.example.proyectocac.entity.Pedido;
import com.example.proyectocac.entity.Producto;
import com.example.proyectocac.exception.ResourceNotFoundException;
import com.example.proyectocac.repository.IPedidoRepository;
import com.example.proyectocac.repository.IProductoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements IPedidoService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IProductoRepository productosRepository;

    @Autowired
    private IPedidoRepository pedidosRepository;

    @Override
    public PedidoDto agregarPedido(PedidoDto pedidoDto) {
        Pedido pedido = mapearEntidad(pedidoDto);
        Pedido pedidoNuevo = pedidosRepository.save(pedido);
        PedidoDto pedidoFinal = mapearDTO(pedidoNuevo);
        return pedidoFinal;
    }

   /* @Override
    public PedidoDto agregarPedido(Long productoId, PedidoDto pedidoDto) {
        Pedido pedido = mapearEntidad(pedidoDto);
        Producto producto = productosRepository.findById(productoId)
                .orElseThrow(() -> new ResourceNotFoundException("Producto inexistente con id: " + productoId));

        pedido.setProductosLista((List<Producto>) producto);

        Pedido pedidoFinal = pedidosRepository.save(pedido);

        return mapearDTO(pedidoFinal);

    }*/

   @Override
    public PedidoDto obtenerPedidoPorId(Long id) {
        Pedido pedido = pedidosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido inexistente con id: " + id));
        return mapearDTO(pedido);
    }



   /* @Override
    public PedidoDto obtenerPedidoPorId(Long productoId, Long id) {
        Pedido pedido = pedidosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido inexistente con id: " + id));
        Producto producto = productosRepository.findById(productoId)
                .orElseThrow(() -> new ResourceNotFoundException("Producto inexistente con id: " + productoId));

        return mapearDTO(pedido);
    }*/

    @Override
    public List<PedidoDto> listarPedido() {
        List<Pedido> listaPedidos = pedidosRepository.findAll();
        List<PedidoDto> pedidoDto = listaPedidos.stream().map
                (pedido -> mapearDTO(pedido)).collect(Collectors.toList());
        return pedidoDto;
    }

   /* @Override
    public void eliminarPedido(Long productoId, Long id) {
        Pedido pedido = pedidosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido inexistente con id: " + id));
        Producto producto = productosRepository.findById(productoId)
                .orElseThrow(() -> new ResourceNotFoundException("Producto inexistente con id: " + productoId));
        pedidosRepository.delete(pedido);
    }*/

    @Override
    public void eliminarPedido(Long id) {
        Pedido pedido = pedidosRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido inexistente con id: " + id));
        pedidosRepository.delete(pedido);
    }

    private PedidoDto mapearDTO(Pedido pedido) {
        PedidoDto pedidoDto = modelMapper.map(pedido, PedidoDto.class);
        return pedidoDto;
    }

    private Pedido mapearEntidad(PedidoDto pedidoDto) {
        Pedido pedido = modelMapper.map(pedidoDto, Pedido.class);
        return pedido;
    }
}
