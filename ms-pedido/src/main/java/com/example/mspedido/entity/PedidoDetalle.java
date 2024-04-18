package com.example.mspedido.entity;

import com.example.mspedido.dto.ClienteDto;
import com.example.mspedido.dto.ProductoDto;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class PedidoDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double cantidad;
    private Double precio;
    private Integer productoId;


    public PedidoDetalle() {
        this.cantidad = (double) 0;
        this.precio = (double) 0;
    }

    @Transient
    ProductoDto productoDto;
}
