package com.example.proyectocac.dto;

import com.example.proyectocac.entity.Producto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDto {
    private int id;

    private String nombre;

    private String direccion;

    private List<Producto> productos;


}
