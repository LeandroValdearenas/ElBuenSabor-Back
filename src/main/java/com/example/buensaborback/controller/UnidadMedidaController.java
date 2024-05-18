package com.example.buensaborback.controller;

import com.example.buensaborback.domain.entities.UnidadMedida;
import com.example.buensaborback.service.UnidadMedidaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "api/unidadesmedida")
public class UnidadMedidaController extends BaseControllerImpl<UnidadMedida, UnidadMedidaServiceImpl>{

    private UnidadMedidaServiceImpl service;
    public UnidadMedidaController(UnidadMedidaServiceImpl service) {
        super(service);
    }
}

