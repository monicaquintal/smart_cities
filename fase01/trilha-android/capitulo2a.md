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

### 1.8.2 Aritméticos (+, -, *, /, %)
- são utilizados para a realização de operações aritméticas: soma, subtração, mudança de sinal, módulo etc.

~~~kotlin
var a = 12
var b = 3

var sum = a + b 
var subtract = a - b 
var multiplication = a * b 
var division = a / b 
var módulus = a % b 
var minusA = -a 

println(sum) // 15
println(subtract) // 9
println(multiplication) // 36
println(division) // 4
println(módulus) // Resto da divisão: 0
println(minusA) // -12
~~~

### 1.8.3 Compostos (+=, -=, *=, /=, %=, ++, --)
- são junções dos operadores aritméticos com o operador de atribuição.
- efetuam a operação e atribuem o valor na variável ao mesmo tempo.

~~~kotlin
var a = 2
var b = 3
var newValue = 5

newValue += a // 7
newValue -= b // 4
newValue *= a // 8
newValue /= a // 4
newValue %= b // Resto da divisão: 1

newValue++ // incrementando 1
println(newValue) 

newValue-- // decrementando 1
println(newValue)
~~~

### 1.8.4 Operadores lógicos (&&, ||, !)
- executam operações lógicas, ou seja, sempre retornam verdadeiro ou falso.

~~~kotlin
var yes = true
var no = false

println(yes && no) //false
println(yes || no) //true
println(!yes) //false
~~~

### 1.8.5 Operadores de comparação (>, <, >=, <=, ==, !=)
- utilizados quando se pretende comparar valores e possuir retorno de verdadeiro ou falso.

~~~kotlin
var a = 12
var b = 3
var c = 7
var d = 3

println(a > b) // true
println(a < b) // false
println(b >= d) // true
println(a <= c) // false
println(b == d) // true
println(b != d) // false
~~~

### 1.8.6 Estrutura de decisão em mesma linha
- operador ternário. 
- com essa sintaxe, é possível avaliar uma condição e atribuir um valor,caso a condição seja verdadeira, e outro valor, caso seja falsa.

~~~kotlin
var grade = 7.5
var result = if (grade > 7.0) "aprovado" else "reprovado"
println(result) // aprovado
~~~

### 1.8.7 Coalescência nula (?:)
- em Kotlin, o operador "?:" permite decidir pelo uso de uma atribuição de redundância, caso a variável analisada seja nula.

~~~kotlin
var age: Int? = null
var myAge = age ?: 0 // 0
println(myAge)

age = 25
var newAge = age ?: 0 // 25
println(newAge)
~~~

### 1.8.8 Closed Range (..) e Half Closed Range (until)
- estes operadores criamum intervalo de valores. 
  - `Closed Range` utiliza (..) para criar um intervalo aberto, indicando o valor inicial e o valor final. 
  - `Half Closed Range` utiliza a palavra reservada (until) para criar um intervalo entre o valor inicial e o valor imediatamente anterior ao valor final (intervalo aberto no início e fechado ao final). 

~~~kotlin
println("\nClosed Range ..")
var numbers = 1..10
for (number in numbers) {
  println(number) // Imprime de 1 a 10
}

println("\nHalf Closed Range (until)")
var newNumbers = (1 until 10)
for (number in newNumbers) {
  println(number) // Imprime de 1 a 9
}
~~~

## 1.9 Estruturas condicionais e de repetição

- toda linguagem precisa de uma estrutura na qual se pode tomar uma decisão e agir de acordo com ela, ou seja, definir o fluxo do código com base no resultado de uma análise. 
- em Kotlin, a mais utilizadas é a `estrutura if else`. 
- outro recurso existente em toda a linguagem é a possibilidade de executarmos o mesmo trecho de código o número de vezes que for necessário, seja controlado por um intervalo específico ou até que uma condição seja alcançada.

### 1.9.1 If – else – else if
- para uma tomada de decisão, caso certa condição seja verdadeira, e outra, caso seja falsa, faz-se uso da estrutura if – else – else if.

~~~kotlin
var number = 11
if (number % 2 == 0) {
  println("Ele é par")
} else {
  println("Ele é ímpar")
}
// Resultado: "Ele é ímpar"

var temperature = 18
var climate = ""
if (temperature <= 0) {
  climate = "Muito frio"
} else if (temperature < 14) {
  climate = "Frio"
} else if (temperature < 21) {
  climate = "Clima agradável"
} else if (temperature < 30) {
  climate = "Um pouco quente"
} else {
  climate = "Muuuito quente"
}
println("Temperatura: $temperature graus \nStatus: $climate")
// Resultado:
// Temperatura: 18 graus 
// Status: Clima agradável
~~~

### 1.9.2 When
- em situações em que precisamos fazer uso de vários else if, a estrutura `when` é mais adequada, pois foi criada especificamente para validar uma série de cenários possíveis para uma variável.
- a palavra reservada when tem correlação com a palavra switch utilizada em outras linguagens de programação.
- em Kotlin, o when precisa ser exaurido, ou seja, deve contemplar todos os possíveis cenários para aquela variável que está sendo validada. 
  - porém, em situações nas quais o cenário é amplo, faz-se o uso da cláusula else (default em outras linguagens), que é o cenário escolhido quando nenhum dos outros é verdadeiro!

~~~kotlin
var number = 7
when (number % 2) {
  0 -> 
  println("$number é par")
  else -> 
  println("$number é ímpar")
}

// Exemplo com vários cenários no mesmo case
var letter = "z"
when (letter) {
  "a", "e", "i", "o", "u" ->
  println("vogal")
  else ->
  println("consoante")
}

// Exemplo com range de letras
when (letter) {
  in "a".."f" ->
  println("Você está na turma 1")
  in "g".."l" ->
  println("Você está na turma 2")
  in "m".."r" ->
  println("Você está na turma 3")
  else ->
  println("Você está na turma 4")
}

// Range de números
var speed = 33
when (speed) {
  in 0 until 20 ->
  println("Primeira marcha")
  in 20 until 40 ->
  println("Segunda marcha")
  in 40 until 50 ->
  println("Terceira marcha")
  in 50 until 90 ->
  println("Quarta marcha")
  else ->
  println("Quinta marcha")
}
~~~

### 1.9.3 While / do while
- essa estrutura de repetição é utilizada quando se deseja que certo trecho de código seja executado enquanto (`while`) uma condição seja verdadeira, ou seja, o laço será encerradono momento que a condição for falsa.
- a estrutura `do while` é semelhante, porém sempre executa o código uma vez antes de validar a condição.

~~~kotlin
// while
var life = 10
while (life > 0) {
  println("O jogador está com $life vidas")
  life = life - 1
}

println("\n")
 
// do while
var tries = 0
var diceNumber = 0
do {
  tries += 1 
  diceNumber = ((Math.random() * 6) + 1).toInt()
  println("Tentativa:$tries <-> Número Randomizado: $diceNumber")
} while (diceNumber != 6)
println("\nVocê tirou 6 após $tries tentativas")
~~~

### 1.9.4 For in
- é a estrutura de repetição mais utilizada em Kotlin.
- permite iterar (percorrer) uma coleção e recuperar todos os seus valores, o que é ideal quando necessitamos percorrer um array ou uma coleção, por exemplo. 

~~~kotlin
// Percorrendo um Array
var students = arrayOf(
  "João Francisco",
  "Pedro Henrique",
  "Gustavo Oliveira",
  "Janaina Santos",
  "Francisco José"
) 
for (student in students) {
  println("O aluno $student veio na aula de hoje!")
}

// Percorrendo uma sequência (range)
for (day in 1..30) {
  println("Estou no dia $day")
}

// Note abaixo que uma String também é uma coleção
var name = "FIAP"
for (letter in name) {
  println(letter)
}

// Vejamos como percorrer uma coleção,
// imprimindo sua chave e valor. Nesta coleção
// a chave é String e o valor é Int
var people = mapOf(
  (25 to "Paulo"),
  (18 to "Renata"),
  (33 to "Kleber"),
  (51 to "Roberto"),
  (36 to "Carol")
)
// A variável person, abaixo, recebe a chave
// (key) e o valor (value) de cada elemento da coleção
for (person in people) {
  println(" ${person.key} => ${person.value}")
}
// Podemos quebrar a execução de um laço usando
// o comando break
var grades = arrayOf(10.0, 9.0, 8.5, 7.0, 9.5, 5.0, 22.0, 6.5, 10.0)
for (grade in grades) {
  println(grade)
  if (grade < 0.0 || grade > 10.0) {
    println("Nota inválida")
    break
  }
}
~~~

## 1.10 Enumeradores

- enumeradores (ou enum) são tipos criados pelo usuário.
- servem para definir um tipo comum para um conjunto fechado de valores.
- são utilizados para cenários os quais devem armazenar uma informação baseada em um conjunto limitado de possibilidades.
- `palavra reservada enum` em conjunto com a palavra class, seguida do nome do enumerados (com inicial maiúscula) e, entre chaves, definimos todos os valores possíveis.
- Enums são muito utilizados com When, pois geralmente precisamos verificar qual valor ele possui, para tomarmos uma decisão.
- no exemplo abaixo, é criado um enum que serve para definir uma bússola, com quatro possíveis valores (norte, sul, leste e oeste).

~~~kotlin
//Definindo um enum fora da função main
enum class Compass {
  north,
  east,
  west,
  south
}
fun main(args: Array<String>) {
  // Criando uma variável do tipo Compass
  var direction = Compass.north
  // Como Kotlin trabalha com inferência de tipo, podemos usar
  // somente .valor, caso o tipo seja definido explicitamente
  var direction2: Compass = Compass.south
  println("Minha direção é $direction")
  // Minha direção é north

  // Enums são muito usados com switch para análise do valor
  when (direction) {
    Compass.north -> 
      println("Estamos indo para o norte")
    Compass.south ->
      println("Estamos indo para o sul")
    Compass.east ->
      println("Estamos indo para o leste")
    Compass.west ->
      println("Estamos indo para o oeste")
  }
  // Estamos indo para o norte

// Outra forma de apresentar informações de um Enum
  Compass.values().forEach {
    println(it)
  }
}
~~~

### 1.10.1 Valores padrões
- em Kotlin, é possível definir o tipo de um enum e, além disso, atribuir um valor padrão a cada um dos casos.

~~~kotlin
// Enum que define as posições das poltronas em um avião
// Veja que é possível atribuir um valor padrão a cada uma delas
enum class SeatPosition(var seat: String) {
  aisle("corredor"),
  middle("meio"),
  window("janela")
}

// Enum de Int com valores padrões
enum class Month(var m: Int) {
  january(1), february(2), march(3), april(4), may(5), june(6), 
  july(7), august(8), september(9), october(10), november(11), december(12)
}

fun main(args: Array<String>) {
	var passengerSeat = SeatPosition.window
	// Para imprimir o valor padrão, usamos o nome utilizado na construção do enum. Veja:
	println(passengerSeat.seat) // janela
	var currentMonth: Month = Month.june
	println("Estamos no mês ${currentMonth.m} do ano")
}
~~~

<div align="center">
<h2>2. FUNÇÕES E CLOSURES</h2>
</div>

## 2.1 Funções

- muitas vezes, ao longo do desenvolvimento de um app, nos deparamos com trechos de funcionalidades que precisam ser reutilizados ao longo do código. 
- esses blocos de código podem ser criados por meio do uso de funções, que são trechos de comandos que executam operações definidas, podem receber valores (parâmetros) para trabalhar e podem retornar um resultado.

## 2.2 Criando funções

~~~kotlin
// Sintaxe para criação de funções:
fun main(args: Array<String>) {
/*
  fun nomeDaFuncao(parâmetro: Tipo) : TipoDeRetorno {
    // Código
    return TipoDeRetorno
  }
*/

// Exemplo de uma função simples que não recebe
// parâmetros e não retorna nada
fun printlnHelloFormal() {
  println("Hello!!!!")
}
printlnHelloFormal() // Hello!!!

fun printlnHelloModoReduzido() = println("Hello!!!! Modo reduzido!")
printlnHelloModoReduzido() // Hello!!!

// Função que aceita parâmetro
fun say(message: String) {
  println(message)
}
say("Vamos criar funções em Kotlin")

// Função que aceita mais de um parâmetro e que retorna algo
fun sumNumbers(a: Int, b: Int) : Int {
  return a + b
}
var result = sumNumbers(10,15)
println(result) // 15
}
~~~

- exemplo de função para calcular os 10 primeiros números da sequência de Fibonacci:

~~~kotlin
fun main(args: Array<String>) {

  // Função
  fun sequenciaFibonacci() {

    // Declaração de variáveis
    var number1 = 0
    var number2 = 1

    // Loop controlado de 1 até 10
    for (sequence in 1..10) {

      // Impressão do conteúdo da variável number1
      println("$sequence -> $number1")

      // Soma dos 2 valores das variáveis
      var sum = number1 + number2

      // Troca os valores entre as variáveis
      number1 = number2
      number2 = sum
    }
  }

  // Executar a função
  sequenciaFibonacci()
}
~~~

## 2.3 Single-Expression functions

- é possível desenvolver, na linguagem Kotlin, funções que encapsulam outras funções.

~~~kotlin
fun main(args: Array<String>) {
  fun double(x: Int): Int = x * 2
  println(double(8))
  fun triple(x: Int) = x * 3
  println(triple(10)) 
}
~~~

## 2.4 Map, Filter e Reduce

- muitas vezes, é necessário efetuar operações em Arrays ou Coleções em que é preciso percorrer a coleção para extrair determinados elementos ou modificá-los. 
- além do for in, existem vários métodos que utilizam closures para esses fins.

~~~kotlin
fun main(args: Array<String>) {
  
  // elaborando um coleção do tipo List com números entre 1 a 10
  val numbers = listOf(1,2,3,4,5,6,7,8,9,10)
  println(numbers)

  // "Filtrando" (filter) somente os números pares da coleção numbers
  // a variável temporária chamada "it" utilizada na operação
  var evenNumbers = numbers.filter { it%2 == 0 }
  println("Listagem de números Pares: $evenNumbers")

  // "Filtrando" (filter) somente os números ímpares da coleção numbers
  // a variável temporária chamada "it" utilizada na operação
  var oddNumbers = numbers.filter { it%2 != 0 }
  println("Listagem de números Ímpares: $oddNumbers")

  // A utilização do Map executa o processamento individual
  // de cada elemento dentro da coleção.
  var multiplyNumbers = numbers.map { it * it }
  println("Multiplicação: $multiplyNumbers")

  // Executa o processamento da coleção de acordo
  // com os parâmetros enviados.
  var sumNumbers = numbers.reduce {
    // Captura o valor anterior ou atual (acc) e o valor atual(it)
    acc, it ->
    // Apresenta as informações
    println("acc = $acc, it = $it")
    // Executa o processamento das informações
    acc + it }

  println("Resultado da Somatório: $sumNumbers") // Total 1+2+3+4+5+6+7+8+9+10=55

}
~~~

- o map é um método presente em coleções que percorre a coleção e executa uma closure em cada um de seus elementos, devolvendo a nova coleção gerada.

~~~kotlin
fun main(args: Array<String>) {

  var names = arrayOf("João", "Paulo", "Henrique", "Ana", "Beatriz", "Carla", "Caroline")

  // Aplicando map em names
  var uppercasedNames = names.map({it.toUpperCase()})
  println(uppercasedNames)
  
  // ["JOÃO", "PAULO", "HENRIQUE", "ANA", "BEATRIZ", "CARLA", "CAROLINE"]

}
~~~

- foi criada uma closure que retorna a versão em maiúsculas (usando o ***método de String toUpperCase()***) dos nomes. 
- o "it", nesse caso, refere-seao parâmetro da closure que representa cada um dos nomes da coleção.

- no próximo exemplo, o desejo é filtrar a coleção e gerar um novo Array contendo apenas os nomes compostos por cinco letras ou menos, ou seja, agora será criado um novo Array contendo parte dos elementos do Array principal. 
- quando existem casos como esse, deve ser utilizado o método filter,que filtra uma coleção, devolvendo outra com os elementos que foram filtrados.

~~~kotlin
// Aplicando filter em names
var filteredNames = names.filter({it.length < 6})
println(filteredNames)
// ["João", "Paulo", "Ana", "Carla"]
~~~

- o método filter solicita que seja passada a função que servirá para filtrar os elementos. 
- essa função deve conter a lógica que será implementada em cada um dos elementos do Array e, caso essa lógica retorne true, aquele elemento deverá fazer parte do novo Array. 
- nesse exemplo, foi criada uma closure que verifica se a contagem de caracteres de cada nome é menor que seis, ou seja, se possui cincoou menos letras.

- no último exemplo, será criado um Array de Double que representa algumas movimentações realizadas em uma conta-corrente (entrada e saída de valores, sendo que valores positivos representam entrada, enquanto negativos indicam saída). 
- existe um método em Kotlin que está presente em todas as coleções e que serve para combinar todos os valores presentes naquela coleção, segundo uma lógica estipulada por nós. 
- nesse exemplo, a combinação deverá ser feita por meio da soma de todos esses valores, porém é permitido implementar a lógica que desejar.
- vale ressaltar que, apesar de o exemplo utilizar o Double, é possível utilizar Arrays de qualquer tipo, alterando a lógica. 
- esse método é o `reduce`.

~~~kotlin
fun main(args: Array<String>) {

  // Utilizando Reduce
  var transactions = arrayOf<Double>
  (500.0, -45.0, -70.0, -25.80, -321.72, 190.0, -35.15, -100.0)

  var balance = transactions.reduce {

    acc,it -> println("Saldo: " + String.format("%.2f", acc) + 
                      " => Próximo Lançamento: " + String.format("%.2f", it))
    (acc + it)
  }

  println("Seu saldo é R$ " + String.format("%.2f", balance))
  // Seu saldo é R$ 92,33

}
~~~

- o método reduce recebe dois parâmetros:
  - acc: contém o valor inicial da operação.
  - it: contém uma closure que receberá, a cada iteração, o resultado da operação e o elemento do Array. 
- nesse exemplo, é definido que o valor inicial seria 0 e que, a cada iteração, o valor será somado com o elemento do Array, ou seja, na primeira iteração, teremos 0.0 + 500.0, na segunda, 500.0 + -45.0, na terceira, 455.0 + -70.0, e assim sucessivamente, até chegar ao último elemento do Array.

## 2.5 Generics












--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)