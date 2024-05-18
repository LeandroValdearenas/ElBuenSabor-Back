package com.example.buensaborback.controller;

import com.example.buensaborback.domain.entities.Provincia;
import com.example.buensaborback.service.ProvinciaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "api/provincias")
public class ProvinciaController extends BaseControllerImpl<Provincia, ProvinciaServiceImpl>{

    private ProvinciaServiceImpl service;
    public ProvinciaController(ProvinciaServiceImpl service) {
        super(service);
    }
}

