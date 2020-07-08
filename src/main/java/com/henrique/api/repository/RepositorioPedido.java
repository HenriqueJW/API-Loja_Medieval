
package com.henrique.api.repository;



import com.henrique.api.model.Pedido;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface RepositorioPedido extends CrudRepository<Pedido, Integer>{
  List<Pedido> findById(int id);

}

