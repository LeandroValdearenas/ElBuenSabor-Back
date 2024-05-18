package com.example.buensaborback.controller;

import com.example.buensaborback.domain.entities.Factura;
import com.example.buensaborback.service.FacturaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "api/facturas")
public class FacturaController extends BaseControllerImpl<Factura, FacturaServiceImpl>{

    private FacturaServiceImpl service;
    public FacturaController(FacturaServiceImpl service) {
        super(service);
    }
}

