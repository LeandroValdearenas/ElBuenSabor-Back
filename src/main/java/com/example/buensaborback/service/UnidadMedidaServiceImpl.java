package com.example.buensaborback.service;

import com.example.buensaborback.domain.entities.UnidadMedida;
import com.example.buensaborback.repositories.UnidadMedidaRepository;
import org.springframework.stereotype.Service;


@Service
public class UnidadMedidaServiceImpl extends BaseServiceImpl<UnidadMedida, Long> implements UnidadMedidaService {

    private UnidadMedidaRepository unidadMedidaRepository;
    public UnidadMedidaServiceImpl(UnidadMedidaRepository unidadMedidaRepository) {
        super(unidadMedidaRepository);
        this.unidadMedidaRepository = unidadMedidaRepository;
    }
}
