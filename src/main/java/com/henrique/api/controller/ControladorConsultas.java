package com.henrique.api.controller;

import com.henrique.api.model.Categoria;
import com.henrique.api.repository.RepositorioProduto;
import com.henrique.api.repository.RepositorioUsuario;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/consultas")
public class ControladorConsultas {

    RepositorioProduto repositorioProdutos;
    RepositorioUsuario repositorioUsuarios;

    @Autowired
    public ControladorConsultas(RepositorioProduto repositorioProdutos, RepositorioUsuario repositorioUsuarios) {
        this.repositorioProdutos = repositorioProdutos;
        this.repositorioUsuarios = repositorioUsuarios;
    }

    
   
    
    @RequestMapping(value = "/produtosMaisVendidos", method = RequestMethod.GET)
    public ResponseEntity<List<Object[]>> listarprodutosMaisVendidos() {

        List<Object[]> r = repositorioProdutos.queryBuscarProdutosMaisVendidos();


        return new ResponseEntity<List<Object[]>>(r, HttpStatus.OK);
    }
    
    
    @RequestMapping(value = "/usuariosQueMaisCompraram", method = RequestMethod.GET)
    public ResponseEntity<List<Object[]>> listarusuariosQueMaisCompraram() {

        List<Object[]> r = repositorioUsuarios.queryBuscarUsuariosQueMaisCompraram();


        return new ResponseEntity<List<Object[]>>(r, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/usuariosQueMaisComentaram", method = RequestMethod.GET)
    public ResponseEntity<List<Object[]>> listarusuariosQueMaisComentaram() {

        List<Object[]> r = repositorioUsuarios.queryBuscarUsuariosQueMaisComentaram();


        return new ResponseEntity<List<Object[]>>(r, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/usuariosQueCompraramMaisQue10", method = RequestMethod.GET)
    public ResponseEntity<List<Object[]>> listarususuariosQueCompraramMaisQue10() {

        List<Object[]> r = repositorioUsuarios.queryBuscarUsuariosQueCompraramMaisQue10();


        return new ResponseEntity<List<Object[]>>(r, HttpStatus.OK);
    }

    
    @RequestMapping(value = "/produtosMaisVendidosDeCadaCategoria", method = RequestMethod.GET)
    public ResponseEntity<List<Object[]>> listarprodutosMaisVendidosDeCadaCategoria() {

        List<Object[]> r = repositorioProdutos.queryBuscarProdutosMaisVendidosDeCadaCategoria();


        return new ResponseEntity<List<Object[]>>(r, HttpStatus.OK);
    }
}
