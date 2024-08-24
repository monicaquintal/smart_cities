<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img align="right" height="120px" src="../assets/logo.png" /></a>
<h1>FASE 5 - Data Universe</h1>
<h2>Capítulo 04: MongoDB na Prática.</h2>
</div>

<div align="center">
<h2>1. MONGODB NA PRÁTICA</h2>
</div>

## 1.1 Terminologia

- comparação entre os termos usados em um banco de dados relacional Oracle e um banco de dados orientado a documentos MongoDB:

<div align="center">

Oracle (RDBMS) | MongoDB (documento)
---------------|-----------------------
Database | Database
Instânca de Banco de Dados | Instância MongoDB
Esquema | Banco de Dados
Tabela, View | Coleção
Tupla | DOcumento (JSON, BSON)
Coluna | Campo ou Field
ROWID / Primary Key | _id
Junção | DBRef (Embedded Document)
Foreign Key | Reference
Partição | Shard
Select | Método find
Insert | Método insert
Updade | Método update
Delete | Método remove

</div>

### 1.1.1 Coleção (collection)
- uma coleção é onde os dados do MongoDB são armazenados. 
- pode ser comparada com as tabelas de um banco de dados relacional, mas sua estrutura é muito menos rígida do que em um RDBMS. 
- é um conjunto de documentos MongoDB.
- uma coleção pertence a um único banco de dados MongoDB e não possui um esquema. 
- cada documento em uma coleção pode ter campos diferentes. 
- por uma questão de praticidade e organização, procuramos criar coleções com documentos semelhantes.
- coleções podem ser criadas no momento em que formos salvar um documento que a referencie, ou por meio do `comando createCollection`.

~~~
db.createCollection(name, options)
~~~

- onde:
  - ***Name***: indica o nome da coleção a ser criada.
  - ***Options***: configurações opcionais para a criação de:
    - Capped collection.
    - Cluestered collection.
    - View.

- o comando a seguir cria uma coleção denominada biblioteca:

~~~
db.createCollection('biblioteca')
~~~

> a execução foi bem-sucedida, porque o comando retornou a chave-valor {“ok”:1}.

- os nomes de coleções devem obedecer aos seguintes critérios:
  - o nome de uma coleção deve começar por uma letra ou sublinhado ("_").
  - pode conter números.
  - não pode utilizar o caractere cifrão ("$").
  - não pode exceder 128 caracteres.

- é possível criar grupos nomeados usando um ponto ("."), e esses grupos são nomeados ***namespace collection***. 
  - podemos, por exemplo, criar uma coleção para os livros de arte e outra para os romances: 
    - livros.romance
    - livros.arte

- o `comando show collections;` pode ser usado para exibir todas as coleções do banco de dados corrente.

~~~
show collections;
~~~

### 1.1.2 Documento (document)
- em um banco MongoDB, um documento é o equivalente a uma linha, ou tupla, em uma tabela de um banco relacional. 
- é representado por um conjunto de pares de chave-valor.
- exemplo:

~~~
{
  Nome: 'Fulano',
  Idade: 30
}
~~~

- o documento é aberto com uma chave e encerrado por outra chave; tudo que está entre essas duas chaves faz parte desse documento. 
- no exemplo há dois pares de chave-valor, e cada par é separado por uma vírgula. 
- entre a chave e o valor existe o símbolo de dois pontos. 
- documentos na mesma coleção não precisam ter a mesma estrutura ou conjunto de campos, e podem conter diferentes tipos de dados.

## 1.2 Tipos de dados

- o MongoDB possui suporte aos principais tipos de dados primitivos utilizados em qualquer banco de dados.
- principais tipos de dados:
  - `String`: 
    - tipo mais usado para armazenar dados. 
    - String no MongoDB deve ser um UTF-8 válido.
  - `Integer`: 
    - este tipo armazena um valor numérico. 
    - Integer pode ser 32 bits ou 64 bits, dependendo do seu servidor.
  - `Boolean`:
    - este tipo armazena um valor booleano (true ou false).
  - `Double`: 
    - tipo que armazena valores de ponto flutuante.
  - `Min/Max keys`: 
    - tipo que compara um valor contra os elementos mais baixos e mais altos de um BSON.
  - `Arrays`: 
    - este tipo armazena arrays, listas ou múltiplos valores dentro de uma chave (key).
  - `Timestamp`: ctimestamp.
    - pode ser útil para a gravação de quando um documento foi modificado ou acrescentado.
  - `Object`:
    - este tipo de dado é para incorporar documentos.
  - `Null`:
    - tipo usado para armazenar um valor nulo (null).
  - `Symbol`:
    - este tipo de dados é usado de forma idêntica ao String, porém geralmente é reservado para linguagens que usam um tipo de símbolo específico.
  - `Date`:
    - tipo de dados utilizado para armazenar a data ou a hora atual no formato de UNIX. 
    - é possível especificar seu próprio date_time por meio da criação do objeto Date e passando o dia, o mês e o ano para ele.
  - `Object ID`:
    - tipo de dados que armazena os identificadores (ID) dos documentos
  - `Binary data`:
    - este tipo de dados armazena um dado binário.
  - `Code`:
    - tipo de dados usado para armazenar código javascript dentro do documento.
  - `Regular expression`:
    - tipo de dados para armazenar expressões regulares.

- dentre os diversos tipos de dados, os mais utilizados são:
  - Numéricos.
  - String (usar '' ou "" para identificá-los).
  - Date.
  - Boolean (true ou false).
  - Array.
  
- o banco de dados MongoDB pode conter uma ou mais coleções; uma coleção pode conter diferentes tipos de documentos; e um documento pode conter um conjunto de chave-valor, arrays e documentos aninhados.
- o nome das ***variáveis shell*** no MongoDB deve iniciar por uma letra minúscula `[a-z]`; as letras seguintes podem ser minúsculas, maiúsculas ou números `[a-zA-Z0-9]`.

## 1.3 Help 

- o MongoDB possui vários comandos que fornecem ajuda ao desenvolvedor:

<div align="center">

Comando | Função | Exemplo de uso
--------|-------|-------------------
help; | Exibe uma lista de funções. | help;
db.help(); | Fornece uma lista das funções de ajuda para um determinado método do banco de dados. | db.help('insert');
db.&lt;colecao&gt;.help(); | FOrnece uma lista dos métodos aplicáveis a uma coleção. &lt;colecao&gt; indica o nome de uma coleção a ser criada ou previamente existente. | db.biblioteca.help();

</div>

- o `comando show` também ajuda muito, pois permite obter informações sobre quais coleções existem em nosso banco, quais são os bancos de dados existentes no servidor e quais são os usuários do banco de dados corrente. 
- principais usos do comando show:

<div align="center">

Comando | Função
--------|-------------
show dbs; |	Fornece uma lista de todos os bancos de dados do servidor.
show collections;	| Fornece uma lista de todas as coleções do banco de dados corrente.
show users; |	Fornece uma lista de todos os usuários do banco de dados corrente.
show roles; |	Fornece uma lista de todas as roles, predefinidas ou definidas pelo usuário, do banco de dados corrente.
show profile; |	Fornece uma lista das últimas cinco operações que levaram um milissegundo ou mais para serem executadas.
show databases;	| Fornece uma lista de todos os bancos de dados disponíveis.

</div>

- `símbolos e operadores` que usamos para trabalhar com os documentos:

<div align="center">

Operador / Símbolo	| Significado
-----------------|----------------------
() (parênteses)	| Indica o uso de um método.
[] (colchetes)	| Usado em arrays.
{} (chaves)	| Usado em documentos.
. (ponto)	| Separador de métodos.
= (igual) |	Atribui valor para variáveis.
, (vírgula)	| Separa atributos. Não deve ser usada com números.
: (dois pontos)	| Especifica o valor de um atributo.
' (aspas simples)	| Indica que o valor de um atributo é texto.
" (aspas duplas)	| Indica que o valor de um atributo é texto.
; (ponto-e-vírgula)	| Encerra um comando.

</div>















--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)