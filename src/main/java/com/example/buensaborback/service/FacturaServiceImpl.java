package com.example.buensaborback.service;

import com.example.buensaborback.domain.entities.Factura;
import com.example.buensaborback.repositories.FacturaRepository;
import org.springframework.stereotype.Service;


@Service
public class FacturaServiceImpl extends BaseServiceImpl<Factura, Long> implements FacturaService {

    private FacturaRepository facturaRepository;
    public FacturaServiceImpl(FacturaRepository facturaRepository) {
        super(facturaRepository);
        this.facturaRepository = facturaRepository;
    }
}
