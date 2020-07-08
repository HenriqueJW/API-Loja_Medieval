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
@Table(name = "comentario")
public class Comentario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idComentario;

    @Column(name = "comentario")
    private String comentario;

    @Column(name = "nota")
    private int nota;

    @ManyToOne
    @JoinColumn(name = "Usuario_idUsuario")
    private Usuario usuario;
    
     @ManyToOne
    @JoinColumn(name = "Produto_idProduto")
    private Produto produto;


    protected Comentario(){
    }

    public Comentario(int idComentario, String comentario, int nota, Usuario usuario, Produto produto) {
        this.idComentario = idComentario;
        this.comentario = comentario;
        this.nota = nota;
        this.usuario = usuario;
        this.produto = produto;
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

   

}
