/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.henrique.api.repository;



import com.henrique.api.model.ItemPedido;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface RepositorioItemPedido extends CrudRepository<ItemPedido, Integer>{
  List<ItemPedido> findById(int id);

}

