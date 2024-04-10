<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img align="right" height="120px" src="../assets/logo.png" /></a>
<h1>FASE 2 - DATABASE PROGRAMMING</h1>
<h2>Capítulo 06: </h2>
</div>

<div align="center">
<h2>1. TRATANDO EXCEÇÕES, DESTA VEZ NO BD</h2>
</div>

## 1.1 Introdução

- erros podem ocorrer durante a compilação ou durante a execução do programa.
- `erros de compilação`:
  - associados à sintaxe das instruções: nome dos comandos, declaração das variáveis, organização dos comandos, entre outros. 
  - o compilador da linguagem informa ao programador durante a tentativa de executar uma instrução a ocorrência do erro.
  - exemplo:

~~~sql
SELET * FROM emp;
SP2-0734: unknown command beginning "SELET * FR..." - rest of line ignored.
~~~

- no exemplo, o compilador retornou a mensagem de erro SP2-0734, porque o comando não foi digitado corretamente.
- apesar de ser possível identificar que um comando foi digitado de forma errada, ainda não é possível capturar esse erro para tratá-lo automaticamente.

- `erros de execução`:
  - também conhecidos como erros de RUNTIME, e estão associados à utilização do programa. 
  - nesse caso, quando as exceções não são previstas e tratadas, o erro gerado interrompe o processamento e uma mensagem de erro é devolvida para a aplicação.
  - exemplo:

~~~sql
SET SERVEROUTPUT ON

DECLARE
   cinco NUMBER := 5;
BEGIN
   DBMS_OUTPUT.PUT_LINE ( cinco / ( cinco - cinco ) );
END;
/

DECLARE
*
ERROR at line 1:
ORA-01476: divisor is equal to zero
ORA-06512: at line 4
~~~

- curante a execução do programa, realizamos uma operação aritmética (CINCO menos CINCO), que produz o valor zero e, em seguida, dividimos o valor da variável CINCO por zero. Como regra, não é possível efetuar divisões por zero e isso acaba gerando um erro em tempo de execução. 

> Uma exceção é uma ocorrência não esperada ou diferente daquela programada para ser executada, é um erro.

- algumas linguagens de programação oferecem recursos para o tratamento de exceções. 
- normalmente, o tratamento de uma exceção consiste em identificar um erro em tempo de execução e tratá-lo de forma que o usuário seja informado sobre o que está acontecendo e o programa não seja interrompido bruscamente.
- o banco de dados Oracle possui várias exceções predefinidas, mas o desenvolvedor pode estabelecer exceções personalizadas. 
- estrutura:

~~~sql
EXCEPTION
WHEN exceção1 [OR exceção2 …] THEN
  comando1;
  comando2;
  …
[WHEN exceção3 [OR exceção4 …] THEN
  comando1;
  comando2;
  …]
[WHEN OTHERS THEN
  comando1;
  comando2;
  …]
~~~

- em que:
  - `EXCEPTION`: indica o início da seção de tratamento de exceções do bloco PL/SQL.
  - `exceção`: indica o nome-padrão de uma exceção predefinida ou o nome de uma exceção definida pelo usuário declarada dentro da seção declarativa.
  - `comando`: indica uma ou mais instruções PL/SQL ou SQL.
  - `OTHERS`: indica uma cláusula de tratamento de exceções opcional que intercepta qualquer exceção que não foi explicitamente tratada.

## 1.2 Exceções predefinidas nomeadas

- a Oracle predefiniu exceções para alguns erros mais comuns, não sendo necessário que as exceções sejam declaradas para serem utilizadas (fazem parte do pacote STANDARD). 
- algumas dessas exceções são muito comuns, então além do identificador ORA-, foram nomeadas (nome = HANDLER).

<div align="center">

Nome da Exceção | Número do Erro do Servidor Oracle | SQL CODE | Descrição
--------------|------------------------------|----------|------------
ACCESS_INTO_NULL | ORA-06530 | -6530 | Tentativa de designar valores aos atributos de um objeto não inicializado.
CASE_NOT_FOUND | ORA-06592 | -6592 | Nenhuma das opções das cláusulas WHEN de uma instrução CASE foi selecionada, e não existe nenhuma cláusula ELSE.
COLLECTION_IS_NULL | ORA-06531 | -6531 | Tentativa de aplicar métodos de coleta diferentes de EXISTS a uma tabela aninhada inicializada ou um VARRAY.
CURSOR_ALREADY_OPEN | ORA-06511 | -6551 | Tentativa de abrir um cursor que já estava aberto.
DUP_VAL_ON_INDEX | ORA-00001 | -1 | Tentativa de inserir um valor duplicado.
INVALID_CURSOR | ORA-01001 | -1001 | Operação com cursor inválido.
INVALID_NUMBER | ORA-01722 | -1722 | Falha na conversão de string de caracteres em número.
LOGIN_DENIED | ORA-01017 | -1017 | Logon no servidor Oracle com nome de usuário ou senha inválidos.
NO_DATA_FOUND | ORA-01403 | 100 | SELECT de uma única linha não retornou dados.
NOT_LOGGED_ON | ORA-01012 | -1012 | O programa PL/SQL executa uma chamada de banco de dados sem estar conectado ao servidor Oracle.
PROGRAM_ERROR | ORA-06501 | -6501 | O código PL/SQL tem um problema interno.
ROWTYPE_MISMATCH | ORA-06504 | -6504 | A variável de cursor host e a variável de cursor PL/SQL envolvidas em uma designação têm tipos de retorno incompatíveis.
STORAGE_ERROR | ORA-06500 | -6500 | O código PL/SQL está sem memória ou a memória está danificada.
SUBSCRIPT_BEYOND_COUNT | ORA-06533 | -6533 | Referência a uma tabela aninhada ou a um elemento VARRAY, usando um número de índice maior que o número de elementos do conjunto.
SUBSCRIPT_OUTSIDE_LIMIT | ORA-06532 | -6532 | Referência a uma tabela aninhada ouaum elemento VARRAY, usando um número de índice que está fora da faixa válida (por exemplo, –1).
SYS_INVALID_ROWID | ORA-01410 | -1410 | Falha na conversão de uma string de caracteres em um ROWID universal porque a string não representa um ROWID válido.
TIMEOUT_ON_RESOURCE | ORA-00051 | -51 | Timeout enquanto o servidor Oracle esperava por um recurso.
TOO_MANY_ROWS | ORA-01422 | -1422 | SELECT de uma única linha retornou várias linhas.
VALUE_ERROR | ORA-06502 | -6502 | Erro aritmético, de conversão, de truncamento ou de restrição de tamanho.
ZERO_DIVIDE | ORA-01476 | -1472 | Tentativa de divisão por zero.

</div>

- aplicando ZERO_DIVIDE no exemplo anterior:

~~~sql
SET SERVEROUTPUT ON

DECLARE 
  cinco NUMBER := 5; 
BEGIN 
  DBMS_OUTPUT.PUT_LINE (cinco / ( cinco - cinco ));
EXCEPTION 
  WHEN ZERO_DIVIDE THEN 
    DBMS_OUTPUT.PUT_LINE ('SQLCODE: ' || SQLCODE || ' SQLERRM: ' || SQLERRM); 
    DBMS_OUTPUT.PUT_LINE ('Divisao por zero'); 
  WHEN OTHERS THEN 
    DBMS_OUTPUT.PUT_LINE ('SQLCODE: ' || SQLCODE || ' SQLERRM: ' || SQLERRM); 
    DBMS_OUTPUT.PUT_LINE ('Erro imprevisto'); 
END;
/
-- retorno:
-- SQLCODE: -1476 SQLERRM: ORA-01476: o divisor é igual a zero
-- Divisao por zero
~~~

- a seção de tratamento de exceção captura somente as exceções especificadas; quaisquer outras exceções não serão capturadas, a não ser que seja utilizado o `HANDLER de exceção OTHERS`, que captura qualquer exceção que ainda não esteja tratada. 
- por isso, OTHERS é o último HANDLER de exceção definido.
- podem ser definidos vários HANDLERS de exceção para o bloco, cada um com o seu próprio conjunto das ações.
- quando ocorre uma exceção, o código PL/SQL processa somente um HANDLER antes de sair do bloco. 
- as exceções não podem aparecer em instruções da atribuição ou instruções SQL.

### 1.2.1 Funções para a captura de erro
- quando ocorre uma exceção, pode-se identificar o código ou a mensagem de erro associado usando duas funções SQLCODE e SQLERRM, e com base nos valores do código ou mensagem, pode-se decidir qual ação subsequente tomar a partir do erro.
  - `SQLERRM` é uma função que retorna a mensagem de erro associada a um código de erro numérico.
  - `SQLCODE`: retorna o código numérico de uma exceção.
- quando uma exceção é capturada no HANDLER de exceção WHEN OTHERS, pode-se usar um conjunto de funções genéricas para identificar esses erros.
- exemplo:

~~~sql
CREATE TABLE erros
(usuario VARCHAR2(30),
 data DATE,
 cod_erro NUMBER,
 msg_erro VARCHAR2(100));

SET SERVEROUTPUT ON

DECLARE
   cod erros.cod_erro%TYPE;
   msg erros.msg_erro%TYPE; 
   cinco NUMBER := 5; 
BEGIN
  DBMS_OUTPUT.PUT_LINE (cinco / ( cinco - cinco )); 
EXCEPTION 
  WHEN ZERO_DIVIDE THEN
        cod := SQLCODE;
        msg := SUBSTR(SQLERRM, 1, 100);
        insert into erros values (USER, SYSDATE, cod, msg);
  WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE ('Erro imprevisto'); END;
/
~~~

- no exemplo:
  - valores de SQLCODE e SQLERRM estão sendo atribuídos a variáveis e, em seguida, sendo usadas em uma instrução SQL. Se, mais tarde, consultar a tabela ERROS, verá o nome do usuário que executou o programa PL/SQL, o horário, código e mensagem de erro.
  - usada a função SUBSTR para truncar o tamanho da mensagem de erro para um tamanho conhecido, já que que não sabemos o tamanho final da mensagem que atribuiremos à variável e, desta forma, evitamos introduzir outro erro no programa.
  - valores que podem ser assumidos pelo SQLCODE:

<div align="center">



</div>


















--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)