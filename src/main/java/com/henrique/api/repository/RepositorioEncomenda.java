
package com.henrique.api.repository;

import com.henrique.api.model.Encomenda;
import org.springframework.data.repository.CrudRepository;


public interface RepositorioEncomenda extends CrudRepository<Encomenda, Integer>{
  Encomenda findById(int id);

}

