package com.henrique.api.controller;

import com.henrique.api.model.Endereco;
import com.henrique.api.model.Usuario;
import com.henrique.api.repository.RepositorioEndereco;
import com.henrique.api.repository.RepositorioUsuario;
import java.util.Arrays;
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
public class ControladorUsuario {

    RepositorioUsuario repositorioUsuario;
    RepositorioEndereco re;

    @Autowired
    public ControladorUsuario(RepositorioUsuario ru, RepositorioEndereco re) {

        this.repositorioUsuario = ru;

        this.re = re;  

    }


    
    //retorna o usuario com o id 1
    @RequestMapping(value = "/usuarios/{id}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable("id") int id) {
        Usuario usuario = repositorioUsuario.findByidUsuario(id);

        if (usuario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }

    //deleta o usuario com id 1
    @RequestMapping(value = "/usuarios/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deletarUsuario(@PathVariable("id") int id) {
        Usuario usuario = repositorioUsuario.findByidUsuario(id);

        if (usuario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        repositorioUsuario.deleteById(id);

        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);

    }

    //atualiza o usuario com id 1
    @RequestMapping(value = "/usuarios/{id}", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<Usuario> atualizarUsuario(@RequestBody Usuario novo, @PathVariable("id") int id) {

        if (novo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        novo.setIdUsuario(id);

        if (repositorioUsuario.existsById(id)) {
            Usuario antigo = repositorioUsuario.findByidUsuario(id);
            antigo.atualizar(novo);
            repositorioUsuario.save(antigo);
            
            return new ResponseEntity<Usuario>(repositorioUsuario.findByidUsuario(id), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

      //retorna o usuario com o nick
    @RequestMapping(value = "/usuarios/nick/{nick}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> buscarUsuarioPorNick(@PathVariable("nick") String nick) {
        Usuario usuario = repositorioUsuario.findByNickname(nick);

        if (usuario == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }
    
    

}
