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















--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)