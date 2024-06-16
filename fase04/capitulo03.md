<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img align="right" height="120px" src="../assets/logo.png" /></a>
<h1>FASE 4 - FRAMEWORKS .NET</h1>
<h2>Capítulo 03: Programando em C#.</h2>
</div>

<div align="center">
<h2>1. PROGRAMANDO EM C#</h2>
</div>

## 1.1 Estrutura básica de um programa C#

- um programa C# típico é composto de vários componentes interligados, cada um desempenhando uma função específica dentro do ecossistema maior do .NET.
- `namespace`: espaço de nomes, é uma forma de organizar e encapsular conjuntos de classes relacionadas.
- dentro de um namespace, encontramos `classes`, que são os blocos de construção fundamentais de qualquer aplicativo C#. 
- uma classe encapsula dados e comportamento, representando entidades ou conceitos com propriedades (dados) e métodos (ações).
- `método Main`: ponto de entrada de todo programa C#, é onde a execução do programa começa e termina; pode processar argumentos da linha de comando e controlar o fluxo do programa.
- `variáveis em C#` são **fortemente tipadas** (devemos declarar o tipo de dados que a variável irá armazenar). 
	- o C# suporta vários tipos de dados primitivos, como inteiros, pontos flutuantes e caracteres, além de tipos mais complexos, como arrays e strings.
- `tratamento de erros`: realizado através de exceções, permitindo que escrevamos códigos mais seguros e robustos. 
	- as `exceções` capturam erros em tempo de execução, facilitando a depuração e a manutenção do código.

## 1.2 Criando o projeto Hello World

- abra o Visual Studio; observaremos as opções:
	- `Clone a repository`: permite clonar (fazer uma cópia completa) um repositório de código existente de plataformas de hospedagem como GitHub ou Azure DevOps.
	- `Open a project or solution`: permite abrir um projeto ou solução existente no Visual Studio.
	- `Open a local folder`: opção para navegar e editar código dentro de qualquer pasta no computador do usuário, sem a necessidade de abrir um projeto ou solução; é útil para trabalhar com códigos ou scripts soltos.
	- `Create a new project`: iniciar um novo projeto de programação. O Visual Studio oferece vários modelos de projeto que incluem configurações e arquivos básicos necessários para diferentes tipos de aplicativos, como aplicativos de console, aplicativos web, bibliotecas de classes, entre outros.

- no canto inferior, a opção `Continue without code` permite que você acesse o Visual Studio e utilize suas ferramentas e recursos sem carregar ou criar um projeto imediatamente, o que pode ser útil para configurar o IDE ou explorar suas extensões e recursos antes de mergulhar no código.

> Para dar início à construção do projeto 'Hello World', selecionar 'Create a new project'.

- `descrição dos modelos de projetos`:
  - ***Aplicativo de Console***: para criar aplicativos de linha de comando que podem ser executados no .NET em diferentes sistemas operacionais. É ideal para programas simples ou ferramentas de utilidade.
  - ***Blazor Web App***: Um modelo para criar aplicativos web que utilizam Blazor para oferecer interatividade do lado do cliente com renderização do lado do servidor. É adequado para interfaces de usuário ricas e dinâmicas.
  - ***Aplicativo Web ASP.NET Core***: modelo voltado para criação de aplicativos web utilizando o padrão ASP.NET Core com páginas Razor, que é uma maneira simplificada de construir interfaces de usuário baseadas na web.
  - ***API Web do ASP.NET Core***: específico para desenvolvimento de APIs Web RESTful com o ASP.NET Core, incluindo suporte para OpenAPI e autenticação, comumente utilizado para backend de serviços web e aplicativos móveis.

- para a base do projeto Hello World, usar o modelo ***"Aplicativo de Console"***, ideal para iniciar no desenvolvimento com C#, pois fornece um esqueleto de aplicativo simplificado, centrado na linha de comando, para entender as mecânicas básicas da linguagem e do ambiente .NET. 

- na ***tela "Configurar seu novo projeto"***, podemos personalizar e configurar os detalhes do aplicativo. Neste estágio, a interface permite definir a identidade e a localização do projeto, estabelecendo as bases para o desenvolvimento:
	- `Nome do projeto`: neste caso, "HelloWorld" foi escolhido.
	- `Local`: indica o diretório em que o projeto será salvo no seu computador. O caminho padrão é C:\Users\source\repos, típico para projetos no Windows.
	- `Nome da solução`: por padrão, a solução (que pode conter vários projetos relacionados) recebe o mesmo nome do projeto. No entanto, há a opção de alterá-lo se necessário. Aqui, também foi nomeado como "HelloWorld".
	- `Colocar a solução e o projeto no mesmo diretório`: esta caixa de seleção, quando marcada, indica que o Visual Studio deve colocar os arquivos de solução (.sln) no mesmo diretório do projeto, o que ajuda a manter a estrutura de arquivos simplificada, especialmente para projetos menores ou individuais. 

- na ***tela Informações adicionais***, é possível definir configurações mais específicas que influenciarão a compilação e execução do aplicativo:
	- `Estrutura`: permite selecionar a versão do .NET que deseja usar. 
	- `Não use instruções de nível superior`: quando marcada, essa opção instrui o Visual Studio a não usar as mais recentes instruções de nível superior do C# no ponto de entrada do programa.
	- `Habilitar publicação AOT nativo`: AOT significa "Ahead-of-Time Compilation". Marcar esta opção otimiza o desempenho do aplicativo compilando o código C# em código de máquina nativo antes da execução, em vez de usar a compilação "Just-in-Time" (JIT) padrão do .NET.
- neste estágio, manteremos as configurações avançadas em suas seleções padrão. Clicar no botão 'Criar'.

## 1.3 Entendendo o Hello World

- no .NET 8, a experiência do "Hello World" é uma lição de simplicidade e um vislumbre da eficiência moderna do framework. Com apenas uma linha de código, `Console.WriteLine("Hello, World!");`, o programador estabelece um diálogo com o sistema.
- esta versão mais recente do .NET, reconhecida por seu suporte de longo prazo, oferece uma plataforma refinada e robusta para o desenvolvimento de aplicações. Ao executar o "Hello World", o programador estreita laços com a `Common Language Runtime (CLR)`, o coração executivo do .NET que gerencia a execução de código; é uma prova da capacidade de um ambiente gerenciado para facilitar a criação de software seguro, eficiente e de alto desempenho.

~~~csharp
// Código Hello World com instrução superior:
Console.WriteLine("Hello, World!");
~~~

~~~csharp
// Código Hello World sem instrução superior:
namespace HelloWorld
{
	class Program 
	{
		static void Main(string[] args)
		{
			Console.WriteLine("Hello, World!");
		}
	}
}
~~~

<div align="center">
<h2>2. CONHECENDO A IDE VISUAL STUDIO</h2>
</div>

## 2.1 Explorando a barra de menu

- central de comando.
- da acesso a diversas funcionalidades, desde criação de novos projetos e abertura de arquivos existentes até a personalização do ambiente de desenvolvimento e acesso a ferramentas de depuração avançadas.

## 2.2 Gerenciamento de Soluções e Projetos

- esta funcionalidade permite que você agrupe logicamente seus arquivos de código e recursos associados em uma estrutura de diretório bem-organizada, facilitando o acesso e a manutenção. 
- com o Gerenciador de Soluções, é possível adicionar, remover e organizar projetos e itens dentro de cada projeto. 

## 2.3 Janela de Código e Editor de Texto

- equipado com IntelliSense.
- oferece realce de sintaxe para melhorar a legibilidade do código.
- possui ferramentas de refatoração que ajudam a reestruturar o código de maneira mais eficiente.

## 2.4 Utilizando a Janela de Propriedades

- fornece um meio direto e interativo para modificar propriedades e configurações de elementos selecionados no projeto, seja um arquivo, componente de interface do usuário ou mesmo um controle dentro de um formulário.
- permite alterar atributos como tamanho, cor, fonte e outros parâmetros, dependendo do elemento selecionado.

## 2.5 Console e Ferramentas de Output

- fornece feedback instantâneo e contínuo sobre a execução do seu programa. 
- exibe a saída do programa, mensagens de erro, advertências e outros tipos de informações importantes durante a compilação e execução. 
- é aqui que podemos acompanhar o comportamento do programa em tempo real, verificar se há erros de lógica, e entender como o código está interagindo com o sistema. 

## 2.6 Ferramentas de Depuração

- permitem inspecionar o código em execução, linha por linha, para identificar e resolver bugs ou comportamentos inesperados. 
- possibilitam definir pontos de interrupção, observar o estado das variáveis, e percorrer o código passo a passo.
- este processo facilita a identificação de onde e por que os erros estão ocorrendo, e também oferece uma oportunidade valiosa para compreender melhor o funcionamento do código.

## 2.7 Atalhos

<div align="center">

Atalho | Descrição 
-------|--------------
Ctrl + L | Remove a linha de código em que o cursor está posicionado.
Ctrl + K, Ctrl + D | Formata (identa) todo o código da classe em edição.
Ctrl + Shift + B | Compilação de todos os projetos da solução.
Ctrl + . | Abre opção de SmartTags para correções rápidas de código ou criação rápida de código. É usada também como autocomplete.
ctor + tab + tab | Cria o código do construtor da classe.
prop + tab + tab | Cria um atributo para a classe.
propfull + tab + tab | Cria um atributo para a classe e adiciona a implementação do get e do set.
propg + tab + tab | Cria um atributo somente leitura, em que o set é declarado como privado.

</div>

## 2.8 Explorando as opções de Compilação e Publicação

- etapas que preparam o projeto para distribuição ou deployment. 
- a `compilação` transforma o código que escrevemos em um formato que a máquina pode executar, seja como um aplicativo independente ou como uma biblioteca de código. 
- a `publicação` é o processo de empacotar esse código compilado, juntamente com quaisquer recursos e dependências necessários, para que possa ser implantado ou distribuído. 
- seja para um servidor, uma plataforma em nuvem ou para usuários finais, cada aspecto dessa fase garante que o projeto seja entregue com sucesso e funcione como esperado no ambiente de destino.

<div align="center">
<h2>3. LINGUAGEM C#</h2>
</div>

- C# é uma linguagem de programação moderna, orientada a objetos e fortemente tipada, desenvolvida pela Microsoft como parte de sua plataforma .NET. 
- lançada pela primeira vez em 2000, foi criada por Anders Hejlsberg. 
- tem suas raízes em C e C++, mas com influências notáveis de outras linguagens como Java.
- projetada para ser poderosa e versátil, ao mesmo tempo em que oferece uma sintaxe clara e concisa. 
- é amplamente usada para desenvolver uma vasta gama de aplicações, desde pequenos programas de console até grandes aplicativos de negócios baseados em Windows, aplicativos web com ASP.NET, serviços de nuvem, e até mesmo jogos com a Unity. 
- uma das principais vantagens do C# é sua ***integração com o .NET Framework***, uma extensa biblioteca de código que fornece uma ampla gama de funcionalidades, incluindo acesso a banco de dados, manipulação de arquivos, interfaces gráficas, e muito mais.
- a linguagem suporta muitos paradigmas de programação, incluindo programação procedural, orientada a objetos e funcional.
	- a orientação a objetos em C# é uma de suas características mais fortes, com suporte a classes, herança, polimorfismo, e encapsulamento.
- com o tempo, C# continuou a evoluir, adicionando novas funcionalidades em cada versão, como LINQ (Language Integrated Query), async/await para programação assíncrona, e mais recentemente, melhorias em padrões e performance. 
- também se destaca pela sua segurança de tipo, gerenciamento automático de memória com coleta de lixo, e sua interoperabilidade com outras linguagens no .NET.

## 3.1 Método Main

- desempenha um papel crucial como o ponto de entrada para a execução de um aplicativo. 
- este método específico marca o início da lógica do programa, sendo o primeiro código a ser executado quando um aplicativo é iniciado. 
- alguns detalhes adicionais sobre o método Main:
	- `Localização e Definição`: é geralmente localizado em uma classe. Ele pode ser definido em qualquer classe, mas por convenção, é frequentemente colocado em uma classe denominada Program. A definição padrão do método Main aparece como `static void Main(string[] args)`, mas existem variações.
	- `Método Estático`: Main é um método estático, o que significa que ele pode ser chamado sem criar uma instância da classe em que está definido. Isso é essencial, pois o método precisa ser acessível para o sistema operacional e o ambiente de execução do .NET para iniciar a execução do programa.
	- `Parâmetros de Entrada`: o método Main pode aceitar um argumento, conhecido como args, que é um array de strings. Este array contém quaisquer argumentos de linha de comando que são passados para o programa quando ele é iniciado.
	- `Tipos de Retorno`: tradicionalmente, o Main não retorna valor algum (void), mas em versões mais recentes do C#, também pode retornar um int, que normalmente é utilizado para indicar o status de saída do programa (***zero para sucesso e valores não zero para indicar erros***), ou um Task ou Task&lt;int&gt; para suportar operações assíncronas.
	- `Execução Assíncrona`: é possível definir Main como async, o que permite o uso de await dentro dele. Por exemplo, `static async Task Main(string[] args)`. Isso é útil para programas que realizam operações IO-bound ou network-bound na inicialização.
	- `Flexibilidade e Uso`: além de iniciar a execução do programa, o Main pode ser usado para processar argumentos de linha de comando, inicializar recursos necessários e determinar o fluxo de execução do programa com base nas entradas recebidas ou na configuração.

~~~csharp
using System;
namespace MyApp
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Programa iniciado.");
            // Verifica se algum argumento foi passado
            if (args.Length > 0)
            {
                Console.WriteLine("Argumentos recebidos:");
                foreach (var arg in args)
                {
                    Console.WriteLine(arg);
                }
            }
            else
            {
                Console.WriteLine("Nenhum argumento foi recebido.");
            }
            Console.WriteLine("Programa encerrado. Pressione qualquer tecla para sair.");
            Console.ReadKey();
        }
    }
}
~~~

## 3.2 Namespace

- no C#, os namespaces são fundamentais para organizar o código. 
- ajudam a categorizar classes e outros tipos, evitando conflitos de nomeação e facilitando a manutenção. 
- um programa C# típico começa com declarações de namespace, como `using System;`, que dá acesso a classes e métodos padrão do .NET.

## 3.3 Classes

- é uma estrutura fundamental que encapsula dados e comportamentos, servindo como um molde para criar objetos. 
- cada classe define um tipo e o tipo de operações que podem ser realizadas nele. 
- geralmente, um programa em C# começa com uma classe principal que contém o método Main, o ponto de partida do programa. 
- as classes permitem a organização e a modularização do código, facilitando a manutenção e a extensibilidade. 
- suportam princípios importantes como encapsulamento, herança e polimorfismo.
- ***exemplo***: classe simples chamada Carro, que irá encapsular algumas propriedades de um carro e fornece métodos para interagir com essas propriedades.

~~~csharp
using System;
namespace Veiculos
{
    class Carro
    {
        // Propriedades da classe
        public string Marca { get; set; }
        public string Modelo { get; set; }
        public int Ano { get; set; }
        // Construtor da classe
        public Carro(string marca, string modelo, int ano)
        {
            Marca = marca;
            Modelo = modelo;
            Ano = ano;
        }
        // Método que exibe detalhes do carro
        public void ExibirDetalhes()
        {
            Console.WriteLine($"Marca: {Marca}, Modelo: {Modelo}, Ano: {Ano}");
        }
    }
}
~~~

- explicado a classe Carro:
	- possui três propriedades: Marca, Modelo e Ano. Estas propriedades armazenam os dados relevantes para um objeto do tipo Carro.
	- o Construtor da classe (public Carro(...)) é um método especial usado para inicializar novas instâncias da classe. Ele configura o objeto Carro com valores específicos para Marca, Modelo e Ano quando um novo carro é criado.
	- o método ExibirDetalhes é um comportamento da classe Carro que, quando chamado, imprime detalhes do carro no console.

## 3.4 Tipos (Variáveis)

- `tipos` ou `variáveis` em C# são elementos essenciais que armazenam dados utilizados durante a execução de um programa. 
- no C#, as variáveis precisam ser declaradas antes de serem usadas, especificando o tipo de dado que irão armazenar, seguido por um nome identificador único. 
- a tipagem forte ajuda a prevenir erros e torna o código mais legível e manutenível.
- permitem o armazenamento de informações como números, textos e instâncias de objetos, e podem ter seu conteúdo alterado ao longo do tempo. 
- o escopo de uma variável pode ser local (dentro de um método) ou global (acessível em toda a classe ou aplicação), e determina sua visibilidade e tempo de vida dentro do programa.

<div align="center">

Tipo de Variável | Descrição | Exemplo
------------------|---------|----------------
int | Armazena números inteiros. | int idade = 30;
double | Armazena números de ponto flutuante de dupla precisão. | double peso = 70.5;
char | Armazena um único caractere. | char letra = 'A';
string | Armazena sequências de caracteres. | string nome = "Alice";
bool | Armazena valores booleanos (verdadeiro ou falso). | bool estaChovendo = true;
decimal | Armazena números decimais com alta precisão. | decimal preco = 99.99m;
float | Armazena números de ponto flutuante de precisão simples. | float altura = 5.3f;
long | Armazena números inteiros de grande magnitude. | long distancia = 1000000L;

</div>

- além dos tipos acima, o C# oferece uma rica variedade de `tipos complexos`, essenciais para manipulação avançada de dados e construção de estruturas sofisticadas dentro de um programa. 
- esses tipos complexos permitem aos desenvolvedores lidar com coleções de dados, relações entre objetos, e estruturas de controle de fluxo com maior eficiência e flexibilidade. 
- são fundamentais para a implementação de conceitos de programação orientada a objetos e para construção de aplicações robustas e escaláveis. 

### 3.4.1 Inicialização
- passo crucial no processo de declaração de variáveis, que define o valor inicial que a variável irá armazenar. 
- é essencial para evitar comportamentos inesperados em seu programa, pois variáveis não inicializadas podem conter valores residuais da memória, levando a resultados imprevisíveis.
- importância da Inicialização:
	- garante que a variável comece com um valor conhecido e definido.
	- ajuda a prevenir erros, pois o uso de variáveis não inicializadas em C# pode resultar em erros de compilação ou comportamentos indefinidos em tempo de execução.
	- melhora legibilidade e manutenção do código, pois outros desenvolvedores podem entender mais facilmente o propósito e o uso da variável.
- exemplo:

~~~csharp
class Program
{
    static void Main(string[] args)
    {
        int idade = 25; // inicializa uma variável do tipo int
        string nome = "Alice"; // inicializa uma variável do tipo string
        double altura = 1.75; // inicializa uma variável do tipo double
        bool estaChovendo = false; // inicializa uma variável do tipo bool
        Console.WriteLine($"Nome: {nome}, Idade: {idade}, Altura: {altura}, Está chovendo: {estaChovendo}");
    }
}
~~~

### 3.4.2 Escopo de variáveis
- refere-se à região do código onde a variável é acessível e pode ser usada. 
- influencia tanto a segurança quanto a manutenção do código. 
- há principalmente dois tipos de escopo para variáveis: local e global (ou de classe).
	- `Local`: declaradas dentro de um método ou bloco de código (como dentro de um laço ou uma estrutura condicional) e só podem ser acessadas dentro desse contexto.

~~~csharp
void Teste()
{
	int contadorLocal = 0; // Escopo local dentro de Teste
	...
}
~~~

- `Global`: variáveis com escopo global, ou de classe, são declaradas fora de qualquer método, geralmente no início da classe. São acessíveis de qualquer lugar dentro da classe, e seu ciclo de vida é o mesmo da instância da classe.

~~~csharp
class MinhaClasse
{
    int contadorGlobal; // Escopo de classe
    void Metodo1()
    {
        contadorGlobal = 10; // acessível aqui
    }
    void Metodo2()
    {
        contadorGlobal += 5; // E aqui
    }
}
~~~

- o escopo determina não apenas a acessibilidade e a vida útil das variáveis, mas também influencia a segurança do código, ajudando a prevenir erros como a modificação acidental de variáveis em partes não relacionadas do programa.

### 3.4.3 Constantes
- são um tipo especial de variável cujo valor não pode ser alterado após a sua inicialização. 
- são definidas utilizando a palavra-chave `const`.
- são uma ferramenta útil para armazenar valores que são conhecidos em tempo de compilação e não devem ser modificados durante a execução do programa. 
- o uso de constantes contribui para a segurança, clareza e manutenção do código.
- características das Constantes:
	- `imutabilidade`: tentativas de modificar uma constante resultarão em erro de compilação.
	- `definição e inicialização`: devem ser inicializadas no momento da sua declaração; não é possível declarar uma constante sem atribuir um valor a ela.
	- `tipagem`: podem ser de qualquer tipo de dado, incluindo tipos primitivos (como int, double, string) e tipos definidos pelo usuário.
	- `escopo`: pode ser local ou global. Constantes locais existem dentro do método ou bloco onde são declaradas, enquanto constantes globais são declaradas fora de métodos, geralmente no início da classe.

~~~csharp
class Program
{
	const double PI = 3.14159; // Constante global
	static void Main(string[] args)
	{
		const int LIMIT = 100; // Constante local
		Console.WriteLine($"Valor de PI: {PI}");
		Console.WriteLine($"Valor do Limite: {LIMIT}");
	}
}
~~~

## 3.5 Operadores

- há uma variedade de operadores para realizar operações matemáticas (como +, -, *, /), comparações (como ==, !=, <, >), e lógicas (como &&, ||, !). 
- operadores são fundamentais para construção de expressões e instruções condicionais.

### 3.5.1 Aritméticos
- usados para realizar cálculos matemáticos básicos, como adição, subtração, multiplicação, divisão e obtenção de resto. 

a) ***incremento(++)***: operador de incremento unário ++ incrementa seu operando em 1.

~~~csharp
int i = 3;
Console.WriteLine(i);   // output: 3
Console.WriteLine(i++); // output: 3
Console.WriteLine(i);   // output: 4
~~~

b) ***decremento (--)***: decrementa o operando em 1.

~~~csharp
int i = 3;
Console.WriteLine(i);   // output: 3
Console.WriteLine(i--); // output: 3
Console.WriteLine(i);   // output: 2
~~~

- operadores de incremento (++) e decremento (--) em C# podem ser usados de duas formas: ***pré-fixados*** e ***pós-fixados***. 
- a diferença entre eles reside quando o valor é alterado em relação à execução do restante do código.
	- `pré-fixado (++var, --var)`: o valor da variável é incrementado ou decrementado antes que a expressão atual seja avaliada. Isso significa que a alteração no valor da variável é imediata e refletida na expressão em que está sendo usada.
	- `pós-fixado (var++, var--)`: a variável é incrementada ou decrementada após a expressão atual ser avaliada. Isso significa que a expressão usa o valor original da variável antes de aplicar o incremento ou decremento.

c) ***Adição (+) e Subtração (-)***: operador unário + retorna o valor do operando, e operador unário - calcula a negação numérica do operando.

~~~csharp
Console.WriteLine(+4); // output: 4
Console.WriteLine(-4); // output: -4
Console.WriteLine(-(-4)); // output: 4
uint a = 5;
var b = -a;
Console.WriteLine(b); // output: -5
Console.WriteLine(b.GetType()); // output: System.Int64
Console.WriteLine(-double.NaN); // output: NaN
~~~

d) ***Multiplicação (&#42;)***: calcula o produto dos operandos.

~~~csharp
Console.WriteLine(5 * 2); // output: 10
Console.WriteLine(0.5 * 2.5); // output: 1.25
Console.WriteLine(0.1m * 23.4m); // output: 2.34
~~~

e) ***Divisão (/)***: divide o operando à esquerda pelo operando à direita.

~~~csharp
Console.WriteLine(13 / 5); // output: 2
Console.WriteLine(-13 / 5); // output: -2
Console.WriteLine(13 / -5); // output: -2
Console.WriteLine(-13 / -5); // output: 2
~~~

- para obter o quociente de dois operandos na forma de um número de ponto flutuante, é recomendável utilizar os tipos float, double ou decimal, que permitem a representação de números com frações, garantindo que o resultado da divisão seja mais preciso e abrangente.

~~~csharp
Console.WriteLine(13 / 5.0); // output: 2.6
int a = 13;
int b = 5;
Console.WriteLine((double)a / b); // output: 2.6
~~~

f) ***Resto (%)***: calcula o resto após dividir o operando à esquerda pelo à direita.

~~~csharp
Console.WriteLine(5 % 4); // output: 1
Console.WriteLine(5 % -4); // output: 1
Console.WriteLine(-5 % 4); // output: -1
Console.WriteLine(-5 % -4); // output: -1
~~~

g) ***Atribuição composta***: para um operador binário op, uma expressão de atribuição composta do formato:

~~~csharp
int a = 5;
a += 9;
Console.WriteLine(a); // output: 14
a -= 4;
Console.WriteLine(a); // output: 10
a *= 2;
Console.WriteLine(a); // output: 20
a /= 4;
Console.WriteLine(a); // output: 5
a %= 3;
Console.WriteLine(a); // output: 2
~~~

### 3.5.2 Comparação
- utilizados para comparar dois valores ou expressões. 
- fundamentais na tomada de decisões dentro do código, como em estruturas condicionais (if, switch) e laços de repetição (while, for). 
- retornam um valor booleano (true ou false), indicando o resultado da comparação. 
- principais operadores de comparação em C#:

a) ***Igualdade ==***: verifica se dois operandos são iguais e retorna true se forem, e false se não forem. Essa verificação é fundamental em muitas estruturas de controle, onde a igualdade entre variáveis ou expressões determina o fluxo de execução do programa.

~~~csharp
int a = 1 + 2 + 3;
int b = 6;
Console.WriteLine(a == b);  // output: True
char c1 = 'a';
char c2 = 'A';
Console.WriteLine(c1 == c2);  // output: False
Console.WriteLine(c1 == char.ToLower(c2));  // output: True
~~~

b) ***Desigualdade !=***: resulta em true quando seus operandos são diferentes e false quando são iguais. Para operandos de tipos primitivos, a expressão x != y é funcionalmente equivalente a !(x == y), significando que x != y será verdadeira se x e y não forem iguais, da mesma forma que !(x == y) verifica se x é igual a y e inverte o resultado:

~~~csharp
int a = 1 + 1 + 2 + 3;
int b = 6;
Console.WriteLine(a != b);  // output: True
string s1 = "Hello";
string s2 = "Hello";
Console.WriteLine(s1 != s2);  // output: False
~~~

c) ***Menor que &lt;***: retornará true se o operando à esquerda for menor do que o operando à direita, caso contrário, false.

~~~csharp
Console.WriteLine(7.0 < 5.1);   // output: False
Console.WriteLine(5.1 < 5.1);   // output: False
Console.WriteLine(0.0 < 5.1);   // output: True
Console.WriteLine(double.NaN < 5.1);   // output: False
Console.WriteLine(double.NaN >= 5.1);  // output: False
~~~

d) ***Maior que &gt;***: retornará true se o operando à esquerda for maior que o operando à direita, caso contrário, false.

~~~csharp
Console.WriteLine(7.0 > 5.1);   // output: True
Console.WriteLine(5.1 > 5.1);   // output: False
Console.WriteLine(0.0 > 5.1);   // output: False
Console.WriteLine(double.NaN > 5.1);   // output: False
Console.WriteLine(double.NaN <= 5.1);  // output: False
~~~

e) ***Menor ou igual a &lt;=***: retornará true se o operando à esquerda for menor ou igual ao operando à direita, caso contrário, false.

~~~csharp
Console.WriteLine(7.0 <= 5.1);   // output: False
Console.WriteLine(5.1 <= 5.1);   // output: True
Console.WriteLine(0.0 <= 5.1);   // output: True
Console.WriteLine(double.NaN > 5.1);   // output: False
Console.WriteLine(double.NaN <= 5.1);  // output: False
~~~

f) ***Maior ou igual &gt;=***: retornará true se o operando à esquerda for maior ou igual ao operando à direita, caso contrário, false.

~~~csharp
Console.WriteLine(7.0 >= 5.1);   // output: True
Console.WriteLine(5.1 >= 5.1);   // output: True
Console.WriteLine(0.0 >= 5.1);   // output: False
Console.WriteLine(double.NaN < 5.1);   // output: False
Console.WriteLine(double.NaN >= 5.1);  // output: False
~~~

### 3.5.3 Lógicos Booleanos
- desempenham um papel crucial no controle do fluxo de decisões e na execução de condições complexas. 
- esses operadores, incluindo AND, OR, NOT e XOR, são utilizados para combinar ou inverter valores booleanos (true ou false).

a) ***Negação lógica !***: calcula a negação lógica de seu operando. Ou seja, produz true se o operando for avaliado como false, e false se o operando for avaliado como true.

~~~csharp
bool passed = false;
Console.WriteLine(!passed);  // output: True
Console.WriteLine(!true);    // output: False
~~~

b) ***AND lógico &***: o resultado de x & y será true se ambos x e y forem avaliados como true. Caso contrário, o resultado será false.

~~~csharp
bool SecondOperand()
{
    Console.WriteLine("Second operand is evaluated.");
    return true;
}
bool a = false & SecondOperand();
Console.WriteLine(a);
// Output:
// Second operand is evaluated.
// False
bool b = true & SecondOperand();
Console.WriteLine(b);
// Output:
// Second operand is evaluated.
// True
~~~

c) ***OR lógico |***: o resultado de x | y será true se x ou y for avaliado como true. Caso contrário, o resultado será false.

~~~csharp
bool SecondOperand()
{
    Console.WriteLine("Second operand is evaluated.");
    return true;
}
bool a = true | SecondOperand();
Console.WriteLine(a);
// Output:
// Second operand is evaluated.
// True
bool b = false | SecondOperand();
Console.WriteLine(b);
// Output:
// Second operand is evaluated.
// True
~~~

d) ***AND lógico condicional &&***: também conhecido como operador AND lógico de "curto-circuito", computa o AND lógico de seus operandos.

~~~csharp
bool SecondOperand()
{
    Console.WriteLine("Second operand is evaluated.");
    return true;
}
bool a = false && SecondOperand();
Console.WriteLine(a);
// Output:
// False
bool b = true && SecondOperand();
Console.WriteLine(b);
// Output:
// Second operand is evaluated.
// True
~~~

e) ***OR lógico condicional ||***: também conhecido como operador OR lógico de "curto-circuito", computa o OR lógico de seus operandos:

~~~csharp
bool SecondOperand()
{
    Console.WriteLine("Second operand is evaluated.");
    return true;
}
bool a = true || SecondOperand();
Console.WriteLine(a);
// Output:
// True
bool b = false || SecondOperand();
Console.WriteLine(b);
// Output:
// Second operand is evaluated.
// True
~~~

## 3.6 Estrutura de Controle: Decisões e Loops

### 3.6.1 Decisões

pág 45




















--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)