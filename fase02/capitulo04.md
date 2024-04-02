<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img align="right" height="120px" src="../assets/logo.png" /></a>
<h1>FASE 2 - DATABASE PROGRAMMING</h1>
<h2>Capítulo 04: Malabarismo dentro do Oracle.</h2>
</div>

<div align="center">
<h2>1. MALABARISMO DENTRO DO ORACLE</h2>
</div>

## 1.1 Mais um pouco sobre tipos de dados

- ao declarar uma variável, podemos usar o `atributo %TYPE` para que assuma o mesmo tipo e tamanho de uma coluna ou tipo de dados declarado anteriormente. Porém, é necessário criar uma variável para cada coluna consultada na tabela, caso a int4enção seja consultar todas as colunas.

~~~sql
SET SERVEROUTPUT ON

DECLARE
  v_empno emp.empno%TYPE;
  v_ename emp.ename%TYPE;
  v_job emp.job%TYPE;
  v_mgr emp.mgr%TYPE;
  v_hiredate emp.hiredate%TYPE;
  v_sal emp.sal%TYPE;
  v_comm emp.comm%TYPE;
  v_deptno emp.deptno%TYPE;

BEGIN
SELECT empno, ename, job, mgr,
       hiredate, sal, comm, deptno
  INTO v_empno, v_ename, v_job, v_mgr,
       v_hiredate, v_sal, v_comm, v_deptno
  FROM emp
 WHERE empno = 7839;
 DBMS_OUTPUT.PUT_LINE ('Codigo = ' || v_empno);
 DBMS_OUTPUT.PUT_LINE ('Nome = ' || v_ename);
 DBMS_OUTPUT.PUT_LINE ('Cargo = ' || v_job);
 DBMS_OUTPUT.PUT_LINE ('Gerente = ' || v_mgr);
 DBMS_OUTPUT.PUT_LINE ('Data = ' || v_hiredate);
 DBMS_OUTPUT.PUT_LINE ('Sala = ' || v_sal);
 DBMS_OUTPUT.PUT_LINE ('Comissao = ' || v_comm);
 DBMS_OUTPUT.PUT_LINE ('Depart. = ' || v_deptno); 
END;
/
~~~

- o `atributo %ROWTYPE`, por sua vez, fornece um tipo de registro que representa uma linha de uma tabela em um banco de dados relacional. O registro pode armazenar uma linha inteira dos dados, esses podem ser selecionados de uma tabela ou obtidos de um CURSOR ou de uma variável de CURSOR.
- as variáveis que forem declaradas usando %ROWTYPE terão o mesmo nome e tipos de dados referenciados por elas. 
- para usar a variável criada no registro, basta usar o nome do campo precedido do nome do registro. Por exemplo, se o seu registro tem o nome de EMPREC e quer referenciar o campo DEPTNO, use-o no formato EMPREC.DEPTNO.
- os campos em um registro definido por %ROWTYPE não herdam as restrições (CONSTRAINTS) e seus valores padrão.

~~~sql
SET SERVEROUTPUT ON

DECLARE
  emprec emp%ROWTYPE;

BEGIN
SELECT *
  INTO emprec
  FROM emp
 WHERE empno = 7839;
 DBMS_OUTPUT.PUT_LINE ('Codigo = ' || emprec.empno);
 DBMS_OUTPUT.PUT_LINE ('Nome = ' || emprec.ename);
 DBMS_OUTPUT.PUT_LINE ('Cargo = ' || emprec.job);
 DBMS_OUTPUT.PUT_LINE ('Gerente = ' || emprec.mgr);
 DBMS_OUTPUT.PUT_LINE ('Data = ' || emprec.hiredate);
 DBMS_OUTPUT.PUT_LINE ('Sala = ' || emprec.sal);
 DBMS_OUTPUT.PUT_LINE ('Comissao = ' || emprec.comm);
 DBMS_OUTPUT.PUT_LINE ('Depart. = ' || emprec.deptno); 
END;
/
~~~

## 1.2 Tipos de Cursores

- ao processar uma instrução de SQL, o banco de dados Oracle atribui uma área de trabalho na memória para a execução da instrução SQL, denominada `área de contexto` ou `área SQL privada` (***PRIVATE SQL AREA***), que armazena informações necessárias para executar a instrução SQL.
- na área de contexto podemos encontrar: o número de linhas processadas, um apontador e, no caso de consultas, o conjunto ativo. O conjunto ativo é o conjunto de linhas recuperadas por uma consulta, por exemplo.

~~~sql
SELECT * 
  FROM emp;
-- nesse caso, o conjunto ativo será composto por todas as linhas e colunas da tabela EMP.
~~~

~~~sql
SELECT ename, job 
  FROM emp
 WHERE deptno = 20;
-- o conjunto ativo é composto pelas colunas ENAME e JOB da tab. EMP que atendem à condição DEPTNO = 20.
~~~

- `CURSOR`:
  - é o apontador da área de contexto.
  - permite que nomeie uma instrução SQL, acesse a informação em sua área de contexto e, até certo ponto, controle seu processamento.
  - há dois tipos de cursores: Implícitos e Explícitos.

### a) `CURSOR implícito`:
- não é declarado, é criado sem a intervenção do usuário para todas as instruções de definição dos dados (DDL), manipulação dos dados (DML) e instruções SELECT...INTO que retornam apenas uma linha.
- se a consulta retornar mais de uma linha dentro do bloco PL/SQL, um erro será gerado; para corrigir esse erro, declarar um CURSOR.
- exemplo:

~~~sql
DECLARE 
  emprec emp%ROWTYPE; 
BEGIN 
SELECT SUM(sal) 
  INTO emprec.sal 
  FROM emp 
GROUP BY deptno; 
  DBMS_OUTPUT.PUT_LINE ('Salario = ' || emprec.sal); 
END;
/
-- ERROR at line 1:
-- ORA-01422: exact fetch returns more than requested number of rows
-- ORA-06512: at line 4

-- o erro gerado porque a execução do programa retornou mais de uma linha. 
-- pode ser corrigido pela adoção do uso de um CURSOR explícito!
~~~

### b) `CURSOR explícito`:
- deve ser declarado explicitamente na área declarativa (DECLARE) do bloco PL/SQL.
- permite processar várias linhas, controlar a área de contexto e os processos que nela ocorrem.
- o conjunto retornado em um CURSOR explícito é denominado ***conjunto ativo***, e seu tamanho depende da quantidade das linhas em uma tabela que atendam às condições aplicadas em uma consulta. 
- o CURSOR explícito identifica a linha que está sendo processada no momento, chamada de ***linha atual***.

- tanto CURSOR implícito quanto CURSOR explícito possuem `quatro atributos em comum`: %FOUND, %ISOPEN, %NOTFOUND e %ROWCOUNT (observação: tupla é sinônimo de linha ou registro da tabela), os quais retornam informações úteis sobre a execução dos comandos:
  - `%FOUND`: retorna verdadeiro (TRUE), caso alguma linha (tupla) tenha sido afetada.
  - `%ISOPEN`: em um CURSOR explícito, retorna verdadeiro (TRUE) caso o CURSOR esteja aberto. No caso do CURSO implícito sempre retornará como falso (FALSE), porque um CURSOR implícito sempre é fechado após a execução dos comandos associados a ele.
  - `%NOTFOUND`: retorna verdadeiro (TRUE) caso não tenha encontrado nenhuma tupla. Caso tenha encontrado, retornará falso (FALSE) até a última tupla.
  - `%ROWCOUNT`: retorna o número de tuplas do CURSOR.

~~~sql
BEGIN
   DELETE 
     FROM emp
   WHERE deptno = 10;
   DBMS_OUTPUT.PUT_LINE ('Linhas apagadas = ' || SQL%ROWCOUNT);
   ROLLBACK;
END;
/

-- neste exemplo, o BD cria um CURSOR implícito, 
-- apaga os registros do departamento 10 da tabela EMP, 
-- exibe a quantidade de linhas deletadas e desfaz a operação!
~~~

- o ***CURSOR implícito possui dois atributos adicionais***: `%BULK_ROWCOUNT` e `%BULK_EXCEPTION`.

- a sequência para execução do controle dos cursores consiste em:
  - 1. Declaração do CURSOR - Declare o cursor nomeando-o e definindo a estrutura da consulta a ser executada dentro dele.
  - 2. Abertura do CURSOR - Abra o cursor. A instrução OPEN executa a consulta e vincula as variáveis que estiverem referenciadas. As linhas identificadas pela consulta são chamadas conjunto ativo e estão agora disponíveis para extração.
  - 3. Recuperação das linhas - Extraia dados do cursor.
  - 4. Verificação do término das tuplas - Após cada extração, teste o CURSOR para qualquer linha existente. Se não existirem mais linhas para serem processadas, precisará fechar o CURSOR.
  - 5. Fechamento do CURSOR - Feche o CURSOR. A instrução CLOSE libera o conjunto ativo de linhas. Agora é possível reabrir o CURSOR e estabelecer um novo conjunto ativo, se necessário.

### 1.2.1 Declaração de Cursores Explícitos
- devem ser declarados no bloco PL/SQL e a manipulação do seu conjunto ativo deve ser realizada na área de processamento do bloco.

~~~sql
CURSOR nome_cursor IS
  consulta;
~~~








--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)