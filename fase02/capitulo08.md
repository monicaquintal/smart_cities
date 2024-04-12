<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img align="right" height="120px" src="../assets/logo.png" /></a>
<h1>FASE 2 - DATABASE PROGRAMMING</h1>
<h2>Capítulo 08: Crie suas próprias funções no Oracle.</h2>
</div>

<div align="center">
<h2>1. CRIE SUAS PRÓPRIAS FUNÇÕES NOORACLE</h2>
</div>

- Muito parecidas com as procedures, as funções têm como características o retorno de valores e a utilização como parte de uma expressão.

## 1.1 Bloco PL/SQL nomeado

- assim como o PROCEDURE, a função (FUNCTION) é um bloco de código PL/SQL que recebe um nome e pode ser executada por outras aplicações e/ou usuários, que executarão as funções e procedimentos, caso recebam permissão para isso.
- o bloco nomeado de uma função é conhecido por vários nomes: função armazenada (STORED FUNCTION), função do usuário (USER FUNCTION), função definida pelo usuário (USER-DEFINED FUNCTION), subprograma ou sub-rotina.

## 1.2 A função

- muito semelhante a um procedimento ou PROCEDURE. 
- o que a difere, do ponto de vista estrutural, é a inclusão da `cláusula RETURN`: nas funções há obrigatoriedade de um retorno à rotina chamadora, enquanto no procedimento não existe essa obrigatoriedade. 
- pode-se dizer que uma função é chamada como parte de uma expressão.
- diferenças entre procedimentos e funções: 

<div align="center">

Procedimento | Função
-------------|----------------
É chamado em uma declaração SQL, blocos PL/SQL ou por uma aplicação. | É chamada como parte de uma expressão.
Não contém a cláusula RETURN no cabeçalho. | Contém a cláusula RETURN no cabeçalho.
Pode retornar nenhum, um ou vários valores. | Retorna somente um valor.
Pode devolver um retorno à rotima chamadora. | Retorna obrigatoriamente um valor à rotina chamadora.

</div>

- sintaxe para a criação de uma função:

~~~sql
CREATE [ OR REPLACE] FUNCTION nome_função
[(parâmetro [in] tipo_parâmetro,
  ...
return tipo_do_retorno

{IS ou AS}

BEGIN
   corpo_da_função
END nome_função;
~~~

- onde:
  - ***CREATE OR REPLACE***: instrução para criação ou substituição da função.
  - ***nome_função***.
  - ***parâmetro [parâmetro [in]]***: nome do parâmetro que poderá ser somente de entrada.
  - ***tipo_parâmetro***: tipo de dado que o parâmetro poderá aceitar; somente pode ser IN.
  - ***return tipo_do_retorno***: indica o retorno do controle à rotina chamadora com o valor que será devolvido.
  - ***IS ou ASV***: têm a mesma função e indicam o bloco que estará associado à função, substitui a palavra reservada DECLARE.
  - ***BEGIN corpo_do_procedimento END***: são, respectivamente, o início do bloco, o conjunto de instruções da funçãoe o final do bloco.

### a) exemplo 1:

~~~sql
CREATE OR REPLACE FUNCTION descobrir_salario
(p_id IN emp.empno%TYPE)
RETURN NUMBER
IS
v_salario emp.sal%TYPE := 0;
BEGIN
SELECT sal INTO v_salario
  FROM emp
 WHERE empno = p_id;
RETURN v_salario;
END descobrir_salario;
/
~~~

- esse exemplo cria a função DESCOBRIR_SALARIO, que recebe código de um funcionário e devolve para a rotina chamadora o salário do empregado pesquisado.
- testando a função:

~~~sql
SELECT empno, DESCOBRIR_SALARIO(empno)
FROM emp;
~~~

- o teste exibe o código de cada funcionário e executa a função DESCOBRIR_SALARIO com o código de cada funcionário como entrada e retorna o salário de cada um deles.
- a função DESCOBRIR_SALARIO foi executada uma vez para cada linha retornada pela consulta que foi executada com o valor do código do empregado obtido pelo cursor implícito.

- também podemos executar a função em outra função, procedimento ou bloco anônimo; exemplo:

~~~sql
SET SERVEROUTPUT ON

BEGIN
   DBMS_OUTPUT.PUT_LINE(DESCOBRIR_SALARIO(7900));
END;
/
~~~

- no exemplo, executamos a função DESCOBRIR_SALARIO em bloco PL/SQL anônimo. A função recebe como entrada o código do funcionário 7900 e retorna o seu salário para o programa chamador, que o exibe.

### b) exemplo 2:
- criar mais uma função, mas desta vez não terá valores de entrada, apenas o valor de retorno:

~~~sql
CREATE OR REPLACE FUNCTION contadept
RETURN number IS 
   total NUMBER(7) := 0; 
BEGIN 
   SELECT count(*) INTO total 
     FROM dept; 
   RETURN total; 
END; 
/
~~~

- a função acima não tem parâmetros de entrada. Ao ser executada, conta a quantidade de tuplas da tabela DEPT e retorna ao programa chamador.
- testando a função, usando um bloco anônimo:

~~~sql
SET SERVEROUTPUT ON

DECLARE 
   conta NUMBER(7); 
BEGIN 
   conta := CONTADEPT(); 
   DBMS_OUTPUT.PUT_LINE('Quantidade de Departamentos: ' || conta); 
END;
/
~~~

- a função foi executada sem a passagem de valores de entrada, mas retornou a contagem da quantidade de registros da tabela DEPT.

### c) exemplo 3: 
- desta vez, receberá dois parâmetros e não acessará dados de uma tabela.

~~~sql
CREATE OR REPLACE FUNCTION sal_anual (
  p_sal NUMBER,
  p_comm NUMBER )
RETURN NUMBER
IS
BEGIN
 RETURN (p_sal + NVL(p_comm, 0)) * 12;
END sal_anual;
/
~~~

- na função SAL_ANUAL temos dois parâmetros de entrada: o primeiro receberá o valor do salário e o segundo receberá a comissão do funcionário. 
- a função soma os dois valores e os multiplica por 12. O valor calculado será devolvido para o programa chamador.
- testando:

~~~sql
SELECT sal, comm, SAL_ANUAL(sal, comm)
FROM emp;
~~~

- o teste exibe o salário de cada funcionário e a comissão de cada um e executa a função SAL_ANUAL com o valor do salário e da comissão como parâmetro. 
- a função SAL_ANUAL calcula e devolve o salário anual de cada um dos funcionários. 
- alguns funcionários não têm comissão e, por esse motivo, o campo de comissão está com valores nulos.
- a função SAL_ANUAL trata os valores nulos usando a função NVL, que trata os valores nulos. Ou seja, ***a função está usando outra função em seu código***.
- a função SAL_ANUAL é executada uma vez para cada linha retornada pela consulta.
- testando a função em um bloco anônimo:

~~~sql
SET SERVEROUTPUT ON

DECLARE 
   total NUMBER(7); 
BEGIN 
   total := SAL_ANUAL(900, 100); 
   DBMS_OUTPUT.PUT_LINE('Salario anual: ' || total); 
END;
/
~~~

- tanto as funções quanto os procedimentos podem usar as funções nativas do banco de dados, também as estruturas condicionais do PL/SQL para criar novas funcionalidades para seu SGBDR! 

### d) exemplo 4:

~~~sql
CREATE OR REPLACE FUNCTION ordinal (
  p_numero NUMBER)
RETURN VARCHAR2
IS
BEGIN
CASE p_numero
 WHEN 1 THEN RETURN 'primeiro'; 
 WHEN 2 THEN RETURN 'segundo'; 
 WHEN 3 THEN RETURN 'terceiro'; 
 WHEN 4 THEN RETURN 'quarto'; 
 WHEN 5 THEN RETURN 'quinto'; 
 WHEN 6 THEN RETURN 'sexto'; 
 WHEN 7 THEN RETURN 'sétimo'; 
 WHEN 8 THEN RETURN 'oitavo'; 
 WHEN 9 THEN RETURN 'nono'; 
 ELSE RETURN 'não previsto';
END CASE;
END ordinal;
/
~~~

- na função ORDINAL, temos um parâmetro numérico de entrada e o retorno de um texto. O programa testa valores entre ume nove e exibe o ordinal do número, ou seja, o número 1 será exibido como “primeiro”, o número 2 será mostrado como “segundo” e assim por diante até o número 9, que será exibido como “nono”. Qualquer número diferente desses nove números será mostrado como “não previsto”.
- testando a nova função:

~~~sql
SELECT ORDINAL(9)
FROM dual;
~~~

- no teste, a consulta executa a função ORDINAL com o valor 9 como parâmetro. A função retorna o texto “nono”. A tabela DUAL é usada para testes e contém apenas uma tupla.
- testando a função com um bloco PL/SQL anônimo:

~~~sql
SET SERVEROUTPUT ON

BEGIN 
   FOR i IN 1..9 LOOP 
       DBMS_OUTPUT.PUT_LINE(ORDINAL(i));
   END LOOP;
END;
/
~~~

- nesse teste, o bloco PL/SQL anônimo está executando um laço FOR,iterando a variável “i” do número um até o número nove. Dentro do laço,estamos chamando a função ORDINAL nove vezes. Na primeira vez, o valor de “i” será um, na segunda passagem, o valor de “i” será dois e assim por diante até chegar ao valor nove. Dessa forma, serão exibidos os valores ordinais para todos os números previstos em nosso código.

## 1.3 Visualização de erros de compilação

- durante a criação ou a alteração de uma função, o desenvolvedor pode receber a mensagem "Function created with compilation errors", o que indica que a função foi criada com erros de compilação.
- além do `comando SHOW ERROS`, podemos obter mais informações sobre os erros por meio das views `USER_ERRORS`, `ALL_ERRORS` e `DBA_ERRORS`. 
- estrutura básica dessas views:

~~~sql
Name                                 Null?    Type
------------------------------------ -------- ----------------
 NAME                                NOT NULL VARCHAR2(30)
 TYPE                                         VARCHAR2(12)
 SEQUENCE                            NOT NULL NUMBER
 LINE                                NOT NULL NUMBER
 POSITION                            NOT NULL NUMBER
 TEXT                                NOT NULL VARCHAR2(4000)
 ATTRIBUTE                                    VARCHAR2(9)
 MESSAGE_NUMBER                               NUMBER
~~~

- onde:
  - ***NAME*** contém o nome do objeto compilado.
  - ***TYPE*** pode assumir os valores PROCEDURE, FUNCTION, TRIGGER, PACKAGE e PACKAGE_BODY.
  - ***SEQUENCE*** corresponde ao número de erros relativo ao número de erros na compilação.
  - ***LINE*** indica o número da linha que contém o erro.
  - ***POSITION*** indica a coluna que contém o erro.
  - ***TEXT*** contém o texto do erro, exemplo: “PL/SQL: Statement ignored PL/SQL-00201 identifier 'DBMS_OUTPUT.PUT_LINE' must be declared”.
  - ***ATTRIBUTE*** nem todo registro da view é um erro, alguns dos registros podem conter apenas uma advertência. Caso seja uma advertência, essa coluna conterá a palavra “WARNING”; se forum erro,conterá a palavra “ERROR”.
  - ***MESSAGE_NUMBER*** contém o código do erro, sem o prefixo. Por exemplo, se o erro for PLS-00103, essa coluna conterá o código 103.

- usando essas views, é possível listar os erros das funções criadas. 
- exemplo de consulta:

~~~sql
SELECT line, position, text 
FROM user_errors 
WHERE name = 'ORDINAL' 
ORDER BY sequence;
~~~

- no exemplo acima, estamos exibindo linha, coluna e mensagem de erro da função ORDINAL. Caso não existam erros de compilação, nenhuma linha será exibida.
- se houver necessidade, **é possível consultar a view USER_SOURCE para obter o código-fonte da função**. Exemplo:

~~~sql
SELECT text
FROM user_source
WHERE name = 'ORDINAL'
ORDER BY line;
~~~

- no exemplo, estamos exigindo o código-fonte da função ORDINAL.
- via de regra, o nome dos objetos é armazenado em letras maiúsculas no dicionário de dados.

---

## FAST TEST

### 1. Qual alternativa não funcionaria para chamar uma função?
> EXECUTE SAL_ANUAL (900, 100);

### 2. Temos algumas formas de identificar erros de compilação de funções. Qual alternativa não tem essa finalidade?
> Consulta na view FUNCTION_ERRORS.

### 3. Uma função pode ser definida por diversos nomes. Qual das alternativas não é um nome válido para funções?
> NAMED FUNCTION.

### 4. Procedimentos e funções são semelhantes, qual destas diferenças está incorreta?
> Procedures podem ser utilizados dentro de outros blocos, functions não.

--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)