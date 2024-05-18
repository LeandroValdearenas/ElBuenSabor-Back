package com.example.buensaborback.service;

import com.example.buensaborback.domain.entities.Promocion;
import com.example.buensaborback.repositories.PromocionRepository;
import org.springframework.stereotype.Service;


@Service
public class PromocionServiceImpl extends BaseServiceImpl<Promocion, Long> implements PromocionService {

    private PromocionRepository promocionRepository;
    public PromocionServiceImpl(PromocionRepository promocionRepository) {
        super(promocionRepository);
        this.promocionRepository = promocionRepository;
    }
}
