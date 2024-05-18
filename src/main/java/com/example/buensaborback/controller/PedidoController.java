package com.example.buensaborback.controller;

import com.example.buensaborback.domain.entities.Pedido;
import com.example.buensaborback.service.PedidoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "api/pedidos")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoServiceImpl>{

    private PedidoServiceImpl service;
    public PedidoController(PedidoServiceImpl service) {
        super(service);
    }
}

