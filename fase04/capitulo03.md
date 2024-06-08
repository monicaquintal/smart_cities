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




















--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)