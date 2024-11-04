<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img align="right" height="120px" src="../assets/logo.png" /></a>
<h1>FASE 7 - Emerging Technologies</h1>
<h2>Capítulo 05: Uma linguagem heroica.</h2>
</div>

<div align="center">
<h2>1. UMA LINGUAGEM HEROICA</h2>
</div>

- a linguagem C, dentro do universo de dispositivos conectados, é largamente utilizada na programação de microcontroladores como o Microchip AVR, que, por sua vez, compõe a plataforma de prototipagem eletrônica de hardware livre conhecida como Arduino Uno. A linguagem C é muito utilizada para programar as estruturas de dados e opera de forma próxima ao hardware.

## 1.1 Construções básicas e tipos de dados

- em termos de estrutura mínima, um programa escrito em linguagem C apresenta a seguinte configuração:

~~~c
#include <stdio.h>
// várias bibliotecas podem ser incluídas 
int main()// função principal
  {
    /* 
     declaração de variáveis 
    */
   
   // comandos da linguagem C
   return 0;
  }
~~~

- o `identificador #include` é uma das chamadas ***diretivas de pré-processamento***. 
  - uma diretiva não é um comando da linguagem C, e sim um “comando” do pré-processador, o qual, antes de compilar o programa, examina o código realizando modificações conforme as diretivas
  - a ação gerada pelo pré-processador a partir da diretiva #include é a inclusão (ou importação) de bibliotecas com funções específicas. 
  - por exemplo, quando forem utilizadas funções de entrada de dados via teclado e de saída de resultados na tela de saída do programa, será preciso incluir o arquivo de biblioteca denominado `stdio.h` (standart input/output), a fim de incluir as definições das funções de entrada e saída ***printf()*** e ***scanf()***, que estão contidas nessa biblioteca do compilador C.
  - o pré-processador faz com que o arquivo stdio.h seja inserido no programa atual.
- todos os arquivos que pertencem à biblioteca da linguagem C têm como extensão “.h”, e conforme os programas apresentados tenham funções de outras bibliotecas, o conhecimento sobre elas aumenta de forma exponencial.
- observe que, após o #include, aparece o nome da biblioteca entre os delimitadores '&lt;' e '&gt;'. Caso outras bibliotecas sejam necessárias,deverão ser incluídas seguindo a mesma regra, com um #include&lt; &gt; em cada linha.
- o código a ser executado é colocado, como indicado, entre chaves, o símbolo que representa é { para inicio e } para final, da `função principal sempre denominada main()`.
- quando um programa é escrito, sempre se tem a recomendação de colocar `comentários` para identificar soluções e observações que possam ajudar a compreender e modificar o código após um longo período sem utilizá-lo; podem ser introduzidos no código de duas formas:
  - usando //, que permite inserir um comentário até o fim da linha.
  - por meio dos delimitadores /* e */, para início e fim de comentário, respectivamente, assim, várias linhas podem ser consideradas como comentários.
- logo no início da função main devem ser declaradas todas as variáveis e, finalmente, é feita a inserção dos comandos a serem executados no programa.

### 1.1.1 Declaração de variáveis e tipos de dados 
- para elaborar a declaração de uma variável, utilizar um `tipo ou identificador`, nomes formados por uma sequência de letras ou dígitos, sendo que o primeiro caractere deve ser uma letra: o caractere “_” é considerado uma letra, e letras maiúsculas e minúsculas são consideradas distintas (case sensitive, ou sensível a maiúscula ou minúscula).
- existe um conjunto de identificadores reservados para a linguagem C (palavras reservadas):

<div align="center">

| Palavras-chave em C (padrão ANSI) |
|------------------------------------|
| auto |
| break |
| case |
| char |
| const |
| continue |
| default |
| do |
| double |
| else |
| enum |
| extern |
| float |
| for |
| goto |
| if |
| int |
| long |
| register |
| return |
| short |
| signed |
| sizeof |
| static |
| struct |
| switch |
| typedef |
| union |
| unsigned |
| void |
| volatile |
| while |

</div>

- quanto aos tipos de dados existentes na linguagem C, os principais que serão utilizados neste momento inicial são (lembrando que 1 byte é equivalente a 8 bits):

<div align="center">

| Tipo | Descrição | Tamanho típico (bytes) |
|---------------|----------------------|-------------------------|
| char | Caractere | 1 |
| int | Inteiro com sinal | 4 ou 8 |
| unsigned int | Inteiro sem sinal | 4 ou 8 |
| long int | Inteiro longo | 8 ou 16 |
| float | Real | 8 |
| double | Real longo | 16 |
| void | Vazio | 0 |

</div>

- exemplo de declaração de variáveis em um programa. 
  - observar que é possível apenas declarar uma variável, e posteriormente atribuir um valora ela, ou, então, atribuir um valor inicial quando ocorre sua respectiva declaração.

~~~c
#include <stdio.h>

int main()
{
  int n;
  float x, pi=3.14;
  unsigned int contador = 0;
  char letra;
  n = -1;
  x = 2.3;
  letra = 'A';
  return 0;
}
~~~

### 1.1.2 Apresentação de resultados do programa
- para poder escrever, ou seja, apresentar resultados na tela de saída,será utilizada a `função printf()`, uma das possibilidades dentro da linguagem. 
  - essa função encontra-se definida na biblioteca &lt;stdio.h&gt;. 
  - é uma função que não apenas apresenta mensagem e valores de variáveis na tela de saída, mas também é capaz de formatar os valores dos dados antes de apresentá-los (número de casas decimais por exemplo).
  - exemplo de sintaxe:

~~~c
printf("expressão de controle", lista de argumentos);
~~~

- a expressão de controle pode ser uma mensagem constante ou um código que determina o formato do argumento (variável) que deve ter seu conteúdo escrito na tela de saída
- códigos de formatação do comando printf:

<div align="center">

| Código | Formato |
|--------|--------------------------------|
| %c | Caractere simples |
| %d | Decimal |
| %e | Notação científica |
| %f | Ponto-flutuante (real) |
| %g | %e ou %f (o mais curto) |
| %o | Octal |
| %s | Cadeia de caracteres |
| %u | Decimal sem sinal |
| %x | Hexadecimal |
| %ld | Decimal longo |
| %lf | Double |

</div>

- além do formato, alguns códigos especiais podem ser utilizados:

<div align="center">

Códigos Especiais | Significado
------------------|-----------------
&#92;n | Nova linha
&#92;t | TAB
&#92;"" | Aspas
&#92;&#92; | Barra
&#92;o | Nulo 

</div>

- no exemplo abaixo, é possível observar como a linguagem utiliza a função printf para a formatação da saída na tela, inicialmente fazendo a declaração das variáveis e o armazenamento de valores de acordo com os seus respectivos tipos.

~~~c
#include <stdio.h>

int main()
{
  int x;
  float y;
  char z;
  x=1;
  y= 2.3;
  z='A';
  printf("o valor de x = %d\n", x);

//formato %d para valor inteiro
  printf("valor de y = %f\n", y);

//formato %f para valor float
  printf("%c\n", z);

//formato %c para valor caractere
  y=8.5421;
  printf("x somado a 1 = %d \n e z = %c\n", x+1,z);
  printf("\n%0.2f\n", y); /* %0.2f formata saída para quantidade de dígitos livre para parte inteira e 2 dígitos para parte fracionária */

  return 0;
}
~~~

- o programa a seguir será utilizado para observar as funções de entrada e saída, assim como para apresentar alguns operadores aritméticos e suas regras de precedência.

~~~c
#include <stdio.h>
int main()
{
	float x,y,z,w; //variáveis x, y, z e w são do tipo real
	int m, n=1; //variáveis m e n são do tipo inteiro 
	x=3.2; 	 // variável x recebe o valor 3.2  
	y=x*2;	 //variável y recebe o valor 6.4
	z=(x+y)/2; // variável z recebe o valor 4.8 
	w= x+y/2; // variável w recebe o valor 6.4 
	m = n/2;	 // variável m recebe o valor 0
	x = n/2; // variável x recebe o valor 0.0
	x = n/2.0; // variável x recebe o valor 0.5
     printf("x=%0.1f \t y=%0.1f \n",x, y);
     printf("z=%0.1f \t w=%0.1f \n", z, w);
     printf("m=%d \t n=%d \n",m, n);
    
     return 0;
}
~~~

> Para que você praticar, utilizar [este endereço](https://www.onlinegdb.com/online_c_compiler) para fazer os testes e visualizar os resultados apresentados, por meio de um compilador on-line.

### 1.1.3 Leitura de valores de dados via teclado
- a `função nativa scanf()` foi implementada para permitir a entrada de dados em um programa escrito na linguagem C. 
  - esse comando encontra-se definido na biblioteca “stdio.h”.
  - sua sintaxe é:

~~~c
scanf(“expressão de controle”, lista de argumentos);
~~~

- assim como no printf, a função scanf() não apenas lê um valor digitado no teclado e o armazena em uma variável do programa, mas também realiza a conversão de tipo em função da especificação do programador(a). 
  - essa especificação deve ser realizada na expressão de controle, por meio de um código que determina o formato do argumento (variável) cujo conteúdo se deseja ter lido no teclado.
  - os códigos de formatação são os mesmos da função printf().
- exemplo simples de uso da função scanf() para ler variável inteira, que pede ao usuário para inserir um valor inteiro, e neste caso é preciso utilizar a tecla ENTER para indicar que o valor foi inserido:

~~~c
#include <stdio.h>
  int main()
  {
    int x;
    printf("digite um valor inteiro: ;");
    scanf("%d", &x);
    printf("o valor de x = %d\n", x);
  
    return 0;
}
~~~

- importante notar que a função scanf exige uma referência à variável que armazena o valor lido do teclado, usando-se para isso o operador &. 
  - exemplo: &x especifica que o valor lido do teclado como número inteiro (formato %d) é armazenado no endereço de memória RAM reservado para guardar a variável x.

> IMPORTANTE: A expressão de controle do scanf deve ter apenas o(s)formato(s) da(s) variável(variáveis) e nenhum caracterea mais, nem espaço em branco, pois isso ocasionará um erro de sintaxe.

- exemplo de uso da função scanf para ler vários tipos de variáveis:

~~~c
#include <stdio.h>
int main()
{
  int n, m;
  float x, y;
  char letra;
  printf("digite um caracter: ");
  scanf("%c",&letra);
  printf("digite 2 valores inteiros: ");
  scanf("%d%d",&n,&m);
  printf("digite 2 valores reais: ");
  scanf("%f",&x);
  scanf("%f",&y);
  printf("n=%d \t m=%d \t x=%0.1f \t y=%0.1f \n",n,m,x,y);
  printf("O caractere lido foi %c \n",letra);

  return 0;
}
~~~

- é importante notar que, no exemplo scanf("%d%d",&n,&m), não há espaço em branco nem qualquer tipo de caractere. 

> DICA: Se de forma inadvertida for escrito qualquer caractere na expressão de controle, você vai notar que a função scanf() não lerá o dado do teclado passando como se não tivesse sido executada.

- para realizar a leitura do teclado e obter caracteres, pode ser usada a `função getchar()`, sendo que o caractere será lido somente quando pressionada a tecla ENTER. Sintaxe:

~~~c
letra = getchar();
~~~

- no Código-fonte a seguir, foi usada a `função fflush(stdin)`, a fim de esvaziar o buffer (memória temporária) direcionado para guardar cada tecla pressionada do teclado (stdin - standard input – entrada padrão). 
  - apenas na leitura de caracteres é necessário executar tal função.
  - caso a chamada da função fflush(stdin) não seja inserida, o programa não fará a leitura do teclado do caractere, sendo assim, você logo perceberá que deve corrigir o código-fonte.

~~~c
#include <stdio.h>
  int main()
  {
    int x;
    char letra;
  
    printf("digite uma letra: ");
    fflush(stdin); //limpa buffer do teclado 
    letra = getchar();
    printf("digite um número inteiro: ");
    scanf("%d",&x);
    fflush(stdin); //limpa buffer do teclado 
    printf("%c",letra);
    printf("%d \n",x);
}
~~~

### 1.1.4 Construções básicas em C
- operadores: aritméticos (+, -, *, / e %), relacionais (como >, <=, ==, !=) e lógicos (como ||, && e !).
- `operadores aritméticos`: usados para calcular expressões matemáticas e se classificam em duas categorias: binários e unários.
  - ***operadores unários***: atuam na inversão de valores, e utilizam os símbolos – e +. 
  - ***operadores binários***: dependem de dois elementos para a operação.

<div align="center">

Operação | Operador
---------|-----------------
Soma | +
Subtração | -
Multiplicação | *
Divisão | /
Módulo (resto) | %

</div>

- `operadores relacionais`: relação de comparação entre os elementos, utilizados ao longo dos códigos para a resolução de problemas.

<div align="center">

| Símbolo | Operador        | Exemplo  | Significado            |
|---------|------------------|----------|------------------------|
| &gt; | Maior que       | x &gt; y    | x é maior que y?       |
| &gt;=      | Maior ou igual  | x &gt;= y   | x é maior ou igual a y?|
| &lt;       | Menor que       | x &lt; y    | x é menor que y?       |
| &lt;=      | Menor ou igual  | x &lt;= y   | x é menor ou igual a y?|
| ==      | Igualdade       | x == y   | x é igual a y?         |
| !=      | Diferente de    | x != y   | x é diferente de y?    |

</div>

> Distinguir (=) de (==): o primeiro é de atribuição (aritmético) e o segundo compara expressões (relacional).

- `operadores lógicos`: servem para interligar mais de uma operação relacional e, do mesmo modo que os relacionais, retornam zero para falso e um para verdadeiro.

<div align="center">

| Operação | Operador |
|----------|----------|
E | &&
OU | &vert;&vert;
NÃO | !

</div>

- `estruturas de controle`: permitem que o programa faça a escolha do que executar, de acordo com uma condição. 
  - a linguagem C oferece comandos para a utilização com dois tipos de estruturas: if...else e switch...case. 

- ***Construção if...else***:

~~~c
if (condição) 
{
  /* conjunto de comandos do se; */
  }
  else
  {
    /*conjunto de comandos do senão;*/
  }
~~~

> IMPORTANTE: Não existem valores do tipo boolean (lógico) TRUE ou FALSE; tais valores lógicos passam a ter um valor do tipo int correspondente à condição, sendo TRUE = 1 e FALSE = 0.

- exemplo de uso da estrutura de controle com if, em que uma operação de soma entre dois números inteiros é efetuada e em seguida é verificado se o valor da soma é maior que o número 10.

~~~c
#include <stdio.h>
  int main(void)
  {
    int N1, N2, Soma;
    printf("Digite um número inteiro: ");
    scanf("%d", &N1);
    
    printf("Digite um número inteiro: ");
    scanf("%d", &N2);
    
    Soma = N1 + N2;
    printf("O Valor da soma = %d\n", Soma);
    
    if(Soma > 10)
    {
      printf("O valor da soma é maior que 10\n");
    }
    else
    {
      printf("Valor menor ou igual a 10\n";
    }
    return 0;
  }
~~~

- ***construção switch...case:***

~~~c
switch (var) {
  case opção1: comandos;
    break;
  case opção2: comandos;
    break;
    ...
  default: comandos;
}
~~~







--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)