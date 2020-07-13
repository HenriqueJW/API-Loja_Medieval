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
@Table(name = "itemPedido")
public class ItemPedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idItemPedido;

    @Column(name = "precoItem")
    private float precoItem;

    @Column(name = "precoUnitario")
    private float precoUnitario;

    @Column(name = "quantidade")
    private int quantidade;

    
    @ManyToOne
    @JoinColumn(name = "Pedido_idPedido")
    private Pedido pedido;
    
    @ManyToOne
    @JoinColumn(name = "Produto_idProduto")
    private Produto produto;

    protected ItemPedido() {
    }

    public ItemPedido(int idItemPedido, float precoItem, float precoUnitario, int quantidade, Pedido pedido, Produto produto) {
        this.idItemPedido = idItemPedido;
        this.precoItem = precoItem;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
        this.pedido = pedido;
        this.produto = produto;
    }

    public int getIdItemPedido() {
        return idItemPedido;
    }

    public void setIdItemPedido(int idItemPedido) {
        this.idItemPedido = idItemPedido;
    }

    public float getPrecoItem() {
        return precoItem;
    }

    public void setPrecoItem(float precoItem) {
        this.precoItem = precoItem;
    }

    public float getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(float precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    
}
