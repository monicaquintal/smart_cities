<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img align="right" height="120px" src="../assets/logo.png" /></a>
<h1>FASE 2 - DATABASE PROGRAMMING</h1>
<h2>Capítulo 02: Programando dentro do banco de dados!</h2>
</div>

<div align="center">
<h2>1. PROGRAMANDO DENTRO DO BANCO DE DADOS!</h2>
</div>

## 1.1 Histórico

- `PL/SQL` (***Procedural Language extensions to SQL***):
  - surgiu como uma linguagem de quarta geração, de alto nível, com foco em consulta a banco de dados. 
  - lançada em 1991 com a versão 6.0 do Oracle, era uma extensão opcional que poderia ser incorporada ao banco de dados.
  - só na versão 2.0 passou a trabalhar com procedimentos armazenados (storage procedures), pacotes (packages) e funções (functions).
  - é muito similar ao SQL, mas incorpora funcionalidades de outras linguagens de programação, se tornando uma poderosa linguagem para manipulação dos dados.
  - os desenvolvedores da linguagem PL/SQL tomaram como base a sintaxe da linguagem ADA, linguagem desenvolvida para o Departamento de Defesa dos Estados Unidos. A sintaxe da linguagem ADA, por sua vez, foi baseada na linguagem PASCAL.
  - atualmente a linguagem PL/SQL é incorporada a diversas ferramentas Oracle e é a linguagem básica para o desenvolvimento dos programas complexos e poderosos.

## 1.2 Preparando o ambiente

- nos exemplos e exercícios, serão usadas duas tabelas fornecidas pela própria Oracle para serem usadas em ambientes de teste e treinamento: `EMP (Empregados)` e `DEPT (Departamentos)`. 
- nos exemplos, pode ser usado o usuário SCOTT, adequado para treinamento, fornecido pela própria Oracle, ou pode ser usado o seu próprio usuário.
- outras tabelas serão criadas durante o curso, mas por enquanto essas serão suficientes.

> Curiosidade: Bruce Scott é um dos fundadores da Oracle, em 1977. É o criador do usuário SCOTT e das tabelas que usaremos nos exemplos durante o curso!

- o primeiro passo para a construção do ambiente de aprendizado é garantir que as tabelas DEPT e EMP estão consistentes. 
- antes de criar uma tabela nova, tentar apagá-la (`comando DROP`), garantindo que a nova tabela não irá entrar em conflito com outra que já exista no ambiente.
- executar no SQLDEVELOPER:

~~~sql
DROP TABLE dept PURGE;
DROP TABLE emp PURGE;
~~~

> não estranhar se a execução do comando retornar a mensagem: `ORA-00942: tabela ou view não existe`. Essa mensagem indica que a tabela realmente não existia no ambiente.

- executar os comandos abaixo no SQLDEVELOPER para criar e popular a `tabela DEPT`, que deve ser a primeira tabela criada (pois existe uma chave estrangeira na coluna DEPTNO da tabela EMP, que referencia a coluna DEPTNO da tabela DEPT).

~~~sql
CREATE TABLE dept (
  deptno NUMBER(2,0),
  dname VARCHAR2(14),
  loc VARCHAR2(13),
  CONSTRAINT pk_dept PRIMARY KEY (deptno)
);

INSERT INTO dept VALUES(10, 'ACCOUNTING', 'NEW YORK');
INSERT INTO dept VALUES(20, 'RESEARCH', 'DALLAS');
INSERT INTO dept VALUES(30, 'SALES', 'CHICAGO');
INSERT INTO dept VALUES(40, 'OPERATIONS', 'BOSTON');
~~~

- estrutura da tabela DEPT:

<div align="center">

Coluna | Significado | Observação | Coluna
-------|-------------|------------|----------
DEPTNO | Código do departamento. | Numérico, inteiro, com até 2 dígitos. Chave Primária. | DEPTNO
DNAME | Nome do departamento. | Alfanumérico, até 14 caracteres. | DNAME
LOC | Localização do departamento. | Alfanumérico, até 13 caracteres. | LOC

</div>

- executar os comandos abaixo no SQLDEVELOPER para criar e popular a `tabela EMP`:

~~~sql
CREATE TABLE emp(
  empno NUMBER(4,0),
  ename VARCHAR2(10),
  job VARCHAR2(9),
  mgr NUMBER(4,0),
  hiredate DATE,
  sal NUMBER(7,2),
  comm NUMBER(7,2),
  deptno NUMBER(2,0),
  CONSTRAINT pk_emp PRIMARY KEY (empno),
  CONSTRAINT fk_deptno FOREIGN KEY (deptno) REFERENCES dept (deptno)
);

INSERT INTO EMP VALUES
        (7369, 'SMITH', 'CLERK', 7902,
        TO_DATE('17-DEZ-1980', 'DD-MON-YYYY'), 800, NULL, 20);
INSERT INTO EMP VALUES
        (7499, 'ALLEN', 'SALESMAN', 7698,
        TO_DATE('20-FEV-1981', 'DD-MON-YYYY'), 1600, 300, 30);
INSERT INTO EMP VALUES
        (7521, 'WARD', 'SALESMAN', 7698,
        TO_DATE('22-FEV-1981', 'DD-MON-YYYY'), 1250, 500, 30);
INSERT INTO EMP VALUES
        (7566, 'JONES', 'MANAGER', 7839,
        TO_DATE('2-ABR-1981', 'DD-MON-YYYY'), 2975, NULL, 20);
INSERT INTO EMP VALUES
        (7654, 'MARTIN', 'SALESMAN', 7698,
        TO_DATE('28-SET-1981', 'DD-MON-YYYY'), 1250, 1400, 30);
INSERT INTO EMP VALUES
        (7698, 'BLAKE', 'MANAGER', 7839,
        TO_DATE('1-MAI-1981', 'DD-MON-YYYY'), 2850, NULL, 30);
INSERT INTO EMP VALUES
        (7782, 'CLARK', 'MANAGER', 7839,
        TO_DATE('9-JUN-1981', 'DD-MON-YYYY'), 2450, NULL, 10);
INSERT INTO EMP VALUES
        (7788, 'SCOTT', 'ANALYST', 7566,
        TO_DATE('09-DEZ-1982', 'DD-MON-YYYY'), 3000, NULL, 20);
INSERT INTO EMP VALUES
        (7839, 'KING', 'PRESIDENT', NULL,
        TO_DATE('17-NOV-1981', 'DD-MON-YYYY'), 5000, NULL, 10);
INSERT INTO EMP VALUES
        (7844, 'TURNER', 'SALESMAN', 7698,
        TO_DATE('8-SET-1981', 'DD-MON-YYYY'), 1500, 0, 30);
INSERT INTO EMP VALUES
        (7876, 'ADAMS', 'CLERK', 7788,
        TO_DATE('12-JAN-1983', 'DD-MON-YYYY'), 1100, NULL, 20);
INSERT INTO EMP VALUES
        (7900, 'JAMES', 'CLERK', 7698,
        TO_DATE('3-DEZ-1981', 'DD-MON-YYYY'), 950, NULL, 30);
INSERT INTO EMP VALUES
        (7902, 'FORD', 'ANALYST', 7566,
        TO_DATE('3-DEZ-1981', 'DD-MON-YYYY'), 3000, NULL, 20);
INSERT INTO EMP VALUES
        (7934, 'MILLER', 'CLERK', 7782,
        TO_DATE('23-JAN-1982', 'DD-MON-YYYY'), 1300, NULL, 10);
~~~

- estrutura da tabela EMP:

<div align="center">

Coluna | Significado | Observação | Coluna
-------|-------------|------------|----------
EMPNO | Código do empregado. | Numérico, inteiro com até 4 dígitos. Chave primária. | EMPNO
ENAME | Nome do empregado. | Alfanumérico, até 10 caracteres. | ENAME
JOB | Cargo do empregado. | Alfanumérico, até 9 caracteres. | JOB
MGR | Código do gerente. | Numérico, inteiro com atpe 4 dígitos. | MGR
HIREDATE | Data de contratação. | Data. | HIREDATE
SAL | Salário. | Numérico, 5 dígitos inteiros e 2 casas decimais. | SAL
COMM | Comissão. | Numérico, 5 dígitos inteiros e 2 casas decimais. | COMM
DEPTNO | Código do departamento. | Numérico, inteiro com até 2 dígitos. Chave Estrangeira. | DEPTNO 

</div>

- para verificar se a tabela DEPT e a tabela EMP foram criadas corretamente, executar o comando:

~~~sql
SELECT table_name FROM user_tables;

-- OU --

SELECT * FROM tab;
~~~

- para verificar se o conteúdo das tabelas foi inserido corretamente, executar os comandos:

~~~sql
SELECT * FROM dept;

-- E --

SELECT * FROM emp;
~~~

## 1.3 Estrutura da linguagem PL/SQL

- é uma linguagem de programação de alto nível.
- possui vários recursos de programa, como: declaração de constantes e variáveis, tipos de dados predefinidos, estruturas de seleção, estruturas de repetição, procedimentos, funções, pacotes.
- tudo isso pode ser desenvolvido ***em módulos*** ou, usando a ***terminologia da Oracle***, `em blocos`. 

### 1.3.1 Blocos
- ***um bloco é a unidade básica de programação do PL/SQL***.
- em um bloco PL/SQL podem-se usar:
  - comandos SQL (como SELECT, INSERT, UPDATE e DELETE), e
  - usar instruções como IF, THEN, ELSE. 
- é possível criar ***blocos anônimos*** ou ***blocos nomeados***.

### 1.3.1.1 Blocos anônimos
- um `bloco anônimo` é um conjunto de instruções que não fica armazenado definitivamente no banco.
- o conjunto de instruções é interpretado, executado e, mais tarde, descartado!

~~~sql
BEGIN
	NULL;
END;
~~~

### 1.3.1.2 Blocos nomeados
- conjunto de instruções que fica armazenado no banco de dados. 
- veremos esse assunto com mais detalhes ao longo dos capítulos.

### 1.3.2 Estruturação da Linguagem PL/SQL
- alinguagem PL/SQL é estruturada em blocos, e os programas podem ser divididos em blocos lógicos. 
- podemos dividir o bloco PL/SQL em quatro seções:
  - `DECLARATIVA` (opcional): 
    - seção destinada à declaração das variáveis, cursores e exceções que serão utilizadas no bloco. 
    - é iniciado pela palavra DECLARE.
    - caso seja definida, deve ser a primeira estrutura do programa.
  - `EXECUTÁVEL` (obrigatória):
    - também conhecida como corpo do programa, área em que são descritos os passos necessários para realização da tarefa.
    - podem ser utilizadas instruções SQL e/ou PL/SQL.
    - é iniciado pela palavra BEGIN.
  - `TRATAMENTO DE EXCEÇÕES` (opcional): 
    - destinada ao tratamento das exceções geradas no bloco.
    - devem ser descritas as ações a serem desempenhadas quando ocorrerem erros.
    - iniciado pela palavra EXCEPTION.
  - `FIM` (obrigatória): 
    - destinado ao encerramento do programa. 
    - todo programa PL/SQL deve ser finalizado usando a palavra END.

~~~sql
DECLARE (opcional)
-- Aqui definimos as variáveis e outras estruturas que veremos mais a frente
BEGIN (obrigatório)
-- Aqui usamos instruções SQL e PL/SQL
EXCEPTION (opcional)
-- Aqui definimos as ações que serão tomadas quando ocorrer alguma exceção entro do programa
END; (obrigatório)
~~~

> As palavras `DECLARE, BEGIN e EXCEPTION não são seguidas de ponto e vírgula`, mas `a palavra END tem um ponto e vírgula no final`. Lembre-se de colocar um ponto e vírgula ao final de todos os comandos SQL e PL/SQL usados em seu programa PL/SQL!

## 1.4 Blocos Anônimos

- blocos anônimos não ficam armazenados na base de dados. 
  - como consequência, não podem ser chamados por outros blocos PL/SQL e devem ser compilados a cada utilização.
  - é possível incorporar um bloco anônimo em uma aplicação ou executá-lo interativamente no SQL*Plus.
- importante observar que a recompilação de um programa a cada vez que é reexecutado, consome recursos importantes de processamento e memória do servidor de banco de dados e pode impactar diretamente no desempenho geral do sistema.
- exemplo da estrutura de um bloco em PL/SQL:

~~~sql
DECLARE 
		v_variavel varchar2(5);
BEGIN 
		Select nome_coluna
	into v_variavel
		from nome_tabela;
EXCEPTION 
		When exception_name then
END; 
/
~~~

- analisando o código:
  - na primeira linha aparece a palavra-chave DECLARE. Nesta seção, definir as constantes e variáveis que serão usadas no programa. Note que não há um ponto e vírgulaapós a palavra DECLARE!
  - na segunda linha é declarado o nome de uma variável chamada V_VARIAVEL. Após o nome da variável, informamos o tipo de dados que aceitará e, em seguida, o tamanho máximo dessa variável. Nesse caso, V_VARIAVEL aceitará valores alfanuméricos (VARCHAR2) com tamanho de até cinco caracteres (5). Note que há um ponto e vírgula logo após a definição da variável!
  - a terceira linha mostra a palavra-chave BEGIN. A seção executável inicia nesse ponto. Também não há um ponto e vírgula após a palavra BEGIN.
  - a quarta linha mostra o início de uma seleção, SELECT NOME_COLUNA. Como o comando não terminou, ainda não foi usado um ponto e vírgula.
  - a quinta linha traz o comando INTO (específico do PL/SQL) V_VARIAVEL, que indica que o conteúdo da coluna NOME_DA_COLUNA será armazenado na variável V_VARIÁVEL. Ainda não terminamos de escrever o comando, então ainda não colocaremos ponto e vírgula.
  - a sexta linha informa de qual tabela extrairemos os dados por meio do comando FROM NOME_TABELA. Desta vez, colocaremos o ponto e vírgula para indicar que o comando encerrou.
  - na sétima linha aparece a palavra-chave EXCEPTION. Nessa seção iremos tratar as exceções encontradas durante a execução do programa. Note que não há um ponto e vírgula após a palavra Exception.
  - a oitava linha mostra a sintaxe incompleta de como capturamos a exceção para tratá-la.
  - a nona linha encerra o programa com a palavra-chave END; desta vez temos um ponto e vírgula após a palavra END.
  - a décima linha mostra uma / (barra). Quando estamos trabalhando com a interface SQL*Plus, é esse caractere que encerra o editor PL/SQL e executa o bloco anônimo.
  - lembrando, as `palavras-chave BEGIN e END são as únicas obrigatórias`.

<div align="center">
<h2>2. VARIÁVEIS</h2>
</div>

- são campos definidos pelo usuário e podem ser usadas para armazenar dados temporariamente. 
- normalmente, as variáveis são definidas e usadas em tempo de execução, isto é, ***são criadas quando o programa é executado e deixam de existir quando o programa é encerrado***.
- podem ser utilizadas para:
  - `manipulação de valores armazenados`: 
    - variáveis podem ser usadas para cálculo e manipulação de outros dados sem acessar o banco de dados.
    - ou seja, após os valores em memória, não há necessidade de outros acessos para complemento da informação armazenada.
  - `reutilização`:
    - quando declaradas, podem ser usadas repetidamente em uma aplicação simplesmente referenciando-as em outras instruções, incluindo outras instruções declarativas.
  - `facilitar a manutenção`: 
    - pode-se declarar variáveis baseadas na estrutura das colunas das tabelas ou em outras variáveis (%TYPE e %ROWTYPE). 
    - se uma definição subjacente for alterada, a declaração da variável é atualizada em tempo de execução. 
    - isso permite a independência dos dados, reduz custos de manutenção e permite que os programas se adaptem de acordo com as alterações realizadas no banco de dados.
  - `passar valores`: aos subprogramas PL/SQL por meio de parâmetros.
  - `exibir os resultados`: em um bloco PL/SQL por meio de variáveis de saída.

- a declaração e a inicialização das variáveis são realizada sna seção declarativa de qualquer subprograma pacote ou bloco PL/SQL. 
- as declarações alocam espaço de armazenamento para um valor, especificam seus tipos de dados e nomeiam a localização de armazenamento para que se possa referenciá-los.
- as declarações poderão também atribuir um valor inicial e impor a restrição NOT NULL.
- ao atribuir novos valores às variáveis na seção executável, o valor existente da variável é substituído pelo novo e é necessário declarar uma variável antes de referenciá-la em outras instruções, incluindo outras instruções declarativas.

## 2.1 Tipos de Variáveis

- todas as variáveis PL/SQL têm um tipo de dados, o qual especifica um formato de armazenamento, restrições e uma faixa válida de valores.
- a linguagem PL/SQL suporta quatro categorias de tipos de dados:
  - `Escalares`: 
    - armazenam um único valor. 
    - os principais tipos de dados são aqueles que correspondem aos tipos de coluna nas tabelas do Oracle Server.
    - exemplo: VACHAR2, NUMBER, CHAR, entre outros.
    - a linguagem PL/SQL também suporta variáveis booleanas.
  - `Compostos`:
    - comportam o armazenamento de diferentes valores. 
    - os tipos compostos em PL/SQL são registro, tabelas e matrizes. 
  - `Referenciais`:
    - armazenam valores, chamados de indicadores, que designam outros itens de programa. 
    - exemplo de tipos referenciais é o REF CURSOR.
  - `LOB` (large object):
    - armazenam blocos de dados não estruturados (como texto, imagens gráficas, videoclipes e formatos de arquivo para armazenar sons) de até 4 gigabytes em tamanho. 
    - os tipos de dados LOB fornecem acesso eficiente, aleatório e em intervalos aos dados, podendo ser atributos de um tipo de objeto.

- ***variáveis LOB*** podem ser classificadas como:
  - **tipo de dados CLOB** (character large object, objeto grande de caractere): usado para armazenar blocos grandes de dados com caracteres de um único byte no banco de dados.
  - **tipo de dados BLOB** (binary large object, objeto grande binário): usado para armazenar objetos binários grandes no banco de dados em linha (dentro de uma linha de tabela) ou fora de linha (fora da linha de tabela).
  - **tipo de dados BFILE** (binary file, arquivo binário): usado para armazenar objetos grandes binários em arquivos do sistema operacional fora do banco de dados.
  - **tipo de dados NCLOB** (objeto grande de caractere do idioma nacional): usado para armazenar blocos grandes de dados NCHAR de byte único ou de bytes múltiplos de largura fixa no banco de dados, dentro e fora de linha.

- ao declarar uma variável, usar a sintaxe:

~~~sql
identificador [CONSTANT] tipo de dados [NOT NULL]
		[:= valor para inicialização | expr default]
~~~

- em que:
  - ***Identificador***: é o nome da variável; identificadores não devem ter mais de 30 caracteres. O primeiro caractere deve ser uma letra, os demais podem ser letras, números ou símbolos especiais e não devem ser palavras reservadas nem possuir espaços entre os caracteres.
  - ***CONSTANT***: restringe as variáveis para que o seu valor não possa ser alterado; constantes devem ser inicializadas.
  - ***Tipo de dados***: são tipos de dados escalares, compostos, referenciais ou LOB.
  - ***NOT NULL***: indica preenchimento obrigatório (variáveis NOT NULL devem ser inicializadas).
  - ***Expr***: é uma expressão PL/SQL que pode ser uma literal, outra variável ou uma expressão que envolve operadores e funções.

- para inicializar a variável, utiliza-se operador de atribuição (`:=`) ou a `palavra reservada DEFAULT`.
  - se não for atribuído um valor inicial, terá NULL por default. 
  - não é aconselhável identificar uma variável com nome igual ao nome das colunas de tabela usadas no bloco. 
  - se as variáveis PL/SQL ocorrerem nas instruções SQL e tiverem o mesmo nome que uma coluna, o Oracle Server (2016) supõe que seja a coluna que esteja sendo referenciada.

## 2.2 Tipos de dados escalares

- armazena um valor único e não possui componentes internos.
- classificados em quatro categorias: número, caractere, data e booleano. 
- os tipos de dados de caractere e número possuem subtipos que associam um tipo básico a uma restrição (exemplo: INTEGER e POSITIVE são subtipos do tipo básico NUMBER). 

<div align="center">

Tipo de dado | Descrição
-------------|-----------------
VARCHAR2 (tamanho) | Armazena caracteres com tamanho variável com até 32.767 bytes; não há tamanho default para essas variáveis.
NUMBER (tamanho, precisão) | Armazena números reais ou inteiros.
DATE | Armazena datas e horas entre os períodos de 4712 a.C. e 9999 d.C.
CHAR (tamanho) | Armazena caracteres de tamanho fixo até 32.767 bytes, tamanho default = 1 byte.
BOOLEAN | Armazena um de três possíveis valores: TRUE, FALSE ou NULL.
BINARY_INTEGER | Armazena números inteiros entre -2.147.483.647 e 2.147.483.647.
PLS_INTEGER | Armazena números inteiros entre -2.147.483.647 e 2.147.483.647; estes valores requerem menos armazenamento e são mais rápidos que os valores NUMBER e BINARY_INTEGER. 

</div>

### 2.2.1 Alguns testes:

### a) Testando a definição de variáveis:

~~~sql
SET SERVEROUTPUT ON
DECLARE
    v_teste VARCHAR2(30):='Hello, World';
BEGIN
	DBMS_OUTPUT.PUT_LINE(v_teste);
END;       
/
~~~

- o comando `SET SERVEROUTPUT ON` informa que as mensagens do programa devem ser exibidas na tela.

### b) Exemplos de declaração de variáveis:

~~~sql
v_nascimento DATE; 
-- aceita valores nulos
-- não tem nenhum valor inicial atribuído

v_data DATE := SYSDATE + 7;
-- inicialização a partir de uma operação aritmética 
-- (hoje + 7 dias)

v_codigo NUMBER(2) NOT NULL := 10; 
-- preenchimento obrigatório (NOT NULL)
-- variável recebe valor inicial 10

v_UF VARCHAR2(2) := 'SP'; 
-- declaração e inicialização com valor SP
-- os literais devem ser informados entre aspas simples

v_loc VARCHAR2(2) DEFAULT 'RJ';
-- valor default é RJ

v_teste_logico BOOLEAN := (v_valor1 < v_valor2); 
-- declaração da variável booleana.
-- inicializada com o resultado da expressão:
-- (v_valor1 < v_valor2).

c_const CONSTANT NUMBER := 54;
~~~

## 2.3 Instrução SELECT em PL/SQL

- é possível usar a instrução SELECT para recuperar dados do banco de dados. 
- para isso, é necessário usar uma estrutura denominada `CURSOR` para recuperar mais de uma linha por vez. Porém, por enquanto, as consultas retornarão apenas uma linha (ORACLE, 2016).
- sintaxe das instruções SELECT no PL/SQL:

~~~sql
SELECT colunas
INTO	 {variáveis...| registro} 
FROM	 tabela
WHERE	 condição;
~~~

- em que:
  - ***colunas***: colunas que retornarão dados à consulta; podem incluir funções de linhas, de grupo ou expressões SQL.
  - ***Into***: cláusula obrigatória, usada para especificar os nomes das variáveis que armazenarão os valores que o SQL retornará a partir da cláusula SELECT. Deve-se oferecer uma variável para cada coluna, seguindo a mesma ordem.
  - ***Variáveis***: nome das variáveis que irão armazenar o valor recuperado.
  - ***Registro***: registro PL/SQL para armazenar os valores recuperados, a tabela que especifica o nome da tabela do banco de dados condição é composta de nomes de coluna, expressões, constantes e operadores de comparação, incluindo as variáveis PL/SQL e operadores.

- exemplos:

~~~sql
SET SERVEROUTPUT ON
DECLARE
  v_nome VARCHAR2(30);
  v_cargo VARCHAR2(30);
BEGIN
  SELECT ename, job
  INTO v_nome, v_cargo
  FROM emp
  WHERE empno = 7934;
DBMS_OUTPUT.PUT_LINE(v_nome);
DBMS_OUTPUT.PUT_LINE(v_cargo);
END;
/
~~~

~~~sql
SET SERVEROUTPUT ON
DECLARE 
  v_soma_sal NUMBER; 
  v_deptno NUMBER NOT NULL := 10; 
BEGIN
  SELECT SUM(sal) 
  INTO v_soma_sal
  FROM emp
  WHERE	deptno = v_deptno;
DBMS_OUTPUT.PUT_LINE('A soma dos salários do departamento ' || v_deptno || ' é ' || v_soma_sal);
END;
/
~~~

## 2.4Instrução INSERT em PL/SQL

- usada para incluir dados em uma tabela.
- sintaxe similar à da linguagem SQL: 

~~~sql
DECLARE
v_empno NUMBER := 11;
v_ename VARCHAR2(13) := 'SANDRA';
v_job VARCHAR2(13) := 'GERENTE';
v_deptno NUMBER := 10;
BEGIN
   INSERT INTO emp(empno, ename, job, deptno)
          VALUES (v_empno, v_ename, v_job, v_deptno);
END;
/
~~~

## 2.5 Instrução UPDATE em PL/SQL

- usada para alterar dados em uma tabela.
- sintaxe similar ao comando UPDATE da linguagem SQL.

~~~sql
DECLARE
	v_sal_increase NUMBER := 2000;
BEGIN
	UPDATE emp
	SET sal = sal + v_sal_increase
	WHERE	job = 'ANALYST';
END;
/
~~~

## 2.6 Instrução DELETE em PL/SQL

- usada para remover registros de uma tabela.
- sintaxe similar ao comando DELETE da linguagem SQL.

~~~sql
DECLARE
	v_deptno NUMBER := 10; 
BEGIN							
	DELETE FROM emp
	WHERE deptno = v_deptno;
END;
/
~~~

## 2.7 Controle de Transação em PL/SQL

- uma transação consiste em uma ou mais instruções SQL que, quando executadas, podem ser consideradas como uma única unidade.
- ou seja, se uma instrução da transação falhar, a transação inteira falha e todas as instruções que foram executadas antes do ponto de falha são revertidas.
- o início e o término de uma transação definem os pontos da consistência da base de dados.
- os efeitos de todas as operações SQL realizadas dentro de uma transação são aplicados ao banco de dados (`COMMIT`) ou os efeitos de todas as operações SQL realizadas são completamente "desfeitos" e jogados fora (`ROLLBACK`).
- em uma transação, locks ou bloqueios são obtidos no início e mantidos ao longo da vida de uma transação. Quando surge uma condição de erro, o banco de dados remove todas as alterações feitas pela transação.
- em situações de erro, os bloqueios são liberados; nenhuma conexão é permitida até a consistência ser restaurada.

~~~sql
BEGIN
	INSERT INTO dept VALUES ('A','A','A');
  -- o 1°. campo da tabela DEPT é DEPTNO, numérico.
  -- tentaremos inserir o valor 'A' (alfanumérico), em um campo numérico,
  -- então esperamos que o comando falhe.
	COMMIT;
EXCEPTION
	WHEN OTHERS THEN ROLLBACK;
  -- instrui o programa a executar o comando ROLLBACK caso ocorra falha no programa
END;
/
~~~

--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)