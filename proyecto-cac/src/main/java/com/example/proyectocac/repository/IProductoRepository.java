package com.example.proyectocac.repository;

import com.example.proyectocac.entity.Pedido;
import com.example.proyectocac.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {

}
