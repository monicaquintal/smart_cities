<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img align="right" height="120px" src="../assets/logo.png" /></a>
<h1>FASE 2 - DATABASE PROGRAMMING</h1>
<h2>Capítulo 03: O banco respeitando decisões.</h2>
</div>

<div align="center">
<h2>1. O BANCO RESPEITANDO DECISÕES</h2>
</div>

## 1.1 Mais sobre tipos de dados

- exemplo:

~~~sql
CREATE TABLE tabela1
(col1 VARCHAR2(18));

INSERT INTO tabela1
  VALUES ('Campo com 18 bytes');

SET SERVEROUTPUT ON

DECLARE
  v_col1 VARCHAR2(18);
BEGIN
  SELECT col1 INTO v_col1
    FROM tabela1;
  DBMS_OUTPUT.PUT_LINE ('Valor = ' || v_col1);
END;
/
~~~

- o que acontece se alterar o tamanho de uma coluna da tabela? O bloco PL/SQL continuará funcionando normalmente?:

~~~sql
TRUNCATE TABLE tabela1;

ALTER TABLE tabela1
MODIFY col1 VARCHAR2(30);

INSERT INTO tabela1
  VALUES ('Tamanho alterado para 30 bytes');

SET SERVEROUTPUT ON

DECLARE
  v_col1 VARCHAR2(18);
BEGIN
  SELECT col1 INTO v_col1
    FROM tabela1;
  DBMS_OUTPUT.PUT_LINE ('Valor = ' || v_col1);
END;
/

-- ORA-06502: PL/SQL: numeric or value error: character string buffer too small
-- ORA-06512: at line 4
~~~

- nesse caso, o erro ORA-06502 ocorreu porque o tamanho da coluna COL1 da tabela TABELA1 é maior do que o tamanho da variável COL1 definida na sessão DECLARE do bloco PL/SQL.
- uma forma de evitarmos esse tipo de problema é declararmos a variável com o `atributo %TYPE`.
  - permite que declare uma constante, variável, elemento de coleção, campo de registro ou subprograma para que seja do mesmo tipo de dados que uma variável ou coluna previamente declarada, mesmo que não saiba qual é esse tipo. 
  - vantagem: se a declaração do item referenciado for alterada, a declaração do item de referência muda de acordo com ele.
  - exemplo:

~~~sql
DECLARE
  v_col1 tabela1.col1%TYPE;
BEGIN
  SELECT col1 INTO v_col1
    FROM tabela1;
  DBMS_OUTPUT.PUT_LINE ('Valor = ' || v_col1);
END;
/
~~~

> o uso de `%TYPE` faz com que o campo declarado herde o tipo de dados, tamanho e restrições (CONSTRAINTS) do campo original. ***O campo não herda o valor inicial do item referenciado***.

- o atributo %TYPE pode ser utilizado para declarar variáveis com a mesma estrutura de uma tabela ou de uma variável já existente.
- sintaxe:

~~~sql
identificador [CONSTANT] {tabela.coluna%type | variavel%type} 
[NOT NULL] [:= valor para inicialização | expr default]
~~~

- exemplos:

~~~sql
v_nome emp.ename%type; 
-- declaração da variável com a mesma 
-- estrutura da coluna ename da tabela emp.

v_balance number(7,2); 

v_min_balance v_balance%type; 
-- declaração da variável com a 
-- mesma estrutura da variável declarada anteriormente.
~~~

- é uma `boa prática` a adoção de uma `convenção de nomeação para variáveis`, como: ***prefixo v_*** representa uma variável; ***c_*** representa uma constante.

## 1.2 Estruturas de seleção

- estruturas de controle permitem que o desenvolvedor estabeleça o fluxo lógico de instruções que serão executadas.
- podem ser utilizadas as ***estruturas de controle para repetição de blocos do programa*** (`LOOP`) e as ***estruturas de controle para avaliação das condições e seleção*** (`IF`).
- estruturas de seleção possibilitam que o fluxo de processamento das instruções PL/SQL seja direcionado de acordo com a condição especificada.
- há três maneiras para se utilizar a instrução IF: 
  - IF THEN.
  - IF THEN ELSE.
  - IF THEN ELSIF.

### 1.2.1 If Then

~~~sql
IF (condição) THEN
  conjunto de instruções;
END IF;
~~~

- sendo: 
  - ***condição***: 
    - expressão ou variável Booleana (TRUE, FALSE ou NULL). 
    - está associada a uma sequência de instruções, que será executada se, e somente se, a expressão for avaliada como TRUE.
  - ***THEN***:
    - cláusula que associa a expressão Booleana que a precede com a sequência de instruções posterior.
  - ***instruções***:
    - uma ou mais instruções SQL ou PL/SQL. 
    - podem incluir mais instruções IF contendo diversos IFs, ELSEs e ELSIFs aninhados.

- no caso do IF THEN:
  - se o teste de avaliação da condição retornar verdadeiro, o conjunto de instruções será realizado, 
  - caso contrário, o bloco de seleção é encerrado.

~~~sql
DECLARE
  v_col1 tabela1.col1%TYPE; 
  v_tamanho NUMBER(3); 
BEGIN 
  SELECT LENGTH(col1), col1 INTO v_tamanho, v_col1 
    FROM tabela1
  IF v_tamanho > 25 THEN 
    DBMS_OUTPUT.PUT_LINE ('Texto = ' || v_col1); 
  END IF; 
END;
/
~~~

- nesse caso, o bloco PL/SQL lê a coluna COL1 da tabela TABELA1. 
- usando a função LENGTH, determina o tamanho do texto armazenado dentro da coluna COL1 e armazena esse tamanho na variável V_TAMANHO, também armazena o texto existente na coluna COL1 na variável V_COL1. 
- em seguida, usa a instrução IF para testar se o valor armazenado na variável V_TAMANHO é maior que 25: se for maior que 25,exibe uma mensagem e encerra a estrutura de decisão.

### 1.2.2 If Then Else

~~~sql
IF (condição) THEN
  -- conjunto de instruções 1;
ELSE
  -- conjunto de instruções 2;
END IF;
~~~

- neste caso, se o teste de avaliação da condição retornar verdadeiro, o conjunto de instruções 1 será realizado, caso contrário,será realizado o conjunto de instruções 2.

~~~sql
DECLARE
  v_col1 tabela1.col1%TYPE; 
  v_tamanho NUMBER(3); 
BEGIN 
  SELECT LENGTH(col1), col1 INTO v_tamanho, v_col1 
    FROM tabela1; 
  IF v_tamanho > 25 THEN 
    DBMS_OUTPUT.PUT_LINE ('Texto = ' || v_col1);
  ELSE
     DBMS_OUTPUT.PUT_LINE ('Texto menor ou igual a 25');
  END IF; 
END;
/
~~~

- o bloco PL/SQL lê a coluna COL1 da tabela TABELA1.
- usando a função LENGTH, determina o tamanho do texto armazenado dentro da coluna COL1 e armazena esse tamanho na variável V_TAMANHO, também armazena o texto existente na coluna COL1 na variável V_COL1. 
- logo após isso, usa a instrução IF para testar se o valor armazenado na variável V_TAMANHO é maior que 25. Se for maior que 25,exibe uma mensagem, caso não seja maior que 25, então exibe a mensagem "Texto menor ou igual a 25" e encerra a estrutura de decisão.

### 1.2.3 If Then Elsif

~~~sql
IF (condição1 ) THEN
  -- conjunto de instruções 1;
ELSIF (condição 2)
  -- conjunto de instruções 2 ;
ELSE
  -- conjunto de instruções n;
END IF;
~~~

- neste caso, se o teste de avaliação da condição retornar verdadeiro, o conjunto de instruções 1 será realizado, caso contrário,será realizado o teste de avaliação da condição 2. Se o resultado for verdadeiro, será realizado o conjunto de instruções 2, teremos o teste avaliação da condição 3 e assim por diante. Se nenhuma das condições testadas resultar em verdadeiro, será realizado o conjunto de instruções previsto após o ELSE.

~~~sql
DECLARE
  v_col1 tabela1.col1%TYPE; 
  v_tamanho NUMBER(3); 
BEGIN 
  SELECT LENGTH(col1), col1 INTO v_tamanho, v_col1 
    FROM tabela1; 
  IF v_tamanho > 25 THEN 
    DBMS_OUTPUT.PUT_LINE ('Texto = ' || v_col1);
  ELSIF v_tamanho > 20 THEN
     DBMS_OUTPUT.PUT_LINE ('Texto maior que 20');
  ELSIF v_tamanho > 15 THEN
     DBMS_OUTPUT.PUT_LINE ('Texto maior que 15');
  ELSE
     DBMS_OUTPUT.PUT_LINE ('Texto menor ou igual a 15');
  END IF; 
END;
/
~~~

- o bloco PL/SQL lê a coluna COL1 da tabela TABELA1.
- usando a função LENGTH, determina o tamanho do texto armazenado dentro da coluna COL1 e armazena esse tamanho na variável V_TAMANHO. Também armazena o texto existente na coluna COL1 na variável V_COL1. 
- logo após isso, usa a instrução IF para testar se o valor armazenado na variável V_TAMANHO é maior que 25. Se for maior que 25,exibe uma mensagem, caso não seja maior que 25, mas for maior que 20, então exibe a mensagem “Texto maior que 20”. Se não for maior que 20, mas maior que 15, então exibe a mensagem “Texto maior que 15”. Se nenhuma dessas condições for avaliada como verdadeira, então exibe a mensagem “Texto menor ou igual a 15” e encerra a estrutura de decisão.

> Importante: é possível usar qualquer quantidade de cláusulas ELSIF, mas só pode haver, no máximo, uma cláusula ELSE!

### 1.2.4 And Or

- ao usar o `operador lógico AND`, a estrutura condicional será avaliada como ***TRUE se todas as condições testadas forem verdadeiras***. 
- ao usar o `operador lógico OR`, a estrutura condicional será avaliada como ***TRUE se pelo menos uma condição for verdadeira***.
- exemplo:

~~~sql
DECLARE
  v_tamanho NUMBER(3); 
BEGIN 
  SELECT LENGTH(col1) INTO v_tamanho 
    FROM tabela1; 
  IF v_tamanho > 25 AND
     TO_CHAR(SYSDATE, 'YYYY') > 1999 THEN 
     DBMS_OUTPUT.PUT_LINE ('Maior que 25 bytes e século XXI');
  END IF; 
END;
/
~~~

- o exemplo acima usa a instrução IF para testar se o valor armazenado na variável V_TAMANHO é maior que 25 ***E*** se o ano corrente é maior que1999. Se ambas as condições forem atendidas (texto maior que vinte e cinco e ano maior que 1999) então exibe a mensagem “Maior que 25 bytes e século XXI” e encerra a estrutura de decisão. A mensagem só será exibida se ambas as afirmações forem verdadeiras!

~~~sql
DECLARE
  v_tamanho NUMBER(3); 
BEGIN 
  SELECT LENGTH(col1) INTO v_tamanho 
    FROM tabela1; 
  IF v_tamanho > 25 OR
     TO_CHAR(SYSDATE, 'YYYY') > 1999 THEN
     DBMS_OUTPUT.PUT_LINE ('Maior que 25 bytes ou século XXI');
  END IF; 
END;
/
~~~

- no exemplo acima, a instrução IF testa se o valor armazenado na variável V_TAMANHO é maior que 25 ***OU*** se o ano corrente é maior que 1999. Se uma das condições forem atendidas (texto maior que vinte e cinco ou ano maior que 1999) então exibe a mensagem “Maior que 25 bytes ou século XXI” e encerra a estrutura de decisão. A mensagem será exibida se qualquer uma das afirmações for verdadeira.

> Podemos, então, criar condições compostas combinando as condições com os operadores lógicos AND, OR e NOT. 

<div align="center">

a) `OPERADOR AND`:

Expressão 1 | Expressão 2 | Resultado
------------|--------------|-------------
TRUE | TRUE | TRUE
TRUE | FALSE | FALSE
FALSE | FALSE | FALSE
FALSE | TRUE | FALSE
NULL | FALSE | FALSE
FALSE | NULL | FALSE

</div>

<div align="center">

b) `OPERADOR OR`:

Expressão 1 | Expressão 2 | Resultado
------------|--------------|-------------
TRUE | TRUE | TRUE
TRUE | FALSE | TRUE
FALSE | FALSE | FALSE
FALSE | TRUE | TRUE
NULL | FALSE | FALSE
FALSE | NULL | FALSE

</div>

> Em termos de precedência de operadores, ***FALSE tem precedência sobre uma condição AND e TRUE tem precedência sobre uma condição OR.***

<div align="center">

c) `OPERADOR NOT`:

Expressão | Resultado | Explicação
------------|--------------|-------------
TRUE | FALSE | O operador NOT faz com que o valor booleano TRUE seja avaliado como FALSE. 
FALSE | TRUE | O operador NOT faz com que o valor booleano FALSE seja avaliado como TRUE.
NULL | NULL | O operador NOT aplicado a um valor nulo (NULL) faz com que seja avaliado como nulo (NULL).

</div>

## 1.3 Estruturas de Repetição

- também conhecidas pelo nome de laço ou termos em inglês LOOP ou LOOPING.
- em determinadas situações, temos a necessidade de que um programa, ou parte dele, seja executado várias vezes. Reiniciar o programa para cada repetição não uma solução muito prática, e algumas vezes é inviável. Uma solução comum é a utilização de estruturas de repetição.
- o conceito de repetição (LOOPING) é utilizado quando se deseja repetir um certo trecho de instruções por um número de vezes.
- o número de repetições pode ser conhecido anteriormente ou não, mas necessariamente precisa ser finito.
  - nem todas as estruturas de repetição possuem recursos para fazer a contagem do número de vezes que o laço deverá ser repetido.
  - nessas situações, deve-se utilizar uma variável de apoio sempre do tipo int.
- o PL/SQL oferece diversos recursos para estruturar laços de repetição:
  - ***LOOP básico***: para fornecer ações repetitivas sem condições gerais.
  - ***LOOP FOR***: para fornecer controle iterativo para ações com base em uma contagem.
  - ***LOOP WHILE***: para fornecer controle iterativo para ações com base em uma condição.
- a `instrução EXIT` pode ser usada para terminar um laço de repetição.

### 1.3.1 Loop Básico
- permite a execução de sua instrução pelo menos uma vez.
- entretanto, se a condição EXIT for colocada no início do loop antes de qualquer outra instrução executável e for verdadeira, ocorrerá a saídado loop e as instruções jamais serão executadas.
- importante: sem a instrução EXIT, o LOOP nunca terminaria.

~~~sql
LOOP
 conjunto de instruções;
  EXIT [WHEN condição]; 
END LOOP;
~~~

- em que:
  - LOOP é o delimitador de início do laço. 
  - CONJUNTO DE INSTRUÇÕES são as instruções a serem executadas em cada iteração.
  - EXIT é o ponto de saída do laço.
  - [WHEN CONDIÇÃO] indica a condição de saída do laço.
  - END LOOP é o delimitador de fim do laço.

- exemplo:

~~~sql
DECLARE
  v_contador NUMBER(2) :=1; 
BEGIN 
  LOOP
    INSERT INTO tabela1
    VALUES ('Inserindo texto numero ' || v_contador);
    v_contador := v_contador + 1; 
  EXIT WHEN v_contador > 10; 
  END LOOP;
END;
/
~~~

> Podemos usar o comando EXIT como uma ação dentro de uma instrução IF ou como uma instrução independente dentro do laço. Um loop básico pode conter várias instruções EXIT.

### 1.3.2 Loop For
- realiza as iterações de acordo com a instrução de controle que precede a palavra-chave LOOP.

~~~sql
FOR contador in [REVERSE] limite_inferior..limite_superior LOOP  
  conjunto de instruções;
  ...
END LOOP;
~~~

- em que:
  - CONTADOR: contador numérico inteiro declarado implicitamente. O valor do contador aumenta ou diminui automaticamente em 1 a cada iteração do loop até o limite superior ou inferior a ser alcançado. O valor do contador diminuirá se a palavra-chave REVERSE for usada.
  - REVERSE faz o contador decrescer a cada iteração a partir do limite superior até o limite inferior. É importante notar que o limite inferior ainda é referenciado primeiro.
  - LIMITE_INFERIOR especifica o limite inferior da faixa de valores do contador.
  - LIMITE_SUPERIOR especifica o limite superior da faixa de valores do contador.
  - LOOP é o delimitador de início do laço. 
  - CONJUNTO DE INSTRUÇÕES são as instruções a serem executadas em cada iteração.
  - END LOOP; é o delimitador de fim do laço.

- exemplo:

~~~sql
BEGIN   
  FOR i IN 1..10 LOOP
    INSERT INTO tabela1
    VALUES ('Inserindo texto numero ' || i);
  END LOOP;
END;
/
~~~

- no exemplo acima, o bloco PL/SQL define implicitamente uma variável denominada i, que recebe o valor 1 (um) na primeira iteração do programa.

### 1.3.3 Loop While
- pode ser usado para repetir uma sequência de instruções até que a condição para controle não seja mais verdadeira. 
- a condição é avaliada ao início de cada iteração, sendo assim, se a condição for falsa no início do LOOP, nenhuma iteração futura será executada.

~~~sql
WHILE condição LOOP
  conjunto de instruções;
    ...
END LOOP;
~~~

- em que:
  - CONDIÇÃO é uma expressão ou variável booleana.
  - CONJUNTO DE INSTRUÇÕES são as instruções a serem executadas em cada iteração.
  - END LOOP; é o delimitador de fim do laço.

- exemplo:

~~~sql
DECLARE
  v_contador NUMBER(2) :=1; 
BEGIN   
  WHILE v_contador <= 10 LOOP
    INSERT INTO tabela1
    VALUES ('Inserindo texto numero ' || v_contador);
    v_contador := v_contador + 1;   
  END LOOP;
END;
~~~

- se as variáveis envolvidas nas condições não se alterarem no curso do corpo do LOOP, a condição permanecerá TRUE e o LOOP não terminará. Se a condição produzir NULL, o LOOP será ignorado e o controle passará para a próxima instrução.

### 1.3.4 Loop aninhado
- é possível aninhar loops básicos, FOR e WHILE um dentro do outro. 
- a terminação de um loop aninhado não terminará o loop delimitado a menos que seja criada uma exceção. Entretanto, pode-se colocar LABELS em laços e sair do laço externo com a instrução EXIT.
  - os nomes de LABEL seguem as mesmas regras de outros identificadores. 
  - um LABEL é colocado antes de uma instrução, seja na mesma linha ou em uma linha separada. 
  - coloque o LABEL no LOOP, colocando-o antes da palavra LOOP dentro dos delimitadores de LABEL (&lt;&lt;LABEL&gt;&gt;). S
  - se for atribuído um LABEL ao LOOP, o nome do LABEL poderá ser opcionalmente incluído após a instrução END LOOP para clareza.
- exemplo:

~~~sql
BEGIN 
  <<loopexterno>>
  FOR i IN 1..3 LOOP
    <<loopexterno>>
    FOR j IN 1..5 LOOP
        INSERT INTO tabela1
        VALUES ('Inserindo texto numero ' || i || j);
    END LOOP loopexterno;
  END LOOP loopexterno;
END;
/
~~~

--- 

## FAST TEST

### 1. Quais são as 3 formas de trabalharmos com estruturas de seleção em PL/SQL?
> IF THEN / IF THEN ELSE / IF THEN ELSE ELSIF.

### 2. Qual é a melhro estrutura de repetição para garantir o Loop enquanto uma condição verdadeira?
> O Loop While.

### 3. Em uma cláusula AND, na qual uma das expressões possui valor NULO, qual é o comportamento esperado?
> O teste retornará falso, pois não é possível saber o resultado da expressão e compará-la corretamente com a segunda expressão.

### 4. Qual é o objetivo de utilizar LABELs em Loops?
> Garantir que a leitura do código seja intuitiva.

---

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)