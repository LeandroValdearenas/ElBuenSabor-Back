package com.example.buensaborback.repositories;

import com.example.buensaborback.domain.entities.Localidad;

public interface LocalidadRepository extends BaseRepository<Localidad,Long> {
    Localidad findByNombre(String localidadNombre);
}
