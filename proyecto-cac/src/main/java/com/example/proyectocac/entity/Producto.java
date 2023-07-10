package com.example.proyectocac.entity;


import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="productos")
public class Producto {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="producto_id", nullable=false)
    private int producto_id;

    @Column(name="nombre", nullable=false, length = 30)
    private String nombre;

    @Column(name="categoria", nullable = false, length = 50)
    private String categoria;

    @Column(name="descripcion", nullable = false, length = 100)
    private String descripcion;

    @Column(name="tamanio", nullable = false)
    private int tamanio;

    @Column(name="tipo", nullable = false)
    private String tipo;
    @Column(name="precio", nullable = false, scale = 2)
    private double precio;
    @Column(name="cantidad", nullable = false, scale = 2)
    private int cantidad;

    @Column(name="total", nullable = false)
    private double total;
    @ManyToOne
    @JoinColumn(name="pedido_id", nullable = false)
    private Pedido pedido;

}
