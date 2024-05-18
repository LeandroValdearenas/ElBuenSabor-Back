package com.example.buensaborback.controller;

import com.example.buensaborback.domain.entities.Empresa;
import com.example.buensaborback.service.EmpresaServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "api/empresas")
public class EmpresaController extends BaseControllerImpl<Empresa, EmpresaServiceImpl>{

    private EmpresaServiceImpl service;
    public EmpresaController(EmpresaServiceImpl service) {
        super(service);
    }
}

