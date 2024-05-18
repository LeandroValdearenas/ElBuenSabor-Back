package com.example.buensaborback.service;

import com.example.buensaborback.domain.entities.ArticuloManufacturado;
import com.example.buensaborback.repositories.ArticuloManufacturadoRepository;
import org.springframework.stereotype.Service;


@Service
public class ArticuloManufacturadoServiceImpl extends BaseServiceImpl<ArticuloManufacturado, Long> implements ArticuloManufacturadoService {

    private ArticuloManufacturadoRepository articuloManufacturadoRepository;
    public ArticuloManufacturadoServiceImpl(ArticuloManufacturadoRepository articuloManufacturadoRepository) {
        super(articuloManufacturadoRepository);
        this.articuloManufacturadoRepository = articuloManufacturadoRepository;
    }
}
