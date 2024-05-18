package com.example.buensaborback.controller;

import com.example.buensaborback.domain.entities.Cliente;
import com.example.buensaborback.service.ClienteServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "api/clientes")
public class ClienteController extends BaseControllerImpl<Cliente, ClienteServiceImpl>{

    private ClienteServiceImpl service;
    public ClienteController(ClienteServiceImpl service) {
        super(service);
    }
}

