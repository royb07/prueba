package com.example.demo.controllers;

import com.example.demo.entities.Mercado;
import com.example.demo.services.MercadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/mercado")
public class MercadoController {

    private final MercadoService mercadoService;

    @Autowired
    public MercadoController(MercadoService mercadoService) {
        this.mercadoService = mercadoService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Mercado>> getAllMercados() {
        List<Mercado> mercados = mercadoService.getAllMercados();
        return new ResponseEntity<>(mercados, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Mercado> saveMercado(@RequestBody Mercado mercado) {
        Mercado savedMercado = mercadoService.saveMercado(mercado);
        return new ResponseEntity<>(savedMercado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mercado> updateMercado(@PathVariable Long id, @RequestBody Mercado mercado) {
        Mercado updatedMercado = mercadoService.updateMercado(id, mercado);
        return new ResponseEntity<>(updatedMercado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMercado(@PathVariable Long id) {
        mercadoService.deleteMercado(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/statistics")
    public ResponseEntity<Map<String, Double>> getDistributionStatisticsByCountry() {
        Map<String, Double> distributionStatistics = mercadoService.getDistributionStatisticsByCountry();
        return new ResponseEntity<>(distributionStatistics, HttpStatus.OK);
    }

}

