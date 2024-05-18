package com.example.buensaborback.service;

import com.example.buensaborback.domain.entities.Categoria;
import com.example.buensaborback.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;


@Service
public class CategoriaServiceImpl extends BaseServiceImpl<Categoria, Long> implements CategoriaService {

    private CategoriaRepository categoriaRepository;
    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        super(categoriaRepository);
        this.categoriaRepository = categoriaRepository;
    }
}
