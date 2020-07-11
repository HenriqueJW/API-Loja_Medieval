package com.henrique.api.repository;

import com.henrique.api.model.Produto;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioProduto extends CrudRepository<Produto, Integer> {

    Produto findById(int id);

    void deleteById(int id);
    
    @Query(value = "select p.* from produto p\n"
            + "where Categoria_id_Categoria = ?1", nativeQuery = true)
    ArrayList<Produto> queryBuscarProdutoPorCategoria(int id);
}
