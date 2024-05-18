package com.example.buensaborback.service;

import com.example.buensaborback.domain.entities.Empleado;
import com.example.buensaborback.repositories.EmpleadoRepository;
import org.springframework.stereotype.Service;


@Service
public class EmpleadoServiceImpl extends BaseServiceImpl<Empleado, Long> implements EmpleadoService {

    private EmpleadoRepository empleadoRepository;
    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository) {
        super(empleadoRepository);
        this.empleadoRepository = empleadoRepository;
    }
}
