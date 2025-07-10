package com.crud.crud_java.controller;

import com.crud.crud_java.dto.ProdutoDTO;
import com.crud.crud_java.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    // POST /produtos
    @PostMapping
    public ResponseEntity<?> criarProduto(@Valid @RequestBody ProdutoDTO dto) {
        ProdutoDTO salvo = service.criarProduto(dto);
        return ResponseEntity.status(201).body(salvo);
    }

    // GET /produtos/{id}
    @GetMapping("/{id}")
    public ResponseEntity<?> getProduto(@PathVariable String id) {
        return service.buscarPorId(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).body(Map.of("message", "Produto não encontrado")));
    }
}