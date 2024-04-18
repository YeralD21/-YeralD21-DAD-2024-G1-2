package com.example.mspedido.service.impl;

import com.example.mspedido.entity.Pedido;
import com.example.mspedido.entity.PedidoDetalle;
import com.example.mspedido.feing.ClienteFeing;
import com.example.mspedido.feing.ProductoFeing;
import com.example.mspedido.repository.PedidoRepository;
import com.example.mspedido.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PedidoServiceImpl implements PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteFeing clienteFeing;

    @Autowired
    private ProductoFeing productoFeing;
    @Override
    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido guardar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public Pedido buscarPorId(Integer id) {

        Pedido pedido = pedidoRepository.findById(id).get();
        pedido.setClienteDto(clienteFeing.findById(pedido.getClienteId()).getBody());

        /*for (PedidoDetalle pedidoDetalle : pedido.getDetalle()){
            pedidoDetalle.setProducto(productoFeing.buscarPorId(pedidoDetalle))
        }*/

        List<PedidoDetalle> pedidoDetalles=pedido.getDetalle().stream().map(pedidoDetalle -> {
            pedidoDetalle.setProductoDto(productoFeing.buscarPorId(pedidoDetalle.getProductoId()).getBody());
            return pedidoDetalle;
        }).toList();
        pedido.setDetalle(pedidoDetalles);

        return pedido;
    }

    @Override
    public Pedido editar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public void eliminar(Integer id) {
        pedidoRepository.deleteById(id);
    }

}
