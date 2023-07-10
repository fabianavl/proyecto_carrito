package com.example.proyectocac.services;

import com.example.proyectocac.dto.PedidoDto;

import java.util.List;

public interface IPedidoService {
    public PedidoDto agregarPedido(PedidoDto pedidoDto);
    public PedidoDto obtenerPedidoPorId(Long id);
    public List<PedidoDto> listarPedido();
    public void eliminarPedido(Long id);


}
