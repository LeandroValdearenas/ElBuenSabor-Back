package com.example.buensaborback.service;

import com.example.buensaborback.domain.entities.Pais;
import com.example.buensaborback.repositories.PaisRepository;
import org.springframework.stereotype.Service;


@Service
public class PaisServiceImpl extends BaseServiceImpl<Pais, Long> implements PaisService {

    private PaisRepository paisRepository;
    public PaisServiceImpl(PaisRepository paisRepository) {
        super(paisRepository);
        this.paisRepository = paisRepository;
    }
}
