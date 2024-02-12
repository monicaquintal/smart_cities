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

~~~java
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

~~~java
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

~~~java
// Criando variável com tipo explícito
var faculdade: String

// Criando variável utilizando inferência de tipo
var cidade = "São Paulo"
~~~

- no exemplo abaixo, a inicialização das variáveis com os conteúdos do tipo String resulta no ajuste de tipo por parte do interpretador, garantindo a manutenção do mesmo tipo em todo o código-fonte (type safe):

~~~java
// Usando lowerCamelCase. Cada nova palavra, começa em maiúscula!

var firstName = "Luke"
var lastName = "Skywalker"
println (firstName)
println (lastName)
~~~

### b) Constantes:
- para criação de constantes (objetos que não modificam seu valor ao longo do código, objetos imutáveis), é utilizada a `palavra reservada val`. 
- exemplos por meio das constantes pi e gravity:

~~~java
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

~~~java
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

~~~java
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

~~~java
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














--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)