<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img align="right" height="120px" src="../assets/logo.png" /></a>
<h1>FASE 2 - DATABASE PROGRAMMING</h1>
<h2>Capítulo 05: Objetos no Oracle!</h2>
</div>

<div align="center">
<h2>1. OBJETOS NO ORACLE</h2>
</div>

## 1.1 Dicionário de dados

- é um conjunto de Metadados (dados sobre os dados). 
- fornece uma descrição do banco de dados: informações sobre a sua estrutura física, sua estrutura lógica e seu conteúdo. 
- é criado durante o processo de criação do banco de dados, e consiste em uma série de tabelas e views.
- contém informações sobre os objetos do banco de dados, como tabelas, sinônimos, índices e restrições. 
- normalmente, o usuário pode ler as informações dentro do dicionário de dados,e qualquer manutenção ao dicionário de dados é feita automaticamente pelo servidor Oracle.
- há ***três tipos de views*** que permitem a consulta do dicionário de dados, e são ***prefixadas pelas palavras*** `USER_`, `ALL_` e `DBA_`.
  - `views USER_`: fornecem informações sobre os objetos de propriedade do usuário conectado.
  - `views ALL_`: fornecem informações sobre os objetos a que o usuário tem acesso.
  - `views DBA_`: de acesso exclusivo dos administradores do banco de dados e fornecem informações de todos os objetos do banco de dados.
- exemplos:

~~~sql
SELECT DISTINCT object_type 
  FROM user_objects;
-- lista os tipos de objetos criados pelo usuário conectado no momento.
-- DISTINCT elimina a duplicidade dos objetos na listagem.

SELECT DISTINCT object_type 
  FROM all_objects;
-- lista os os tipos de objetos a que o usuário conectado no momento tem acesso.
-- a diferença entre quantidade de objetos criados pelo usuário e a que ele tem acesso é notável. 
-- usado o comando DISTINCT para eliminar a duplicidade dos objetos.
~~~

## 1.2 Objetos PL/SQL armazenados

- são procedimentos, gatilhos, funções e pacotes. 
- todos esses objetos são armazenados no dicionário de dados com o seu código-fonte e com a sua compilação. 
- toda vez que um objeto PL/SQL armazenado é chamado por uma sessão, é lido a partir do dicionário de dados ou, caso tenha sido executado anteriormente e estiver disponível, a partir da memória CACHE.
- até o momento, trabalhamos com `blocos PL/SQL anônimos`:
  - são programas em PL/SQL não-nomeados, cujo código não fica armazenado no banco de dados.
  - desvantagem: precisam ser compilados toda vez que vão ser executados e não podem ser chamados por outras aplicações. Se quiser reexecutar, é necessário executar o SCRIPT com o bloco anônimo novamente.
- ao usarmos `blocos PL/SQL nomeados`:
  - vantagens:
    - procedimentos e funções são armazenados no banco de dados em formato compilado, e haverá necessidade de recompilar o código caso ocorram modificações no código ou em seus objetos dependentes.
    - outras aplicações e/ou usuários podem executá-las, desde que possuam os privilégios e autorizações para tanto. 
    - podemos passar parâmetros para os programas e, no caso das funções, podemos obter um retorno.
- há várias views com informações sobre os objetos armazenados, entre elas:

<div align="center">

Nome da view | Descrição
-------------|---------------------
USER_ARGUMENTS | Os argumentos (parâmetros) em todos os procedimentos e funções do seu esquema. 
USER_DEPENDENCIES | As dependências para os objetos que você possui. Essa visão é usada principalmente pelo banco de dados Oracle para invalidar o status dos objetos de banco de dados quando um objeto que eles dependem muda.
USER_ERRORS | O conjunto de erros recentes de compilação para todos os objetos armazenados que você possui. Essa exibição é acessada pelo comando `SHOW ERRORS` do SQL.
USER_OBJECTS | Os objetos que você possui podem, por exemplo, usar essa view para ver se um objeto está marcado como INVALID, encontrar todos os pacotes que tem EMP em seus nomes, e assim por diante.
USER_PROCEDURES | Informações sobre os seus procedimentos armazenados.
USER_SOURCE | O código-fonte do texto para todos os objetos que você possui. Muito útil para analisar o código-fonte por meio do uso de comandos SQL.
USER_TRIGGERS e USER_TRIGGER_COLS | Informações sobre os seus gatiçhos e as colunas identificadas neles. Inclui o código-finte e uma descrição dos eventos.

</div>

### 1.2.1 Exibir informações sobre os objetos armazenados
- cada linha da view USER_OBJECTS contém informações dos seus objetos do banco de dados.
- as colunas mais utilizadas são:

<div align="center">

Nome da coluna | Descrição
---------------|------------------
OBJECT_NAME | Nome do objeto.
OBJECT_TYPE | Tipo do objeto, alguns dos valores que essa coluna pode conter são: PACKAGE, FUNCTION ou TRIGGER.
STATUS | Status do objeto, pode conter os valores VALID ou INVALID.
LAST_DDL_TIME | Contém a data e hora da última alteração deste objeto.

</div>

- exemplos de consultas usando USER_OBJECTS:

~~~sql
SELECT object_name
	  FROM user_objects
	 WHERE object_type = 'TABLE'
	 ORDER BY object_name
	/
~~~

- o exemplo acima fornece uma listagem com o nome de todos os objetos do tipo TABLE pertencentes ao usuário que está executando a consulta. 
- para obter uma listagem com o nome de todos os objetos do tipo TABLE que o usuário que está executando a consulta tem acesso, basta substituir o nome da view USER_OBJECTS por ALL_OBJECTS.

~~~sql
SELECT object_type, object_name
	  FROM user_objects
	 WHERE status = 'INVALID'
	 ORDER BY object_type, object_name
	/
~~~

- o exemplo acima fornece uma listagem com o nome de todos os objetos com o STATUS de INVALID pertencentes ao usuário que está executando a consulta. 
- o STATUS de um programa PL/SQL armazenado é definido como INVALID quando um objeto do qual é dependente é alterado. 
- os ***programas com o STATUS de INVALID devem ser recompilados***, e a recompilação ***pode ser feita manualmente ou automaticamente***. A automática será feita na próxima vez que o banco de dados tentar executar o programa.

~~~sql
SELECT object_type, object_name, 
		   last_ddl_time
	  FROM user_objects
	 WHERE last_ddl_time >= TRUNC (SYSDATE)
	 ORDER BY object_type, object_name
	/
~~~

- o exemplo acima fornece uma listagem com o tipo de objeto, nome do objeto e data da última alteração de todos os objetos pertencentes ao usuário que está executando a consulta que tenham sido alterados hoje.

### 1.2.2 Exibir informações sobre o Código-Fonte
- o código-fonte de todos os programas PL/SQL que você compilou com sucesso estão disponíveis por meio da view USER_SOURCE. 
- as colunas mais utilizadas são:

<div align="center">

Nome da coluna | Descrição
--------------|-----------------------
NAME | Nome do objeto.
TYPE | Tipo do objeto. Pode variar de fonte de programa JAVA até fonte de programa de uma TRIGGER.
LINE | Número da linha do código-fonte.
TEXT | Texto do código-fonte.

</div>

- a USER_SOURCE pode ser consultada para obter várias informações significativas, como:
	- descobrir quais programas usam um determinado valor literal que precisa ser alterado.
	- verificar se os padrões de nomes de variáveis da empresa estão sendo obedecidos.
	- encontrar todos os programas PL/SQL que chamam um determinado procedimento e/ou função e/ou pacote.
- exemplo:

~~~sql
SELECT name, line, text
	  FROM user_source
	 WHERE UPPER (text) 
	  LIKE '%DEPT%'
	 ORDER BY name, line
	/
~~~

- o exemplo fornece uma listagem com o nome do programa, número da linha e o texto do código-fonte que trabalha com a tabela DEPT. 
- como é uma pesquisa em um texto, o exemplo também pode retornar linhas comentadas que possuam a palavra DEPT ou variáveis que possuam a palavra DEPT em seu nome.

### 1.2.3 Exibir informações sobre procedimento e funções
- informações sobre procedimentos e funções criadas pelo usuário podem ser obtidas por meio da view USER_PROCEDURES. 
- as colunas mais utilizadas são:

<div align="center">

Nome da coluna | Descrição
---------------|----------------------
OBJECT_NAME | Nome do objeto.
PROCEDURE_NAME | Nome do procedimento ou função.
AUTHID | Mostra se um procedimento ou função é executada com os privilégios de execução de outro programa (DEFINER) ou se é executado com os privilégios do usuário que executa o procedimento ou função (CURRENT_USER).
OBJECT_TYPE | Tipo do objeto.

</div>

- exemplo:

~~~sql
SELECT object_name
		   , procedure_name 
		FROM user_procedures
	   WHERE authid = 'CURRENT_USER'
	ORDER BY object_name, procedure_name
	/
~~~

- o exemplo fornece uma listagem com o nome do objeto e nome das funções e procedimentos que serão executados usando os privilégios de execução do usuário que executa o programa. 
- os privilégios do executor do programa são usados em tempo de execução para resolver referências a objetos de banco de dados, como tabelas.

### 1.2.4 Exibir informações sobre gatilhos (TRIGGERS)
- informações sobre os gatilhos (TRIGGERS) podem ser obtidas por meio da view USER_TRIGGERS. 
- as colunas mais utilizadas são:

<div align="center">

Nome da coluna | Descrição
---------------|-------------------------
TRIGGER_NAME | Nome do gatilho.
TRIGGER_TYPE | Texto indicando se o gatilho é do tipo AFTER ou BEFORE e se é do tipo ROW ou STATEMENT.
TRIGGERING_EVENT | Indica qual tipo de operação irá disparar o gatilho. Pode assumir os valores INSERT ou UPDATE ou DELETE ou INSERT OR UPDATE ou DELETE OR UPDATE.
TABLE_NAME | Nome da tabela em que o gatilho está definido.
STATUS | O status do gatilho, que pode ser ENABLE ou DISABLE.
WHEN_CLAUSE | Uma cláusula opcional que pode ser usada para evitar a execução desnecessária do corpo do gatilho.
TRIGGER_BODY | O código executado quando o gatilho dispara.

</div>

- exemplos:

~~~sql
SELECT *
	  FROM user_triggers 
	 WHERE status = 'DISABLED'
	/
-- fornece uma lista com informações sobre todos os gatilhos desabilitados,
-- criados pelo usuário conectado ao banco de dados.
~~~

~~~sql
SELECT *
	  FROM user_triggers 
	 WHERE table_name = 'EMP'
	   AND trigger_type LIKE '%EACH ROW'
	/
-- fornece uma lista com informações sobre todos os gatilhos
-- associados à tabela EMP e que são executados em nível de linha.
~~~

~~~sql
SELECT *
	  FROM user_triggers 
	 WHERE triggering_event LIKE '%UPDATE%'
	/
-- fornece uma lista com informações sobre todos os gatilhos
-- que são acionados quando uma operação de atualização é executada.
~~~

---

## FAST TEST

### 1. Qual é a melhor definição para metadados?
> Dados sobre dados.

### 2. Das afirmações a seguir, qual não é uma característica de um bloco PL/SQL nomeado?
> Para rodar, é necessário chamar um script com todo o conteúdo do bloco em toda execução.

### 3. A view USER_OBJECTS contém informações dos seus objetos do banco de dados. Quais os campos mais utilizados?
> OBJECT_NAME, OBJECT_TYPE, STATUS, LAST_DDL_TIME.

### 4. Em qual view é possível consultar os códigos-fontes compilados de todos os programas PL/SQL?
> USER_SOURCE.

--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)