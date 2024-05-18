package com.example.buensaborback.controller;

import com.example.buensaborback.domain.entities.Sucursal;
import com.example.buensaborback.service.SucursalServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "api/sucursales")
public class SucursalController extends BaseControllerImpl<Sucursal, SucursalServiceImpl>{

    private SucursalServiceImpl service;
    public SucursalController(SucursalServiceImpl service) {
        super(service);
    }
}

