package com.example.demo.services.impl;

import com.example.demo.entities.Comitente;
import com.example.demo.repositories.ComitenteRepository;
import com.example.demo.services.ComitenteService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ComitenteServiceImpl implements ComitenteService {

    private final ComitenteRepository comitenteRepository;

    @Autowired
    public ComitenteServiceImpl(ComitenteRepository comitenteRepository) {
        this.comitenteRepository = comitenteRepository;
    }

    @Override
    public List<Comitente> getAllComitentes() {
        return comitenteRepository.findAll();
    }

    @Override
    public Comitente saveComitente(Comitente comitente) {

        Optional<Comitente> existingComitente = comitenteRepository.findByDescripcion(comitente.getDescripcion());

        if (existingComitente.isPresent()) {
             throw new IllegalStateException("Ya existe un Comitente con la misma descripción.");
        }

        return comitenteRepository.save(comitente);
    }

    @Override
    public Comitente updateComitente(Long id, Comitente comitente) {
        Comitente existingComitente = comitenteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Comitente no encontrado con el ID: " + id));

        existingComitente.setDescripcion(comitente.getDescripcion());

        return comitenteRepository.save(existingComitente);
    }

    @Override
    public void deleteComitente(Long id) {

    }
}

