-- lojamedieval.categoria definition

CREATE TABLE `categoria` (
  `id_categoria` int(11) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;



-- lojamedieval.produto definition

CREATE TABLE `produto` (
  `id_produto` int(11) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `foto_produto` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `preco` float DEFAULT NULL,
  `categoria_id_categoria` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_produto`),
  KEY `FK6r9tvvijj92b2kg869nlplhhq` (`categoria_id_categoria`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


-- lojamedieval.endereco definition

CREATE TABLE `endereco` (
  `id_endereco` int(11) NOT NULL AUTO_INCREMENT,
  `bairro` varchar(255) DEFAULT NULL,
  `cep` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `municipio` varchar(255) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `pais` varchar(255) DEFAULT NULL,
  `rua` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_endereco`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;



-- lojamedieval.usuario definition

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `cpf` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `foto_perfil` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `sobrenome` varchar(255) DEFAULT NULL,
  `endereco_id_endereco` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  KEY `FKqi0mlo5w2fym8sqqx1xj31v8a` (`endereco_id_endereco`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;


-- lojamedieval.encomenda definition

CREATE TABLE `encomenda` (
  `id_encomenda` int(11) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `foto_produto` varchar(255) DEFAULT NULL,
  `nome_produto` varchar(255) DEFAULT NULL,
  `usuario_id_usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_encomenda`),
  KEY `FK94gh6il7tpr9j6u01cwixft29` (`usuario_id_usuario`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


-- lojamedieval.pedido definition

CREATE TABLE `pedido` (
  `id_pedido` int(11) NOT NULL,
  `condicao_pag` varchar(255) DEFAULT NULL,
  `forma_pag` varchar(255) DEFAULT NULL,
  `preco_total` float DEFAULT NULL,
  `usuario_id_usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_pedido`),
  KEY `FKnfas9a3svxv8lwmkk851a3uu8` (`usuario_id_usuario`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


-- lojamedieval.item_pedido definition

CREATE TABLE `item_pedido` (
  `id_item_pedido` int(11) NOT NULL,
  `preco_item` float DEFAULT NULL,
  `preco_unitario` float DEFAULT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `pedido_id_pedido` int(11) DEFAULT NULL,
  `produto_id_produto` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_item_pedido`),
  KEY `FKkmtptr5fvjqje8f9imoh5mny2` (`pedido_id_pedido`),
  KEY `FKqwbnrrh4klcs4w1rv14qdhf5q` (`produto_id_produto`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;



-- lojamedieval.comentario definition

CREATE TABLE `comentario` (
  `id_comentario` int(11) NOT NULL,
  `comentario` varchar(255) DEFAULT NULL,
  `nota` int(11) DEFAULT NULL,
  `produto_id_produto` int(11) DEFAULT NULL,
  `usuario_id_usuario` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_comentario`),
  KEY `FKtcgunj0v1o1t76d1ds69g4e16` (`produto_id_produto`),
  KEY `FKbgrhjm7xjj8gymj98qj4jb0gb` (`usuario_id_usuario`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;


create view VW_ProdutosMaisVendidos as (select p3.nome, sum(ip.quantidade) as soma from pedido p2
	join item_pedido ip on p2.id_pedido = ip.pedido_id_pedido 
	join produto p3 on p3.id_produto = ip.produto_id_produto 
	group by p3.nome 
	order by soma desc)