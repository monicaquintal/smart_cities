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

#### 1.1.4.1 `Operadores aritméticos`: 
- usados para calcular expressões matemáticas e se classificam em duas categorias: binários e unários.
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

#### 1.1.4.2 `Operadores relacionais`: 
- relação de comparação entre os elementos, utilizados ao longo dos códigos para a resolução de problemas.

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

#### 1.1.4.3 `Operadores lógicos`: 
- servem para interligar mais de uma operação relacional e, do mesmo modo que os relacionais, retornam zero para falso e um para verdadeiro.

<div align="center">

| Operação | Operador |
|----------|----------|
E | &&
OU | &vert;&vert;
NÃO | !

</div>

#### 1.1.4.4 `Estruturas de controle`: 
- permitem que o programa faça a escolha do que executar, de acordo com uma condição. 
- a linguagem C oferece comandos para a utilização com dois tipos de estruturas: if...else e switch...case. 

##### a) ***Construção if...else***:

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

##### b) ***Construção switch...case:***

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

- a utilização da estrutura de controle com o switch...case passa a ser uma opção interessante para testar um determinado resultado de uma expressão ou valor atual de uma variável. 
- exemplo de uso da estrutura de controle com switch...case, onde é possível ver a aplicação testando o valor da variável resp, que teve uma atribuição manual do valor 3, e quando é verdadeira a verificação, não será preciso testar as demais opções, pois o comando break executa a saída do bloco.

~~~c
#include<stdio.h>
  int main() {
   
    int resp;
    printf("Digite um numero inteiro entre 1 e 3: \n")
    scanf("%d",&resp = 3;);
   
    switch (resp)
    {
      case 1:
        printf("Voce selecionou a opcao %d \n", resp);
      break;
    
      case 2:
        printf("Voce selecionou a opcao %d \n", resp);
      break;
      case 3:
        printf("Voce selecionou a opcao %d \n", resp);
      break;
      
      default:
        printf("Voce selecionou uma opcao diferente de 1, 2 ou 3 --> %d \n", resp);
      }
    return 0;
  }
~~~

#### 1.1.4.5 `Estruturas de repetição
- quando houver a necessidade de repetição dentro do programa, existem estruturas especiais para que seja possível implementar na linguagem C, chamadas `estruturas de repetição`.
  - elas permitem que um bloco de instruções seja executado, repetidamente, uma quantidade controlada de vezes. 
  - há três estruturas de repetição: do...while, while e for.

##### a) ***Construção do...while***: é uma estrutura básica de repetição condicional; permite a execução de um bloco de instruções repetidamente, sendo que o critério de parada é testado após a entrada no laço:

~~~c
do
{
  /* comandos executados enquanto condição verdadeira */
  } while(condição)
~~~

- exemplo de uso do comando de repetição do...while, apresentando como resultado a somatória de números somente após o usuário digitar o número 0:

~~~c
#include <stdio.h>
int main()
{
    double number, soma = 0;

    do
    {
        printf("Insira um número: ");
        scanf("%lf", &number);
        soma += number;
    }
    while(number != 0.0);

    printf("Soma = %.2lf",soma);

    return 0;
}
~~~

##### b) ***Construção while***:
- faz com que a condição seja avaliada em primeiro lugar. 
  - se a condição for verdadeira, o bloco é executado uma vez e a condição é avaliada novamente. 
  - caso a condição seja falsa,a repetição é terminada sem a execução do bloco. 
- nessa estrutura, ao contrário da estrutura do...while, o bloco de instruções pode não ser executado nenhuma vez, basta que a condição seja inicialmente falsa.

~~~c
while (condição) 
  {
    /*comandos executados enquanto condição verdadeira*/
  }
~~~

- exemplo de uso do comando de repetição com while; situação em que ocorre o incremento de uma unidade do número 10, até que tenha o valor 19, última iteração do laço, pois o critério de parada é estipulado para valores inteiros menores do que 20.

~~~c
#include <stdio.h>
 
int main () {

   int num = 10;

   while( num < 20 ) {
      printf("Valor atual número: %d\n", num);
      num++;
   }
 
   return 0;
}
~~~

##### c) ***Construção for***:
- muito semelhante às estruturas de repetição vistas anteriormente, entretanto, costuma ser utilizada quando se quer um número determinado de ciclos.
- a contagem dos ciclos é feita por uma variável chamada de contador. 
- a estrutura for é, às vezes, chamada de estrutura de repetição com contador. 
- sintaxe:

~~~c
for(comando de inicialização;teste lógico; comando 3)
{
  /*comandos a serem repetidos*/
}
~~~

- uma forma simples de contagem de números pode ser feita com o comando for, conforme exemplo, que efetua a contagem dos números de 1 até 10.

~~~c
#include <stdio.h>

  int main(void)
  {
    int contador; //variável de controle do loop
    
    for(contador = 1; contador <= 10; contador++)
    {
      printf("%d ", contador);
    }
    printf(“\nFim da contagem...\n”);
    
    return 0;
  } 
~~~

## 1.2 Tipos de dados compostos
- quando o armazenamento ou a atribuição de valores às variáveis se torna mais complexo, faz-se a recursão à utilização de tipos de dados que agregam mais valores. 
- todo tipo de dado que agrega mais de um valor se trata de uma estrutura de dados. 
- na linguagem C, são utilizados dois tipos de dados compostos: os que agregam elementos do mesmo tipo (`vetor` e `matrizes`) e os que são compostos de dados de tipos diferentes (`structs`).

### 1.2.1 Vetores e matrizes
- como vetores (e matrizes) podem conter apenas valores do mesmo tipo,são conhecidos também como estruturas de dados homogêneas. 
- para declarar uma variável do tipo vetor em C:

~~~
<Tipo de dado do elemento> nome_identificador [número de elementos];
~~~

- exemplos de declaração:

~~~c
int x[5]; 
float valores[7];
~~~

- em C, os elementos de um vetor sempre são numerados por índices de 0 até número de elementos –1.
- para que se tenha acesso a um determinado elemento, é necessário especificar a variável do tipo vetor e, entre colchetes, determinar qual é o índice do elemento, por exemplo, x[2], valores[0] etc.
- para realizar a leitura e a escrita de um vetor inteiro,deve-se escolher elemento a elemento, por isso normalmente é usada uma repetição,como no exemplo abaixo.

> IMPORTANTE: Constantes são usadas para armazenar valores que NÃO podem ser modificados durante a execução de um programa. Uma constante precisa ser declarada e, para tanto, usa-se a diretiva de pré-processador #define.

~~~c
#include <stdio.h>
  #define N 5
  
  int main()
  {
    int idade[N], I, cont=0;
    for (i=0; i<N; i++ ) {
      printf"digite a idade:");
      scanf"%", &idade[i]);
      if (idade[i] >= 18) 
      cont++;
     }
    printf"número de pessoas com idade acima 18 anos = %d", cont);
  
    return 0;
  }
~~~

- no programa, é apresentado mais um novo componente de um programa em C, a `diretiva #define`.
  - uma diretiva é executada pelo pré-processador.
  - nesse caso, a ação gerada será a definição da constante N (C diferencia maiúsculas de minúsculas), que terá o valor 5 atribuído a ela. 
  - quando o programa for compilado, onde houver a constante N, ela será trocada pelo valor 5.
  - a vantagem de usar a definição de constante é que, se for necessário trocar o tamanho do vetor de 5 para 10, basta alterar o valor da constante, e em todo o programa em que N é usado, o novo valor será utilizado.
- a estrutura de repetição foi usada para gerar índices que vão de 0 até 4; com isso, em cada repetição a variável i usada pelo for terá o valor do índice.

> Cuidado: Programas em C não avisam quando o limite do dimensionamento de um vetor foi excedido e pode gerar resultados errados.

### 1.2.2 String: vetor de caracteres
- não existe o tipo básico de dado "string" como existe em algumas linguagens. 
- uma string na linguagem C é um vetor de caracteres (elementos do tipo char). 
- esse vetor de caracteres tem tratamento diferenciado:
  - o final da string armazenada no vetor é marcado com o caractere nulo '\0' (barra zero).
  - existem funções especiais para tratar esse tipo de dado. 
- a variável que será uma string em C pode ser declarada como:

~~~c
char nome[10];
~~~

- nessa declaração, nome é a variável do tipo vetor de caracteres (string), que poderá conter 10 caracteres, embora um deles sempre conterá o caractere ‘\0’ (o último).
- para realizar a leitura e a escrita de uma string, podem ser usadas as seguintes abordagens:
  - Usando funções básicas da biblioteca stdio.h.
  - scanf("%s",nome).
  - printf("%s", nome).
  - fgets(nome, buf,stdin).
  - Usando funções especiais da biblioteca string.h.
  - puts(nome).
- exemplo:

~~~c
#include <stdio.h>

  #define MAX 32
  
  int main() 
  {
    char buf[MAX];
    char f;
  
    printf("Digite o nome completo: "); 
    fgets(buf, MAX, stdin);
  
    printf("\n O nome completo: %s\n", buf);
  
    return 0;
  } 
~~~

- ***função scanf()***: quando lê a informação digitada no teclado, ignora o sobrenome, pois essa função considera o espaço em branco uma forma de finalizar uma string.
- ***função fgets()*** não segue essa mesma lógica, e consegue ler o nome completo digitado.

> IMPORTANTE: A função scanf() considera que o espaço em branco finaliza uma string.

- há outras funções especiais para manipular strings na biblioteca &lt;string.h&gt;.
- exemplo de uso de funções básicas para a manipulação de string:

~~~c
#include <stdio.h>
  #include <string.h>
  
  int main() 
  {
  char nome[30]={0}, todos[200]={0}, copia[30]={0};
  strcpy(nome,"- ");
  while (strcmp(nome,"fim") !=0){
    strcat (todos,nome);
       //concatena a variável nome à variável todos 
       strcpy(copia,nome); 
       //copia o conteúdo da variável nome 'a copia
    printf("\n todos = %s ",todos);
    printf("\n copia = %s ",copia);
    printf("\n digite um nome ou fim para encerrar:");
       fflush(stdin);
    scanf(“%s”,nome);
    }
  printf("\n todos = %s",todos);
  printf("\n comprimento de todos = %d", strlen(todos));
  printf("\n copia = %s",copia);
  printf("\n comprimento de copia = %d\n", strlen(copia));
  
  return 0;
  }
~~~

- `vetor de string`: aplicação mais comum, onde uma variável pode armazenar um conjunto de palavras, como os nomes dos alunos de uma sala de aula. 
  - um vetor de string é um vetor que armazena string de 30 caracteres como elemento de um vetor. 
- exemplo: supondo uma sala com apenas 4 alunos, deve ser usada a variável nome. O programa exemplo mostra como declarar e usar a variável nome apresentada:

~~~c
#include <stdio.h>
  #include <string.h>
  
  #define 	N_ALUNOS  	4
  #define 	N_CARACTERES 	30
  
  int  main() 
  {
      char nome[N_ALUNOS][N_CARACTERES];
      int i;
      for (i=0; i<N_ALUNOS ; i++){
          printf("digite o nome do aluno: ");
        
          fflush(stdin);
          fgets(nome[i], N_CARACTERES,stdin);
      }
      for (i=0; i<N_ALUNOS; i++){
          Printf("Aluno %d: %s",i+1,nome[0]);
      }
  
      return 0;
  }
~~~

### 1.2.3 Registros: estruturas de dados heterogêneas (struct)
- uma estrutura de dados é um conjunto de uma ou mais variáveis, possivelmente de tipos diferentes, colocadas juntas com um único nome. Em algoritmos, esse tipo de variável é chamado de registro. 
- cada informação contida em uma estrutura é denominada de campo ou membro. 
- por ser composto de informações que podem ser de vários tipos, um registro (uma variável struct em linguagem C) é classificado como uma estrutura de dados heterogênea. 

> Exemplo: algoritmo de um registro que armazene informações referentes a um caderno.

- a primeira tarefa a ser realizada é a especificação do molde, ou seja, definição do novo tipo de dado Registro Caderno_Papelaria. 
- depois podem ser declaradas diversas variáveis que são do tipo Registro Caderno_Papelaria.

~~~
Algoritmo Papelaria;

Declare tipo
  Registro Caderno_Papelaria
    Início
      fabricante[15]: caractere;
      num_folhas: inteiro;
      tipo_de_capa[12]: caractere;
      tamanho[10]: caractere;
      preço: real;
      fim;
  declare variáveis
    caderno_cadastro: Registro Caderno_Papelaria
    caderno_venda: Registro Caderno_Papelaria; 
...
~~~

- a linguagem C segue o mesmo conceito.
- o tipo de dado registro é implementado como struct. 
- programa exemplo:

~~~c
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
  
struct Caderno_Papelaria {
      char fabricante[25];
      int num_folhas;
      char tipo_de_capa[12];
      char tamanho[10];
      float preco;
    };
  
int main(){
/* declaração das variáveis */
  struct Caderno_Papelaria caderno_cadastro, caderno_venda; 

/*Leitura de uma variável do tipo struct: o caderno a ser cadastrado*/
    printf("**************************************\n")
    printf("* Digite o caderno a ser cadastrado: *\n");
    printf("**************************************\n");

    printf("\nDigite o fabricante: ");
    fgets(caderno_cadastro.fabricante, sizeof(caderno_cadastro.fabricante), stdin);
    
    printf( "digite o número de folhas: ");
    scanf("%d", &caderno_cadastro.num_folhas);
    
    printf( "digite o tipo de capa: (dura/brochura)");
    
    scanf(“%s”,caderno_cadastro.tipo_de_capa);
    
    printf( "digite a dimensão: ");
    scanf(“%s”,caderno_cadastro.tamanho);
    
    printf( "digite o preço: ");
    scanf ("%f", &caderno_cadastro.preco);

/*Supondo que o caderno cadastrado seja vendido*/ 
    caderno_venda = caderno_cadastro;

/*Escrita das informações do caderno que é vendido*/
    printf("***********************************\n");
    printf("* Apresentacao do caderno vendido *\n");
    printf("***********************************\n");

    printf("\nfabricante:%s", caderno_cadastro.fabricante);
    printf("num. de folhas: %d \n", caderno_venda.num_folhas);
    printf( "tipo de capa: %s \n",caderno_venda.tipo_de_capa);
    printf( "dimensao: %s \n",caderno_venda.tamanho);
    printf( "preco: R$%0.2f \n", caderno_venda.preco);

    return 0;
}
~~~

- no exemplo acima, é possível verificar que, para se ter acesso a cada campo de uma variável do tipo struct, é necessário que cada campo seja especificado, e a forma é sempre: `nome_variavel.campo`.
- para realizar a leitura de uma variável do tipo struct, campo por campo deve ser lido para poder armazenar as informações desejadas; o mesmo ocorre com a escrita de cada campo da variável. Já para uma variável que é do mesmo tipo (ou seja, struct Caderno_Papelaria), a atribuição de cada campo pode ser feita de forma implícita, como em: caderno_venda = caderno_cadastro.

- outro exemplo de programa que declara e utiliza um tipo de dado struct:

~~~C
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

struct rotulo{
  int x;
  float y;
  char n[20];
  };

int main()
{
struct rotulo qlq = {1,2.3,"Primeiro teste"}; 
//declara uma variável struct e atribui valores iniciais
printf(" x= %d \t y= %f \t n= %s \n", qlq.x ,qlq.y ,qlq.n);
qlq.x=0; 
strcpy(qlq.n,"segundo");
printf(" x= %d \t y= %f \t n= %s \n", qlq.x ,qlq.y ,qlq.n);

return 0;
}
~~~

- o struct é mais utilizado quando podem ser armazenados vários registros de um determinado objeto (elementos de vetores ou matrizes).

### 1.2.4 Uso de vetor de struct
- um vetor de elementos do tipo struct deve ser declarado da seguinte forma:

~~~c
struct molde vetor[N];
~~~

- cada elemento que forma a variável vetor será uma struct com todos os campos especificados pelo molde.

- outros exemplos de uso:
  - suponha que um programa deva cadastrar as informações (nome e nota) de três alunos de uma sala de aula e apresentar as informações do aluno com maior nota.
  - o programa abaixo cria o tipo de dado struct cadastro e declara a variável aluno com três elementos do tipo struct.

~~~c
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

struct cadastro{ //cria o tipo de dado struct aluno
  char nome[10];
  float nota;
};

int main()
{
  int quantidade_alunos = 3;
  struct cadastro aluno[quantidade_alunos]; /*declara variável aluno 
        como vetor de 3 elementos do tipo struct aluno*/
  struct cadastro aluno_maior;
      /*declara variável aluno_maior que armazenará
        as informações do(1)aluno com maior nota */
  float maior, nota;
  int i;

  /* cadastra 3 alunos e suas notas*/
  for(i=0;i< quantidade_alunos;i++){
    printf("digite nome: ");
    fgets(aluno[i].nome, sizeof(aluno[i].nome), stdin);

    printf("digite nota: ");
    char nota_str[10];
    fgets(nota_str, sizeof(nota_str), stdin);
    aluno[i].nota = atof(nota_str);
    }

  /* Procura e apresenta o aluno com maior nota*/ 
  maior = 0;    
  for(i=0;i<quantidade_alunos;i++){    
    if(aluno[i].nota > maior){
          maior = aluno[i].nota;
        aluno_maior.nota=maior;
        strcpy(aluno_maior.nome,aluno[i].nome);
  }
  }
printf("\n***********************************\n");
printf("\t maior nota do aluno = %s \t nota = %0.1f \n\n", aluno_maior.nome,  aluno_maior.nota);

return 0;
}
~~~

- o uso de struct em C é bastante extenso, sendo que cada campo que compõe um registro pode ser não apenas de tipo simples de dados, mas também de tipo composto, como vetor, matriz e registro.

### 1.2.5 Variáveis do tipo ponteiro
- há duas situações em que se pode utilizar variáveis do tipo ponteiros:
  - passagem de parâmetros para funções por referência.
  - alocação dinâmica de variáveis na memória RAM.
- quando uma variável é declarada, um espaço na memória RAM é reservado para ela, e cada posição de memória é identificada com um endereço único. 
  - em programação, é permitido acesso a uma variável pelo nome ou símbolo que foi criado.
- ***definição de ponteiro***: uma variável é dita do tipo ponteiro se ela contiver como informação um endereço de memória RAM.

> IMPORTANTE: Ponteiro é uma variável que aponta para uma posição da memória RAM.

- para declarar e manipular variáveis do tipo ponteiro, são necessários dois operadores: 
  - & (endereço de): que retorna o endereço de memória de uma variável.
  - * (conteúdo de): que especifica que se deve manipular o conteúdo de um endereço de memória.
- exemplo de declaração de variável do tipo ponteiro:

~~~C
int *ptr;
~~~

- toda variável do tipo ponteiro tem o operador * antes do seu nome.
- a declaração deve ser lida da seguinte forma: ptr é uma variável do tipo ponteiro cujo conteúdo do que ela aponta é inteiro. 
- exemplo:

~~~C
#include <stdio.h>
int main()
{
int x = 3; 
int *ptr; //declara ptrcomo ponteiro para um dado inteiro
ptr = &x; /*atribui à variável ptr o endereço de memória onde está a
 variável x, ou seja, ptr aponta para área da memória onde está a 
 variável x */
printf(" x=%d ptr=%d conteudo do que ptr aponta %d \n",x, ptr, *ptr);
}
~~~

- adicionando mais um comando executado após o trecho anterior:

~~~c
//conteúdo do que ptr aponta recebe o valor 7
*ptr = 7; 
printf(" x=%d ptr=%d conteudo do que ptr aponta %d \n",x, ptr, *ptr);
~~~

- esse comando deve ser lido da seguinte forma: o conteúdo do que está sendo apontado por ptr recebe o valor 7. Portanto, a variável x apontada por ptr deixa de valer 3 e passar a conter o valor 7.

- exemplo do programa completo:

~~~c
#include <stdio.h>
int main()
{
int x = 3;
int *ptr;
ptr = &x;
printf(" x=%d ptr=%d conteudo do que ptr aponta %d \n",x, ptr, *ptr);
//conteúdo do que ptr aponta recebe o valor 7
*ptr = 7; 
printf(" x=%d ptr=%d conteudo do que ptr aponta %d \n",x, ptr, *ptr);
return 0;
}
~~~

- no próximo código, são feitas as mesmas operações com ponteiro, com a diferença que o dado onde o ponteiro aponta é do tipo float.

~~~c
#include <stdio.h>
  int main()
  {
  float x;
  x = 12.998;
  float *pontx; 
  pontx = &x;	//pontx passa a apontar para a variável x
  *pontx = 3.14;//conteúdo do que pontx aponta recebe 3.14 
  printf(" x=%0.2f pontx=%d conteúdo do que pontx aponta %f \n",x, pontx, *pontx);
  
  return 0;
} 
~~~

- para concluir a apresentação sobre o tipo de dado ponteiro e sua manipulação, falta apenas conhecer como são tratados os ponteiros para o tipo de dado struct.
- para tal, será utilizado o programa abaixo, que obedece à mesma sequência de comandos do programa anterior, mas usando um ponteiro para uma variável do tipo struct.

~~~c
#include <stdio.h>

  struct cad{
         int RM;
         char nome[30];
         };       
  int main()
  {
      struct cad aluno; //declara variável do tipo struct cad
      struct cad *p; //declara ponteiro para struct cad
      p = &aluno;  //p aponta para a variável aluno
  
      printf(" digite RM do aluno: ");
  //lê valor para o campo RM da variavel apontada por p
      char rm_str[10];
      fgets(rm_str, sizeof(rm_str), stdin);
      p->RM = atof(rm_str);printf(" digite nome do aluno: ");
  //lê valor para o campo nome da variavel apontada por p
      printf(" digite RM do aluno: ");
      fgets(p->nome,sizeof(p->nome),stdin);
      printf(" O aluno %s tem RM:%d \n",p->nome, p->RM);
  
      return 0;
  }
~~~

- são declaradas duas variáveis: aluno do tipo struct cad e p, um ponteiro para struct cad. 
- depois do comando p=&aluno, o ponteiro p passa a apontar para a área reservada à variável aluno na memória.
- para ter acesso aos campos da variável aluno por meio do ponteiro p, é preciso conhecer mais um operador em C: `->`.
  - quando se encontra `p->` no código, deve-se ler da seguinte forma:"selecione a struct apontada por p". 
  - tendo acessado a variável do tipo struct cad, é preciso selecionar o campo dentro da struct cad, o que acontece com p->RM e p->nome.

<div align="center">
<h2>2. FUNÇÕES</h2>
</div>

- função é um conjunto de comandos agrupados em um módulo ou bloco, que recebe um nome e, por meio desse nome, pode ser chamado para ser executado.
- em todas as linguagens, é necessário haver construções que permitam escrever programas usando o conceito de modularização. 
- principais razões para utilizar funções na programação de softwares:
  - permitir o reaproveitamento de código já elaborado.
  - evitar que um trecho de código seja repetido várias vezes em um mesmo programa.
  - permitir a alteração de um trecho de código de forma mais rápida. Com o uso de função, é preciso alterar apenas dentro da função que se deseja.
  - evitar que os blocos do programa fiquem grandes demais e, consequentemente, mais difíceis de entender.
  - facilitar a leitura do programa-fonte.
  - separar o programa em partes (blocos) que possam ser logicamente compreendidas de forma isolada.
- estrutura básica de uma função em C:

~~~
<tipo do valor retornado> nome da função(lista de parâmetros)
{
  // declaração de variáveis locais
  // lista de comandos
  return (valor único retornado);
}
~~~

- toda função deve ter um nome e, dentro de delimitadores (“{” e “}”),a especificação dos comandos a serem executados quando a função for chamada.
- as variáveis declaradas dentro da função são as variáveis locais, ou seja, só são conhecidas e utilizadas enquanto a função estiver sendo executada.
- mesmo que não haja parâmetros à frente do nome da função, deve-se ter parênteses ().

## 2.1 Funções com apenas 1 valor de resultado (return)

- em C, uma função pode retornar 1 valor com o próprio nome da função, ou seja, usando o comando return. 
- no caso de retornar um valor de resultado dessa forma, à frente do nome da função deve ser colocado o tipo do valor retornado, por exemplo, int, float, char etc; o retorno do valor do tipo especificado é feito por meio do comando return.
- quando nenhum valor é retornado com o nome da função, deve ser colocado o tipo void, que significa que nenhum valor será retornado. 
- exemplo: programa que calcula (usando uma função) o discriminante de uma equação de segundo grau do tipo ax² + bx + c = 0. 
  - lembrando que o delta (discriminante) é b²–4ac.
  - parâmetros a, b e c são chamados parâmetros de entrada, pois são valores que a função precisa receber para calcular o delta.
  - o delta calculado é um parâmetro de saída. 

~~~C
#include <stdio.h>
#include <stdlib.h>

//função p/ calcular o discriminante de uma equação do 2º grau
int delta(int a,int b, int c)
{
int d;
d = b*b-4*a*c;
return(d);
}

int main()
{
int x,y,z,d;
printf("digite 3 coeficientes:");
scanf("%d%d%d", &x,&y,&z);
d=delta(x,y,z);
printf ("discriminante: %d \n", d);
return 0;
}
~~~

- a especificação das funções que fazem parte do programa deve acontecer antes que a função seja chamada, por isso a função delta é codificada antes da função main().
- a execução de qualquer programa é iniciada sempre na função main() - apenas main está ativa na memória, existindo apenas as variáveis x, y, z e d. 
- quando é feita a chamada da função delta(), a função main() fica “inativa” na memória e apenas a função delta() passa a ser executada. 
- porém, antes de a função main() ficar aguardando o resultado da função delta, são passados os parâmetros necessários para a função delta poder ser executada.
  - no exemplo, o parâmetro a recebe o valor da variável x; o parâmetro b, o valor da variável y; e o parâmetro c, o valor da variável z. 
  - portanto, a = 1, b = 2 e c=1.
  - após a passagem dos parâmetros, a função delta inicia sua execução e, como primeiro comando, é feita a declaração da variável local d.
  - importante notar que, apesar de ter o mesmo nome da variável d da função main(), não há qualquer relação entre elas, pois a variável d da função delta() existe apenas enquanto a função delta estiver sendo executada.
  - em seguida, o cálculo é realizado e armazenado na variável local d. 
  - para que esse resultado possa ser enviado para a função main(), é usado o comando return(d), que faz com que o valor do resultado seja devolvido para a função que fez a chamada da função delta() e, em seguida, ocomando return encerra a execução da função delta().
  - quando o comando return é executado, a função que fez a chamada deve ter uma variável que receba, por meio de uma atribuição, o valor retornado da função.
  - o tipo do retorno da função delta() é int e a variável d da função main() foi declarada como int. 

> IMPORTANTE: É fundamental saber que o return é capaz apenas de retornar um valor, que pode ser do tipo int, float, char, struct ou ponteiro. Deve-se atribuir a uma variável que seja do mesmo tipo do valor declarado do retorno da função.

- outro exemplo:

~~~c
#include <stdio.h>

char avaliacao (float peso1, float peso2)
{
if (peso1 == peso2)
   return 'p'; //permanece igual
else if (peso1 > peso2)
        return 'd'; //diminuiu o peso
     else 
        return 'a'; //aumentou o peso 
}

int main()
{
char situacao;
float peso_inicial, peso_final;
printf("Digite peso antes e depois da dieta");
scanf("%f%f", &peso_inicial, &peso_final);
situacao = avaliacao (peso_inicial, peso_final);

if (situacao == 'p')
    printf("O paciente não emagreceu\n");
else if (situacao == 'd')
         printf("O paciente emagreceu\n");
     else 
         printf("O paciente engordou\n");

return 0;
}
~~~

## 2.2 Funções com vários resultados (parâmetros de saída)

- até agora,todas as funções apresentadas podiam:
  - receber vários parâmetros como valores de entrada para a função.•
  - gerar apenas um valor como resultado da função.
- e se for necessário gerar mais de um resultado? Há `três possíveis tipos de parâmetros de uma função`:
  - ***Entrada:*** valores para serem usados apenas pela função. 
  - ***Entrada e Saída***: valores usados dentro da função, sofrem alterações durante a execução da função e precisam ser passados para a função que fez a chamada.
  - ***Saída***: são resultados que a função gera e que precisam ser passados para a função que fez a chamada.
- em C, os `parâmetros de uma função podem ser passados`:
  - ***por valor***: um valor é copiado para o parâmetro da função e pode ser usado pela função. Apenas para parâmetros de entrada da função.
  - ***por referência (ponteiro)***: o parâmetro é uma ligação (uma referência) a uma variável da função que fez a chamada, assim, toda alteração que a função impor ao parâmetro terá efeito na variável ligada ao parâmetro. Usado para parâmetros de Saída e de Entrada e Saída. 

- exemplo:
  - nessa implementação, não vamos usar o comando return para devolver um resultado da função para quem fez a chamada; assim, o tipo de retorno da função é void.
  - o parâmetro n (inteiro) é apenas de entrada, ou seja, passagem por valor. Finalmente, v (float) e res (inteiro) são parâmetros de saída e de entrada e saída, respectivamente. Sendo assim, devem ser passados por referência, ou melhor, como ponteiros.
  - protótipo da função exemplo:
  
~~~C
void exemplo (int n, int *res, float *v)
~~~

- programa que usa a função exemplo:

~~~C
#include <stdio.h>

void exemplo (int n, int *res, float *v)
  {
  n++;
  *res = n + *res;
  *v = n * 2.1;
  }

int main()  
{
int a = 1,d =2;
float m = 0;
exemplo (a, &d, &m);
printf("a= %d  \t  y = %d\t e m = %.1f\n",a,d,m);
}
~~~

- para realizar a chamada da função exemplo(), são passados os parâmetros, sendo que a variável a tem seu valor passado para o parâmetro de entrada n. Já os parâmetros res e v da função exemplo são parâmetros saída, devem ser ponteiros. 
  - lembrando da definição de ponteiro, que diz que uma variável do tipo ponteiro é aquela que sempre armazena endereço de memória; ao invés de passar o valor de d e m para res e v, devem ser passados os seus endereços usando o operador &. 
- descrevendo a execução da função exemplo():
  - no comando n++, a ação se dá sobre o valor armazenado em n na passagem por valor, que foi o valor 1. Assim, n termina com o valor 2.
  - o valor de n é somado ao conteúdo de memória apontado por res, ou seja, o valor 2 armazenado na variável d da função main(). O resultado 4 é armazenado como conteúdo da variável apontadapor res.
  - a multiplicação realizada gera como resultado 8.2 deve ser armazenado como conteúdo da variável apontada pelo parâmetro v, isto é, na variável m da função main().

- é possível modificar a função que calcula o delta da função de 2° grau e, para não usar o comando return, o resultado deve ser retornado usando passagem de parâmetro por referência (ponteiro). 
- programa:

~~~C
#include <stdio.h>

//função para calcular o discriminante da equação do 2º grau
void delta(int a, int b, int c, int *d)
{
*d= b*b-4*a*c;
}

int main()
{
    int x = 0, y = 0, z = 0, d = 0;
    printf("digite 3 coeficientes:");
    scanf("%d%d%d", &x, &y, &z);
    printf("\nANTES da função delta: x= %d \t y=%d \t z=%d \t d=%d", x, y, z, d);
    delta(x, y, z, &d);
    printf("\nDEPOIS da função delta: x= %d \t y=%d \t z=%d \t d=%d", x, y, z, d);
    printf("\ndiscriminante: %d \n", d);

    Return 0;
}
~~~

- no exemplo acima, o comando return não é usado, o tipo da função foi alterado para void e o quarto parâmetro foi incluído para retornar o resultado da função para a função main(). 

## 2.3 Funções com passagem de parâmetros do tipo de dado struct 

- a regra é a mesma para variáveis como int ou float: se um dado do tipo struct é parâmetro de saída de uma função, este deve ser passado por referência, ou seja, usando ponteiro.
- a ideia é utilizar um programa que possui duas funções:
  - a função le_registro() deve ler do teclado os campos que compõem a struct prod, devolvendo para a função que a chamou um parâmetro com a struct prod alterada. Dessa forma, tem apenas uma struct prod como parâmetro de saída.
  - já a função escreve() recebe como parâmetro uma struct prod e deve apenas escrever na tela de saída, sem gerar qualquer alteração no conteúdo dos campos. Portanto, recebe apenas um parâmetro de entrada.

~~~C
#include<stdio.h>
#include<string.h> 

struct prod{		
    int cod;
    float preco;
};

//parametro de saida p_cad é ponteiro para struct prod
void le_registro(struct prod *p_cad) 
{  
printf("Digite codigo do produto e preco\n");
scanf("%d", &p_cad->cod); 
scanf("%f", &p_cad->preco); 
}

//parametro de entrad cad é uma struct prod
void escreve(struct prod reg) {
printf(" Codigo e preco do produto são: %d R$%.2f \n", reg.cod, reg.preco);
}

int main() {
struct prod cad;
//chama função passando o endereço da variável cad 
le_registro (&cad);
//chama função passando o valor da variável cad 
escreve(cad);	 

return 0;	 
}
~~~

- na função main(), é feita a declaração da variável cad, que é do tipo struct prod. 
- em seguida, é feita a chamada da função le_registro(&cad).
- assim, pela passagem de parâmetro p_cad (do tipo ponteiro para uma struct prod) recebe o endereço de memória (ou seja, aponta) onde se encontra a variável cad (p_cad = &cad).
- dentro da função le_registro():
  - p_cad->cod especifica que o campo cod da struct apontada por p_cad (deve ser lido como “o campo cod da struct apontada por p_cad”). 
  - p_cad->preco especifica que o campo preco da struct apontada por p_cad (deve ser lido como “o campo preco da struct apontada por p_cad”). 
- quando a função le_registro() termina, a variável cad da função main()tem os valores dos campos lidos dentro da função.
- o parâmetro de entrada reg da função escreve() recebe uma cópia da variável cad da função main(). Dessa forma, a parâmetro do tipo struct prod reg tem seus campos escritos na tela de saída de forma normal.

## 2.4 Vetores, string e matrizes como parâmetros de funções

- todos os parâmetros que são de saída, ou de entrada e saída, devem ser passados por referência, ou seja, como ponteiros. Com vetores e matrizes não é diferente, deve-se conhecer como passá-los como ponteiro. 
- vetores e matrizes seguem o mesmo conceito para serem passados como parâmetros por referência.
- em C, quando é declarado um vetor ou uma matriz, é reservada uma área de memória para o armazenamento dos elementos. Quando se referencia apenas o nome do vetor, é obtido o endereço inicial onde foi armazenado o 1º elemento da estrutura.
  - para passar um vetor ou matriz como parâmetro, basta usar o seu nome sem índice.

> IMPORTANTE: Vetores e matrizes são sempre passados por referência de forma implícita (não precisamos usar explicitamente ponteiros).

- os exemplos a seguir apresentam vetores passados como parâmetros em várias situações.
  - suponha um programa que leia as quantidades vendidas de cada um dos 10 produtos em uma loja em 2 dias consecutivos.
    - o programa deve apresentar o total vendido de cada produto nos 2 dias usando uma função para somar os elementos dos 2 vetores. 

~~~C
#include <stdio.h>

#define N 300

/*a e b sao parametros de entrada e s é de saída, mas não há
  diferença para a funçao */
void soma_vetor(int a[N],int b[N], int s[N])
{
int i;
for (i=0; i<N;i++)
    s[i]=a[i]+b[i];
}

int main(){
int i,venda1[N],venda2[N],total[N];
for (i=0;i<N;i++){
  printf(" digite quantidade vendida 1º dia do produto %d: ",i);
  scanf("%d",&venda1[i]);
  }
for (i=0;i<N;i++){
  printf("Digite quantidade vendida 2ºdia do produto %d: ",i);
  scanf("%d",&venda2[i]);
  }
//chama a função passando por referencia cada vetores 
soma_vetor(venda1,venda2,total);
for (i=0;i<N;i++){
  printf(" A quantidade vendida nos 2 dias do produto %d: %d\n",i,total[i]);
  }

  return 0;
}  
~~~

- para ter mais um modelo, o exemplo anterior pode ser modificado da seguinte maneira:
  - uma função que realize a leitura dos elementos de um vetor com N elementos e a utilize para fazer a entrada de dados dos 2 vetores.
  - uma função para escrever um vetor com N elementos para escrever o vetor soma.
  - uma função que calcule a média de produtos vendidos de cada dia.

~~~C
#include <stdio.h>

#define N 300

void leitura(int x[N])
//vetor x é parametro de saida 
{
int i;
for (i=0;i<N;i++){
  printf(" digite quantidade vendida do produto %d: ",i);
  scanf("%d",&x[i]);
  }
}

void escreve(int x[N])
//vetor x é parametro de entrada 
{
int i;
for (i=0;i<N;i++){
  printf(" A quantidade vendida nos 2 dias do produto %d: %d\n",i,x[i]);
  }
}

void soma_vetor(int a[N],int b[N], int s[N])
/*vetores a e b são parâmetros de entrada e vetor s é 
parâmetro de saída */
{
int i;
for (i=0; i<N;i++){
  s[i]=a[i]+b[i];
  }
}

float media(int x[N])
/*vetor x é parametro de entrada e valor da média calculada 
  é retornado pelo comando return */
{
int i,soma=0;
float aux;
for (i=0;i<N;i++)
    soma=soma+x[i]; 
aux= (float) soma/N;
return(aux);
}

int main()
{
int i,venda1[N],venda2[N],total[N];
float m1,m2;
printf(" digite quantidades vendidas no primeiro dia\n");
leitura(venda1);
printf(" digite quantidades vendidas no segundo dia\n");
leitura(venda2);
soma_vetor(venda1,venda2,total);
printf(" As quantidades vendidas nos 2 dias\n" );
escreve(total);
m1=media(venda1);
printf(" A media de vendas do primeiro dia: %0.1f\n",m1 );
m2=media(venda2);
printf(" A media de vendas do segundo dia: %0.1f\n",m2 );

return 0;
}
~~~

---

## FAST test

### 1. Qual das opções não é um tipo de dado em linguagem de programação C?
> const.

### 2. Em linguagem C, as palavras-chave ou reservadas são comandos específicos da linguagem que não podem ser utilizados com outro propósito além do definido pela linguagem. Qual das alternativas não é uma palavra-chave em C?
> Caractere.

### 3. Em linguagem de programação C, qual é a ação gerada pelo pré-processador pela diretiva #include?
> É inclusão (ou importação) de bibliotecas com funções específicas.

### 4. Todos os arquivos que pertencem à biblioteca da linguagem C têm qual extensão?
> ".h".

### 5. Qual das alternativas não é um operador relacional utilizado em linguagem C?
> &&.

--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)