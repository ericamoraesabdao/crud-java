package com.crud.crud_java.service;

// src/main/java/com/suaproposta/service/ProdutoService.java

import com.crud.crud_java.dto.ProdutoDTO;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class ProdutoService {
    // Simulando banco de dados em memória (thread-safe)
    private static final List<ProdutoDTO> produtos = new CopyOnWriteArrayList<>();

    public ProdutoDTO criarProduto(ProdutoDTO entrada) {
        ProdutoDTO novoProduto = new ProdutoDTO();
        novoProduto.setId(UUID.randomUUID().toString());
        novoProduto.setNome(entrada.getNome());
        novoProduto.setData_criacao(entrada.getData_criacao());
        novoProduto.setQuantidade_disponivel(entrada.getQuantidade_disponivel());
        produtos.add(novoProduto);
        return novoProduto;
    }

    public Optional<ProdutoDTO> buscarPorId(String id) {
        return produtos.stream().filter(p -> p.getId().equals(id)).findFirst();
    }
}