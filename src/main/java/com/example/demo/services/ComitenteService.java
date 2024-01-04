package com.example.demo.services;

import com.example.demo.entities.Comitente;

import java.util.List;
import java.util.Map;

public interface ComitenteService {

    List<Comitente> getAllComitentes();

    Comitente saveComitente(Comitente comitente);

    Comitente updateComitente(Long id, Comitente comitente);
    void deleteComitente(Long id);
}
