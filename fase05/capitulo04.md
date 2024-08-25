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

## 1.4 Criando um novo banco de dados

- ao contrário dos bancos de dados relacionais, não existe um comando create database. 
- ***o banco é fisicamente criado no momento em que uma coleção é criada***. 
- estudamos o comando createCollection para criar uma nova coleção, mas ao inserir um documento em uma coleção que não existe, o Mongo DB cria automaticamente esta coleção utilizando a configuração padrão. 
- portanto, para começar a utilizar o banco, não precisamos criar um banco nem uma coleção antes de inserirmos nosso primeiro documento. 
- para mudarmos de um banco para outro, usamos o comando use.

~~~
use db
~~~

- em que:
  - db: indica o nome do banco de dados a ser usado.
  - a variável shell db é alterada para o nome do banco de dados que será usado. 

## 1.5 Um novo banco, collection, ou documentos aninhados?

- a ***regra de ouro do MongoDB*** é: `Dados que são acessados juntos devem ser armazenados juntos`.
- idealmente, devemos contar com um único banco de dados para o mesmo tema. 
- se temos um serviço sendo desenvolvido, esse serviço terá o seu banco de dados; um bom caso de uso para a criação de um novo banco, seria para o desenvolvimento de outro serviço dentro da mesma instância do MongoDB, pois os dados ali presentes não têm nada em comum e são utilizados em produtos distintos.
- essa questão se torna mais complicada quando estamos trabalhando dentro do mesmo serviço. 
  - depois de estudar os conceitos de modelagem de dados relacional, é muito comum tentarmos segregar as “partes” de um mesmo produto em diferentes collections (seguindo os conceitos das tabelas) para garantir as regras de normalização. 
  - dentro do MongoDB, precisamos ter uma visão um pouco mais ampla identificando o que compõe o mesmo produto e que será consultado em conjunto pela nossa aplicação. 
  - exemplos:
    - analogia da conculta de um carro: todas as partes do carro compõem o produto, portanto devem estar persistidas junto com o identificador do carro e estarem acessíveis caso seja do interesse consultar mais detalhes sobre o carro sem a necessidade de enriquecer o nosso documento com dados adicionais de outro documento possivelmente presente em outra collection (nada de joins!).
    - para uma nova collection, um caso de uso interessante seria o de pessoa, pois uma pessoa é a dona deste carro, e, portanto,precisaríamos dos dados da mesma que se encontrariam em uma collection a parte dos dados do veículo em si, existindo apenas uma referência às collections através de um identificador do veículo e um identificador da pessoa.

## 1.6 Organização e escalabilidade

- modelagem de dados refere-se à organização de dados dentro de um banco de dados e aos links entre entidades relacionadas. 
- com um modelo de dados flexível, documentos dentro de uma collection não são obrigados a ter o mesmo conjunto de campos, e os tipos de dados de um campo podem diferir de documento para documento.
- essa divergência de campos e dados pode gerar problemas de organização se não tivermos cuidado.
- portanto, geralmente documentos de uma collection compartilham de estrutura semelhante, mas para garantir a consistência ***é possível criar regras de validação de esquema***, o que possibilita uma confiabilidade maior para o uso de determinadas collections.
- essas regras de validação são chamadas também de `JSON Schema`, e podem ser implementadas na criação de uma Collection da seguinte forma:

~~~
db.createCollection("students", {
   validator: {
      $jsonSchema: {
         bsonType: "object",
         title: "Student Object Validation",
         required: ["address", "major", "name", "year"],
         properties: {
            name: {
               bsonType: "string",
               description: "'name' must be a string."
            },
            year: {
               bsonType: "int",
               minimum: 2017,
               maximum: 3017,
               description: "'year' must be an integer."
            },
            gpa: {
               bsonType: ["double"],
               description: "'gpa' must be a double."
            }
         }
      }
   }
} )
~~~

- o MongoDB oferece o conceito de `operações de escrita atômicas`, na granularidade de documento.
- ou seja, se um documento com outros documentos aninhados for escrito ou atualizado, a operação só será concluída caso todos os documentos aninhados sejam corretamente modificados. 
- um modelo de dados desnormalizado permite operações atômicas, em contraste com um modelo normalizado onde as operações afetam vários documentos.

<div align="center">
<h2>2. OPERAÇÕES CRUD</h2>
</div>

- as quatro operações básicas em banco de dados são:
  - incluir dados (create).
  - consultar dados (read).
  - alterar dados (update).
  - apagar dados (delete).

- o acrônimo das quatro palavras em inglês (create, read, update e delete) forma a palavra CRUD. 
- foi convencionado que o termo CRUD indica essas quatro operações.
- a estrutura básica de um comando no banco de dados MongoDB é:

~~~
database.coleção.função()
~~~

- em que:
  - database: indica o banco de dados. A variável db contém o nome do banco de dados. 
  - coleção: mostra o nome da coleção.
  - função: aponta a função que será aplicada à coleção.

- os comandos usados pelas operações CRUD, normalmente, irão começar por db, indicando que as operações serão realizadas no banco corrente.

## 2.1 Incluindo dados

- adicionamos documentos a uma coleção por meio de uma operação de inclusão. 

> IMPORTANTE: Caso a coleção ainda não tenha sido criada, a operação de inclusão irá criá-la!

- há várias formas de incluir dados em uma coleção. 
- neste primeiro momento, iremos nos concentrar na `função insertOne`.

~~~
db.coleção.insertOne(
  <documento>,
  {
    writeConcern: <documento>
  }
)
~~~

- em que:
  - documento: indica o documento a ser inserido em uma coleção.
  - writeConcern: opcional; há 2 configurações possíveis para o writeConcern, sendo:
    - ***w***: para solicitar o reconhecimento de que a operação de gravação propagou para um número especificado de instâncias.
    - ***j***: para solicitar a confirmação de que a operação de gravação foi gravada no diário em disco.
    - ***wtimeout***: para especificar um limite de tempo para impedir que as operações de gravação sejam bloqueadas indefinidamente.

### `Exemplo de uso`: 
- incluir dados de um funcionário em uma coleção denominada "emp". Os dados do funcionário são:
  - Nome: Sullivan
  - Idade: 21
  - Cargo: Engenheiro de dados
  - Salário: 10.000,00
- ou seja, são quatro pares de chave-valor.
- converter esses dados para uma estrutura de chave-valor mais apropriada:

~~~
{
   Nome: "Sullivan",
	Idade: 21,
	Cargo: 'Engenheiro de dados',
	Salario: 10000.00
}
~~~ 

- detalhes importantes:
  - nesse caso, os campos contêm texto por aspas simples ou aspas duplas, sendo qualquer uma delas aceita, mostrando para o banco de dados que esse campo conterá um texto. 
  - campos numéricos não contêm aspas. 
  - vírgulas são usadas para separar os pares de chaves-valor. 
  - valores decimais são indicados por um ponto. 

- vamos usar a sintaxe para incluir os dados na coleção emp.

~~~
db.emp.insertOne({ Nome: "Sullivan",
                Idade: 21,
                Cargo: 'Engenheiro de dados',
                Salario: 10000.00 
})
~~~

- o resultado da operação retorna o ObjectId do documento inserido,confirmando que o comando foi bem-sucedido e que um documento foi incluído na coleção emp.

### `Outro exemplo`:
- desta vez, os dados são:
  - Nome: Mel
  - Idade:26
  - Cargo: Gerente
  - Salário: 18.830,50
  - Dependentes: Jhonny, Clarinha
  
- agora, acrescentamos a chave "Dependentes", que possui dois valores "Jhonny" e "Clarinha". 
- como esta chave tem dois valores, iremos usar um array para representá-los, lembrando que campos do tipo texto podem ser indicados usando aspas simples ou aspas duplas.

~~~
db.emp.insertOne(
              { Nome: "Mel",
                Idade: 26,
                Cargo: 'Gerente',
                Salario: 18830.50,
                Dependentes: ["Jhonny", 'Clarinha']  
}
)
~~~

### `Um exemplo um pouco mais complexo`:
- desta vez, vamos incluir informações sobre o departamento em que o empregado trabalha. 
- os dados do funcionário são:
  - Nome: Thais
  - Idade: 20
  - Cargo: Analista
  - Salário: 14.530,77
  - Dependentes: Angela, Dora, Hugo
  
- os dados do departamento são:
  - Nome: Pesquisa
  - Local: São Paulo

- vamos tratar os dados do departamento como um documento dentro do documento.

~~~
db.emp.insertOne(
             { Nome: "Thais",
               Idade: 20,
               Cargo: "Analista",
               Salario: 14530.77,
               Dependentes:["Angela", "Dora", "Hugo"],
               Departamento: { Nome: "Pesquisa",
                               Local: "São Paulo"
                              }
              }
)
~~~

- ao contrário dos bancos de dados relacionais, procuramos evitar a junção de duas coleções. 
- sempre que possível, já efetuamos a operação de junção durante a inclusão dos dados. 
- ***podemos ter vários documentos dentro do mesmo documento. Também podemos ter vetores de documentos.***

### `Outro exemplo`: incluindo, no documento do funcionário, as informações sobre as suas promoções dentro da empresa.
- dados do funcionário:
  - Nome: Fátima
  - Idade: 29
  - Cargo: Analista
  - Salário: 12.345,67
  - Dependentes: Gohan
- dados do departamento:
  - Nome: Vendas
  - Local: Campinas
- histórico de promoções:
  - Ano: 2001
  - Cargo: "Estagiário"
  - Valor: 180,00
  - Ano: 2002
  - Cargo: "Desenvolvedor"
  - Valor: 1.700,00

- vamos tratar os dados das promoções como um array de documentos dentro do documento:

~~~
db.emp.insertOne(
             { Nome: "Fátima",
               Idade: 29,
               Cargo: "Analista",
               Salario: 12345.67,
               Dependentes:["Gohan"],
               Departamento: { Nome: "Vendas",
                               Local: "Campinas"
                             },
               Promoções: [{Ano: 2001,
                            Cargo: "Estagiário",
                            Valor: 180.00},
                           {Ano: 2002,
                            Cargo: "Analista",
                            Valor: 1700.00}]
  }
  )
~~~

- ou seja, temos um array de documentos em promoções!

### 2.1.1 Inclusão de documentos por meio de variáveis

- o uso de variáveis permite que incluamos vários documentos em uma única operação.
- imagine que você queira incluir os seguintes dados em uma coleção denominada grade:

<div align="center">

| Nome                              | Autor     | Professor | Novo  | Cód  | Mês | ISBN     | Valor  |
|-----------------------------------|-----------|-----------|-------|------|-----|----------|--------|
| Estruturas de dados               | Rossetti  |           | FALSE |      |     | 12345678 | 171,13 |
| Engenharia de software            |           | Rita      |       | FES  | 2   |          |        |
| Inglês instrumental               | Ana       |           | FALSE |      |     | 45678901 | 122,99 |
| Interfaces com usuário            |           | André     |       | IU   | 2   |          |        |
| Programação orientada a objeto    | Gatti     |           | TRUE  |      |     | 23456789 | 161,16 |
| Modelagem orientada a objeto      | Rodrigo   |           |       | MO01 | 2   |          |        |
| Banco de dados                    | Angélica  |           | TRUE  |      |     | 34567890 | 133,29 |
| Gestão empresarial                | Silva     | Silva     | TRUE  | GE   | 2   | 56789012 | 156,55 |

</div>

- é possível criar uma variável usando a instrução var, que irá receber esses documentos.

~~~
var dados = [ 
{Nome: 'Estruturas de dados', 
 Autor: 'Rossetti', 
 Novo: false, 
 ISBN: 12345678, 
 Valor: 171.13},
 
{Nome: 'Engenharia de software', 
 Professor: 'Rita', 
 Cod: 'FES', Mes: 2}, 
{Nome: 'Inglês instrumental', 
 Autor: 'Ana', 
 Novo: false, 
 ISBN: 45678901, 
 Valor: 122.99},
 
{Nome: 'Interfaces com usuário',
 Professor: 'André', 
 Cod: 'IU', 
 Mes: 2},
 
{Nome: 'Programação orientada a objeto', 
 Autor: 'Gatti', 
 Novo: true, 
 ISBN: 23456789, 
 Valor: 161.16},

{Nome: 'Modelagem orientada a objeto', 
 Professor: 'Rodrigo', 
 Cod: 'MOO1', 
 Mes: 2}, 
{Nome: 'Banco de dados', 
 Autor: 'Angélica', 
 Novo: true, 
 ISBN: 34567890, 
 Valor: 133.29},
 
{Nome: 'Gestão empresarial', 
 Autor: 'Silva', 
 Professor: 'Silva', 
 Novo: true, 
 Cod: 'GE', 
 Mes: 2, 
 ISBN: 56789012, Valor: 156.55}
 ]
~~~

- esta variável pode ser usada com o `método insertMany()` para incluir os documentos na coleção grade:

~~~
db.grade.insertMany(dados);
~~~

## 2.2 Consultando dados

- os documentos que foram incluídos nas coleções podem ser consultados usando o `método find()`. 
- este método retorna um array com os objetos da coleção, mesmo que se trate de apenas um objeto.

~~~
db.Coleção.find(Consulta, Projeção, Opções)
~~~

- em que:
  - ***Coleção***: indica o nome da coleção.
  - ***Consulta***: 
    - aponta quais serão os filtros aplicados na pesquisa. 
    - para retornar todos os documentos de uma coleção, basta omitir este parâmetro ou informar um documento vazio ({}). 
    - este parâmetro é opcional.
  - ***Projeção***: 
    - exibe quais campos específicos do documento serão retornados pela pesquisa. 
    - se omitido, todos os campos do documento serão retornados. 
    - este parâmetro é opcional.
  - ***Opções***:
    - especifica opções adicionais para a query. 
    - estas opções modificam o comportamento da query e como os resultados são retornados.E
    - este parâmetro é opcional

- a consulta básica aos dados de uma coleção MongoDB é bem simples. 
- exemplo de uso:

~~~
db.grade.find();
~~~

- o método find() retornou uma lista com todos os documentos da coleção.

- podemos usar o `método findOne()` para retornar o primeiro objeto encontrado na coleção que atenda aos critérios de busca da consulta.

~~~
db.coleção.findOne(consulta, projeção, opções)
~~~

- em que:
  - ***Coleção***: indica o nome da coleção.
  - ***Consulta***:
    - mostra quais serão os filtros aplicados na pesquisa. 
    - para retornar todos os documentos de uma coleção, basta omitir este parâmetro ou informar um documento vazio ({}). 
    - este parâmetro é opcional.
  - ***Projeção***: 
    - aponta quais campos específicos do documento serão retornados pela pesquisa. 
    - se omitido, todos os campos do documento serão retornados. 
    - este parâmetro é opcional.
  - ***Opções***: 
    - especifica opções adicionais para a query. 
    - estas opções modificam o comportamento da query e como os resultados são retornados.
    - este parâmetro é opcional.

- consulta básica usando o findOne():

~~~
db.grade.findOne();
~~~

- nesse caso, apenas os dados do primeiro objeto da coleção foram exibidos.

### 2.2.1 Atributo _id












--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)