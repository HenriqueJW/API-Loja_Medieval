package com.henrique.api.controller;

import com.henrique.api.model.Categoria;
import com.henrique.api.repository.RepositorioCategoria;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControladorCategoria {

    RepositorioCategoria repositorioCategoria;

    @Autowired
    public ControladorCategoria(RepositorioCategoria rc) {
        this.repositorioCategoria = rc;
    }
    
    //Lista as categorias
    @RequestMapping(value = "/categorias", method = RequestMethod.GET)
    public ResponseEntity<List<Categoria>> listar() {

        ArrayList<Categoria> categorias = new ArrayList<Categoria>();

        for (Categoria c : repositorioCategoria.findAll()) {
            categorias.add(c);
        }

        return new ResponseEntity<List<Categoria>>(categorias, HttpStatus.OK);
    }

    //retorna a Categoria com o id 1
    @RequestMapping(value = "/categorias/{id}", method = RequestMethod.GET)
    public ResponseEntity<Categoria> buscarCategoria(@PathVariable("id") int id) {
        Categoria categoria = repositorioCategoria.findById(id);

        if (categoria == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Categoria>(categoria, HttpStatus.OK);
    }

    //deleta a categoria com id 1
    @RequestMapping(value = "/categorias/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletarCategoria(@PathVariable("id") int id) {
        Categoria categoria = repositorioCategoria.findById(id);

        if (categoria == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        repositorioCategoria.deleteById(id);

        return new ResponseEntity<Categoria>(categoria, HttpStatus.OK);

    }

    //atualiza a Categoria com id 1
    @RequestMapping(value = "/categorias/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<Categoria> atualizarCategoria(@RequestBody Categoria novo, @PathVariable("id") int id) {

        if (novo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        novo.setIdCategoria(id);

        if (repositorioCategoria.existsById(id)) {
            Categoria antigo = repositorioCategoria.findById(id);
            antigo.atualizar(novo);
            repositorioCategoria.save(antigo);

            return new ResponseEntity<Categoria>(repositorioCategoria.findById(id), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    //cria uma nova categoria
    @RequestMapping(value = "/categorias", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Categoria> criarProduto(@RequestBody Categoria categoria) {

        if (categoria == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        repositorioCategoria.save(categoria);

        return new ResponseEntity<Categoria>(repositorioCategoria.findById(categoria.getIdCategoria()), HttpStatus.OK);
    }

}
