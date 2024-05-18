package com.example.buensaborback.service;

import com.example.buensaborback.domain.entities.Domicilio;
import com.example.buensaborback.repositories.DomicilioRepository;
import org.springframework.stereotype.Service;


@Service
public class DomicilioServiceImpl extends BaseServiceImpl<Domicilio, Long> implements DomicilioService {

    private DomicilioRepository domicilioRepository;
    public DomicilioServiceImpl(DomicilioRepository domicilioRepository) {
        super(domicilioRepository);
        this.domicilioRepository = domicilioRepository;
    }
}
