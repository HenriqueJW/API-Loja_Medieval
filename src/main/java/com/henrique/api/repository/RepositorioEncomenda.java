
package com.henrique.api.repository;

import com.henrique.api.model.Encomenda;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface RepositorioEncomenda extends CrudRepository<Encomenda, Integer>{
  Encomenda findById(int id);

  @Query(value = "select e.* from encomenda e\n"
            + "where usuario_id_usuario = ?1", nativeQuery = true)
    ArrayList<Encomenda> buscarPorUsuario(int id);
}

