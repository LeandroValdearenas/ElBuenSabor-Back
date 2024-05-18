package com.example.buensaborback.service;

import com.example.buensaborback.domain.entities.UsuarioEmpleado;
import com.example.buensaborback.repositories.UsuarioEmpleadoRepository;
import org.springframework.stereotype.Service;


@Service
public class UsuarioEmpleadoServiceImpl extends BaseServiceImpl<UsuarioEmpleado, Long> implements UsuarioEmpleadoService {

    private UsuarioEmpleadoRepository usuarioEmpleadoRepository;
    public UsuarioEmpleadoServiceImpl(UsuarioEmpleadoRepository usuarioEmpleadoRepository) {
        super(usuarioEmpleadoRepository);
        this.usuarioEmpleadoRepository = usuarioEmpleadoRepository;
    }
}
