package com.henrique.api.repository;

import com.henrique.api.model.Produto;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioProduto extends CrudRepository<Produto, Integer> {

    Produto findById(int id);

    void deleteById(int id);
}
