package com.henrique.api.model;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "produto")
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idProduto;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "fotoProduto")
    private String fotoProduto;

    @Column(name = "preco")
    private float preco;

    @ManyToOne
    @JoinColumn(name = "Categoria_id_Categoria")
    private Categoria categoria;

    protected Produto() {
    }

    public Produto(int idProduto, String nome, String descricao, String fotoProduto, float preco, Categoria categoria) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.fotoProduto = fotoProduto;
        this.preco = preco;
        this.categoria = categoria;
    }

    public String getFotoProduto() {
        return fotoProduto;
    }

    public void setFotoProduto(String fotoProduto) {
        this.fotoProduto = fotoProduto;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void atualizar(Produto novo) {

        if (novo.getNome() != null && !novo.getNome().equals("")) {
            this.nome = novo.getNome();
        }

        if (novo.getDescricao() != null && !novo.getDescricao().equals("")) {
            this.nome = novo.getNome();
        }

        if (novo.getPreco() != 0) {
            this.preco = novo.getPreco();
        }

        if (novo.getFotoProduto() != null && !novo.getFotoProduto().equals("")) {
            this.fotoProduto = novo.getFotoProduto();

            if (novo.getCategoria()!= null) {
                this.categoria = novo.getCategoria();
            }

        }
    }
    
    
    
}
