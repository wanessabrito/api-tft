package com.example.api_tft.controller;

import com.example.api_tft.model.Campeao;
import com.example.api_tft.repository.CampeaoRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/campeoes")
public class CampeaoController {

    private final CampeaoRepository repository;

    public CampeaoController(CampeaoRepository repository) {
        this.repository = repository;
    }

    // GET - Listar todos os campeões
    @GetMapping
    public ResponseEntity<List<Campeao>> listar() {
        return ResponseEntity.ok(repository.findAll());
    }

    // GET - Buscar campeão por ID
    @GetMapping("/{id}")
    public ResponseEntity<Campeao> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST - Criar novo campeão
    @PostMapping
    public ResponseEntity<Campeao> criar(@RequestBody Campeao campeao) {
        if (campeao.getNome() == null || campeao.getClasse() == null
                || campeao.getOrigem() == null || campeao.getCusto() <= 0) {
            return ResponseEntity.badRequest().build(); // 400 Bad Request
        }
        Campeao salvo = repository.save(campeao);
        return ResponseEntity.status(201).body(salvo); // 201 Created
    }

    // PUT - Atualizar campeão existente
    @PutMapping("/{id}")
    public ResponseEntity<Campeao> atualizar(@PathVariable Long id, @RequestBody Campeao campeao) {
        return repository.findById(id).map(c -> {
            c.setNome(campeao.getNome());
            c.setClasse(campeao.getClasse());
            c.setOrigem(campeao.getOrigem());
            c.setCusto(campeao.getCusto());
            c.setDificuldade(campeao.getDificuldade());
            repository.save(c);
            return ResponseEntity.ok(c); // 200 OK
        }).orElse(ResponseEntity.notFound().build()); // 404 Not Found
    }

    // DELETE - Remover campeão por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id) {
        return repository.findById(id).map(c -> {
            repository.delete(c);
            return ResponseEntity.noContent().build(); // 204 No Content
        }).orElse(ResponseEntity.notFound().build());
    }
}
