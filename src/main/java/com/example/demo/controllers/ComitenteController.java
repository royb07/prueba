package com.example.demo.controllers;

import com.example.demo.entities.Comitente;
import com.example.demo.services.ComitenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comitente")
public class ComitenteController {
    private final ComitenteService comitenteService;

    @Autowired
    public ComitenteController(ComitenteService comitenteService) {
        this.comitenteService = comitenteService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Comitente>> getAllComitentes() {
        List<Comitente> comitentes = comitenteService.getAllComitentes();
        return new ResponseEntity<>(comitentes, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Comitente> saveComitente(@RequestBody Comitente comitente) {
        Comitente savedComitente = comitenteService.saveComitente(comitente);
        return new ResponseEntity<>(savedComitente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comitente> updateComitente(@PathVariable Long id, @RequestBody Comitente comitente) {
        Comitente updatedComitente = comitenteService.updateComitente(id, comitente);
        return new ResponseEntity<>(updatedComitente, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComitente(@PathVariable Long id) {
        comitenteService.deleteComitente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

