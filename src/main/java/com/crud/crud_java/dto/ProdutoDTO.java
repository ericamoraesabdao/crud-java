package com.crud.crud_java.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProdutoDTO {
    private String id;

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @NotBlank(message = "A data_criacao é obrigatória")
    private String data_criacao;

    @NotNull(message = "A quantidade_disponivel é obrigatória")
    private Integer quantidade_disponivel;

    // Getters e setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getData_criacao() { return data_criacao; }
    public void setData_criacao(String data_criacao) { this.data_criacao = data_criacao; }

    public Integer getQuantidade_disponivel() { return quantidade_disponivel; }
    public void setQuantidade_disponivel(Integer quantidade_disponivel) { this.quantidade_disponivel = quantidade_disponivel; }
}