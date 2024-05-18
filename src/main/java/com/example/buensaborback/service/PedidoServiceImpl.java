package com.example.buensaborback.service;

import com.example.buensaborback.domain.entities.Pedido;
import com.example.buensaborback.repositories.PedidoRepository;
import org.springframework.stereotype.Service;


@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido, Long> implements PedidoService {

    private PedidoRepository pedidoRepository;
    public PedidoServiceImpl(PedidoRepository pedidoRepository) {
        super(pedidoRepository);
        this.pedidoRepository = pedidoRepository;
    }
}
