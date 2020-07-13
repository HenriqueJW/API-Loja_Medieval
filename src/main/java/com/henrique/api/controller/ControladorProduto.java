package com.henrique.api.controller;

import com.henrique.api.model.Produto;
import com.henrique.api.repository.RepositorioCategoria;
import com.henrique.api.repository.RepositorioProduto;
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
public class ControladorProduto {

    RepositorioProduto repositorioProduto;
    RepositorioCategoria repositorioCategoria;

    @Autowired
    public ControladorProduto(RepositorioProduto rp, RepositorioCategoria rc) {

        this.repositorioProduto = rp;
        this.repositorioCategoria = rc;

    }

    //Lista todos os produtos
    @RequestMapping(value = "/produtos", method = RequestMethod.GET)
    public ResponseEntity<List<Produto>> listar() {

        ArrayList<Produto> produtos = new ArrayList<Produto>();

        for (Produto p : repositorioProduto.findAll()) {
            produtos.add(p);
        }

        return new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK);
    }

    //retorna o produto com o id informado
    @RequestMapping(value = "/produtos/{id}", method = RequestMethod.GET)
    public ResponseEntity<Produto> buscarProduto(@PathVariable("id") int id) {
        Produto produto = repositorioProduto.findById(id);

        if (produto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Produto>(produto, HttpStatus.OK);
    }

    //deleta o produto com id informado
    @RequestMapping(value = "/produtos/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletarProduto(@PathVariable("id") int id) {
        Produto produto = repositorioProduto.findById(id);

        if (produto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        repositorioProduto.deleteById(id);

        return new ResponseEntity<Produto>(produto, HttpStatus.OK);

    }

    //atualiza o produto com id informado
    @RequestMapping(value = "/produtos/{id}", method = RequestMethod.PUT, consumes = "application/json")
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
    @RequestMapping(value = "/produtos", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto) {

        if (produto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        repositorioProduto.save(produto);

        return new ResponseEntity<Produto>(repositorioProduto.findById(produto.getIdProduto()), HttpStatus.OK);
    }

    //Busca os produtos baseado no id da categoria passada
    @RequestMapping(value = "/produtos/categorias/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Produto>> buscarProdutoPorCategoria(@PathVariable("id") int id) {

        if (repositorioCategoria.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Produto>>(repositorioProduto.queryBuscarProdutoPorCategoria(id), HttpStatus.OK);
    }

}
