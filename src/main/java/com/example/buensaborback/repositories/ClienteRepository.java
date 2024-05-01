package com.example.buensaborback.repositories;

import com.example.buensaborback.domain.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteRepository extends BaseRepository<Cliente,Long> {
}
