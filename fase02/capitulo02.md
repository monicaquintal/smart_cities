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












--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)