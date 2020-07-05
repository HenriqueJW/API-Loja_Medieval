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
@Table(name = "encomenda")
public class Encomenda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEncomenda;
    
    @Column(name = "nomeProduto")
    private String nomeProduto;
    
    @Column(name = "descricao")
    private String descricao;
    
    @Column(name = "fotoProduto")
    private String fotoProduto;
    
    @ManyToOne
    @JoinColumn(name = "Usuario_idUsuario")
    private Usuario usuario;

    
    protected Encomenda(){
    }

    public Encomenda(int idEncomenda, String nomeProduto, String descricao, String fotoProduto, Usuario usuario) {
        this.idEncomenda = idEncomenda;
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
        this.fotoProduto = fotoProduto;
        this.usuario = usuario;
    }

    public int getIdEncomenda() {
        return idEncomenda;
    }

    public void setIdEncomenda(int idEncomenda) {
        this.idEncomenda = idEncomenda;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFotoProduto() {
        return fotoProduto;
    }

    public void setFotoProduto(String fotoProduto) {
        this.fotoProduto = fotoProduto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    

 

}
