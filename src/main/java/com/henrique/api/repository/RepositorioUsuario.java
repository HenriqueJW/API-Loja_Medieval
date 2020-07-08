
package com.henrique.api.repository;



import com.henrique.api.model.Usuario;
import org.springframework.data.repository.CrudRepository;


public interface RepositorioUsuario extends CrudRepository<Usuario, Integer>{
    
  Usuario findById(int id);

  void deleteById(int id);

  boolean existsById(int id);

  Usuario findByNickname(String username);


}

