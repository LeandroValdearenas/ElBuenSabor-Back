package com.example.buensaborback.controller;

import com.example.buensaborback.domain.entities.Domicilio;
import com.example.buensaborback.service.DomicilioServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "api/domicilios")
public class DomicilioController extends BaseControllerImpl<Domicilio, DomicilioServiceImpl>{

    private DomicilioServiceImpl service;
    public DomicilioController(DomicilioServiceImpl service) {
        super(service);
    }
}

