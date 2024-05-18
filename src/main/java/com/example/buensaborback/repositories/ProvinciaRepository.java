package com.example.buensaborback.repositories;

import com.example.buensaborback.domain.entities.Provincia;

public interface ProvinciaRepository extends BaseRepository<Provincia,Long> {
    Provincia findByNombre(String nombre);
}
