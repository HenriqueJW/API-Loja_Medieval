INSERT INTO LojaMedieval.categoria (id_categoria,nome) VALUES 
(1,'Machados')
,(2,'Espadas')
,(3,'Armaduras')
,(4,'Escudos')
;


INSERT INTO LojaMedieval.endereco (id_endereco,bairro,cep,estado,municipio,numero,pais,rua) VALUES 
(1,'bairro1','cep1','estado1','municipio1',1,'pais1','rua1')
,(2,'bairro2','cep2','estado2','municipio2',2,'pais2','rua2')
,(3,'bairro3','cep3','estado3','municipio3',3,'pais3','rua3')
,(4,'bairro5','cep5','estado5','municipio5',5,'pais5','rua5')
,(5,'bairro','cep','estado','municipio',1,'pais','rua')
,(6,'bairro','cep','estado','municipio',1,'pais','rua')
,(7,'bairro','cep','estado','municipio',1,'pais','rua')
;


INSERT INTO LojaMedieval.usuario (id_usuario,cpf,email,foto_perfil,nickname,nome,senha,sobrenome,endereco_id_endereco) VALUES 
(1,'cpf1','email1','foto1','Lulu69','Nome 1','senha1','Sobrenome1',1)
,(2,'cpf2','email2','foto2','Pedro16','Nome 2','senha2','Sobrenome2',2)
,(3,'cpf3','email3','foto3','EliasM','Nome 3','senha3','Sobrenome3',3)
,(4,'165.588.890-05','ademiro@email.com','foto','Ademiro12','Ademiro','$2a$10$x8p5hz7n.mLJzcPxyR7t/OPHh5z2bhuDnEIpDnUfizmEjHOAWlo9q','JK',4)
,(5,'757.385.580-06','Joaozinh@email.com','foto','João BomBom','João','$2a$10$J2u7h6wDx1B22hq/iE1a9O4fG9hNalaAdljVuiDOLblTZ3vLEF6Q6','Perez',5)
,(6,'226.177.640-36','Lucas@email.com','foto','Lucas98','Lucas','$2a$10$BX1/e5WK0.OuEl7TPYkI7ePPyzZFgBS0FyvEGYPyJwZz7.4Ldn1rW','KK',6)
,(7,'757.385.580-06','akitemvideo@email.com','foto','admin','Célio','$2a$10$HU0/H2aYflDNQ4HxLPxYkOcTyM1GPALwmMWpl1RlaWndRL9YNgQFi','Rodrigues',7)
;


INSERT INTO LojaMedieval.encomenda (id_encomenda,descricao,foto_produto,nome_produto,usuario_id_usuario) VALUES 
(5,'Descricao 2','Foto 2','Encomenda 2',2)
,(6,'Descricao 3','Foto 3','Encomenda 3',3)
,(3,'Espada especial do Skyrim chamada Dawnbreaker','https://i.pinimg.com/originals/7a/0a/a7/7a0aa7f3ae8d89fb4e9bab6f3c64f288.png','Espada Especial Dawnbreak',5)
,(2,'A adaga especial do Skyrim chamada Mehrunes Razor','https://gamepedia.cursecdn.com/skyrim_gamepedia/a/a5/MehrunesRazor.png','Mehrunes Razor',5)
;


INSERT INTO LojaMedieval.pedido (id_pedido,condicao_pag,forma_pag,preco_total,usuario_id_usuario) VALUES 
(1,'A VISTA','BOLETO',2500.0,4)
,(2,'3 VEZES','CARTÃO DE CRÉDITO',5000.0,3)
,(3,'A VISTA','BOLETO',1000.0,1)
,(4,'A VISTA','BOLETO',3556.0,5)
,(5,'A VISTA','BOLETO',3556.0,4)
,(6,'A VISTA','BOLETO',3556.0,1)
,(7,'A VISTA','BOLETO',3556.0,2)
,(8,'A VISTA','BOLETO',3556.0,2)
,(9,'A VISTA','BOLETO',3556.0,3)
,(10,'A VISTA','BOLETO',3556.0,4)
;
INSERT INTO LojaMedieval.pedido (id_pedido,condicao_pag,forma_pag,preco_total,usuario_id_usuario) VALUES 
(11,'A VISTA','BOLETO',3556.0,5)
,(12,'A VISTA','BOLETO',3556.0,6)
,(13,'A VISTA','BOLETO',3556.0,6)
,(14,'A VISTA','BOLETO',3556.0,1)
,(15,'A VISTA','BOLETO',2500.0,4)
,(16,'3 VEZES','CARTÃO DE CRÉDITO',10000.0,3)
,(17,'3 VEZES','CARTÃO DE CRÉDITO',15000.0,1)
,(18,'3 VEZES','CARTÃO DE CRÉDITO',15644.0,5)
,(19,'3 VEZES','CARTÃO DE CRÉDITO',651.0,4)
,(20,'3 VEZES','CARTÃO DE CRÉDITO',5721.0,1)
;
INSERT INTO LojaMedieval.pedido (id_pedido,condicao_pag,forma_pag,preco_total,usuario_id_usuario) VALUES 
(21,'3 VEZES','CARTÃO DE CRÉDITO',6549.0,2)
,(22,'3 VEZES','CARTÃO DE CRÉDITO',3015.0,2)
,(23,'3 VEZES','CARTÃO DE CRÉDITO',874.0,3)
,(24,'3 VEZES','CARTÃO DE CRÉDITO',1652.0,4)
,(25,'A VISTA','BOLETO',114.0,5)
,(26,'A VISTA','BOLETO',1354.0,6)
,(27,'A VISTA','BOLETO',9876.0,6)
,(28,'A VISTA','BOLETO',1123.0,1)
,(29,'A VISTA','BOLETO',114.0,5)
,(30,'A VISTA','BOLETO',1354.0,6)
;
INSERT INTO LojaMedieval.pedido (id_pedido,condicao_pag,forma_pag,preco_total,usuario_id_usuario) VALUES 
(31,'A VISTA','BOLETO',9876.0,6)
,(32,'A VISTA','BOLETO',1123.0,1)
,(33,'A VISTA','BOLETO',1354.0,6)
,(34,'A VISTA','BOLETO',9876.0,6)
,(35,'A VISTA','BOLETO',9876.0,6)
,(36,'A VISTA','BOLETO',1354.0,6)
,(37,'A VISTA','BOLETO',9876.0,6)
;


INSERT INTO LojaMedieval.produto (id_produto,descricao,foto_produto,nome,preco,categoria_id_categoria) VALUES 
(7,'Uma espada de ferro de duas mãos, pertencente ao universo do jogo Skyrim.','https://gamepedia.cursecdn.com/skyrim_gamepedia/thumb/c/c7/Iron_Sword.png/1200px-Iron_Sword.png','Espada de Ferro',259.99,2)
,(8,'Um machado de aço de uma mão, pertencente ao universo do jogo Skyrim.','https://static.fandomspot.com/images/10/3212/15-skyforge-steel-war-axe.jpg','Machado de Aço',359.99,1)
,(9,'Uma armadura de couro pertencente ao universo do jogo Skyrim','https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTtm1EPfgH3WsNbVACOQVAK4D1-U5adpGgYag&usqp=CAU','Armadura de Couro',655.99,3)
,(10,'Um machado de ébano de uma mão, pertencente ao universo do jogo Skyrim.','https://vignette.wikia.nocookie.net/elderscrolls/images/d/d0/Ebonywaraxe.png/revision/latest?cb=20120513000607','Machado de Ébano',1255.99,1)
,(11,'Uma espada de anão de duas mãos, pertencente ao universo do jogo Skyrim.','https://vignette.wikia.nocookie.net/the-elder-scrolls-arquivos-imperiais/images/c/c0/Dwarvengreatsword.png/revision/latest?cb=20180427160855&path-prefix=pt-br','Espada de Anão',780.99,2)
,(16,'Uma espada de aço de duas mãos, pertencente ao universo do jogo Skyrim.','https://vignette.wikia.nocookie.net/elderscrolls/images/3/3a/SteelGreatsword_SK.png/revision/latest?cb=20121012192809','Espada de Aço de Duas Mãos',659.99,2)
,(15,'Um machado de ferro de duas mãos, pertencente ao universo do jogo Skyrim.','https://vignette.wikia.nocookie.net/elderscrolls/images/5/55/IronBattleAxe_SK.png/revision/latest?cb=20131212021844','Machado de Ferro de Duas Mãos',789.99,1)
,(14,'Uma armadura de placas de aço pertencente ao universo do jogo Skyrim','https://gamepedia.cursecdn.com/skyrim_gamepedia/2/2d/SteelPlateArmor.png','Armadura de placas de aço',1650.99,3)
,(12,'Um escudo leve pertencente ao universo do jogo Skyrim.','https://gamepedia.cursecdn.com/skyrim_gamepedia/7/7c/LightImperialShield.png','Escudo leve',480.59,4)
,(13,'Um escudo de ferro pertencente ao universo do jogo Skyrim.','https://vignette.wikia.nocookie.net/elderscrolls/images/5/58/Banded_Iron_Shield.png/revision/latest?cb=20121016233048','Escudo de ferro',580.59,4)
;
INSERT INTO LojaMedieval.produto (id_produto,descricao,foto_produto,nome,preco,categoria_id_categoria) VALUES 
(17,'Um escudo de couro pertencente ao universo do jogo Skyrim.','https://vignette.wikia.nocookie.net/elderscrolls/images/4/43/Hide_shield.png/revision/latest?cb=20121011011900','Escudo de Couro',345.99,4)
,(18,'Um escudo de ferro trabalhado pertencente ao universo do jogo Skyrim.','https://vignette.wikia.nocookie.net/elderscrolls/images/6/69/ArmorShieldofYsgramor.png/revision/latest?cb=20120512202313','Escudo de Ferro Trabalhado',1225.99,4)
,(19,'Uma armadura de placas de malaquita pertencente ao universo do jogo Skyrim','https://gamepedia.cursecdn.com/skyrim_gamepedia/0/08/OrcishArmoroftheMajorKnight.png','Armadura de Placas de Malaquita',2560.99,3)
,(20,'Uma armadura de de aço pertencente ao universo do jogo Skyrim','https://gamepedia.cursecdn.com/skyrim_gamepedia/c/c4/SteelArmor.png','Armadura de aço',1250.99,3)
,(21,'Um capacete de ébano pertencente ao universo do jogo Skyrim','https://i.pinimg.com/originals/f8/c5/7c/f8c57c341612c1abd8355e99416dc76f.png','Capacete de Ébano',2399.99,3)
,(22,'Um capacete de ferro trabalhado pertencente ao universo do jogo Skyrim','https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQzq4uKb5QuFcGLEwv-7Aoqh-chkdm06PmV9A&usqp=CAU','Capacete de Ferro Trabalhado',1845.99,3)
,(23,'Uma espada élfica, pertencente ao universo do jogo Skyrim.','https://gamepedia.cursecdn.com/skyrim_gamepedia/thumb/a/aa/ElvenSword.png/1200px-ElvenSword.png','Espada Élfica',579.99,2)
,(24,'Um machado de aço de anão, pertencente ao universo do jogo Skyrim.','https://static.fandomspot.com/images/10/3212/20-dwarven-axe.jpg','Machado de Anão',756.99,1)
;

INSERT INTO LojaMedieval.comentario (id_comentario,comentario,nota,produto_id_produto,usuario_id_usuario) VALUES 
(1,'Muito bom o produto, chegou na hora',9,7,4)
,(2,'Mais ou menos',6,8,5)
,(3,'Bom produto',8,9,6)
,(4,'Gostei bastante',10,7,1)
,(5,'Gostei',8,7,1)
,(6,'Gostei pouco',4,7,1)
,(7,'Gostei muito',9,7,1)
,(8,'Gostei bastante',8,9,1)
,(9,'Gostei bastante',8,9,1)
,(10,'Gostei bastante',9,9,1)
;
INSERT INTO LojaMedieval.comentario (id_comentario,comentario,nota,produto_id_produto,usuario_id_usuario) VALUES 
(11,'Gostei bastante',6,10,1)
,(12,'Gostei bastante',4,11,1)
,(13,'Gostei bastante',1,12,1)
,(14,'Gostei bastante',5,10,1)
,(15,'Gostei bastante',3,9,1)
,(16,'Gostei bastante',1,10,1)
,(17,'Gostei bastante',2,11,1)
,(18,'Gostei bastante',8,12,1)
,(19,'Gostei bastante',9,10,1)
;

INSERT INTO LojaMedieval.item_pedido (id_item_pedido,preco_item,preco_unitario,quantidade,pedido_id_pedido,produto_id_produto) VALUES 
(1,259.99,259.99,1,1,7)
,(2,1561.0,780.99,2,2,11)
,(3,1255.99,1255.99,1,3,10)
,(4,4059.99,259.99,20,4,18)
,(5,1561.0,780.99,6,5,12)
,(6,1255.99,1255.99,1,6,13)
,(7,259.99,259.99,1,7,14)
,(8,1561.0,780.99,5,8,15)
,(9,1255.99,1255.99,1,9,16)
,(10,259.99,259.99,4,10,17)
;
INSERT INTO LojaMedieval.item_pedido (id_item_pedido,preco_item,preco_unitario,quantidade,pedido_id_pedido,produto_id_produto) VALUES 
(11,1561.0,780.99,2,11,18)
,(12,1255.99,1255.99,7,12,19)
,(13,1651.0,259.99,5,1,20)
,(14,154.0,780.99,3,2,21)
,(15,4898.0,1255.99,13,3,22)
,(16,5123.0,259.99,4,4,23)
,(17,1221.0,780.99,6,5,24)
,(18,114.0,1255.99,1,6,8)
,(19,864.0,259.99,2,7,9)
,(20,315.0,780.99,5,8,10)
;
INSERT INTO LojaMedieval.item_pedido (id_item_pedido,preco_item,preco_unitario,quantidade,pedido_id_pedido,produto_id_produto) VALUES 
(21,894.0,1255.99,1,9,11)
,(22,1578.0,259.99,4,10,7)
,(23,3662.0,780.99,2,11,12)
,(24,5746.0,1255.99,1,12,15)
;


