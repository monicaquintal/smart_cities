<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img align="right" height="120px" src="../assets/logo.png" /></a>
<h1>FASE 4 - FRAMEWORKS .NET</h1>
<h2>Capítulo 04: Desenvolvimento Web com ASP.NET.</h2>
</div>

<div align="center">
<h2>1. DESENVOLVIMENTO WEB COM ASP.NET</h2>
</div>

- com .NET, as possibilidades de desenvolvimento abrangem uma ampla gama de aplicações e arquiteturas, permitindo aos desenvolvedores construir soluções robustas escaláveis e modernas. 
- exemplos de possibilidades:
  - `Criação de Microsserviço`: desenvolvimento de aplicações desacopladas e escaláveis, facilitando a manutenção e a implementação de funcionalidades específicas de negócio.
  - `Desenvolvimento de Aplicações Web com MVC`: utilizando o padrão Model-View-Controller (MVC) para criar aplicações web dinâmicas, organizadas e eficientes.
  - `Desenvolvimento de Aplicações de Página Única (SPA)`: uso de frameworks JavaScript em conjunto com .NET para criar experiências de usuário ricas e interativas em uma única página.
  - `APIs RESTful`: construção de interfaces de programação de aplicações (APIs) que seguem os princípios REST, permitindo a comunicação entre diferentes sistemas de forma eficiente.
  - `Desenvolvimento de Aplicações Desktop`: utilizando o Windows Presentation Foundation (WPF) ou o Universal Windows Platform (UWP).
  - `Desenvolvimento de Jogos com Unity`: utilização do .NET como base para desenvolver jogos complexos e interativos com o motor Unity.
  - `.NET Multi-Platform App UI`: foco em oferecer uma experiência de desenvolvimento moderna e unificada para aplicativos multiplataforma. O .NET MAUI simplifica o processo de criação de interfaces de usuário nativas em várias plataformas a partir de um único código-base em C#, utilizando as mais recentes práticas e tecnologias. Isso pode significar melhor integração, performance aprimorada e manutenção mais eficiente para projetos de aplicativos móveis e de desktop.
  - `Acesso a Dados com Entity Framework`: manipulação de dados de forma eficiente com o ORM (Object-Relational Mapping) Entity Framework, facilitando o acesso e a gestão de bancos de dados.
  - `Cloud Computing com Azure`: integração de aplicações .NET com serviços de nuvem do Azure, oferecendo escalabilidade, armazenamento, segurança e muito mais.
  - `Desenvolvimento de Aplicações IoT`: criação de soluções para a Internet das Coisas, permitindo que dispositivos se comuniquem e sejam gerenciados através de aplicações .NET.
  - `Machine Learning com ML.NET`: aplicação de técnicas de aprendizado de máquina em seus projetos .NET, utilizando o ML.NET para analisar dados e prever tendências.

<div align="center">
<h2>2. MICROSSERVIÇOS</h2>
</div>

## 2.1 Introdução a microsserviço

- a arquitetura de microsserviço emergiu como uma solução poderosa para construir aplicações escaláveis, resilientes e facilmente gerenciáveis. 
- divergindo da tradicional arquitetura monolítica, onde todos os componentes da aplicação estão interligados e dependentes, a abordagem de microsserviço ***propõe a divisão da aplicação em pequenos serviços independentes, cada um executando uma única função de negócio***. 

### 2.1.1 Comparação entre arquitetura monolítica e microsserviço
- escolha é fundamental no desenvolvimento de software, impactando diretamente a maneira como as aplicações são construídas, mantidas e escaladas.
- `arquitetura monolítica`:
  - todos os componentes da aplicação — interface do usuário, lógica de negócio, e acesso a dados — são integrados em um único código-base indissociável.
  - simplifica o desenvolvimento inicial e o deployment.
  - porém pode se tornar um obstáculo à escalabilidade e à manutenção conforme a aplicação cresce.
- `arquitetura de microsserviço`:
  - fragmenta a aplicação em serviços menores e independentes, cada um responsável por executar uma função específica de negócio. 
  - os serviços comunicam-se através de APIs bem definidas, permitindo desenvolvimento, teste, deployment e escalabilidade de maneira mais granular e isolada. 
  - promove a modularidade, facilita a implementação de novas tecnologias e padrões, e suporta uma escalabilidade mais eficiente ao permitir que apenas componentes específicos sejam escalados conforme a necessidade.

### 2.1.2 Benefícios e desafios do microsserviço
- como qualquer inovação tecnológica, traz consigo um conjunto de benefícios e desafios. 
- vantagens: escalabilidade aprimorada, flexibilidade tecnológica e resiliência operacional.
- obstáculos: complexidade do gerenciamento, consistência dos dados e questões de segurança. 

### 2.1.3 Benefícios 
- `Escalabilidade`: permitem a escalabilidade de partes específicas da aplicação conforme a demanda, sem a necessidade de escalar toda a aplicação.
- `Resiliência`: falhas em um microsserviço específico geralmente não afetam o funcionamento de outros serviços, aumentando a estabilidade geral da aplicação.
- `Flexibilidade Tecnológica`: cada microsserviço pode ser desenvolvido, testado e deployado utilizando as tecnologias mais adequadas para sua função específica.
- `Facilidade de Manutenção e Atualização`: a independência entre os serviços facilita a atualização, manutenção e deploy, permitindo inovações rápidas e reduzindo o risco de impactar outras partes do sistema.
- `Desenvolvimento Paralelo`: times diferentes podem trabalhar em diferentes microsserviço simultaneamente, acelerando o desenvolvimento.

### 2.1.4 Desafios 
- `Complexidade de Gerenciamento`: a orquestração e o monitoramento de múltiplos serviços independentes podem ser complexos, exigindo ferramentas e expertise especializados.
- `Consistência de Dados`: manter a consistência e integridade dos dados entre serviços independentes pode ser desafiador.
- `Custo de Infraestrutura`: cada microsserviço pode requerer sua própria instância de banco de dados ou ambiente de execução.
- `Complexidade de Comunicação`: comunicação entre serviços através de redes pode introduzir latência e pontos de falha adicionais.
- `Desafios de Segurança`: a superfície de ataque é ampliada com múltiplos pontos de entrada, exigindo uma gestão de segurança robusta e abrangente.

## 2.2 .Net Core e sua relevância para microsserviço

- .NET é um framework open-source e multiplataforma para a construção de aplicações modernas, conectadas à internet, como web apps, IoT apps e microsserviço. 
- sua leveza, desempenho e modularidade o tornam ideal para construir microsserviço, pois permite que desenvolvedores implementem, testem e deployem serviços de forma independente.
  - `Leveza e Modularidade`: .NET foi desenhado para permitir que desenvolvedores incluam apenas os componentes necessários para suas aplicações, reduzindo o overhead e melhorando o desempenho.
  - `Desenvolvimento e Deploy Multiplataforma`: .NET pode ser desenvolvido e executado em Windows, Linux e macOS, o que facilita a construção de aplicações que precisam rodar em diferentes ambientes.
  - `Integração com Containers`: ASP.NET Core se integra naturalmente com tecnologias de container como Docker, facilitando o empacotamento, deploy e escalabilidade de microsserviço.

## 2.3 Integração com Docker 

- o Docker proporciona um ambiente de containerização que encapsula o microsserviço e suas dependências em um container isolado, o que assegura que o microsserviço funcione de maneira consistente em qualquer ambiente.
  - `Desenvolvimento e Implantação Simplificados`: a integração do ASP.NET Core com Docker simplifica o ciclo de vida de desenvolvimento, testes e implantação de microsserviço, promovendo práticas de DevOps e integração contínua.
  - `.NET e Docker`: a imagem base do .NET no Docker Hub permite que desenvolvedores comecem rapidamente a desenvolver e containerizar aplicações .NET, incluindo serviços construídos com ASP.NET Core.

## 2.4 Orquestração Kurbernetes

- a orquestração de containers com Kubernetes oferece uma gestão eficiente de containers em larga escala, essencial para operar microsserviçoem produção.
  - `Gerenciamento de Deploy e Escala`: Kubernetes automatiza o deploy e a escala de microsserviço baseados em ASP.NET Core, lidando com a complexidade de gerenciar múltiplos containers.
  - `Integração .NET`: o ecossistema .NET, especialmente com projetos como o Steeltoe, facilita o desenvolvimento de microsserviço .NET prontos para a nuvem, que podem ser gerenciados por Kubernetes, aproveitando suas funcionalidades de descoberta de serviços, configuração e gerenciamento de segredos.

> A sinergia entre ASP.NET Core, Docker e Kubernetes constitui uma plataforma poderosa para o desenvolvimento, implantação e gerenciamento de microsserviço em C#: `ASP.NET Core` fornece a base sólida e flexível para construir microsserviços eficientes; o `Docker` simplifica a containerização e implantação desses serviços; `Kubernetes` oferece as ferramentas necessárias para sua orquestração em produção. 

<div align="center">
<h2>3. APLICAÇÕES WEB COM MVC</h2>
</div>

## 3.1 Introdução ao MVC (Model-View-Controller)

- é um padrão de arquitetura de software essencial para o desenvolvimento de aplicações web, promovendo a separação de responsabilidades em três componentes principais: Model, View e Controller. 
- ***Model*** representa a lógica de negócios e os dados, ***View*** é a interface de usuário que exibe os dados, e ***Controller*** lida com a entrada do usuário, manipula o modelo e seleciona a view para renderizar. 
- este padrão facilita manutenção, testabilidade e escalabilidade das aplicações, permitindo aos desenvolvedores trabalhar de forma mais organizada e eficiente.
- é uma das arquiteturas de software mais adotadas no desenvolvimento de aplicações web, dada a sua capacidade de separar as responsabilidades de uma aplicação, facilitando a manutenção, a expansão e a testabilidade do código.
  - `Model`: 
    - representa a camada de dados da aplicação.
    - é responsável por gerenciar as regras de negócio, os dados e as lógicas de aplicação.
    - interage com o banco de dados, realiza consultas, insere informações e trata os dados, enviando-os de volta ao controller ou diretamente para a view, dependendo da arquitetura implementada.
  - `View`: 
    - camada de apresentação, onde os dados solicitados são exibidos ao usuário.
    - é responsável por definir exatamente como os dados serão apresentados, transformando-os em uma interface gráfica compreensível e interativa. 
    - em aplicações .NET, as views são comumente construídas usando Razor, uma sintaxe que permite embutir código C# diretamente no HTML.
  - `Controller`: 
    - atua como intermediário entre o Model e a View.
    - recebe as solicitações do usuário, interpreta-as (com ajuda de rotas e parâmetros), solicita dados ao Model, recebe esses dados de volta e então seleciona uma View para apresentar os dados ao usuário. 
    - é o coração da aplicação, coordenando o fluxo de informações e as interações entre Model e View.

> A arquitetura MVC é amplamente utilizada em frameworks .NET, como ASP.NET MVC, que oferece um ambiente robusto, com suporte a roteamento, model binding, filtros e muito mais, facilitando a criação de aplicações web escaláveis e seguras.

## 3.2 Por que MVC?

- é uma evolução na maneira como pensamos e estruturamos as aplicações.
- esta arquitetura traz clareza, modularidade e eficiência ao processo de desenvolvimento.

## 3.3 Benefícios 
- `Separação de Responsabilidades`: capacidade de separar a aplicação em três componentes interconectados, mas independentes, o que facilita gerenciamento do código, manutenção e atualização da aplicação.
- `Desenvolvimento e Manutenção Facilitados`: é possível que diferentes equipes trabalhem em partes distintas da aplicação (Model, View, Controller) simultaneamente, otimizando tempo de desenvolvimento. Além disso, a manutenção se torna menos onerosa, pois atualizações em um componente específico raramente exigem alterações em outros.
- `Testabilidade Aprimorada`: a clara divisão entre lógica de negócios, interface do usuário e controle de entrada facilita a implementação de testes automatizados; cada parte da aplicação pode ser testada de forma isolada, garantindo maior qualidade e estabilidade do software.
- `Reutilização de Código e Flexibilidade`: permite que os desenvolvedores criem bibliotecas de modelos e controladores que podem ser reaproveitados em diferentes projetos; o que estende-se à capacidade de mudar a interface do usuário (View) sem alterar a lógica de negócios subjacente.
- `Adaptabilidade a Mudanças`: o MVC, com sua estrutura modular, permite atualizações e melhorias contínuas sem necessidade de reescrever a aplicação do zero.

## 3.4 Desafios 

- `Curva de aprendizado acentuada`: desenvolvedores novos no padrão MVC e no ecossistema .NET podem encontrar uma curva de aprendizado íngreme - a compreensão do fluxo de dados, a separação de responsabilidades e a aplicação das melhores práticas demandam um investimento inicial em aprendizado e adaptação. 
- `Gestão de complexidade em aplicações volumosas`: gerenciar um número extensivo de views e controllers em aplicações de grande escala pode ser um desafio considerável, exigindo arquitetura sólida e planejamento cuidadoso - requer abordagem estruturada, empregando padrões de design como DDD (Domain-Driven Design) e práticas como modularização e uso de áreas para manter o projeto organizado e gerenciável.
- `Integração com sistemas legados`: a solução para esse desafio envolve criação de estratégia de integração detalhada, que muitas vezes passa por um processo de modernização incremental, wrappers ou adaptadores para garantir a comunicação eficaz entre os sistemas.

> Em conclusão, MVC não é apenas uma escolha arquitetônica; é uma estratégia de desenvolvimento que coloca ordem no caos, transformando a complexidade em simplicidade gerenciável. Sua implementação em projetos, especialmente naqueles baseados em .NET, abre portas para um desenvolvimento ágil, eficiente e, acima de tudo, sustentável a longo prazo.

## 3.5 MVC ultrapassado?

- com o avanço das tecnologias e o surgimento de novos padrões e frameworks de desenvolvimento, é natural questionar a atualidade e relevância de padrões estabelecidos como o MVC. 
- algumas considerações incluem:
  - `Evolução dos Frameworks`: novos frameworks e bibliotecas, especialmente no desenvolvimento front-end (como React, Vue.js e Angular), introduziram abordagens diferentes para a construção de interfaces de usuário, que podem ou não seguir estritamente o padrão MVC. Esses frameworks tendem a enfatizar mais a reatividade e o data binding bidirecional, o que pode desviar-se da separação tradicional proposta pelo MVC.
  - `Microsserviço e Arquiteturas Descentralizadas`: questões sobre a adequação do MVC em contextos em que a modularidade e a independência entre os componentes são críticas.
  - `Performance e Escalabilidade`: projetos de grande escala ou de alta performance podem exigir abordagens arquitetônicas mais especializadas para atender a requisitos específicos de escalabilidade e eficiência.
  - `Preferências e Necessidades do Projeto`.

## 3.6 Exemplo – Criando um projeto 

- inicie o Visual Studio e crie um projeto clicando em “Create a new project”.
- selecione a opção "Aplicativo WEB do ASP.NET Core Web App (Model-View-Controller)".
- definir o nome do projeto, o local no sistema de arquivos e o nome da solução: Fiap.Web.Alunos será o nome do projeto e da solução.
- na próxima etapa, definir configurações:
  - Estrutura: .NET 8.0 (Suporte de Longo Prazo), indicando que o projeto será construído usando essa versão estável e com suporte estendido do .NET.
  - Tipo de Autenticação: inicialmente deixaremos selecionado o “Nenhum”.
  - Configurar HTTPS: deixaremos configurado para usar o protocolo HTTPS, garantindo que os dados transmitidos entre o cliente e o servidor sejam criptografados.
  - Habilitar o Docker: deixando habilitado, o projeto será configurado para rodar dentro de um container Docker. 
  - Sistema Operacional do Docker: pode ser Windows ou Linux.
  - Não use instruções de nível superior: quando marcada, instrui o Visual Studio a não usar as mais recentes instruções de nível superior do C# no ponto de entrada do programa.
- o Visual Studio criará o projeto baseado no template MVC:
  - `Connected Services`: diretório usado para gerenciar e configurar serviços externos aos quais o aplicativo pode se conectar, como bancos de dados em nuvem, APIs, serviços de autenticação, entre outros.
  - `Dependências`: bibliotecas e pacotes dos quais o projeto depende. Inclui pacotes NuGet, referências a projetos, bibliotecas, etc.
  - `Properties`: arquivos de configuração do projeto, como o arquivo AssemblyInfo.cs, que contém metadados sobre a compilação do assembly, como versão, informações de direitos autorais, etc.
  - `wwwroot`: diretório raiz da web que contém arquivos estáticos como HTML, CSS, JavaScript, imagens e outros arquivos que são servidos diretamente pelo servidor web.
  - `Controllers`: contém os controladores do MVC, responsáveis por responder às interações do usuário, trabalhar com o modelo e selecionar a view para renderizar a resposta do lado do servidor.
  - `Models`: inclui as classes que representam os dados e a lógica de negócios do aplicativo; usados para passar dados entre os controladores e as visualizações.
  - `Views`: contém as visualizações do MVC, que são os templates HTML utilizados para gerar a resposta do lado do servidor que é enviada ao cliente.
  - `appsettings.json`: arquivo de configuração que armazena configurações do aplicativo, como strings de conexão de banco de dados, configurações de serviços externos etc.
  - `Dockerfile`: script utilizado pelo Docker para criar uma imagem de container contendo o aplicativo e suas dependências, facilitando o deploy e a execução em qualquer ambiente que suporte Docker.
  - `Program.cs`: 
    - ponto de entrada do aplicativo ASP.NET Core, onde é configurado e iniciado o host web. 
    - dentro deste arquivo, o ***método Main*** (nem sempre declarado) é responsável por iniciar a execução da aplicação, configurando o ambiente de hospedagem por meio do método CreateHostBuilder. 
    - aqui, é possível definir o servidor web a ser utilizado e suas opções, como portas e certificados SSL. 
    - além disso, permite configurar o pipeline de requisição, adicionando middleware e definindo rotas dentro do método ConfigureWebHostDefaults. 
    - adicionalmente, é possível configurar serviços da aplicação e realizar injeção de dependência por meio do método ConfigureServices. 
    - em suma, o Program.cs desempenha um papel fundamental na inicialização e configuração de uma aplicação ASP.NET Core MVC, permitindo definir seu comportamento básico e suas configurações principais.

- no menu superior do Visual Studio, haverá uma barra de ferramentas com um dropdown que permite selecionar o perfil de execução do seu projeto.
  - se o Docker estiver configurado corretamente, você deve ver uma opção que permite executar o aplicativo em um container Docker. 
  - clique no botão verde "Start" (com o ícone de play) na barra de ferramentas para iniciar o projeto. Se o Docker for selecionado como o perfil de execução, o Visual Studio usará o Dockerfile para construir uma imagem do Docker e executar um container baseado nessa imagem.
  - tanto com a opção do Docker ou sem a opção do Docker, ao clicar no botão de execução o Visual Studio deve abrir uma janela do navegador apontando para a URL onde o aplicativo está sendo executado, geralmente algo como `http://localhost:porta`.

- esse resultado é possível graças ao `scaffold` (template) disponibilizado pela Microsoft, que simplifica consideravelmente o processo de inicialização de um projeto web.
  - permite dar início ao desenvolvimento da aplicação MVC de maneira mais ágil e eficiente. 
  - esses recursos oferecem uma estrutura básica predefinida. 
  - assim, é possível direcionar os esforços para o desenvolvimento das funcionalidades exclusivas da aplicação, em vez de se preocupar com a configuração inicial do projeto.

<div align="center">
<h2>4. CONTROLLERS</h2>
</div>

- atuam como os intermediários entre as solicitações do usuário e a lógica de negócios da aplicação. 
- são responsáveis por receber as requisições do cliente, tomar decisões com base nessas solicitações e coordenar a interação entre o modelo de dados e a camada de visualização. 
- são essenciais para estruturação e organização do código em uma aplicação MVC, garantindo uma separação clara entre a lógica de apresentação e a lógica de negócios. 
- controlam todo o fluxo de navegação e ações do usuário.

## 4.1 Explicando o código Controller 

- `HomeController`: responsável por gerenciar as respostas a algumas ações comuns em uma aplicação web, como visitar a página inicial, acessar uma página de privacidade e tratar erros.

~~~csharp
using Fiap.Web.Alunos.Models;
using Microsoft.AspNetCore.Mvc;
using System.Diagnostics;
namespace Fiap.Web.Alunos.Controllers
{
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;
        public HomeController(ILogger<HomeController> logger)
        {
            _logger = logger;
        }
        public IActionResult Index()
        {
            return View();
        }
        public IActionResult Privacy()
        {
            return View();
        }
        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}
~~~

## 4.2 Declaração de Controlador

~~~csharp
public class HomeController : Controller
~~~

- `Classe HomeController`: 
  - a ***classe Microsoft.AspNetCore.Mvc.Controller*** é uma classe que lida com as requisições HTTP. 
  - a herança em HomeController atribui funcionalidades para tratar requisições e retornar respostas, como views, a nossa classe HomeController.

## 4.3 Logging com ILogge

~~~csharp
private readonly ILogger<HomeController> _logger;
~~~

- `ILogger<HomeController>`: 
  - o logging é essencial para monitorar e diagnosticar comportamentos da aplicação. 
  - ILogger permite registrar logs de diferentes níveis de severidade (informação, erro, etc.). 
  - a forma de uso do ILogger no em nosso controller inicial é feito pela prática ou padrão da injeção de dependência (abordada mais adiante).

## 4.4 Ações do Controlador 

~~~csharp
public IActionResult Index()
        {
            return View();
        }
        public IActionResult Privacy()
        {
            return View();
        }
~~~

- os métodos `Index` e `Privacy` representam ações que podem ser executadas pelo controlador.
- cada método corresponde a uma rota ou caminho no navegador acessível por uma URL. 
- nesse caso, os métodos têm como retorno uma `interface IActionResult`, comumente utilizada para apresentar um componente do tipo View, o qual é renderizado ao usuário final em HTML.
  - `Index()`: geralmente serve como a página inicial da aplicação.
  - `Privacy()`: exemplo montado pelo scaffold para exibir uma página de política de privacidade. 
- as ações dos controladores do ASP.NET Core MVC (Microsoft.AspNetCore.Mvc.Controller) possuem outros tipos de retorno além da interface IActionResult; lista com suas respectivas funcionalidades:
  - `IActionResult`: retorna uma resposta HTTP para o cliente. Pode ser usado para retornar uma View, um JSON, um arquivo, entre outros tipos de respostas.
  - `ViewResult`: retorna uma View ao cliente, representando uma página HTML a ser exibida no navegador.
  - `JsonResult`: retorna um objeto serializado em formato JSON ao cliente, comumente utilizado para requisições AJAX.
  - `RedirectResult`: redireciona o cliente para outra URL especificada.
  - `FileResult`: retorna um arquivo ao cliente para download.
  - `ContentResult`: retorna um conteúdo específico ao cliente, geralmente usado para retornar texto ou XML.
  - `PartialViewResult`: retorna uma parte de uma View ao cliente, útil para carregamento assíncrono de componentes.
  - `StatusCodeResult`: retorna um código de status HTTP específico ao cliente, sem corpo de resposta.
  - `EmptyResult`: retorna uma resposta vazia ao cliente, geralmente usado para ações que não têm conteúdo para retornar.

## 4.5 Atributos de Ação (ou anotações)

- presentes nas linguagens C#, Java, Dart e muitas outras. 
- no caso do nosso HomeController, o scaffold implementou uma ação de cache para ações de erro.

~~~csharp
[ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
~~~

- `Atributo [ResponseCache]`: usado para controlar como as respostas das ações são armazenadas em cache. No método Error, ele é configurado para não armazenar cache, garantindo que as mensagens de erro sejam sempre atualizadas.
- exemplos de atributos de ação de uso mais comuns nos controllers: 
  - 1. `[HttpGet]`: especifica que a ação responde apenas a requisições HTTP GET.
  - 2. `[HttpPost]`: indica que a ação responde apenas a requisições HTTP POST.
  - 3. `[Route]`: define a rota específica para a ação, substituindo a rota padrão gerada pelo roteamento.
  - 4. `[Authorize]`: restringe o acesso à ação apenas a usuários autenticados.
  - 5. `[ValidateAntiForgeryToken]`: protege ataques CSRF (Cross-Site Request Forgery) verificando se o token anti-falsificação foi fornecido.
  - 6. `[AllowAnonymous]`: permite acesso anônimo à ação, mesmo em uma aplicação que requer autenticação global.
- esses atributos oferecem controle granular sobre o comportamento das ações nos controllers, permitindo a personalização do roteamento, restrição de acesso, proteção de ataques, entre outros recursos.

## 4.6 Tratamento de Erros 

~~~csharp
public IActionResult Error()
{
  return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
}
~~~

- trecho do código-fonte Action Error, que apresenta o método Error comoum padrão comum gerado pelo Visual Studio para lidar com erros em um Controller ASP.NET MVC. 
- sua função é retornar uma View específica para exibir mensagens de erro ao usuário quando ocorre uma exceção não tratada na aplicação. 
- quando uma exceção é lançada, o método Error é chamado automaticamente e uma instância da classe ErrorViewModel é passada para a View, contendo informações sobre o erro (ID da requisição e o identificador de rastreamento).
- permite que a View de erro exiba informações úteis para o usuário, como mensagens de erro personalizadas, informações de rastreamento para diagnóstico e possíveis soluções para resolver o problema. 
- o método Error desempenha um papel importante na experiência do usuário ao lidar com erros inesperados durante a execução da aplicação.

<div align="center">
<h2>5. VIEWS</h2>
</div>

- no framework ASP.NET Core MVC, as Views são `arquivos .cshtml`, baseados em HTML. 
- por convenção, são armazenadas na pasta "Views" e em subpastas com o nome do Controller associado.
- apenas HTML por si só não oferece a capacidade de tornar as páginas dinâmicas ou interativas, especialmente quando se trata de manipular e persistir informações em um banco de dados. 
	- para superar essa limitação, o ASP.NET Core MVC utiliza um mecanismo conhecido como `view engine`, que ***combina a linguagem C# com a marcação Razor***, permitindo que as Views sejam dinâmicas e possam interagir com o código C# do servidor. 
	- podemos fazer uma analogia com o JSP (JavaServer Pages) da linguagem Java e a Expression Language (EL), que facilita a inclusão de scriptlets.

## 5.1 ASP.NET Razor

- o Razor é um dos mecanismos do ASP.NET Core MVC (Web App) responsáveis por construir Views dinâmicas. 
- antes de seu lançamento, o mecanismo padrão era o ASPX, que utilizava scriptlets ASP.NET puro como base.
	- porém, apesar de ainda disponível para criação de projetos MVC, não é mais recomendado pelo framework devido às vantagens oferecidas pelo Razor.
- integrado pela primeira vez na versão do ASP.NET MVC 3, lançada em 2011.
- introduzido com o objetivo de simplificar a codificação na camada de View.
- `benefícios`:
	- ***uso da linguagem C# como base de scriptlets***: o Razor utiliza a linguagem C# como base para seus scriptlets, o que oferece uma experiência de codificação familiar para os desenvolvedores do .NET.
	- ***Sintaxe limpa, reduzindo o código***: a sintaxe do Razor é projetada para ser limpa e concisa, o que resulta em menos código e uma melhor legibilidade.
	- ***Simplificação do acesso aos componentes Model***: o Razor simplifica o acesso aos componentes do Model, permitindo que os desenvolvedores integrem facilmente dados dinâmicos em suas Views.
	- ***Facilidade de escrita de testes unitários para a camada de Views***: o Razor torna mais fácil escrever testes unitários para a camada de Views, facilitando a verificação do comportamento e da lógica da interface do usuário.
	- ***Autocompletar (IntelliSense) no Visual Studio***: o uso do Razor no Visual Studio oferece suporte a recursos de autocomplete (IntelliSense), o que ajuda os desenvolvedores a escrever código mais rapidamente e com menos erros.
	- ***Facilidade de uso de layouts predefinidos para todo o site***: facilita a definição e o uso de layouts predefinidos (como master pages) para todo o site, proporcionando uma consistência visual em todas as páginas.

> Para identificar uma expressão Razor em um arquivo .cshtml, basta observar blocos de código iniciados pelo caractere @.

~~~csharp
@{
    Layout = null;
}
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width" />
    <title>Homepage</title>
</head>
<body>
    <div>
        <h1>Nossa home-page.</h1>
    </div>
    @{
        for (int i = 0; i < 10; i++)
        {
            <p>@i</p>
        }
    }
</body>
</html>
~~~

## 5.2 Modos de Integração de dados com a View

- há diversas maneiras de integrar dados na camada de View do ASP.NET MVC. 
- a escolha da abordagem depende das necessidades específicas da aplicação e da preferência do desenvolvedor.
- algumas das principais são:
	- `Model Binding`: o ASP.NET MVC possui um recurso chamado Model Binding, que automaticamente mapeia os valores dos parâmetros de uma action para as propriedades de um objeto Model. Isso permite que os dados do Model sejam facilmente acessíveis na View.
	- `Passagem de dados via ViewBag e ViewData`: são mecanismos que permitem passar dados da Controller para a View; são úteis quando você precisa passar dados simples e não complexos para a View, como strings ou valores booleanos.
	- `Strongly Typed Views`: permitem que você defina explicitamente o tipo de dados que a View espera receber, utilizando um Model específico. Isso torna mais fácil e seguro acessar os dados do Model na View, pois você tem acesso ao IntelliSense e verificações de tipo durante o desenvolvimento.
	- `ViewModels`: são classes que representam os dados necessários para uma determinada View. Eles permitem agrupar dados de vários Models em um único objeto, tornando mais fácil e organizada a passagem de dados da Controller para a View. Os ViewModels são especialmente úteis quando uma View precisa exibir dados de várias entidades relacionadas.

## 5.3 Razor TagHelpers

- para facilitar o desenvolvimento na camada de View, o ASP.NET, utilizando o engine Razor, oferece elementos e tags personalizadas para exibir dados aos clientes da aplicação, conhecidas como TagHelpers. 
- essa praticidade, presente no framework ASP.NET Core MVC (Web App), disponibiliza componentes auxiliares para o desenvolvimento das Views.
- Tag Helpers, permitem definir e usar elementos HTML personalizados diretamente nas Views, tornando o código mais limpo e legível.
- os Helpers criam tags HTML com funcionalidades específicas, processadas pelo ASP.NET Core durante a renderização da página.
- algumas características dos Tag Helpers:
	- `sintaxe semelhante a HTML`: por ser escrito com sintaxe semelhante ao HTML, os Tag Helpers são mais fáceis de ler e escrever do que os helpers tradicionais do Razor.
	- `integração com IntelliSense do Visual Studio`: facilitando a descoberta e o uso dos Tag Helpers disponíveis.
	- `melhor manutenção do código`: permitem a separação do código de apresentação do código de lógica, simplificando a manutenção do código e o trabalho em equipe.
	- `Reutilização`: podem ser reaproveitados em várias Views, reduzindo a duplicação de código e mantendo uma consistência visual em toda a aplicação.

<div align="center">

Tag Helper | Método tipado
--------------|-------------------
Anchor tag helper | Link tag helper
Cache tag helper | Option tag helper
Environment tag helper | Partial tag helper
Form Action tag helper | Script tag helper
Form tag helper | Select tag helper
Imagem tag helper | Textarea tag helper
Input tag helper | Validation Message tag helper
Label tag helper | Validation Summary tag helper

</div>

- o exemplo abaixo apresenta a sintaxe para a criação de uma caixa de texto usando o helper e o código HTML gerado depois que o view engine renderiza o código da View.

~~~csharp
<!-- Tag Help -->
<input asp-for="DescricaoTipo" placeholder ="Digite a descrição." />
~~~

~~~html
<!-- Tag Help -->
<input placeholder="Digite a descrição." type="text" id="DescricaoTipo" name="DescricaoTipo" value/>
~~~

<div align="center">
<h2>6. IMPLEMENTANDO ASP.NET CORE WEB APP MVC</h2>
</div>

- agora serão implementados os códigos.
- a ideia é implementar uma funcionalidade simples, mas que demonstre o fluxo de navegação e a troca de informações entre as diferentes partes do sistema - a camada de visualização e o Controller.

## 6.1 Funcionalidades

- abordaremos o módulo de clientes e representantes. 
- a proposta é criar uma entidade simples que represente as informações de um cliente associado a um representante. 
- inicialmente não exploremos os modelos em detalhes, uma vez que são classes com propriedades básicas; posteriormente, poderemos aprimorar esse relacionamento no banco de dados.
- no Diagrama de Classe, temos:
	- Classe Representante: RepresentanteId, Cpf, NomeRepresentante (+ getters e setters).
	- Classe Cliente: ClienteId, Nome, SobreNome, DataNascimento, Observacao, Representante (+ getters e setters).
- o objetivo é construir os seguintes comportamentos ou funcionalidades:
	- criação de um novo cliente.
	- remoção de um cliente já existente.
	- alteração dos dados de um cliente.
	- listagem de todos os clientes cadastrados.
- os componentes da camada de modelo são simples classes C#, que devem ser adicionadas no namespace Models do projeto. 
- para criar o modelo `RepresentanteModel` e `ClienteModel`, clique com o botão direito na pasta Models e escolha a opção Add > Class. Defina o nome como `RepresentanteModel.cs` e `ClienteModel.cs`,  e adicione os atributos de cada uma das classes.

~~~csharp
namespace Fiap.Web.Alunos.Models
{
    public class RepresentanteModel
    {
        public int RepresentanteId { get; set; }
        public string? NomeRepresentante { get; set; }
        public string? Cpf { get; set; }
    }
}
~~~

~~~csharp
namespace Fiap.Web.Alunos.Models
{
    public class ClienteModel
    {
        public int ClienteId { get; set; }
        public string? Nome { get; set; }
        public string? Sobrenome { get; set; }
        public string? Email { get; set; }
        public DateTime DataNascimento { get; set; }
        public string? Observacao { get; set; }
        public int RepresentanteId { get; set; }
        public RepresentanteModel? Representante { get; set; }
    }
}
~~~

- detalhes importantes:
	- o destaque dado à funcionalidade do cliente serve como uma forma de ilustrar o relacionamento e a dependência presentes; nessa modelagem, um cliente está sempre associado a um representante.
	- após adicionar uma classe no seu projeto, observe o namespace declarado na classe a pasta que a classe foi adicionada, devemos manter sempre o nome. Verifique também se a classe está declarada como public.

## 6.2 Controllers e Actions

- em um projeto ASP.NET Core MVC, toda solicitação do usuário feita pelo navegador será recebida e gerenciada por um Controller, ficando este responsável por receber o pedido, acionar os componentes necessários e gerar a resposta para o navegador.
- podemos criar um Controller para cada funcionalidade da nossa aplicação (por exemplo: CriarProduto, ExcluirProduto, AlterarProduto e ListaProdutos), porém ***não é recomendado***. 
- para organizar melhor as funcionalidades, há os conceitos das `Actions`.
	- ***ações (Actions) são métodos adicionados na classe de controle com o objetivo de organizar e padronizar ainda mais o código***. Com o
	- com o seu uso, devemos criar um controlador para cada domínio e ações para cada funcionalidade (por exemplo: ControllerRepresentante, Actions Criar, Excluir, Alterar, Detalhar e Listar).
	- ***todo Controller necessita de uma Action***; caso não seja criada, nada será executado. 
- além da pasta Controller (namespace), a criação de Controllers e  Actions deve seguir algumas `particularidades`:
	- o nome da classe do controlador deverá ter o sufixo Controller (como: ClienteControlller, ProdutoController ou FavorecidoController).
	- os métodos que representam as ações devem ser declarados como públicos.
	- os métodos Actions não podem ser declarados como static.
	- os métodos Actions só podem ser sobrecarregados (overloading) com uso de Anotações (Attributes).
	- o mapeamento-padrão adota o nome de Index para a Action inicial de um Controller.
	- o retorno mais comum de uma Action é um componente View em HTML implementado pela classe ActionResult ou pela interface IActionResult.
	- é possível criar uma Action sem resposta.
	- uma Action tem o mapeamento um para um, ou seja, deve ser implementada para executar apenas uma ação.
- as Actions podem ser implementadas com algumas responsabilidades diferentes, como de apresentar uma View ao usuário, por exemplo, ações que serão responsáveis por retornar um arquivo para download.

## 6.3 Implementando Controllers

- clique com o botão direito do mouse na pasta Controllers do projeto e selecione a opção Add > Controller; o Visual Studio apresentará a janela Add Scaffold. 
- selecione a opção MVC Controller–Empty.
- o próximo passo é definir o nome do controlador (ClienteController): clique no botão Add e aguarde a criação. 
	- lembre-se que todo Controller deverá ter o sufixo Controller.
- agora podemos observar a classe criada no namespace Controllers; no código da classe Controller, é possível ver a importação do namespace Microsoft.AspNetCore.Mvc e a extensão da classe Microsoft.AspNetCore.Mvc.Controller. 
- como padrão da criação de todo Controller, a action Index foi adicionada na classe, por meio do método de mesmo nome, e o  retorno é um objeto do tipo IActionResult. 

~~~csharp
using Microsoft.AspNetCore.Mvc;

namespace Fiap.Web.Alunos.Controllers
{
	public class ClienteController : Controller {
		public IActionResult Index() {
			return View;
		}
	}
}
~~~

- com o Controller criado, agora podemos fazer o primeiro teste. 
- pressione a tecla F5 e aguarde o navegador-padrão do computador ser aberto. 
- com o navegador aberto, complemente o endereço com o caminho /Cliente e pressione Enter. 
	- o navegador vai exibir uma tela de erro informando que nenhuma View com o nome de Index foi encontrada. 
	- isso significa que o teste foi bem-sucedido (pois ainda não criamos a View).

## 6.4 Associando uma View e Controller

- criar a primeira View e validar a execução do Controller: a View será uma página HTML simples com uma mensagem de texto informando o nome do Controller e da Action.
- com o Controller ClienteController aberto na janela de edição, clique com o botão direito sobre o nome da Action Index e selecione a opção “Add View” (Adicionar edição) (uma janela com detalhes da View será apresentada). Selecione o modelo vazio.

> IMPORTANTE: Quando um projeto está em execução, alguns recursos de edição, como adicionar novos arquivos à solução, podem ficar indisponíveis temporariamente. Portanto, é importante parar o projeto antes de tentar adicionar novos arquivos à solução (clicar no botão Stop ou pressionar Shift + F5).

- também é possível criar uma View abrindo a pasta Views correspondente ao Controller desejado (por exemplo, Views/Cliente), criar um novo arquivo com o nome da Action desejada seguido da extensão cshtml (por exemplo, Index.cshtml para a action Index), e, em seguida, escrever diretamente o código HTML e Razor.
- com a View adicionada, verifique na janela Solution Explorer se na pasta “Views” foram adicionados uma subpasta Cliente e um arquivo Index.cshtml (arquivo da View).
- o próximo passo é editar o arquivo Index.cshtml e, no bloco body, adicionar uma mensagem com o nome do Controller e a Action à qual a View pertence.

~~~csharp
@{
    Layout = null;
}
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width" />
    <title>Index</title>
</head>
<body>
    <div>
        Executando Controller Cliente, a Action Index 
        e renderizando a View Index.cshtml
    </div>
</body>
</html>
~~~

- para testar o Controller, pressione F5, aguarde o navegador ser carregado, informe o caminho /Cliente/Index e pressione Enter: o Controller será executado novamente e a View Index será retornada.

## 6.5 Método de retorno – View()

- o Controller e a Action criados retornam para a requisição a View do mesmo nome da ação por meio método View().
- o método View() apresenta algumas sobrecargas, as quais permitem passagem de parâmetros para informar resultados diferentes, como outra View. 
  - podemos alterar a View-padrão, passando uma string como parâmetro, ou informar um objeto que será usado para a renderização da View. 

<div align="center">

Nome | Descrição
-----|---------------
View() | Cria um ViewResult objeto que renderiza uma exibição para a resposta.
View(Object) | Cria um ViewResult objeto especificando um model a ser renderizado pelo modo de exibição.
View(String) | Cria um ViewResult objeto especificando um viewName.
View(IView) | Cria um ViewResult que processa especificado do objeto IView objeto.
View(String, Object) | Cria um ViewResult objeto usando o nome de exibição e o modelo que processa um modo de exibição para a resposta.
View(String, String) | Cria um ViewResult objeto usando o nome e o nome da página mestra que processa um modo de exibição para a resposta.
View(IView, Object) | Cria um ViewResult que processa especificado do objeto IView objeto.
View(String, String, Object) | Cria um ViewResult objeto usando o nome de exibição, o nome da página mestra e o modelo que processa um modo de exibição.

</div>

<div align="center">
<h2>7. ROTAS E NAVEGAÇÃO</h2>
</div>

## 7.1 Convenções



















--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)