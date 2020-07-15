# API-Loja_Medieval
Neste repositório constam os códigos dos dois trabalhos finais da disciplina de Programação III. O trabalho 2 pode ser acessado a partir do caminho 
API-Loja_Medieval/src/main/java/Trabalho2/

A classe principal do trabalho 3 (API) pode ser encontrada no caminho
API-Loja_Medieval/src/main/java/com/henrique/api/Main.java



Para executar este projeto, é necessário antes possuir o banco de dados MariaDB (Versão utilizada no trabalho: 10.4) instalado na máquina.
Link para download: https://downloads.mariadb.org/


O usuário e senha padrões do banco são "root".
Além do banco de dados, é necessário ter criado uma database com o nome "LojaMedieval".
Comando no console do mariadb: create database LojaMedieval;
Após criada a database, será necessário executar os scripts localizados no caminho
API-Loja_Medieval/src/main/java/ScriptsSQL/

Primeiro os de criação de tabelas, após, os de inserção de registros.



É recomendado clonar o repositório para a máquina desejada, desde que possua uma IDE compatível (utilizado neste trabalho foi o NetBeans).

Após isso, compilar o código (como o projeto utiliza Maven, serão baixadas as dependências). Ao executar o código do Trabalho3 (classe Main.java), a API estará criada e rodando.

Com isso, é só abrir a pagina HTML "login.html" presente na pasta Trabalho2.
A API está configurada para operar em localhost na porta 8080, então basta abrir o html em um browser e ele conseguirá conectar.

No site, na tela de login, é possível logar com o nick e senha dos usuários cadastrados, algumas opções:
OBS: o usuário admin tem acesso à todas as encomendas realizadas por todos os usuários, bem como possui acesso à relatórios gerenciais.

Nick: admin
Senha admin


Nick: Joao BomBom
Senha joao

Após logar, será obtida a token e armazenada no local storage do browser, após isso será possível utilizar todos os endpoints da API.
OBS: como não foi implementado o cadastro de usuários (na parte do front-end), só será possível cadastrar a partir da API, ou de requests a partir do Postman. Foram implementados controladores e repositórios para todos os modelos de dados (Categorias, Usuários, Produtos, Endereços, Encomendas, Comentario) porém, somente alguns foram realmente utilizados, visto que os outros modelos fazem parte do trabalho de banco de dados 2. Os modelos principais utilizados são: Usuarios, Categorias, Encomendas e Produtos).

---Explicação da Estrutura da API---

O programa da API é dividido em pacotes, são eles:

*autenticacao: este pacote contém as classes referentes à autenticação dos usuários e da API;

*controller: este pacote contém as classes referentes aos controladores dos endpoints da API;

*model: este pacote contém as classes referentes aos modelos de dados (objetos relacionais);

*repository: este pacote contém as classes referentes à persistência dos dados no banco de dados, cada classe implementa uma versão do repositório CRUD básico fornecido pela framework.
