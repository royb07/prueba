package com.example.demo.services.impl;

import com.example.demo.entities.Mercado;
import com.example.demo.repositories.MercadoRepository;
import com.example.demo.services.MercadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MercadoServiceImpl implements MercadoService {

    private final MercadoRepository mercadoRepository;

    @Autowired
    public MercadoServiceImpl(MercadoRepository mercadoRepository) {
        this.mercadoRepository = mercadoRepository;
    }

    @Override
    public Mercado saveMercado(Mercado mercado) {
        return mercadoRepository.save(mercado);
    }

    @Override
    public List<Mercado> getAllMercados() {
        return mercadoRepository.findAll();
    }

    @Override
    public Mercado updateMercado(Long id, Mercado mercado) {
        Mercado existingMercado = mercadoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Comitente no encontrado con el ID: " + id));

        existingMercado.setDescripcion(mercado.getDescripcion());

        return mercadoRepository.save(existingMercado);
    }

    @Override
    public void deleteMercado(Long id) {
        Mercado existingMercado = mercadoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Comitente no encontrado con el ID: " + id));

        mercadoRepository.delete(existingMercado);
    }

    @Override
    public Map<String, Double> getDistributionStatisticsByCountry() {
        List<Mercado> mercados = mercadoRepository.findAll();
        Map<String, Double> distributionStatistics = new HashMap<>();

        for (Mercado mercado : mercados) {
            String country = mercado.getPais().name();
            distributionStatistics.putIfAbsent(country, 0.0);

            double currentPercentage = distributionStatistics.get(country);
            double newPercentage = currentPercentage + (1.0 / mercados.size()) * 100;

            distributionStatistics.put(country, newPercentage);
        }

        return distributionStatistics;
    }
}
