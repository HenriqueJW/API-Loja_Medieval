/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.henrique.api.repository;


import com.henrique.api.model.Endereco;
import org.springframework.data.repository.CrudRepository;


public interface RepositorioEndereco extends CrudRepository<Endereco, Integer>{
  Endereco findById(int idEndereco);
  Endereco save(Endereco e);
}

