<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/kotlin/kotlin-original.svg" width="100px" align="left"/></a>
<h1>FASE 1 - APP WORLD</h1>
<h2>Capítulo 2A: Introdução ao Kotlin.</h2>
</div>

<div align="center">
<h2>1. INTRODUÇÃO AO KOTLIN</h2>
</div>

## 1.1 Apresentação

- linguagem de programação criada em 2011 pela JetBrains, empresa conhecida pelas IDEs (Integrated Development Environment)comercializadas. 
- essa linguagem recebeu o nome de uma ilha russa situada próximo à costa de São Petersburgo, onde a equipe Kotlin reside.
- apenas em 2016 foi lançada a primeira versão estável.
- em 2017, no Google I/O 17, os engenheiros do Google Android anunciaram a Kotlin como a mais nova linguagem oficial da plataforma.

## 1.2 Principais características

- uma característica importante do Kotlin é a ***compatibilidade com o Java***: todas as APIs compatíveis com Java também são compatíveis para Kotlin. 
- outras características:
  - Aplicativos em Kotlin possuem desempenho equivalente a aplicativos desenvolvidos em Java.
  - É possível realizar a declaração de variáveis de forma implícita (sem explicitar o tipo de dado, por exemplo), o que permite a adaptação de desenvolvedores advindos de abordagens funcionais (Python, JavaScript, Swift e similares).
  - A linguagem é considerada type-safe, como o Java, e também null-safe, ou seja, caso necessite que uma variável receba valor nulo (null), terá de definir isso de forma explícita.
  - Utiliza type casts que asseguram o desenvolvedor nas diferentes conversões e comparações entre tipos.

## 1.3 Por que desenvolver para Android com Kotlin?

- dadas as características de uma linguagem multiparadigma, o Kotlin pode ser uma opção para o desenvolvimento dos aplicativos Android.
- traz as vantagens de uma linguagem moderna sem apresentar restrições em relação ao Java.
- características:
  - Compatibilidade: Kotlin é totalmente compatível com a JDK (Java Devlopment Kit), e oferece o suporte legado para versões anteriores do Android.
  - Desempenho: um aplicativo Kotlin pode ser equivalente a um desenvolvido em Java, gerando bytecodes semelhantes. Uma vez que o Kotlin orienta o desenvolvedor a utilizar códigos enxutos, existe a possiblidade da geração de bytecodes otimizados.
  - Curva de aprendizado: favorável a desenvolvedores de outras linguagens de programação. Para desenvolvedores em Java, existem ferramentas para a migração segura de código-fonte para integração com Kotlin.

## 1.4 REPL (Read-Eval-Print Loop)

### 1.4.1 Ambiente de estudos

- para possibilitar o estudo na linguagem de programação Kotlin, é sugerido um ambiente de estudos no formato `REPL (Read-Eval-PrintLoop)` para escrever programas simplese que reforcem o aprendizado de elementos essenciais da linguagem.
- a sugestão é utilizar o [Portal para teste de trechos de código em Kotlin](https://play.kotlinlang.org), para teste dos exemplos e incremento gradativo do aprendizado.

~~~kotlin
/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

fun main() {
  println("Hello, world!!!")
}
~~~

- para executar os exemplos desenvolvidos neste material, devem ser feitas as seguintes observações:
  - na parte superior, podemos selecionar a opção do menu [Examples](https://play.kotlinlang.org/byExample/overview), que contém exemplos que poderão ser utilizados para facilitar o aprendizado da linguagem.
  - a parte central é o local destinado à digitação dos exemplos. Inicialmente, essa digitação é distribuída nas seguintes partes:
    - Nas linhas 1 a 4 foram inseridos comentários, e mantê-los é opcional.
    - Nas linhas 6 e 8, encontra-se a função principal de execução dos blocos de códigos que serão digitados (***fun main***). A assinatura função “main” não deve ser alterada.
    - A linha 7 contém a função println com o texto entre aspas Hello,world. A função println, assim como na linguagem Java, permite gerar a saída do programa em terminal (localizado na parte inferior da figura).
  - no canto superior direito, há uma seta na cor verde em conjunto com a palavra Run. Ao clicar nesse botão, o código-fonte será executado. Em caso de inconsistência no código-fonte, serão fornecidas mensagens para auxiliar na correção.
  - na parte inferior, vemos a debug area em que aparece a mensagem “Hello, world!!!”. Caso nosso código tenha algum erro, é na debug area que encontraremos mais informações sobre esse erro.

## 1.5 Comentários e variáveis

### 1.5.1 Comentários
- usados seja para documentar um trecho de código, seja para lembrá-lo de revisar algo que tenha feito, ou quando se deseja que certo trecho do código-fonte não seja interpretado. 
- em Kotlin, há 2 tipos de comentários: 
  - em única linha, utilizando os `caracteres //`.
  - em múltiplas linhas, iniciando o comentário com /* e finalizamos com */ (`caracteres /* */`).

~~~kotlin
// Comentários em uma linha
  // Quantidade de alunos por sala de aula 
  var sala1 = 20
  var sala2 = 15
  var sala3 = 18
  
  var total = sala1 + sala2 + sala3
  println(total)
  
/*
 * Comentários em bloco.
 * Podemos digitar várias explicações em 
 * um mesmo bloco de comentários
*/

  sala1 = 25
  sala2 = 27
  sala3 = 34
  
  total = sala1 + sala2 + sala3
  println(total)
~~~

### 1.5.2 Variáveis e constantes

### a) Variáveis
- `palavra reservada var`, que indica o início da declaração de um objeto cujo valor pode mudar ao longo do código (objeto mutável ou variável). 
- a declaração da variável pode ser:
  - ***explícita*** (com informação do tipo de dados ou objeto) ou 
  - ***implícita*** (o interpretador definirá a partir do conteúdo a ser inicialmente atribuído). 
- para declarar uma variável explícita, é utilizada a palavra reservada var, seguida do nome da variável, dois-pontos e o seu tipo.
- uma das características da linguagem Kotlin é existência da ***Inferência de Tipo***, ou seja, não é obrigatória a definição do tipo de uma variável, caso ela seja inicializada na declaração. 

~~~kotlin
// Criando variável com tipo explícito
var faculdade: String

// Criando variável utilizando inferência de tipo
var cidade = "São Paulo"
~~~

- no exemplo abaixo, a inicialização das variáveis com os conteúdos do tipo String resulta no ajuste de tipo por parte do interpretador, garantindo a manutenção do mesmo tipo em todo o código-fonte (type safe):

~~~kotlin
// Usando lowerCamelCase. Cada nova palavra, começa em maiúscula!

var firstName = "Luke"
var lastName = "Skywalker"
println (firstName)
println (lastName)
~~~

### b) Constantes:
- para criação de constantes (objetos que não modificam seu valor ao longo do código, objetos imutáveis), é utilizada a `palavra reservada val`. 
- exemplos por meio das constantes pi e gravity:

~~~kotlin
// Criando constantes
val pi = 3.141592
val gravity = 9.81

/* Não é possível alterar o valor de uma constante!
 * Quando se tenta atribuir novo valor à constante gravity,
 * é gerado erro pelo interpretador!
 */

gravity = 10.01 // ERRO
// "Val cannot be reassigned"
~~~

> Sempre procure utilizar constantes em seu código, a menos que realmente precise modificar o objeto futuramente. O acesso às constantes na memória é mais rápido do que o acesso às variáveis!

## 1.6 Tipos

- há tipos predefinidos em Kotlin que são utilizados com frequência, como representações para números inteiros, números com casas decimais, valores booleanos, etc. 

<div align="center">

Tipo | Tamanho em bits
-----|------------------
Long | 64
Int | 32
Short | 16
Byte | 8
Double | 64
Float | 32

</div>

### 1.6.1 Tipos inteiros (Long, Int, Short e Byte)
- quando é necessário representar, em Kotlin, um número que não possui casas decimais, as representações para números inteiros podem ser utilizadas de acordo com a necessidade e as decisões de projeto de software:
  - o `tipo Long` utiliza 64 bits de memória para ser representado, ou seja, pode variar entre -9223372036854775808 e 9223372036854775807.
  - o `tipo Int` utiliza 32 bits de memória e pode variar entre -2.147.483.648 a 2.147.483.647.
  - o `tipo Short` utiliza 16 bits de memória e pode variar entre -32768 a 32767.
  - o `tipo Byte` utiliza 8 bits de memória e pode variar entre -128 a 127.
- o exemplo abaixo apresenta os valores MAX_VALUE e MIN_VALUE, os quais retornam, respectivamente, a faixa de valor máximo e mínimo para cada tipo de dado suportado. Além disso, é apresentado um exemplo da declaração de variável em modo implícito e modo explícito.

~~~kotlin
var value1 = 500 // A inferência é para Int
var value2: Int = 500 //Declaração explícita

// Apresentando o value1
println(value1)
// Apresentando o value2
println(value2) 

//Forma de mostrar o valor máximo aceito pelo tipo
println(Int.MAX_VALUE)
//Forma de mostrar o valor mínimo aceito pelo tipo
println(Int.MIN_VALUE)
~~~

### 1.6.2 Double e Float (números com casas decimais)
- para representar números que possuem casas decimais, o ***Double (que é o tipo inferido automaticamente quando atribuímos um número com casas decimais a uma variável***) e o ***Float*** podem ser utilizados. 
- a **diferença entre Double e Float** é que Double ocupa 64 bits na memória, podendo trabalhar com números maiores, e Float usa 32 bits de memória.

~~~kotlin
// Tipo Double é o tipo padrão para valores numéricos com casas decimais
var balance = 1500.75 // Double inferido automaticamente
var sallary: Double = 1200.50 // Double explícito

// Para usarmos Float, precisamos adicionar a letra F maiúscula ou minúscula no final da informação
var height = 1.82f
var temperature: Float = 35.9F

// Apresentando as informações
println(balance)
println(sallary)
println(height)
println(temperature)
~~~

### 1.6.3 String e Char
- blocos de texto são representados em Kotlin pelo `tipo String`:
  - é definido por um ou mais caracteres entre aspas. 
  - ***é o tipo inferido*** quando se atribui um texto a uma variável. 
- `tipo Char`:
  - quando for necessário ocupar o espaço de apenas um único caractere.
  - porém para atribuir um Char a uma variável, é necessário definir de forma explícita o tipo Char, mesmo que o texto contenha apenas um caractere. 
  - o tipo Char necessita que o caractere esteja entre aspas simples.

~~~kotlin
var module: String = "Introdução ao Kotlin" // String explícita
var schoolName = "FIAP" // String inferida automaticamente

// A var "letter", na linha abaixo, é uma String, dada inferência de tipo
var letter = "A"

// Para usar Char, precisamos definir explicitamente
var gender: Char = 'M'

// Apresentando os valores
println(module)
println(schoolName)
println(letter)

// Para apresentação de valores Char é necessária a conversão para String.
// Utilizar o caracter $ para a saída. 
println("$gender")
~~~

- quando é necessário inserir, em uma String, algum caractere reservado pela linguagem (por exemplo, o caractere de aspas duplas, que define o início/fim de uma String), utilizamos o caractere \, que permite utilizar caracteres reservados, bem como outros conjuntos especiais, como o carriage return (simulando a tecla ENTER), uma tabulação, entre outros. 

~~~kotlin
var text = "Este texto \"quebra\" em \n duas linhas"
/* Resultado:
 * Este texto "quebra" em
 * duas linhas
 */

// O \t gera uma tabulação
var text2 = "Nota:\t 10"
// Resultado: Nota:   10

// Apresentando os valores das variáveis
println(text)
println(text2)
~~~

- em Kotlin, é possível criar Strings utilizando uma técnica chamada `Interpolação de Strings`. É muito comum a atribuição de uma String à combinação de diversas variáveis. 
- por exemplo, supondo que tenhamos uma variável que represente a nota do aluno (studentGrade), o nome (studentName) e o resultado de sua avaliação (aprovado ou reprovado), podemos criar uma variável chamada message, que conterá uma String informando todos os dados dos alunos e a sua avaliação. Exemplo: “O aluno João tirou 8.5 e está aprovado”. 
- para criarmos essa String, é necessário juntar informações de três variáveis e, para isso, utiliza-se a técnica de interpolação, ***colocando, na String principal, as variáveis dentro de parênteses, precedidas pelo caractere $***.

~~~kotlin
val studentGrade = 8.5
val studentName = "João"
val result = "aprovado"
val message = "O aluno $studentName tirou $studentGrade e está $result!"
println(message)

// Resultado:
// O aluno João tirou 8.5 e está aprovado!
~~~

### 1.6.4 Bool (booleanos)
- Booleanos são tipo simples, que ocupam apenas 1 bit de memória e apenas aceitam dois estados, 0 ou 1. 
- em Kotlin, booleanos são definidos pelo tipo Boolean e aceitam true ou false.

~~~kotlin
var isApproved = true
var firstTime: Boolean = false
~~~

### 1.6.5 Pair (par)
- existe, em Kotlin, um tipo muito útil, em determinados casos, para compor pares de dados. 
- um dos casos mais utilizados é quando, por exemplo, precisamos definir que uma função deve retornar mais de um tipo ao mesmo tempo.
- o Pair é um tipo composto formado por dois valores.

~~~kotlin
val (address,number) = Pair("Av. Lins de Vasconcelos", 1264)

println(address)
println(number)
~~~

### 1.6.6 Tipo Nullable (null safety)
- por padrão, variáveis em Kotlin não aceitam o uso de valor nulo; portanto, o desenvolvedor deve realizar as condições de contorno necessárias. 
- o recurso da atribuição de valor nulo a uma variável pode ser utilizado, sendo essa abordagem denominada `null safety` pela comunidade dos programadores.
- o sistema de tipos de Kotlin é avançado o suficiente a ponto de poder monitorar a diferença entre tipos nullable e não nullable.
- a atribuição de valor nulo a uma variável só pode ser realizada quando a sua declaração seguir com o ***sufixo "?"***.

~~~kotlin
// A linha abaixo o código não vai compilar
// mensagem de erro: "Null can not be a value of a non-null type String"
var driverLicense: String = null
  
// A atribuição de null a um var também não será compilada
var driverLicense: String = "6789877"
driverLicense = null // não compila
// "Null can not be a value of a non-null type String"

// Para que uma variável contenha um valor null é necessário
// o uso do sufixo ? no tipo
var driverLicense: String? = null
println(driverLicense)
// Resultado: null

driverLicense = "6789877"
println(driverLicense)
// Resultado: 6789877

driverLicense = null // agora compila
println(driverLicense)
// Resultado: null
~~~

- exemplo de como a verificação de uma variável nullable possui valor nulo:

~~~kotlin
var driverLicense: String? = null
//driverLicense = "6789877"

if (driverLicense != null) {
  println("A carteira de motorista é $driverLicense")
} else {
  println("Esta pessoa não possui carteira de motorista")
}

// Resultado: Esta pessoa não possui carteira de motorista
~~~

## 1.7 Coleções

- as principais coleções em Kotlin são Array, List, Sete Map.

### 1.7.1 Array
- é uma coleção ordenada de elementos de mesmo tipo, ou seja, não é possível misturar tipos dentro de um Array.
- se definimos um Array de Int, todos os elementos dessa coleção devem necessariamente ser Int, não podendo ter um String, Double ou qualquer outro tipo.

~~~kotlin
// Criando um Array de Strings vazio
var emptyArray = arrayOf<String>()

// Criando um Array de Strings e alimentando valores na criação
var shoppingList = arrayOf<String>("Leite", "Pão", "Manteiga", "Açúcar")

// Usando inferência
var inferredShoppingList = arrayOf("Leite", "Pão", "Manteiga", "Açúcar")

// Testando se um Array está vazio
if (shoppingList.isEmpty()) {
  println("A lista de compras está vazia")
} else {
  println("A lista de compras NÃO está vazia")
}
// Resultado: A lista de compras NÃO está vazia

// Recuperando o total de elementos do Array
println("Nossa lista de compras possui ${shoppingList.size} itens")
// Resultado: Nossa lista de compras possui 4 itens
~~~

- o Array possui uma `função isEmpty()`, que é um Bool nos informando se o array está ou não vazio.
- também possui uma propriedade que retorna o total de itens, a `propriedade size`. Essas propriedades estão presentes em todas as coleções usadas em Kotlin.

> Em Kotlin, uma String também é uma coleção de caracteres, ou seja, se quisermos saber o total de letras presentes em uma String, basta utilizarmos a `função count()`.

- para recuperar um elemento de um Array, esse deve ser acessado pelo uso de subscript, ou seja, definindo, entre colchetes, o índice no qual se encontra esse elemento dentro do Array. Ele pode ser usado para modificar um elemento de um Array.

~~~kotlin
// Criando um Array de Strings vazio
var emptyArray = arrayOf<String>()

// Criando um Array de Strings e alimentando valores na criação
var shoppingList = arrayOf<String>("Leite", "Pão", "Manteiga", "Açúcar")

// Usando inferência
var inferredShoppingList = arrayOf("Leite", "Pão", "Manteiga", "Açúcar")

// Testando se um Array está vazio
if (shoppingList.isEmpty()) {
  println("A lista de compras está vazia")
} else {
  println("A lista de compras NÃO está vazia")
}
// Resultado: A lista de compras NÃO está vazia

// Recuperando o total de elementos do Array
println("Nossa lista de compras possui ${shoppingList.size} itens")
// Resultado: Nossa lista de compras possui 4 itens

println("Listando todos os itens:")
println(shoppingList[0]) // Primeiro item do array
println(shoppingList[1]) // Segundo item Acessando itens de um Array do array
println(shoppingList[2]) // Terceiro item do array
println(shoppingList[3]) // Quarto item do array
~~~

### 1.7.2 List
- é uma coleção muito versátil, pois permite elementos repetidos.
- é ideal para quando precisarmos definir um conjunto de itens cujo valor poderá repetir, como a lista dos produtos que estão em um supermercado oua lista de itens em um carrinho de compras, por exemplo. 
- para criar List, é necessário definir o tipo explicitamente, pois a inferência, nesse caso, atribuiria conteúdo a umArray. 
- um List deve ser criado usando a palavra ArrayList seguida do tipo, entre os sinais &lt; e &gt;.

~~~kotlin
// Criando um List de Strings
var movies = ArrayList<String> ()
  movies.addAll(listOf(
  "Matrix",
  "Vingadores",
  "Jurassic Park",
  "De Volta para o Futuro"
  ))

// Criando um list vazio
var movies2 = ArrayList<String> ()

// Inserindo elementos
movies.add("Homem-Aranha: De Volta ao Lar")
println(movies.count()) //5
println("\n")

// Perceba que o código abaixo vai alterar a quantidade
// de itens do List pois ele aceita itens repetidos.
movies.add("Homem-Aranha: De Volta ao Lar")
println(movies) 
// [Matrix, Vingadores, Jurassic Park, De Volta ao Futuro, Homem-Aranha: De Volta ao Lar, Homem-Aranha: De Volta ao Lar]
println(movies.count()) //6 (2 elementos repetidos)
println("\n")

// Removendo 2 elementos repetidos
movies.remove("Homem-Aranha: De Volta ao Lar")
movies.remove("Homem-Aranha: De Volta ao Lar")
println(movies) 
// ["Vingadores", "De Volta para o Futuro", "Matrix", "Jurassic Park"]
println("\n")

// Percorrendo um List
for (movie in movies) {
  println(movie)
}
println("\n")

// Verificando se determinado elemento está contido no List
if (movies.contains("Matrix")) {
  println("Matrix está na minha lista de filmes favoritos!!")
}
println("\n")

// Vamos criar um novo List para realizarmos algumas operações
// No exemplo abaixo, usaremos um formato mais simplificado de criação de List
var myWifeMovies = listOf(
  "De Repente 30",
  "Mensagem para você",
  "Sintonia de Amor",
  "De Volta para o Futuro",
  "Jurassic Park"
)

// Criando um List com todos os filmes
var allMovies = movies + myWifeMovies
println(allMovies)
// [Matrix, Vingadores, Jurassic Park, De Volta para o Futuro, De Repente 30, Mensagem para você, Sintonia de Amor, De Volta para o Futuro, Jurassic Park]
println("\n")
~~~

### 1.7.3 Set
- é uma coleção versátil, pois não permite elementos repetidos.
- é ideal para quando for necessário definir um conjunto de itens cujo valor não pode se repetir, como os alunos que estão em uma turma ou a nossa lista de filmes favoritos, por exemplo. 
- para criar um Set, precisamos definir o tipo explicitamente, pois a inferência, nesse caso, atribuiria conteúdo a um Array por padrão. 
- um Set pode ser criado usando a `palavra HashSet` seguida do tipo, entre os sinais &lt; e &gt;.

~~~kotlin
// Criando um Set de Strings
var movies = HashSet<String> ()
var catalog = listOf(
  "Matrix",
  "Vingadores",
  "Jurassic Park",
  "De Volta para o Futuro"
)
movies.addAll(catalog)
// Perceba que o catálogo de filmes está ordenado alfabeticamente
println(movies) 
// [Jurassic Park, Matrix, De Volta para o Futuro, Vingadores]
println(movies.count()) //4
println("\n")

// Criando um set vazio
var movies2 = HashSet<String> ()
// Inserindo elementos
movies.add("Homem-Aranha: De Volta ao o Lar")
println(movies) 
// [Homem-Aranha: De Volta ao o Lar, Jurassic Park, Matrix, De Volta para o Futuro, Vingadores]
println(movies.count()) //5
println("\n")

// Perceba que o código abaixo NÃO alterará a quantidade
// de itens do Set pois ele NÃO aceita itens repetidos.
movies.add("Homem-Aranha: De Volta ao o Lar")
println(movies)
// [Homem-Aranha: De Volta ao o Lar, Jurassic Park, Matrix, De Volta para o Futuro, Vingadores]
println(movies.count()) //5 (Nenhum elemento repetido. E ainda tudo ordenado )
println("\n")

// Removendo elemento
movies.remove("Homem-Aranha: De Volta ao o Lar")
println(movies)
// ["Vingadores", "De Volta para o Futuro", "Matrix", "Jurassic Park"]
println(movies.count()) //4
println("\n")

// Percorrendo um Set
for (movie in movies) {
  println(movie)
}
println("\n")

// Verificando se determinado elemento está contido no List
if (movies.contains("Matrix")) {
  println("Matrix está na minha lista de filmes favoritos!!")
}
println("\n")

// Vamos criar um novo set para realizarmos algumas operações
// No exemplo abaixo, usaremos um formato mais simplificado de criação de Set
var myWifeMovies = setOf(
  "De Repente 30",
  "Mensagem para você",
  "Sintonia de Amor",
  "De Volta para o Futuro",
  "Jurassic Park"
)

// Criando um Set com todos os filmes. SEM repetição. TUDO ordenado :)
var allMovies = movies + myWifeMovies
println(allMovies) 
// [Jurassic Park, Matrix, De Volta para o Futuro, Vingadores, De Repente 30, Mensagem para você, Sintonia de Amor]
println(allMovies.count()) //7
~~~

### 1.7.4 Map
- é uma coleção organizada em pares &lt;Chave, Valor&gt; ou &lt;Key, Value&gt;. 
- possibilita a inserção de informações que tenham chaves únicas com seus valores (números, datas, textos etc.) relacionados. 
- é muito utilizada quando precisamos realizar pesquisas específicas por meio da chave ou até mesmo pelo valor. 
- para criar um Map, é necessário definir o tipo explicitamente. 
- um Map pode ser criado coma palavra HashMap seguida do tipo, entre os sinais &lt; e &gt;.

~~~kotlin
// Criando um Map de Strings
var movies = HashMap<Int,String> ()
var catalog = mapOf(
  Pair(10,"Matrix"),
  Pair(20,"Vingadores"),
  Pair(30,"Jurassic Park"),
  Pair(40,"De Volta para o Futuro")
)

// Utilize o método putAll para inserir o catálogo
movies.putAll(catalog)

// Perceba que o catálogo de filmes está ordenado alfabeticamente
println(movies) 
// {40=De Volta para o Futuro, 10=Matrix, 20=Vingadores, 30=Jurassic Park}
println(movies.count()) //4
println("\n")

// Criando um set vazio
var movies2 = HashSet<String> ()

// Inserindo 1 elemento
movies.put(25,"Homem-Aranha: De Volta ao Lar")
println(movies) 
// {40=De Volta para o Futuro, 25=Homem-Aranha: De Volta ao Lar, 10=Matrix, 20=Vingadores, 30=Jurassic Park}
println(movies.count()) //5
println("\n")

// O código abaixo irá alterar a quantidade
// de itens do Map pois ele aceita itens da chave NÃO repetidos.
//movies.put(25,"Homem-Aranha: De Volta ao Lar")
//Faça um teste com a linha superior de código e a inferir
movies.put(35,"Homem-Aranha: De Volta ao Lar")
println(movies) 
// {40=De Volta para o Futuro, 25=Homem-Aranha: De Volta ao Lar, 10=Matrix, 35=Homem-Aranha: De Volta ao Lar, 20=Vingadores, 30=Jurassic Park}
println(movies.count()) //6
println("\n")

// Removendo elemento
movies.remove(25)
println(movies) 
// {40=De Volta para o Futuro, 10=Matrix, 35=Homem-Aranha: De Volta ao Lar, 20=Vingadores, 30=Jurassic Park}
println(movies.count()) //5
println("\n")

// Pecorrendo um Map
for (movie in movies) {
  println(movie)
}
println("\n")

// Verificando se determinado elemento está contido no List
if (movies.containsValue("Matrix")) {
  println("Matrix está na minha lista de filmes favoritos!!")
}
println("\n")

// Vamos criar um novo map para realizarmos algumas operações
// No exemplo abaixo, usaremos um formato mais simplificado de criação de Map
var myWifeMovies = mapOf(
  Pair(100,"De Repente 30"),
  Pair(200,"Mensagem para você"),
  Pair(300,"Sintonia de Amor"),
  Pair(400,"De Volta para o Futuro"),
  Pair(500,"Jurassic Park")
)

// Criando um Map com todos os filmes
var allMovies = movies + myWifeMovies
println(allMovies) 
// {40=De Volta para o Futuro, 10=Matrix, 35=Homem-Aranha: De Volta ao Lar, 20=Vingadores, 30=Jurassic Park, 100=De Repente 30, 200=Mensagem para você, 300=Sintonia de Amor, 400=De Volta para o Futuro, 500=Jurassic Park}
println(allMovies.count()) //10
println("\n")

// Lendo Chave e Valor separadamente
for(movie in allMovies) {
  println("Chave => Key => ${movie.key}")
  println("Valor => Value => ${movie.value}")
  var title = movie.value.toUpperCase()
  println("UpperCase => ${title}")
  title = movie.value.toLowerCase()
  println("LowerCase => ${title}")
  println("\n")
} 

// Executando uma pesquisa diretamente na chave do Map
var film1 = allMovies.get(400) //400=De Volta para o Futuro
println("Title => ${film1}") // Retorna String. Retorna o Título
var film2 = allMovies.get(999) //Não existe
println("Title => ${film2}") // Retorna null

// Verificando a possibilidade de testar antes de imprimir
var code = 1234 // Experimente trocar o código
var film3 = allMovies.get(code) //Não existe
if(film3.isNullOrEmpty()) {
  println("\nFilme com o código $code não encontrado!")
} else {
  println("\nTitle => ${film3}") // Retorna o título
}
~~~

## 1.8 Operadores

- a maioria dos operadores existentes nas diversas linguagens de programação também está disponível em Kotlin, atuandoda mesma forma:
  - operadores unários (que atuam apenas em um operando), 
  - operadores binários(atuam em dois operandos) e 
  - operadores ternários(atua em três operandos).

### 1.8.1 Atribuição (=)
- o sinal = serve para atribuir um valor a uma variável.

~~~kotlin
var height: Double = 1.75
~~~




--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)