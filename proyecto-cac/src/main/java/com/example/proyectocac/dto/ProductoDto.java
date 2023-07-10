package com.example.proyectocac.dto;

import com.example.proyectocac.entity.Pedido;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDto {

    private int id;

    private String nombre;

    private String categoria;

    private String descripcion;

    private int tamanio;

    private String tipo;

    private double precio;

    private int cantidad;
    private double total;

    private Pedido pedido;

}
