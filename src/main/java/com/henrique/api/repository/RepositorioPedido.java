
package com.henrique.api.repository;



import com.henrique.api.model.Pedido;
import org.springframework.data.repository.CrudRepository;


public interface RepositorioPedido extends CrudRepository<Pedido, Integer>{
  Pedido findById(int id);

}

