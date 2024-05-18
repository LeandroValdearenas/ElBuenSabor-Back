package com.example.buensaborback.service;

import com.example.buensaborback.domain.entities.UsuarioCliente;
import com.example.buensaborback.repositories.UsuarioClienteRepository;
import org.springframework.stereotype.Service;


@Service
public class UsuarioClienteServiceImpl extends BaseServiceImpl<UsuarioCliente, Long> implements UsuarioClienteService {

    private UsuarioClienteRepository usuarioClienteRepository;
    public UsuarioClienteServiceImpl(UsuarioClienteRepository usuarioClienteRepository) {
        super(usuarioClienteRepository);
        this.usuarioClienteRepository = usuarioClienteRepository;
    }
}
