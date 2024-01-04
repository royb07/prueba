package com.example.demo.services;

import com.example.demo.entities.Mercado;

import java.util.List;
import java.util.Map;

public interface MercadoService {
    Mercado saveMercado(Mercado mercado);
    List<Mercado> getAllMercados();
    Mercado updateMercado(Long id, Mercado mercado);
    void deleteMercado(Long id);
    Map<String, Double> getDistributionStatisticsByCountry();
}

