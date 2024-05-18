package com.example.buensaborback.controller;

import com.example.buensaborback.domain.entities.Empleado;
import com.example.buensaborback.service.EmpleadoServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "api/empleados")
public class EmpleadoController extends BaseControllerImpl<Empleado, EmpleadoServiceImpl>{

    private EmpleadoServiceImpl service;
    public EmpleadoController(EmpleadoServiceImpl service) {
        super(service);
    }
}

