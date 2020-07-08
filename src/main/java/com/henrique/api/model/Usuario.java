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
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idUsuario;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sobrenome")
    private String sobrenome;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "fotoPerfil")
    private String fotoPerfil;

    @OneToOne
    @JoinColumn(name = "Endereco_idEndereco")
    private Endereco endereco;

    protected Usuario() {
    }

    public Usuario(int idUsuario, String nickname, String nome, String sobrenome, String email, String senha, String cpf, String fotoPerfil, Endereco endereco) {
        this.idUsuario = idUsuario;
        this.nickname = nickname;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.fotoPerfil = fotoPerfil;
        this.endereco = endereco;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void atualizar(Usuario novo) {
        
        if (novo.getNickname() != null && !novo.getNickname().equals("")) {
            this.nickname = novo.getNickname();
        }

        if (novo.getNome() != null && !novo.getNome().equals("")) {
            this.nome = novo.getNome();
        }

        if (novo.getSobrenome() != null && !novo.getSobrenome().equals("")) {
            this.sobrenome = novo.getSobrenome();
        }

        if (novo.getEmail() != null && !novo.getEmail().equals("")) {
            this.email = novo.getEmail();
        }

        if (novo.getSenha() != null && !novo.getSenha().equals("")) {
            this.senha = novo.getSenha();
        }

        if (novo.getCpf() != null && !novo.getCpf().equals("")) {
            this.cpf = novo.getCpf();
        }

        if (novo.getFotoPerfil()!= null && !novo.getFotoPerfil().equals("")) {
            this.fotoPerfil = novo.getFotoPerfil();
        }
        
        if(novo.getEndereco()!= null && !novo.getEndereco().equals("")){
        this.endereco = novo.getEndereco();
        }
    }

}
