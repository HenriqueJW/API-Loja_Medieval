package com.henrique.api.controller;

import com.henrique.api.model.Produto;
import com.henrique.api.repository.RepositorioProduto;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControladorProduto {

    RepositorioProduto repositorioProduto;

    @Autowired
    public ControladorProduto(RepositorioProduto rp) {

        this.repositorioProduto = rp;

        rp.save(new Produto(1, "Produto1", "Descricao1", 1));
        rp.save(new Produto(2, "Produto2", "Descricao2", 2));
        rp.save(new Produto(3, "Produto3", "Descricao3", 3));

    }

    //retorna o produto com o id 1
    @RequestMapping(value = "/produto/{id}", method = RequestMethod.GET)
    public ResponseEntity<Produto> buscarProduto(@PathVariable("id") int id) {
        Produto produto = repositorioProduto.findById(id);

        if (produto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Produto>(produto, HttpStatus.OK);
    }

    //deleta o produto com id 1
    @RequestMapping(value = "/deleteProduto/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletarProduto(@PathVariable("id") int id) {
        Produto produto = repositorioProduto.findById(id);

        if (produto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        repositorioProduto.deleteById(id);

        return new ResponseEntity<Produto>(produto, HttpStatus.OK);

    }

    //atualiza o produto com id 1
    @RequestMapping(value = "/updateProduto/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<Produto> atualizarProduto(@RequestBody Produto novo, @PathVariable("id") int id) {

        if (novo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        novo.setIdProduto(id);

        if (repositorioProduto.existsById(id)) {
            Produto antigo = repositorioProduto.findById(id);
            antigo.atualizar(novo);
            repositorioProduto.save(antigo);

            return new ResponseEntity<Produto>(repositorioProduto.findById(id), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    //cria um novo prodouto
    @RequestMapping(value = "/createProduto", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto) {

        if (produto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        repositorioProduto.save(produto);

        return new ResponseEntity<Produto>(repositorioProduto.findById(produto.getIdProduto()), HttpStatus.OK);
    }

}
