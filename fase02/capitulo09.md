<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img align="right" height="120px" src="../assets/logo.png" /></a>
<h1>FASE 2 - DATABASE PROGRAMMING</h1>
<h2>Capítulo 09: Empacotando os elementos do banco.</h2>
</div>

<div align="center">
<h2>1. EMPACOTANDO OS ELEMENTOS DO BANCO</h2>
</div>

- depois de criar os procedimentos e funções, chegou a hora de agrupar todos em pacotes. 
- uma das vantagens de trabalhar com pacotes é que permitem a organização das aplicações com mais eficiência. 

## 1.1 Definição

- pacotes são áreas de armazenamentos dos PROCEDURES, FUNCTIONS, constantes, variáveis e cursores em PL/SQL que, dependendo do modo que construir, compartilharão as informações desse PACKAGE com outros aplicativos.
- como regra geral, as chamadas aos pacotes darão referência a procedimentos ou funções.
- os pacotes também facilitam a tarefa de conceder privilégios para usuários e grupo de usuários executarem suas tarefas, permitem que os objetos do pacote sejam modificados sem que os objetos de esquema dependentes precisem ser recompilados, habilitam o Oracle a ler múltiplos objetos de pacote na memória de uma única vez e podem conter variáveis globais e cursores que estão disponíveis para todos os procedimentos e funções em um pacote.

## 1.2 Sintaxe do Package Specification

- um PACKAGE possui duas partes:
  - a primeira parte é chamada de especificação de pacote ou `PACKAGE SPECIFICATION` (declara tudo que fará parte do pacote) e 
  - a segunda parte é denominada de corpo do pacote ou `PACKAGE BODY` (apresentará o conteúdo do pacote propriamente dito). 
- sintaxe da especificação do pacote:

~~~sql
CREATE [ OR REPLACE ] PACKAGE nome_pacote
{IS ou AS}

[ variáveis ]

[ especificação dos cursores ]

[ especificação dos módulos ]

END [nome_pacote ];
~~~

- onde: 
  - ***CREATE OR REPLACE*** é a instrução para criação ou substituição do pacote.
  - ***nome_pacote*** é o nome que será dado ao pacote.
  - ***[ variáveis ]*** é a especificação do nome das variáveis, objetos públicos, tipos públicos, exceções e PRAGMAS públicas.
  - ***[ cursores ]*** é a especificação dos cursores.
  - ***[ módulos ]*** é o nome dos módulos do pacote.
- na especificação do pacote podemos definir novos tipos, declarar variáveis globais, tipos, objetos, exceções, cursores, procedimentos e funções.
- o que é definido na especificação do pacote poderá ser compartilhado com outros scripts ou programas em SQL e PL/SQL.

### 1.2.1 Package Specification
- tem como função criar a interface das aplicações. São os tipos de variáveis: cursores, exceções, nomear rotinas e funções. 
- a especificação de um pacote será produzida antes da criação do corpo do pacote e pode existir sem que haja um corpo de pacote associado a ele.
- exemplo:

~~~sql
CREATE OR REPLACE PACKAGE faculdade AS
cnome CONSTANT VARCHAR2(4) := 'FIAP';
cfone CONSTANT VARCHAR2(13) := '(11)3385-8010';
cnota CONSTANT NUMBER(2) := 10;
END faculdade;
/
~~~

- nesse exemplo, estamos criando o pacote FACULDADE, e definindo três constantes: CNOME, CFONE e CNOTA. Esse exemplo é um caso especial de criação de pacote. Como não temos subprogramas associados a ele, não é necessário criar um corpo de pacote. 
- para referenciar as funções, procedimentos, itens e tipos definidos na especificação do pacote, usamos o nome e aquilo que queremos referenciar separados por um ponto.
- exemplo:

~~~sql
SET SERVEROUTPUT ON

DECLARE
 melhor VARCHAR2(30);
BEGIN
  melhor := faculdade.cnome || ', a melhor faculdade';
  dbms_output.put_line(melhor);
END;
/
~~~

- neste exemplo, estamos referenciando a constante CNOME do pacote FACULDADE, usando o nome do pacote e da constante separados por um ponto, no caso, FACULDADE.CNOME. 
- outro exemplo simples:

~~~sql
SET SERVEROUTPUT ON

DECLARE
 conta NUMBER(6);
BEGIN
  conta := faculdade.cnota ** 2;
  dbms_output.put_line(conta);
END;
/
~~~

- neste exemplo estamos referenciando a constante CNOTA do pacote FACULDADE, usando o nome do pacote e da constante separados por um ponto, no caso, FACULDADE.CNOTA.
- perceba que estamos elevando o valor da constante à potência de dois e atribuindo o resultado da conta a uma variável antes de exibi-lo.

> outro exemplo, desta vez, com a ***especificação de subprogramas***:

~~~sql
CREATE OR REPLACE PACKAGE rh as
FUNCTION descobrir_salario 
  (p_id IN emp.empno%TYPE) 
  RETURN NUMBER;
PROCEDURE reajuste
  (v_codigo_emp IN emp.empno%type,
   v_porcentagem IN number DEFAULT 25);
END rh;
/
~~~

- o exemplo acima cria a especificação de um pacote denominado RH. Nele,estamos declarando que existem dois subprogramas, a função DESCOBRIR_SALARIO e o procedimento REAJUSTE. A especificação da função informa que tem um parâmetro de entrada e o retorno de um valor numérico. A especificação do procedimento informa que tem dois parâmetros de entrada, ambos numéricos. A descrição dos parâmetros de entrada pode ser obtida por meio do comando DESC ou DESCRIBE.
- exemplo:

~~~sql
DESC rh

FUNCTION DESCOBRIR_SALARIO RETURNS NUMBER
 Argument Name      Type       In/Out Default?
 ------------------ ---------- ------ --------
 P_ID               NUMBER(4)  IN

PROCEDURE REAJUSTE
 Argument Name      Type       In/Out Default?
 ------------------ ---------- ------ --------
 V_CODIGO_EMP       NUMBER(4)  IN
 V_PORCENTAGEM      NUMBER     IN     DEFAULT
~~~

- ao executar o `comando DESC`, indicando o pacote RH, descobriu-se que o pacote possui dois subprogramas: a função DESCOBRIR_SALÁRIO, que retorna um valor numérico (FUNCTION DESCOBRIR_SALARIO RETURNS NUMBER) com uma entrada numérica de quatro posições de nome P_ID; e um procedimento de nome REAJUSTE (PROCEDURE REAJUSTE) com dois parâmetros de entrada (V_CODIGO_EMP e V_PORCENTAGEM), ambos numéricos.
- para o exemplo ficar completo, precisamos criar a especificação do pacote. 

## 1.3 Sintaxe do Body Specification

~~~sql
CREATE [ OR REPLACE ] PACKAGE BODY nome_pacote
{IS ou AS}

[ variáveis ]

[ especificação dos cursores ]

[ especificação dos módulos ]

  [BEGIN
     sequencia_de_comandos
   
  [EXCEPTION
     exceções ] ]

END [nome_pacote ];
~~~

- onde:
  - ***CREATE OR REPLACE*** é a instrução para criação ou substituição do corpo do pacote.
  - ***nome_pacote***, o mesmo usado na especificação do pacote.
  - ***[ variáveis ]*** é a especificação do nome das variáveis, objetos públicos, tipos públicos, exceções e PRAGMAS privadas.
  - ***[ cursores ]*** é a definição completa dos cursores.
  - ***[ módulos ]*** é a definição completa dos procedimentos e funções.

- a sintaxe é similar à da criação da especificação do pacote, exceto pela palavra-chave BODY e o código implementado das especificações do pacote.

### 1.3.1 Package Body
- o corpo do pacote implementa suas especificações: contém a implementação de cada cursor e subprograma declarados na sua especificação.
- importante lembrar que os subprogramas definidos em um corpo do pacote são acessíveis fora se as suas especificações também aparecem nas especificações do pacote.
- é no corpo do pacote que são definidas as variáveis privadas e onde estão os detalhes da implementação. Essas informações ficam ocultas da aplicação. P
- pode depurar, melhorar ou substituir o corpo do pacote sem precisar alterar sua especificação.
- exemplo de criação do corpo de um pacote:

~~~sql
CREATE OR REPLACE PACKAGE BODY rh
AS

 FUNCTION descobrir_salario
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

 PROCEDURE reajuste
 (v_codigo_emp IN emp.empno%type,
  v_porcentagem IN number DEFAULT 25)
 IS
 BEGIN
 UPDATE emp
    SET sal = sal + (sal *( v_porcentagem / 100 ) )
  where empno = v_codigo_emp;
 COMMIT;
 END reajuste;

END rh;
/
~~~

- esse exemplo acima cria o corpo para o pacote RH. 
- desenvolvemos os detalhes da implementação da função DESCOBRIR_SALARIO e do procedimento REAJUSTE - detalhes de implementação ficam ocultos da aplicação. 
- exemplo de uso desse pacote:

~~~sql
SET SERVEROUTPUT ON

DECLARE
   v_sal NUMBER(8,2);
BEGIN
   v_sal := rh.descobrir_salario(7900);
   DBMS_OUTPUT.PUT_LINE(v_sal);
END;
/
~~~

- o exemplo acima executa a função DESCOBRIR_SALARIO do pacote RH.
- a chamada é feita por meio da RH.DESCOBRIR_SALARIO, ou seja, primeiro indicamos qual é o pacote e, em seguida, executamos a função, o nome do pacote e o nome da função são separados por um ponto. 
- na chamada da função, usamos o parâmetro 7900, o resultado é atribuído à variável V_SAL, exibida logo em seguida. 
- outra forma de executar o pacote:

~~~sql
SELECT rh.descobrir_salario(7900)
FROM dual;
/
~~~

- nesse caso, usamos uma consulta SQL para executar a função DESCOBRIR_SALARIO do pacote RH. 
- mais um teste de execução:

~~~sql
SET SERVEROUTPUT ON

DECLARE
   v_sal NUMBER(8,2);
BEGIN
   v_sal := rh.descobrir_salario(7900);
   DBMS_OUTPUT.PUT_LINE ('Salario atual - ' || v_sal);

   rh.reajuste (7900, faculdade.cnota);

   v_sal := rh.descobrir_salario(7900);
   DBMS_OUTPUT.PUT_LINE ('Salario atualizado - ' || v_sal);
END;
/
~~~

- o exemplo acima mostra vários usos dos recursos dos pacotes. 
- o programa está usando a função RH.DESCOBRIR_SALARIO para obter o salário atual do funcionário de código 7900 e, em seguida, exibir seu salário.
- o procedimento RH.REAJUSTE aumenta o salário de um funcionário específico, calculado por meio de um percentual informado. Em nosso exemplo, o funcionário 7900 receberá o aumento de 10%, valor da constante FACULDADE.CNOTA. 
- em seguida, obtemos e exibimos o novo salário do funcionário. Perceba que, desta vez, nosso programa usou dados fornecidos por outro pacote. 
- o procedimento poderia ter sido executado por meio do comando EXEC, como no exemplo:

~~~sql
exec rh.reajuste (7900, faculdade.cnota);
~~~

- no exemplo acima, o procedimento RH.REAJUSTE atualiza o salário do funcionário 7900 em 10%. O valor do aumento foi obtido da constante CNOTA do pacote FACULDADE.
- acrescentar mais algumas funcionalidades no pacote RH:

~~~sql
CREATE OR REPLACE PACKAGE rh AS 
   TYPE RegEmp IS RECORD (v_empno emp.empno%TYPE, v_sal emp.sal%TYPE); 
   TYPE RegDept IS RECORD (v_deptno dept.deptno%TYPE, v_loc dept.deptno%TYPE); 
   CURSOR c_sal RETURN RegEmp;
    salario_invalido EXCEPTION; 
   FUNCTION contrata_func (v_ename emp.ename%TYPE, v_job emp.job%TYPE, v_mgr emp.mgr%TYPE, v_sal emp.sal%TYPE, v_comm emp.comm%TYPE, v_deptno emp.deptno%TYPE) RETURN INT; 
   PROCEDURE demite_func (v_empno emp.empno%TYPE); 
   PROCEDURE reajuste (v_codigo_emp IN emp.empno%type, v_porcentagem IN number DEFAULT 25); 
   FUNCTION maiores_salarios (n INT) RETURN RegEmp; 
END rh; /
~~~

- agora, temos dois registros, REGEMP e REGDEPT, o cursor C_SAL, a exceção SALARIO_INVALIDO, as funções CONTRATA_FUNC e MAIORES_SALARIOS e os procedimentos DEMITE_FUNC e REAJUSTE. 
- criar o corpo para o pacote:

~~~sql
CREATE OR REPLACE PACKAGE BODY rh AS

  CURSOR c_sal RETURN RegEmp IS
     SELECT empno, sal FROM emp ORDER BY sal DESC;

  FUNCTION contrata_func (
       v_ename emp.ename%TYPE,
       v_job emp.job%TYPE,
       v_mgr emp.mgr%TYPE,
       v_sal emp.sal%TYPE,
       v_comm emp.comm%TYPE,
       v_deptno emp.deptno%TYPE) RETURN INT IS
     cod_novo_emp INT;
  BEGIN
     SELECT max(empno) + 1 INTO cod_novo_emp FROM emp;
     INSERT INTO emp (empno, ename, job, mgr, 
                      hiredate, sal, comm, deptno) 
              VALUES (cod_novo_emp, v_ename, v_job, 
                      v_mgr, SYSDATE, v_sal,
                      v_comm, v_deptno);
     RETURN cod_novo_emp;
  END contrata_func;

  PROCEDURE demite_func (v_empno emp.empno%TYPE) IS
  BEGIN
     DELETE FROM emp WHERE empno = v_empno;
  END demite_func;

  FUNCTION sal_ok
     (v_sal emp.sal%TYPE) 
      RETURN BOOLEAN IS
     min_sal emp.sal%TYPE;
     max_sal emp.sal%TYPE;
  BEGIN
     SELECT min(sal), max(sal) INTO 
            min_sal, max_sal
       FROM emp;
     RETURN (v_sal >= min_sal) AND (v_sal <= max_sal);
  END sal_ok;

 PROCEDURE reajuste
 (v_codigo_emp IN emp.empno%type,
  v_porcentagem IN number DEFAULT 25)
 IS
  v_sal emp.sal%TYPE;
 BEGIN
     SELECT sal INTO v_sal 
       FROM emp 
      WHERE empno = v_codigo_emp;
     IF sal_ok(v_sal + (v_sal*(v_porcentagem/100))) THEN
        UPDATE emp
           SET sal = 
                  v_sal + (v_sal*(v_porcentagem/100))
         WHERE empno = v_codigo_emp;
     ELSE
        RAISE salario_invalido;
     END IF;
 END reajuste;

  FUNCTION maiores_salarios (n INT) RETURN RegEmp IS
     emp_rec RegEmp;
  BEGIN
     OPEN c_sal;
     FOR i IN 1..n LOOP
        FETCH c_sal INTO emp_rec;
     END LOOP;
     CLOSE c_sal;
     RETURN emp_rec;
  END maiores_salarios;

END rh;
~~~

- o novo corpo do pacote RH contém a especificação do cursor C_SAL, uma função local denominada SAL_OK, especificação de duas funções globais CONTRATA_FUNC e MAIORES_SALARIOS e os procedimentos DEMITE_FUNC e REAJUSTE. 
- testando dois dos novos subprogramas:

~~~sql
SET SERVEROUTPUT ON

DECLARE novo_cod emp.empno%TYPE; 
BEGIN novo_cod := rh.contrata_func('Rita','Gerente',7839,9000,NULL,10);
   DBMS_OUTPUT.PUT_LINE ('Funcionario ' || novo_cod || ' cadastrado'); 
END; 
/
~~~

- esse teste usa um bloco anônimo para executar a função RH.CONTRATA_FUNC, que cadastra um novo funcionário na tabela de empregados e retorna o código do novo funcionário cadastrado:

~~~sql
BEGIN
rh.demite_func (7935);
END;
/
~~~

- esse novo procedimento usa o código do funcionário informado no parâmetro e o remove da tabela dos empregados.

---

## FAST TEST

### 1. Quais são os maiores objetivos no uso de Pacotes?
> Organização de código e governança de acessos.

### 2. Qual a melhor definição para um PACKAGE BODY?
> O Package Body é utilizado para criar e atualizar a lógica para os objetos especificados no Package, como funções e cursores.

### 3. Qual das especificações a seguir é obrigatória para a criação de um pacote?
> Ao menos uma variável, constante, cursor, procedure ou função.

### 4. Qual é a melhor definição de pacotes, ou packages, em PL/SQL?
> Conjunto de blocos nomeados, variáveis, constantes e cursores referentes ao mesmo contexto.

--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)