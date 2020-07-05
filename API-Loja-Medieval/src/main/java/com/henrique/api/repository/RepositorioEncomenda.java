
package com.henrique.api.repository;

import com.henrique.api.model.Encomenda;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface RepositorioEncomenda extends CrudRepository<Encomenda, Integer>{
  List<Encomenda> findById(int id);

}

