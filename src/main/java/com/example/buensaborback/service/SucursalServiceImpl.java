package com.example.buensaborback.service;

import com.example.buensaborback.domain.entities.Sucursal;
import com.example.buensaborback.repositories.SucursalRepository;
import org.springframework.stereotype.Service;


@Service
public class SucursalServiceImpl extends BaseServiceImpl<Sucursal, Long> implements SucursalService {

    private SucursalRepository sucursalRepository;
    public SucursalServiceImpl(SucursalRepository sucursalRepository) {
        super(sucursalRepository);
        this.sucursalRepository = sucursalRepository;
    }
}
