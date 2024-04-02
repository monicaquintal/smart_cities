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
- não se deve incluir a cláusula INTO na declaração de CURSOR, porque aparecerá posteriormente na instrução FETCH.

~~~sql
CURSOR nome_cursor IS
  consulta;
~~~

- pode-se fazer referência a variáveis dentro da consulta, mas devem ser declaradas antes da instrução CURSOR.
- exemplo do uso da declaração de um CURSOR:

~~~sql
DECLARE
  CURSOR cursor_emp IS 
      SELECT deptno, SUM(sal) 
      FROM emp 
     GROUP BY deptno;
     ...
~~~

- CURSOR_EMP fará a soma dos salários de todos os funcionários e os agrupará pelo código do departamento em que trabalham. 
- após a declaração do CURSOR, devemos abri-lo.

### 1.2.2 Abertura do Cursor
- a instrução OPEN abre o CURSOR para executar a consulta e identificar o conjunto ativo, que consiste em todas as linhas que atendem aos critérios de pesquisa da consulta. 
- o CURSOR aponta agora para a primeira linha do conjunto ativo.

~~~sql
OPEN nome_cursor;
~~~

- `OPEN` é uma instrução executável que realiza as operações:
  - aloca memória dinamicamente para uma área de contexto que finalmente conterá informações cruciais de processamento.
  - analisa a instrução SELECT.
  - vincula as variáveis de entrada (define o valor das variáveis de entrada obtendo seus endereços de memória).
  - identifica o conjunto ativo (conjunto de linhas que satisfaz os critérios de pesquisa). As linhas no conjunto ativo não são recuperadas para variáveis quando a instrução OPEN é executada. Em vez disso, a instrução FETCH recupera as linhas.
  - posiciona o indicador imediatamente antes da primeira linha no conjunto ativo.

> Se a consulta não retornar qualquer linha quando o CURSOR for aberto, o PL/SQL não criará uma exceção, é possível testar o status do CURSOR após a extração.

~~~sql
DECLARE 
  CURSOR cursor_emp IS 
         SELECT deptno, SUM(sal) 
         FROM emp 
      GROUP BY deptno;
BEGIN
   OPEN cursor_emp;
END;
/
~~~

- nessa continuação do exemplo anterior, após definir CURSOR_EMP, o abrimos com o comando OPEN.
- o próximo passo é usarmos a instrução FETCH para recuperarmos os dados do conjunto ativo.

### 1.2.3 Recuperação das linhas do CURSOR
- a instrução FETCH recupera as linhas no conjunto ativo uma de cada vez; após cada extração, o CURSOR avança para a próxima linha no conjunto ativo.

~~~sql
FETCH cursor_name
 INTO [variável1, variável2, ...|record_name];

 -- variável: variável de saída para armazenar os resultados, 
 -- -- o número de variáveis deve ser compatível com o número de colunas da consulta.
 -- record_name: nome do registro em que os dados recuperados são armazenados.
 -- -- variável de registro pode ser declarada usando o atributo %ROWTYPE.
~~~

- a instrução FETCH realiza as operações:
  - avança o indicador para a próxima linha no conjunto ativo.
  - lê os dados da linha atual para as variáveis PL/SQL de saída.

- `importante`:
  - deve-se incluir o mesmo número de variáveis na cláusula INTO da instrução FETCH do que as colunas na instrução SELECT, as variáveis devem ser do mesmo tipo de dado da coluna correspondente.
    - como alternativa, pode ser definido um registro para o CURSOR que faça referência do registro na cláusula FETCH INTO.
  - também é necessário verificar se o CURSOR possui linhas. 
    - se uma extração não obtiver valores, não existem linhas remanescentes para serem processadas no conjunto ativo e nenhum erro será registrado.
    - no caso de não existirem mais linhas, é chegado o momento de fechar o CURSOR.

~~~sql
DECLARE
  emprec emp%ROWTYPE; 
  CURSOR cursor_emp IS 
         SELECT deptno, SUM(sal) 
          FROM emp 
        GROUP BY deptno;
BEGIN
   OPEN cursor_emp;
   FETCH cursor_emp INTO emprec.deptno, emprec.sal;
   DBMS_OUTPUT.PUT_LINE ('Departamento: ' || emprec.deptno);
   DBMS_OUTPUT.PUT_LINE ('Salario : ' || emprec.sal);
END;
/
~~~

- esse exemplo cria uma variável do tipo ROWTYPE de nome EMPREC, define CURSOR_EMP, que abre com o comando OPEN, extrai os dados com a instrução FETCH e exibe os códigos do departamento e a soma dos salários desse departamento. Existe um problema grave nesse código: ele executa a instrução FETCH uma vez. Para que o programa funcione corretamente é necessário que a instrução FETCH seja executa até que todos os dados sejam extraídos. Será necessário acrescentar um laço de repetição, ou LOOP, para que extraiamos todos os dados do conjunto ativo.
- exemplo:

~~~sql
DECLARE
  emprec emp%ROWTYPE; 
  CURSOR cursor_emp IS 
         SELECT deptno, SUM(sal) 
          FROM emp 
        GROUP BY deptno;
BEGIN
   OPEN cursor_emp;
   LOOP
      FETCH cursor_emp INTO emprec.deptno, emprec.sal;
      EXIT WHEN cursor_emp%NOTFOUND;
      DBMS_OUTPUT.PUT_LINE ('Departamento: ' || emprec.deptno);
      DBMS_OUTPUT.PUT_LINE ('Salario : ' || emprec.sal);
   END LOOP;
END;
/
~~~

- no exemplo acima, incluímos a instrução LOOP. O laço será encerrado quando o atributo %NOTFOUND retornar o valor TRUE. Esse atributo retorna TRUE quando não localiza mais nenhuma tupla no conjunto ativo.

### 1.2.4 Fechamento de CURSOR
- a instrução CLOSE desativa o CURSOR e o conjunto ativo se torna indefinido.
- é uma boa prática fechar o CURSOR após completar o processamento da instrução SELECT. Se necessário, poderá ser reaberto, e o conjunto ativo pode ser estabelecido diversas vezes durante a execução do programa.
- ao fecharmos um CURSOR, a área de contexto é liberada.

~~~sql
CLOSE nome_cursor;
~~~

~~~sql
DECLARE
  emprec emp%ROWTYPE;  
  CURSOR cursor_emp IS 
         SELECT deptno, SUM(sal) 
          FROM emp 
        GROUP BY deptno;
BEGIN
   OPEN cursor_emp;
   LOOP
      FETCH cursor_emp INTO emprec.deptno, emprec.sal;
      EXIT WHEN cursor_emp%NOTFOUND;
      DBMS_OUTPUT.PUT_LINE ('Departamento: ' || emprec.deptno);
      DBMS_OUTPUT.PUT_LINE ('Salario : ' || emprec.sal);
   END LOOP;
   CLOSE cursor_emp;
END;
/
~~~

> A forma tradicional de trabalhar com CURSOR envolve a declaração do CURSOR, abrir o CURSOR, extrair o conjunto ativo dentro de um laço e, finalmente, encerrar. Com a evolução da linguagem PL/SQL, foram criadas outras formas de trabalhar.

### 1.2.5 LOOPS de CURSOR FOR
- é uma forma mais simplificada de usar o CURSOR, que é aberto implicitamente.
- os dados do conjunto ativo são extraídos a cada iteração do LOOP. 
- o LOOP é encerrado assim que a última tupla for processada e o CURSOR é encerrado implicitamente.

~~~sql
FOR nome_registro IN nome_cursor LOOP
  -- Instruções;
END LOOP;
~~~

~~~sql
DECLARE 
  CURSOR cursor_emp IS 
    SELECT deptno, SUM(sal) soma 
    FROM emp 
  GROUP BY deptno; 
BEGIN 
  FOR emprec IN cursor_emp LOOP 
    DBMS_OUTPUT.PUT_LINE ('Departamento: ' || emprec.deptno); 
    DBMS_OUTPUT.PUT_LINE ('Salario : ' || emprec.soma); 
  END LOOP; 
END; 
/
~~~

- nesse exemplo, as operações de OPEN, FETCH e CLOSE foram executadas implicitamente dentro do laço FOR.

### 1.2.6 LOOPS FOR de CURSOR usando subconsulta
- a evolução da linguagem PL/SQL acabou levando a não ser mais necessário declarar um CURSOR explicitamente na sessão de DECLARE. 
- o CURSOR pode ser substituído por uma subconsulta dentro do LAÇO FOR. 
- não será possível fazer referência aos atributos de CURSORES explícitos se usar uma subconsulta em um loop FOR de CURSOR,porque não poderá dar um nome explícito.

~~~sql
BEGIN 
  FOR emprec IN (SELECT deptno, SUM(sal) soma 
    FROM emp GROUP BY deptno) 
  LOOP 
    DBMS_OUTPUT.PUT_LINE ('Departamento: ' || emprec.deptno); 
    DBMS_OUTPUT.PUT_LINE ('Salario: ' || emprec.soma); 
  END LOOP; 
END; 
/
~~~

### 1.2.7 Cursores de atualização
- o comando SELECT FOR UPDATE permite que bloqueie (LOCK) as linhas específicas de uma tabela para garantir que nenhuma alteração será efetuada nessas linhas após lê-las e serem alocadas no conjunto ativo. 
- usar a cláusula FOR UPDATE para adquirir bloqueios exclusivos ao declarar um CURSOR que será referenciado na cláusula CURRENT OF de uma instrução UPDATE ou DELETE.
- a instrução SELECT... FOR UPDATE identifica as linhas que serão atualizadas ou excluídas e bloqueará cada linha no conjunto dos resultados.
- a palavra-chave opcional NOWAIT diz à Oracle que não aguarde, se as linhas solicitadas foram bloqueadas por outro usuário. O controle é imediatamente retornado ao seu programa para que possa fazer outros trabalhos antes de tentar novamente adquirir o bloqueio. 
- se omitir a palavra-chave NOWAIT, a Oracle aguarda até que as linhas estejam disponíveis.
- exemplo:

~~~sql
DECLARE
  emprec emp%ROWTYPE; 
  CURSOR cursor_emp IS 
         SELECT empno, sal 
          FROM emp
            FOR UPDATE; 
BEGIN
   OPEN cursor_emp;
   LOOP
      FETCH cursor_emp INTO emprec.empno, emprec.sal;
      EXIT WHEN cursor_emp%NOTFOUND;
      UPDATE emp SET sal = sal * 1.05 WHERE CURRENT OF cursor_emp;
   END LOOP;
   CLOSE cursor_emp;
END;
/

-- a cada iteração do laço, atualiza o salário do funcionário em 5%.
~~~

---

## FAST TEST

### 1. Qual é a melhor forma de extrairmos todas as colunas de uma tabela para variáveis no PL/SQL?
> Declarar uma variável do tipo %ROWTIPE.

### 2. Qual é o número máximo de linhas que uma consulta que salva valores a variáveis pode retornar?
> Pode retornar 1 linha.

### 3. Qual é a operação que recupera as linhas de um cursor?
> FETCH.

### 4. Qual dos seguintes atributos não é um atributo comum para cursores explícito e implícito?
> %BULK_ROWCOUNT.

--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)