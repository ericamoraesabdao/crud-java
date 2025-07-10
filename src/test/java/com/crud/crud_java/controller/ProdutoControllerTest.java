package com.crud.crud_java.controller;

import com.crud.crud_java.dto.ProdutoDTO;
import com.crud.crud_java.service.ProdutoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProdutoController.class)
class ProdutoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // NÃO recomendado para @WebMvcTest, pois perde a injeção automática
    ProdutoService produtoService = Mockito.mock(ProdutoService.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deveCriarProdutoComSucesso() throws Exception {
        ProdutoDTO entrada = new ProdutoDTO();
        entrada.setNome("Produto Teste");
        entrada.setData_criacao("2024-07-10");
        entrada.setQuantidade_disponivel(10);

        ProdutoDTO salvo = new ProdutoDTO();
        salvo.setId("123");
        salvo.setNome(entrada.getNome());
        salvo.setData_criacao(entrada.getData_criacao());
        salvo.setQuantidade_disponivel(entrada.getQuantidade_disponivel());

        when(produtoService.criarProduto(any(ProdutoDTO.class))).thenReturn(salvo);

        mockMvc.perform(post("/produtos").contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(entrada))).andExpect(status().isCreated()).andExpect(jsonPath("$.id").value("123")).andExpect(jsonPath("$.nome").value("Produto Teste"));
    }

    @Test
    void deveRetornarProdutoPorId() throws Exception {
        ProdutoDTO produto = new ProdutoDTO();
        produto.setId("abc");
        produto.setNome("Produto X");
        produto.setData_criacao("2024-07-10");
        produto.setQuantidade_disponivel(5);

        when(produtoService.buscarPorId("abc")).thenReturn(Optional.of(produto));

        mockMvc.perform(get("/produtos/abc")).andExpect(status().isOk()).andExpect(jsonPath("$.id").value("abc")).andExpect(jsonPath("$.nome").value("Produto X"));
    }

    @Test
    void deveRetornar404SeProdutoNaoEncontrado() throws Exception {
        when(produtoService.buscarPorId("naoexiste")).thenReturn(Optional.empty());

        mockMvc.perform(get("/produtos/naoexiste")).andExpect(status().isNotFound()).andExpect(jsonPath("$.message").value("Produto não encontrado"));
    }
}