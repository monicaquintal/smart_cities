<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img align="right" height="120px" src="../assets/logo.png" /></a>
<h1>FASE 2 - DATABASE PROGRAMMING</h1>
<h2>Capítulo 06: Tratando exceções, desta vez no BD.</h2>
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

Valor SQLCODE | Descrição
---------------|--------------------
0 | Nenhuma exceção encontrada.
1 | Exceção definida pelo usuário.
+100 | Exceção NO_DATA_FOUND.
Número negativo | Número de erro do servidor Oracle.

</div>

### 1.2.2 Exceções nomeadas pelo desenvolvedor
- similares às exceções predefinidas.
- a diferença é que precisam ser declaradas na seção DECLARE e chamadas por meio da instrução RAISE. 
- exemplo:

~~~sql
DECLARE
  e_meu_erro EXCEPTION;
  emprec emp%ROWTYPE; CURSOR cursor_emp IS 
         SELECT empno, ename 
         FROM emp 
         WHERE empno = 1111;
BEGIN
   OPEN cursor_emp;
   LOOP
      FETCH cursor_emp INTO emprec.deptno, emprec.sal;
      IF cursor_emp%NOTFOUND THEN
         RAISE e_meu_erro;
      END IF;
         DBMS_OUTPUT.PUT_LINE ('Codigo : ' || emprec.empno);
         DBMS_OUTPUT.PUT_LINE ('Nome : ' || emprec.ename);
      EXIT WHEN cursor_emp%NOTFOUND;
   END LOOP;
EXCEPTION
   WHEN E_MEU_ERRO THEN
         DBMS_OUTPUT.PUT_LINE ('Codigo nao cadastrado');
         ROLLBACK;
END;
/
~~~

- nesse exemplo, na seção DECLARE, definida a exceção E_MEU_ERROO usando o atributo EXCEPTION. 
- na seção executável, estamos testando, com a cláusula IF, se %NOTFOUND retornou o valor TRUE, ou seja, se a consulta não retornar dados, o programa acionará a exceção E_MEU_ERRO. A seção EXCEPTION capturará o erro, emitirá a mensagem “Codigo não cadastrado” e desfará qualquer alteração que ainda não tenha sido gravada com a instrução ROLLBACK.

### 1.2.3 Associar exceções a erros-padrão do servidor
- algumas exceções declaradas pelo usuário podem ser associadas a erros Oracle predefinidos, mas não nomeados, da seguinte maneira:

~~~sql
PRAGMA EXCEPTION_INIT(nome_exceção, código_Oracle_erro);
/
~~~

- onde:
  - nome_exceção: deve ser colocado na área declarativa (DECLARE).
  - codigo_Oracle_erro: código do erro dentro do padrão Oracle que irá ser associado à exceção declarada.

- `PRAGMA EXCEPTION_INIT` é uma diretiva de compilação que informa o compilador para associar um nome de exceção a um número de erro do Oracle, permitindo que possa ser consultada qualquer exceção interna por nome e criado um HANDLER específico. 

> ***PRAGMA*** (ou pseudoinstruções) é uma palavra-chave que significa que a instrução é uma diretiva de compilador não processada ao executar o bloco PL/SQL. Em vez disso, orienta o compilador do PL/SQL para interpretar todas as ocorrências do nome da exceção dentro do bloco como o número de erro do Oracle Server associado.

- exemplo:

~~~sql
DECLARE 
  e_meu_erro EXCEPTION; 
  PRAGMA EXCEPTION_INIT (e_meu_erro, -2292); 
BEGIN
  DELETE FROM dept 
  WHERE deptno = 10; 
  COMMIT; 
EXCEPTION WHEN e_meu_erro THEN 
  DBMS_OUTPUT.PUT_LINE ('Integridade Referencial Violada');
  ROLLBACK; 
END;
/
~~~

### 1.2.4 Procedimento RAISE_APPLICATION_ERROR
- utilizado para comunicar uma exceção predefinida interativamente,retornando um código ou uma mensagem de erro não padronizado.
- permite relatar erros para a aplicação e evitar o retorno de exceções não tratáveis.

~~~sql
RAISE_APPLICATION_ERROR (numero_erro,	mensagem [, {TRUE | FALSE}]);
~~~

- onde:
  - número_erro: número especificado pelo usuário para a exceção entre –20000 e –20999.
  - mensagem: mensagem especificada pelo usuário para a exceção. Trata-se de uma string de caracteres com até 2.048 bytes.
  - TRUE | FALSE: parâmetro Booleano opcional (Se TRUE, o erro será colocado na pilha de erros anteriores. Se FALSE, o default, o erro substituirá todos os erros anteriores).
- o procedimento RAISE_APPLICATION_ERROR pode ser usado tanto na seção de exceção quanto na seção executável.
- exemplo:

~~~sql
DECLARE 
  cinco NUMBER := 5; 
BEGIN 
  DBMS_OUTPUT.PUT_LINE (cinco / ( cinco - cinco )); 
EXCEPTION 
  WHEN ZERO_DIVIDE THEN 
    RAISE_APPLICATION_ERROR (-20901, 'Erro aritmetico. Reveja o programa'); 
  WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE ('Erro imprevisto'); 
END; /

ERROR at line 1:
ORA-20901: Erro aritmetico. Reveja o programa
~~~

- também podemos usar RAISE_APPLICATION_ERROR na seção executável, como no exemplo:

~~~sql
DECLARE 
  e_meu_erro EXCEPTION; 
  PRAGMA EXCEPTION_INIT (e_meu_erro, -2292); 
BEGIN 
  DELETE FROM dept
  WHERE deptno = 33;
  IF SQL%NOTFOUND THEN
    RAISE_APPLICATION_ERROR (-20901, 'Departamento Inexistente');
      ROLLBACK;
    END IF;
    COMMIT; 
EXCEPTION
  WHEN e_meu_erro THEN 
    DBMS_OUTPUT.PUT_LINE ('Integridade Referencial Violada'); 
    ROLLBACK; 
END; /

ERROR at line 1:
ORA-20901: Departamento Inexistente
~~~

### 1.2.5 Propagar uma exceção para um bloco externo
- em vez de se capturar uma exceção dentro do bloco PL/SQL, é possível propagar a exceção para permitir que seja tratada pelo ambiente de chamada. Cada ambiente de chamada tem seu modo de exibir e acessar erros.
- se o código PL/SQL criar uma exceção e o bloco atual não tiver um HANDLER, a exceção propagará em blocos delimitados sucessivos até localizar um HANDLER. Se nenhum desses blocos tratá-la, o resultado será uma exceção não tratável no ambiente de HOST (chamador).
- quando a exceção propaga para um bloco delimitado, as ações executáveis restantes desse bloco são ignoradas. Uma vantagem desse comportamento é que se pode delimitar instruções que exigem seus próprios tratamentos de erro exclusivos em seu próprio bloco, enquanto deixa o tratamento de exceção mais geral para o bloco delimitado.
- exemplo:

~~~sql
DECLARE
   cod erros.cod_erro%TYPE;
   msg erros.msg_erro%TYPE;
   cinco NUMBER := 5;
BEGIN
    BEGIN
        DELETE FROM dept
         WHERE deptno = 10;
    EXCEPTION
       WHEN ZERO_DIVIDE THEN
            DBMS_OUTPUT.PUT_LINE ('Erro no bloco interno');
    END;
    DBMS_OUTPUT.PUT_LINE (cinco / ( cinco - cinco ));
EXCEPTION
    WHEN OTHERS THEN
        cod := SQLCODE;
        msg := SUBSTR(SQLERRM, 1, 100);
        insert into erros values (USER, SYSDATE, cod, msg);
END;
/
~~~

- nesse exemplo, há dois blocos PL/SQL aninhados. 
- a instrução DELETE está no bloco mais interno e a divisão por zero está no bloco mais externo. 
- ao tentar efetuar a exclusão do departamento 10, ocorre um erro de violação de integridade referencial.
- o programa procura dentro do bloco mais interno uma forma de tratar esse erro. Caso não encontre, transfere o erro para a seção de EXCEPTION do bloco mais externo que insere o código de erro na tabela ERROS. 
- caso não fosse tratado no bloco mais externo, o programa propagaria o erro para o ambiente chamador.

--- 

## FAST TEST

### 1. Qual é o principal comando para abrir um bloco de tratamento de erros em PL/SQL?
> EXCEPTION.

### 2. Podemos identificar um código de erro através da função SQLCODE em um bloco. Qual output não é válido patra este comando?
> ORA-.

### 3. Referente a exceções definidas pelo usuário, qual das alternativas é incorreta?
> Exceções definidas pelo usuário podem sobrescrever exceções nomeadas do Oracle.

### 4. O que são exceções nomeadas?
> Erros conhecidos, portanto, com um código e nome atrelados.

--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)