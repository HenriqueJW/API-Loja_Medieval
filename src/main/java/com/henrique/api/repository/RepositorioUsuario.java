package com.henrique.api.repository;

import com.henrique.api.model.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioUsuario extends CrudRepository<Usuario, Integer> {

    Usuario findByidUsuario(int id);

    void deleteById(int id);

    boolean existsById(int id);

    Usuario findByNickname(String nickname);

    @Query(value = "select u2.nickname, sum(ip.quantidade) as soma from pedido p2\n"
            + "    join item_pedido ip on p2.id_pedido  = ip.pedido_id_pedido \n"
            + "    join produto p3 on p3.id_produto  = ip.produto_id_produto \n"
            + "    join usuario u2 on u2.id_usuario = p2.usuario_id_usuario \n"
            + "group by u2.nickname\n"
            + "order by soma desc", nativeQuery = true)
    List<Object[]> queryBuscarUsuariosQueMaisCompraram();

    @Query(value = "select u.nickname, count(c.usuario_id_usuario ) as contador from comentario c \n"
            + "	join usuario u on u.id_usuario = c.usuario_id_usuario \n"
            + "group by u.nickname \n"
            + "order by contador desc", nativeQuery = true)
    List<Object[]> queryBuscarUsuariosQueMaisComentaram();

    @Query(value = "select u2.nickname, count(p2.id_pedido) as contagem from pedido p2\n"
            + "    join usuario u2 on u2.id_usuario = p2.usuario_id_usuario \n"
            + "group by u2.nickname\n"
            + "having(contagem > 10)\n"
            + "order by contagem desc", nativeQuery = true)
    List<Object[]> queryBuscarUsuariosQueCompraramMaisQue10();

}
