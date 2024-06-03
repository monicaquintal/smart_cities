<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img align="right" height="120px" src="../assets/logo.png" /></a>
<h1>FASE 4 - FRAMEWORKS .NET</h1>
<h2>Capítulo 02: Preparando o Ambiente .NET.</h2>
</div>

<div align="center">
<h2>1. PREPARANDO O AMBIENTE .NET</h2>
</div>

## 1.1 Introdução

- .NET é um framework de software desenvolvido pela Microsoft e lançado inicialmente em 2002.
- a ideia era oferecer uma solução unificada que abrangesse uma variedade de necessidades de programação, desde o desenvolvimento de aplicações web e serviços baseados em nuvem até aplicativos móveis e de desktop; essa abordagem integrada visava resolver alguns dos desafios mais críticos, como a incompatibilidade entre plataformas e a complexidade na manutenção de código para diferentes sistemas operacionais.
- a Microsoft, ao desenvolver o .NET, não se limitou a oferecer um framework: ela estabeleceu um ecossistema completo, incluindo ferramentas de desenvolvimento, como o Visual Studio, e serviços de suporte, como o .NET Framework Class Library e o Common Language Runtime.
- com sua estrutura modular e suporte a serviços baseados em nuvem, permitiu o trabalho de maneira mais sincronizada e responsiva, adaptando-se rapidamente às mudanças nos requisitos do projeto e nas tendências do mercado.
- desde seu lançamento, o .NET passou por várias evoluções significativas. Uma das mais notáveis foi a introdução do .NET Core, uma versão cross-platform e open-source do .NET, que ampliou ainda mais o alcance e a aplicabilidade do framework. Essa mudança refletiu o compromisso da Microsoft com as tendências emergentes na tecnologia e seu apoio à comunidade de código aberto.

## 1.2 Componentes fundamentais do .Net

- o .NET é composto por vários componentes chave, cada um desempenhando um papel vital no desenvolvimento de software:
  - `Common Language Runtime (CLR)`: 
    - é o coração do .NET.
    - atua como um agente de execução que gerencia o código em tempo de execução, oferecendo serviços como gerenciamento de memória, threads e comunicação remota.
    - também garante segurança e precisão no código através de um sistema rigoroso de tipagem e verificações de código. 
    - uma característica importante é a compilação just-in-time (JIT), que converte o código gerido em linguagem de máquina nativa do sistema em que está sendo executado, melhorando o desempenho.
  - `Base Class Library (BCL)`:
    - esta biblioteca é uma vasta coleção de tipos reutilizáveis, orientada a objetos.
    - inclui desde a gestão de cadeias de caracteres e coleções até a conectividade de base de dados e acesso a arquivos. 
    - as bibliotecas do .NET facilitam o desenvolvimento de uma ampla gama de aplicações e serviços, incluindo aplicações de console, aplicações GUI do Windows (Windows Forms), Windows Presentation Foundation (WPF), ASP.NET para aplicações web, serviços do Windows etc.
  - `Framework Class Library (FCL)`: 
    - expansão da BCL, oferece mais funcionalidades, incluindo acesso a bancos de dados, desenvolvimento web. 
    - coleção de classes reutilizáveis, interfaces e tipos de valor que facilitam e otimizam o processo de desenvolvimento e proporcionam acesso à funcionalidade do sistema. 
    - inclui tipos que realizam funções como representação de tipos de dados básicos e exceções, encapsulamento de estruturas de dados, execução de operações de I/O, acesso a informações sobre tipos carregados, invocação de verificações de segurança do .NET, e fornecimento de acesso a dados. 
    - as classes do FCL são organizadas em namespaces para facilitar a busca e referência e podem ser usadas como estão ou derivadas para criar classes.
  - `ASP.NET`:
    - plataforma versátil e dinâmica para o desenvolvimento de aplicações web e serviços web. 
    - proporciona um ambiente rico para a construção de websites interativos, aplicações web integradas e serviços web, oferecendo recursos avançados de segurança, gerenciamento de estado, e integração de back-end. 
    - é ideal para desenvolver aplicações que exigem alto desempenho, confiabilidade, e uma experiência de usuário refinada e interativa.
  - `Interoperabilidade Linguística`:
    - os compiladores que visam o .NET Framework emitem um código intermédio chamado Common Intermediate Language (CIL), que é depois compilado pelo CLR, característica que permite que rotinas escritas em uma linguagem sejam acessíveis por outras linguagens, o que promove a flexibilidade e a reutilização do código.
  - `Compatibilidade de Versão e Execução Lado a Lado`: 
    - é projetado para ser compatível com versões anteriores, permitindo que as aplicações desenvolvidas em uma versão específica do .NET Framework funcionem sem modificação em versões posteriores. 
    - várias versões do .NET Framework podem coexistir no mesmo computador.
  - `Integração com Cloud e Big Data`:
    - .NET se adapta às tendências atuais de tecnologia, oferecendo integração com ambientes de Cloud Computing e Big Data.

## 1.3 Diferenças entre .NET Framework, .NET Core e .NET 7/8 

- cada uma dessas versões do .NET atende a diferentes necessidades e cenários de desenvolvimento.

### 1.3.1 .NET Framework
- lançado em 2002 pela Microsoft.
- representou um avanço no desenvolvimento de software, especialmente aplicações Windows e web. 
- projetado para simplificar o processo de desenvolvimento, oferecia aos programadores uma plataforma consistente repleta de bibliotecas e funcionalidades. 
- sua estrutura monolítica significava que todas os seus componentes, desde a interface gráfica até o acesso a dados, estavam fortemente integrados, proporcionando uma experiência de desenvolvimento coesa.
- dentro do .NET Framework, diversas tecnologias se destacam, como:
  - para o desenvolvimento de aplicações de desktop, Windows Forms era essencial. 
  - no contexto web, ASP.NET se tornou a base para construir páginas e aplicações web, integrando-se com o Internet Information Services (IIS) para otimizar desempenho e segurança. 
  - para acesso e manipulação de dados, ADO.NET se mostrou crucial, permitindo interações eficientes com bases de dados e suportando tanto operações simples quanto transações mais complexas, graças à sua arquitetura desconectada.
- apesar das vantagens, o .NET Framework tinha limitações notáveis:
  - a mais proeminente era sua incompatibilidade com o desenvolvimento de aplicações cross-platform. 
  - inicialmente, foi projetado exclusivamente para sistemas baseados em Windows, restringindo seu uso em ambientes de TI mais diversificados. 
  - a natureza monolítica do .NET Framework, embora benéfica para a integração de seus componentes, podia tornar as atualizações e a manutenção de sistemas mais complexos uma tarefa desafiadora. 
- com o tempo, essas limitações abriram caminho para novas implementações do .NET, como o .NET Core e o .NET 5+.

### 1.3.2 .NET Core
- introduzido pela Microsoft como uma resposta às crescentes demandas por aplicações mais versáteis e adaptáveis. 
- se destacou por sua capacidade de suportar o desenvolvimento de aplicações cross-platform.
- projetado com um foco especial na modularidade: os desenvolvedores tinham a liberdade de incluir apenas as bibliotecas e componentes necessários para suas aplicações, ao invés de depender de uma estrutura monolítica. 
- essa abordagem modular não apenas tornava as aplicações mais leves e eficientes, mas também facilitava a manutenção e atualização.
- outra característica fundamental é sua portabilidade: permitia alcançar uma base de usuários mais ampla sem a necessidade de reescrever o código para cada plataforma.
- também trouxe melhorias significativas no desempenho: otimizações no coletor de lixo (Garbage Collector), JIT (Just-In-Time) compilation e outras áreas garantiram que as aplicações construídas no .NET Core fossem mais rápidas e eficientes, o que era particularmente benéfico para aplicações de alto desempenho e serviços de nuvem.
- também refletiu uma mudança na filosofia de desenvolvimento da Microsoft, com um forte compromisso com o código aberto. 
- representou uma modernização significativa da plataforma .NET, abordando muitas das limitações do .NET Framework e introduzindo novos recursos e capacidades. 
- sua modularidade, portabilidade e desempenho aprimorado, juntamente com seu suporte ao código aberto, o tornaram uma escolha popular para desenvolvedores em todo o mundo.

### 1.3.3 .NET
- com o lançamento do .NET 5 e suas versões subsequentes (incluindo .NET 7/8), a Microsoft consolidou o .NET Framework e o .NET Core em uma única plataforma chamada .NET. 
- evolução contínua na busca por maior eficiência, flexibilidade e capacidade de atender às demandas crescentes do desenvolvimento moderno de software. 
- oferecem suporte aprimorado para desenvolvimento de aplicações cloud-native, microserviços, e containerização. 
- com a adoção crescente de práticas de DevOps, essas versões proporcionam integrações mais robustas com ferramentas de CI/CD (Continuous Integration/Continuous Delivery), facilitando a automatização do ciclo de vida de desenvolvimento de software.
- outra característica chave do .NET 7 e 8 é a ênfase na interoperabilidade e no desenvolvimento multiplataforma: com a inclusão do `MAUI (Multi-platform App UI)`, evolução do Xamarin.Forms, desenvolvedores têm à disposição um framework para criar interfaces de usuário que funcionam de forma consistente em diferentes plataformas: é possível desenvolver uma aplicação que tem uma ótima aparência e funcionamento tanto em iOS quanto em Android, além de desktops Windows e Mac, com uma base de código única.
- além disso, as atualizações de desempenho e as otimizações de memória continuam a ser um foco, o que é particularmente relevante para aplicações que processam grandes volumes de dados ou que exigem alta capacidade de resposta, como aplicações financeiras ou jogos.

### 1.3.4 Trajetória do .NET
- o .NET Framework, com sua abordagem monolítica e foco no desenvolvimento Windows e web, estabeleceu um forte alicerce, mas limitava-se ao ambiente Windows e enfrentava desafios na manutenção e atualizações. 
- o advento do .NET Core marcou uma virada significativa, introduzindo modularidade, suporte a desenvolvimento cross-platform, desempenho aprimorado e um compromisso com o código aberto, atendendo às necessidades de aplicações mais versáteis e adaptáveis.
- com o .NET 7/8, a Microsoft unificou as melhores características do .NET Framework e .NET Core, criando uma plataforma única que abrange aplicações Windows, Linux, macOS e desenvolvimento móvel; as versões mais recentes enfatizam eficiência, flexibilidade, suporte a práticas de DevOps, e desenvolvimento multiplataforma com ferramentas como MAUI, destacando-se na era atual de computação distribuída e cloud-native. Além disso, continuam a tradição de melhorias no desempenho e na otimização de memória, essenciais para aplicações de alto desempenho.
- ou seja, a evolução do .NET reflete esforço contínuo para atender às demandas crescentes e diversificadas do desenvolvimento de software moderno, oferecendo aos desenvolvedores uma plataforma robusta, versátil e eficiente para criar soluções inovadoras em uma variedade de plataformas e ambientes.

<div align="center">
<h2>2. PREPARANDO O AMBIENTE</h2>
</div>










--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)