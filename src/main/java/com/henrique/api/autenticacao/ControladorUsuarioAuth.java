
package com.henrique.api.autenticacao;

import com.henrique.api.model.Usuario;
import com.henrique.api.repository.RepositorioEndereco;
import com.henrique.api.repository.RepositorioUsuario;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class ControladorUsuarioAuth {

    private RepositorioUsuario repositorioUsuario;
    private RepositorioEndereco repositorioEndereco;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public ControladorUsuarioAuth(RepositorioUsuario repositorioUsuario,
                          BCryptPasswordEncoder bCryptPasswordEncoder, RepositorioEndereco repositorioEndereco) {
        this.repositorioUsuario = repositorioUsuario;
        this.repositorioEndereco = repositorioEndereco;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/cadastro")
    public void signUp(@RequestBody Usuario usuario) {
        usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
        repositorioEndereco.save(usuario.getEndereco());
        repositorioUsuario.save(usuario);
    }
}