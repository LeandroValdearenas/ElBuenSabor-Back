package com.example.buensaborback.service;

import com.example.buensaborback.domain.entities.Localidad;
import com.example.buensaborback.repositories.LocalidadRepository;
import org.springframework.stereotype.Service;


@Service
public class LocalidadServiceImpl extends BaseServiceImpl<Localidad, Long> implements LocalidadService {

    private LocalidadRepository localidadRepository;
    public LocalidadServiceImpl(LocalidadRepository localidadRepository) {
        super(localidadRepository);
        this.localidadRepository = localidadRepository;
    }
}
