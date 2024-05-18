package com.example.buensaborback.controller;

import com.example.buensaborback.domain.entities.Pais;
import com.example.buensaborback.service.PaisServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "api/paises")
public class PaisController extends BaseControllerImpl<Pais, PaisServiceImpl>{

    private PaisServiceImpl service;
    public PaisController(PaisServiceImpl service) {
        super(service);
    }
}

