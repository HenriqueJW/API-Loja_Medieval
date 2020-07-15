package com.henrique.api.controller;

import com.henrique.api.model.Encomenda;
import com.henrique.api.model.Usuario;
import com.henrique.api.repository.RepositorioEncomenda;
import com.henrique.api.repository.RepositorioUsuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@CrossOrigin
public class ControladorEncomenda {

    RepositorioEncomenda repositorioEncomenda;
    RepositorioUsuario repositorioUsuario;

    @Autowired
    public ControladorEncomenda(RepositorioEncomenda re, RepositorioUsuario ru) {
        this.repositorioUsuario = ru;
        this.repositorioEncomenda = re;

//        re.save(new Encomenda(1, "Encomenda 1", "Descricao 1", "Foto 1", repositorioUsuario.findByidUsuario(1)));
//        re.save(new Encomenda(2, "Encomenda 2", "Descricao 2", "Foto 2", repositorioUsuario.findByidUsuario(2)));
//        re.save(new Encomenda(3, "Encomenda 3", "Descricao 3", "Foto 3", repositorioUsuario.findByidUsuario(3)));
    }

    //Lista todas as encomendas do usuario informado
    @RequestMapping(value = "/encomendas/usuario/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Encomenda>> listarEncomendasUsuario(@PathVariable("id") int id) {

        ArrayList<Encomenda> encomendas = new ArrayList<Encomenda>();

        encomendas = repositorioEncomenda.buscarPorUsuario(id);

        return new ResponseEntity<List<Encomenda>>(encomendas, HttpStatus.OK);
    }

    //Lista todas as encomendas (quando for admin)
    @RequestMapping(value = "/encomendas", method = RequestMethod.GET)
    public ResponseEntity<List<Encomenda>> listarEncomendas() {

        ArrayList<Encomenda> encomendas = new ArrayList<Encomenda>();

        for (Encomenda e : repositorioEncomenda.findAll()) {
            encomendas.add(e);
        }


        return new ResponseEntity<List<Encomenda>>(encomendas, HttpStatus.OK);
    }

    //retorna o encomenda com o id 1
    @RequestMapping(value = "/encomendas/{id}", method = RequestMethod.GET)
    public ResponseEntity<Encomenda> buscarEncomenda(@PathVariable("id") int id) {
        Encomenda encomenda = repositorioEncomenda.findById(id);

        if (encomenda == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Encomenda>(encomenda, HttpStatus.OK);
    }

    //deleta a encomenda com id 1
    
    @RequestMapping(value = "/encomendas/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Encomenda> deletarProduto(@PathVariable("id") int id) {
        Encomenda encomenda = repositorioEncomenda.findById(id);

        if (encomenda == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        repositorioEncomenda.deleteById(id);

        return new ResponseEntity<Encomenda>(encomenda, HttpStatus.OK);

    }

    //atualiza a encomenda com id 1
    
    @RequestMapping(value = "/encomendas/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<Encomenda> atualizarProduto(@RequestBody Encomenda novo, @PathVariable("id") int id) {

        if (novo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        novo.setIdEncomenda(id);

        if (repositorioEncomenda.existsById(id)) {
            Encomenda antigo = repositorioEncomenda.findById(id);
            antigo.atualizar(novo);
            repositorioEncomenda.save(antigo);

            return new ResponseEntity<Encomenda>(repositorioEncomenda.findById(id), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    //cria uma nova encomenda
    @RequestMapping(value = "/encomendas", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Encomenda> criarProduto(@RequestBody Encomenda encomenda) {
        Usuario u = encomenda.getUsuario();
        if (encomenda == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        repositorioEncomenda.save(encomenda);

        return new ResponseEntity<Encomenda>(repositorioEncomenda.findById(encomenda.getIdEncomenda()), HttpStatus.OK);
    }

}
