package com.henrique.api.controller;

import com.henrique.api.model.Produto;
import com.henrique.api.repository.RepositorioCategoria;
import com.henrique.api.repository.RepositorioProduto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;

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

        rp.save(new Produto(1, "Espada de Ferro", "Uma espada de ferro de duas mãos, pertencente ao universo do jogo Skyrim.", "https://gamepedia.cursecdn.com/skyrim_gamepedia/thumb/c/c7/Iron_Sword.png/1200px-Iron_Sword.png", 259.90f, repositorioCategoria.findById(2)));
        rp.save(new Produto(2, "Machado de Aço", "Um machado de aço de uma mão, pertencente ao universo do jogo Skyrim.", "https://static.fandomspot.com/images/10/3212/15-skyforge-steel-war-axe.jpg", 359.90f, repositorioCategoria.findById(1)));
        rp.save(new Produto(3, "Armadura de Couro", "Uma armadura de couro pertencente ao universo do jogo Skyrim", "https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTtm1EPfgH3WsNbVACOQVAK4D1-U5adpGgYag&usqp=CAU", 655.90f, repositorioCategoria.findById(3)));
        rp.save(new Produto(4, "Machado de Ébano", "Um machado de ébano de uma mão, pertencente ao universo do jogo Skyrim.", "https://vignette.wikia.nocookie.net/elderscrolls/images/d/d0/Ebonywaraxe.png/revision/latest?cb=20120513000607", 1255.90f, repositorioCategoria.findById(1)));
        rp.save(new Produto(5, "Espada de Anão", "Uma espada de anão de duas mãos, pertencente ao universo do jogo Skyrim.", "https://vignette.wikia.nocookie.net/the-elder-scrolls-arquivos-imperiais/images/c/c0/Dwarvengreatsword.png/revision/latest?cb=20180427160855&path-prefix=pt-br", 780.90f, repositorioCategoria.findById(2)));
    }

    @RequestMapping(value = "/produtos", method = RequestMethod.GET)
    public ResponseEntity<List<Produto>> listar() {

        ArrayList<Produto> produtos = new ArrayList<Produto>();

        for (Produto p : repositorioProduto.findAll()) {
            produtos.add(p);
        }

        return new ResponseEntity<List<Produto>>(produtos, HttpStatus.OK);
    }

    //retorna o produto com o id 1
    @RequestMapping(value = "/produtos/{id}", method = RequestMethod.GET)
    public ResponseEntity<Produto> buscarProduto(@PathVariable("id") int id) {
        Produto produto = repositorioProduto.findById(id);

        if (produto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Produto>(produto, HttpStatus.OK);
    }

    //deleta o produto com id 1
    @RequestMapping(value = "/produtos/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletarProduto(@PathVariable("id") int id) {
        Produto produto = repositorioProduto.findById(id);

        if (produto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        repositorioProduto.deleteById(id);

        return new ResponseEntity<Produto>(produto, HttpStatus.OK);

    }

    //atualiza o produto com id 1
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

    @RequestMapping(value = "/produtos/categorias/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Produto>> buscarProdutoPorCategoria(@PathVariable("id") int id) {

        if (repositorioCategoria.findById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Produto>>(repositorioProduto.queryBuscarProdutoPorCategoria(id), HttpStatus.OK);
    }

    
}
