package com.example.buensaborback.service;


import com.example.buensaborback.domain.entities.Base;
import com.example.buensaborback.repositories.BaseRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<T extends Base, ID extends Serializable> implements BaseService<T, ID> {

    protected BaseRepository<T,ID> baseRepository;

    public BaseServiceImpl(BaseRepository<T, ID> baseRepository)
    {
        this.baseRepository = baseRepository;
    }

    @Override
    @Transactional
    public List<T> findAll() throws Exception {
        try {
            return baseRepository.findAll();
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    @Override
    @Transactional
    public T findById(ID id) throws Exception {
        try {
            Optional<T> entityOptional = baseRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public T save(T entity) throws Exception {
        try {
            entity = baseRepository.save(entity);
            return entity;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public T update(T entity) throws Exception {
        try {
            if (entity.getId() == null) {
                throw new Exception("La entidad a modificar debe contener un Id.");
            }
            return baseRepository.save(entity);
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(ID id) throws Exception {
        try {
            Optional<T> entityOptional = baseRepository.findById(id);
            if (entityOptional.isPresent()) {
                baseRepository.delete(entityOptional.get());
                return true;
            }else {
                throw new Exception("No existe la entidad");
            }
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
