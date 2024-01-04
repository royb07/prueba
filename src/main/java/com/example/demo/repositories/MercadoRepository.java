package com.example.demo.repositories;

import com.example.demo.entities.Mercado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MercadoRepository extends JpaRepository<Mercado, Long> {
    Optional<Mercado> findByCodigo(String codigo);

}
