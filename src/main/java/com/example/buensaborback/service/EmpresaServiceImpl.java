package com.example.buensaborback.service;

import com.example.buensaborback.domain.entities.Empresa;
import com.example.buensaborback.repositories.EmpresaRepository;
import org.springframework.stereotype.Service;


@Service
public class EmpresaServiceImpl extends BaseServiceImpl<Empresa, Long> implements EmpresaService {

    private EmpresaRepository empresaRepository;
    public EmpresaServiceImpl(EmpresaRepository empresaRepository) {
        super(empresaRepository);
        this.empresaRepository = empresaRepository;
    }
}
