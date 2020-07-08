/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.henrique.api.repository;

import com.henrique.api.model.Comentario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Micro
 */


public interface RepositorioComentario extends CrudRepository<Comentario, Integer>{
  List<Comentario> findById(int id);

}

