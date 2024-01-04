package com.example.demo.repositories;

import com.example.demo.entities.Comitente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComitenteRepository extends JpaRepository<Comitente, Long> {
    Optional<Comitente> findByDescripcion(String descripcion);
}

