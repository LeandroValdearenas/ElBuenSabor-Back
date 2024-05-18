package com.example.buensaborback.controller;

import com.example.buensaborback.domain.entities.Localidad;
import com.example.buensaborback.service.LocalidadServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "api/localidades")
public class LocalidadController extends BaseControllerImpl<Localidad, LocalidadServiceImpl>{

    private LocalidadServiceImpl service;
    public LocalidadController(LocalidadServiceImpl service) {
        super(service);
    }
}

