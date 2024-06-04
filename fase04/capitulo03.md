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




--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)