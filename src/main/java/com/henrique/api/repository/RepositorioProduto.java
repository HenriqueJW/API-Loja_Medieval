package com.henrique.api.repository;

import com.henrique.api.model.Produto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioProduto extends CrudRepository<Produto, Integer> {

    Produto findById(int id);

    void deleteById(int id);

    @Query(value = "select p.* from produto p\n"
            + "where Categoria_id_Categoria = ?1", nativeQuery = true)
    ArrayList<Produto> queryBuscarProdutoPorCategoria(int id);

    @Query(value = "select * from VW_ProdutosMaisVendidos", nativeQuery = true)
    List<Object[]> queryBuscarProdutosMaisVendidos();

    @Query(value = "select a.categoria, a.nome, max(soma) as quantidade from (\n"
            + "				select c2.nome as categoria, p3.nome, sum(ip.quantidade) as soma from pedido p2\n"
            + "    				join item_pedido ip on p2.id_pedido  = ip.pedido_id_pedido \n"
            + "    				join produto p3 on p3.id_produto  = ip.produto_id_produto \n"
            + "    				join categoria c2 on c2.id_categoria = p3.categoria_id_categoria \n"
            + "				group by c2.nome ,p3.nome\n"
            + "				order by soma desc, c2.nome) a\n"
            + "group by a.categoria\n"
            + "order by quantidade desc", nativeQuery = true)
    List<Object[]> queryBuscarProdutosMaisVendidosDeCadaCategoria();

}
