package com.example.mspedido.service;

import com.example.mspedido.entity.Pedido;

import java.util.List;

public interface PedidoService {
    public List<Pedido> listar();
    public Pedido guardar(Pedido pedido);
    public Pedido buscarPorId(Integer Id);
    public Pedido editar(Pedido pedido);
    public void eliminar(Integer Id);
}
