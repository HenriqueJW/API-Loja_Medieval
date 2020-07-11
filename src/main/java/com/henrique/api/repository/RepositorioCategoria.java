/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.henrique.api.repository;

import com.henrique.api.model.Categoria;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Micro
 */


public interface RepositorioCategoria extends CrudRepository<Categoria, Integer>{
  Categoria findById(int id);
}

