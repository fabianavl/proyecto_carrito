package com.example.proyectocac.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="pedido_id", nullable = false)
    private int pedido_id;
    @Column(name="nombre", nullable = false)
    private String nombre;
    @Column(name="direccion", nullable = false)
    private String direccion;
    @JsonBackReference
    @OneToMany(mappedBy="pedido", cascade = CascadeType.ALL)
    private List<Producto> productosLista = new ArrayList<>();




}