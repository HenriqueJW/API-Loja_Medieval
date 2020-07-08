package com.henrique.api.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPedido;

    @Column(name = "precoTotal")
    private float precoTotal;

    @Column(name = "condicaoPag")
    private String condicaoPag;

    @Column(name = "formaPag")
    private String formaPag;

    @OneToOne
    @JoinColumn(name = "Usuario_idUsuario")
    private Usuario usuario;

    protected Pedido() {
    }

    public Pedido(int idPedido, float precoTotal, String condicaoPag, String formaPag, Usuario usuario) {
        this.idPedido = idPedido;
        this.precoTotal = precoTotal;
        this.condicaoPag = condicaoPag;
        this.formaPag = formaPag;
        this.usuario = usuario;
    }

    
    

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public float getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(float precoTotal) {
        this.precoTotal = precoTotal;
    }

    public String getCondicaoPag() {
        return condicaoPag;
    }

    public void setCondicaoPag(String condicaoPag) {
        this.condicaoPag = condicaoPag;
    }

    public String getFormaPag() {
        return formaPag;
    }

    public void setFormaPag(String formaPag) {
        this.formaPag = formaPag;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    

    
}
