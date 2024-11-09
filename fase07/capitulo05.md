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












--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)