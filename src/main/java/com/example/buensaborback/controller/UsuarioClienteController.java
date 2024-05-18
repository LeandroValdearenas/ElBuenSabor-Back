package com.example.buensaborback.controller;

import com.example.buensaborback.domain.entities.UsuarioCliente;
import com.example.buensaborback.service.UsuarioClienteServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "api/usuarios")
public class UsuarioClienteController extends BaseControllerImpl<UsuarioCliente, UsuarioClienteServiceImpl>{

    private UsuarioClienteServiceImpl service;
    public UsuarioClienteController(UsuarioClienteServiceImpl service) {
        super(service);
    }
}

