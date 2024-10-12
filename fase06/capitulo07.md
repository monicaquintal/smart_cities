<div align="center">
<a href="https://github.com/monicaquintal" target="_blank"><img align="right" height="120px" src="../assets/logo.png" /></a>
<h1>FASE 6 - DevOps</h1>
<h2>Capítulo 07: Hora do Compliance.</h2>
</div>

<div align="center">
<h2>1. HORA DO COMPLIANCE</h2>
</div>

## 1.1 O que é qualidade de software?

- qualidade de software é essencial para garantir que um produto atenda às necessidades e expectativas dos usuários, proporcionando uma experiência satisfatória e confiável. 
- softwares de alta qualidade oferecem uma série de benefícios, como a redução de bugs, que causam frustração e diminuem a confiança no produto. 
  - um software bem projetado e testado minimiza esses problemas, oferecendo uma experiência de uso mais fluida e agradável.
- além disso, a qualidade de software ajuda a minimizar os custos de manutenção. 
  - quando um software for desenvolvido com boas práticas de engenharia e exaustivamente testado antes do lançamento, os problemas são detectados e corrigidos precocemente, reduzindo a necessidade de constantes atualizações e correções de bugs após o lançamento, economizando tempo e recursos.
- o último ponto, embora não menos relevante, é o aumento da confiança do usuário. 
  - usuários que percebem que um software é confiável e funciona conforme esperado tendem a usá-lo com mais frequência e a recomendá-lo a outros, o que impacta diretamente o sucesso comercial de um produto. 
  - usuários satisfeitos são mais propensos a continuar usando o software, adquirir atualizações ou serviços adicionais e falar positivamente sobre o produto.

### 1.1.1 Exemplos práticos de impacto da qualidade de software

- a qualidade de software deve ser uma preocupação constante, garantindo uma experiência satisfatória e confiável para todos os usuários, independentemente da finalidade do software.

### 1.1.2 Entendendo bugs

- trata-se de um erro ou defeito no código ou na lógica do software que causa um comportamento indesejado ou inesperado. 
- outro ponto importante é o processo de depuração, ou "debugging": quando
estamos debugando um código, estamos nos referindo ao processo de localizar e corrigir erros ou bugs no código-fonte de um software. 
- quando o software não funciona conforme o esperado, os desenvolvedores analisam o código em modo debug para determinar as causas dos erros. 
- debug é uma prática essencial na programação, pois permite identificar, corrigir e prevenir bugs em códigos das mais diferentes naturezas.
- os bugs de software podem ser classificados de algumas maneiras, dependendo de seu impacto, origem ou natureza, sendo alguns dos tipos mais comuns:
  - A. `Bugs funcionais`: relacionados a funcionalidades específicas do software que não funcionam conforme o esperado. Um exemplo clássico seria um botão que deveria salvar dados, mas não realiza essa operação.
  - B. `Bugs de desempenho`: afetam diretamente a velocidade e a eficiência do software. Por exemplo, um aplicativo que demora muito tempo para carregar ou processar dados é um caso típico desse tipo de bug, onde o desempenho inadequado pode comprometer a experiência do usuário e a funcionalidade geral do sistema.
  - C. `Bugs de interface do usuário (UI)`: envolvem problemas na interface gráfica que afetam a usabilidade. Por exemplo, elementos da interface que estão fora de lugar ou botões que não respondem ao clique.
  - D. `Bugs de segurança`: referem-se a vulnerabilidades no software que podem ser exploradas para comprometer sua segurança. Um exemplo clássico desse tipo de bug é uma falha que permite o acesso não autorizado a dados sensíveis, colocando em risco a integridade e a confidencialidade das informações armazenadas no sistema.
  - E. `Bugs de compatibilidade`: ocorrem quando o software não funciona corretamente em diferentes ambientes ou dispositivos. Um exemplo seria um aplicativo que opera bem no iOS, mas apresenta problemas no Android.
  - F. `Bugs de conectividade`: são problemas que surgem na comunicação entre o software e outras aplicações ou redes. Um exemplo comum é a falha na conexão com um servidor ou a dificuldade de integrar corretamente com APIs de terceiros, o que pode interromper o fluxo de dados e impactar a funcionalidade do software.
  - G. `Bugs de dados`: dizem respeito a problemas na manipulação e armazenamento de dados, como quando dados são corrompidos durante a gravação ou informações são lidas incorretamente do banco de dados.
  - H. `Bugs de lógica`: ocorrem quando há falhas na lógica de programação, resultando em resultados incorretos. Um exemplo típico é um cálculo matemático que retorna um resultado errado devido a um erro na fórmula implementada, o que pode levar a comportamentos inesperados e comprometer a funcionalidade do software.
  - I. `Bugs de usabilidade`: afetam a facilidade com que os usuários interagem com o software. Um exemplo é um fluxo de navegação confuso ou difícil de entender, que pode dificultar a experiência do usuário e tornar o software menos intuitivo e acessível.
  - J. `Bugs de instalação`: são problemas que afetam a instalação ou atualização do software. Um exemplo é uma falha durante o processo de instalação que impede que o software seja instalado corretamente, o que pode impedir o usuário de utilizar o produto.
  - K. `Bugs de integração`: surgem quando diferentes módulos ou sistemas são combinados e enfrentam problemas. Um exemplo é quando módulos funcionam bem de forma independente, mas falham ao serem integrados, o que pode comprometer a funcionalidade geral do sistema.

- entender os tipos de bugs e como podem ocorrer em um produto são aspectos cruciais para a qualidade e a eficácia de qualquer software. 
- diferentes tipos de bugs afetam várias dimensões do produto, desde funcionalidades e desempenho até a usabilidade e segurança. 
- a compreensão desses diversos problemas permite uma abordagem mais estruturada na identificação e correção, garantindo que o software atenda aos padrões esperados e ofereça uma experiência satisfatória ao usuário.

### 1.1.3 Entendendo os tipos de testes

- testes de software são essenciais para garantir que um produto atenda aos requisitos de qualidade e funcione conforme esperado. 
- cada tipo de teste desempenha um papel específico no ciclo de desenvolvimento, e entender suas características ajuda a assegurar um software robusto e confiável.

- 1. `testes de unidade`:
  - realizados no nível do código-fonte e focados em métodos e funções individuais.
  -  são conhecidos por sua automação eficiente, rápida execução e facilidade de diagnóstico.
  - exemplo: um teste de unidade pode verificar se uma função que soma dois números retorna o resultado correto, garantindo que a função retorne 8 ao somar 3 e 5.
- 2. `testes de integração`:
  - complementam os testes de unidade ao avaliar como diferentes módulos ou serviços interagem quando combinados. 
  - esses testes identificam problemas nas interfaces entre módulos, como incompatibilidades de dados ou falhas de comunicação. 
  - exemplo: em um aplicativo de lista de tarefas, um teste de integração verificaria se uma nova tarefa adicionada aparece corretamente na lista, garantindo que os módulos de adicionar e exibir tarefas funcionem bem juntos.
- 3. `testes funcionais`:
  - focam nos requisitos de negócios da aplicação. 
  - eles avaliam se a aplicação atende às especificações fornecidas, concentrando-se na saída resultante de uma ação específica, sem considerar os estados intermediários do sistema. 
  - por exemplo, em um aplicativo de reservas de restaurantes, um teste funcional pode verificar se a funcionalidade de reserva de mesa está operando corretamente, garantindo que a confirmação seja enviada ao usuário com as informações corretas.
- 4. `testes de regressão`:
  - verificam se alterações no código introduziram novos defeitos em partes já testadas do software. 
  - garantem a estabilidade das funcionalidades existentes após mudanças, correções ou adições de novas funcionalidades. 
  - exemplo: após implementar uma nova funcionalidade de recomendação em um aplicativo de compras online, os testes de regressão garantiriam que a funcionalidade de pagamento não foi afetada, ajudando a identificar problemas como erros no cálculo do total do carrinho.
- 5. `testes de desempenho`:
  - avaliam como o sistema se comporta sob diferentes cargas de trabalho, medindo a confiabilidade, velocidade, escalabilidade e capacidade de resposta do aplicativo. 
  - exemplo: um teste de desempenho em um aplicativo de streaming de vídeo pode revelar gargalos na capacidade do servidor ao lidar com muitos usuários simultâneos, indicando a necessidade de melhorias na infraestrutura.
- 6. `testes de segurança`:
  - essenciais para garantir que o software esteja protegido contra ameaças e vulnerabilidades.
  - incluem testes de penetração para simular ataques e identificar falhas de segurança, além de análises de vulnerabilidades e verificação de conformidade co m normas de segurança.
  - exemplo: em um aplicativo bancário online, um teste de penetração pode revelar uma vulnerabilidade na autenticação de dois fatores, destacando a necessidade de correção para proteger os dados financeiros dos usuários.
- 7. `testes exploratórios`:	
  - oferecem uma abordagem diferenciada.
  - permitem que os testadores explorem o software de forma criativa e intuitiva, sem seguir um roteiro predefinido. 
  - esse tipo de teste é valioso para descobrir problemas que não são facilmente encontrados em testes formais. 
  - exemplo: em um aplicativo de e-commerce, um teste exploratório pode identificar que a aplicação apresenta lentidão ao aplicar vários filtros de pesquisa rapidamente, um problema que pode passar despercebido em testes automatizados.

> É crucial para o sucesso de qualquer projeto, inicialmente, se concentrar nos `testes de unidade e integração`!

- `testes de unidade` assegurarão que as funções e métodos individuais sejam eficazes, enquanto os `testes de integração` assegurarão que os diferentes módulos do software interajam de acordo com o esperado. 
- a implementação desses testes é crucial para manter um nível mínimo de qualidade e estabilidade, independentemente da linguagem de programação utilizada, uma vez que a maioria das bibliotecas oferece suporte a eles.

### 1.1.4 Entendendo os testes de caixa branca e caixa preta

- `teste de caixa branca`:
  - também conhecido como teste estrutural ou teste de caixa clara.
  - é uma abordagem onde o testador possui acesso ao código-fonte, estrutura interna e design do software. 
  - esta técnica concentra-se na verificação da lógica interna do código, incluindo caminhos de execução, fluxos de controle, condições e loops.
  - características principais incluem:
    -  acesso ao código-fonte, que permitem ao testador identificar pontos críticos para teste;
    - cobertura de caminhos, avaliando todos os caminhos possíveis no código, como decisões e loops;
    - validação da lógica, assegurando que a lógica interna esteja correta e que todas as condições sejam tratadas de maneira apropriada.

- `teste de caixa preta`:
  - se concentra nas funcionalidades do software sem considerar sua estrutura interna. 
  - o testador não possui conhecimento sobre o código-fonte e foca apenas nas entradas e saídas para verificar se o software atende aos requisitos e especificações definidos. 
  - essa abordagem é baseada nos requisitos do sistema e simula a perspectiva do usuário final, assegurando que o software funcione conforme esperado do ponto de vista do usuário.

> esses métodos ilustram a diferença fundamental entre ter visibilidade dos processos internos (caixa branca) e testar com base apenas nas funcionalidades externas e requisitos (caixa preta).

### 1.1.5 Pirâmide de testes
- pirâmide de testes é um conceito que sugere uma proporção ideal de diferentes tipos de testes para garantir uma cobertura eficiente e eficaz. 
- a base da pirâmide é formada por testes de unidade, seguidos por testes de integração no meio, e testes funcionais no topo. 
- esse formato ajuda a garantir que o desenvolvimento do software seja eficiente e que os testes forneçam feedback rápido e relevante. 
- a maioria dos testes deve estar na base devido à sua velocidade e baixo custo; à medida que se sobe na pirâmide, os testes tornam-se mais lentos e caros, por isso devem ser menos numerosos. 
  - essa distribuição ajuda a detectar e corrigir problemas de forma eficiente e econômica.

<div align="center">
<img src="./assets/ilustracao-piramide-testes.png" width="60%"><br>
<em>Ilustração da pirâmide de testes.</em><br>
</div>

- há uma uma norma internacional no mercado, a `ISO/IEC 25010:2011`, indispensável para definir e avaliar a qualidade de um software. 
- esta norma estabelece um padrão para a qualidade de sistemas e produtos de software, garantindo que atendam às necessidades dos usuários e atendam às suas necessidades funcionais e não funcionais. 
- a ISO/IEC 25010:2011 é amplamente reconhecida e utilizada na indústria para assegurar que os produtos de software sejam seguros, eficientes e satisfatórios.
-  ela ***divide a qualidade em duas categorias principais***: qualidade do uso e qualidade do produto. 
  - **qualidade de uso**: se concentra na experiência do usuário final.
  - **qualidade do produto**: abrange as características inerentes ao software. 
- esta divisão tem como objetivo auxiliar as organizações na avaliação e melhoria tanto da experiência do usuário quanto dos aspectos técnicos do software.

## 1.2 Qualidade do produto de software - ISO/IEC 25010:2011

- a qualidade de um software é um objetivo essencial no processo de desenvolvimento; por isso, ao criar um produto digital, é importante definir antecipadamente as características de qualidade que se deseja alcançar.
- a ISO/IEC 25010 é um padrão internacional de qualidade de software, lançado em 2011, substituindo a ISO/IEC 9126. 
- ela apresenta um modelo de qualidade de software atualizado e abrangente.
- esse modelo de qualidade consiste em um conjunto bem definido de características e categorias de atributos de qualidade, além das relações entre elas.
- ele fornece a estrutura necessária para especificar os requisitos de qualidade e avaliá-los de maneira eficaz.
- a importância da ISO/IEC 25010 está em fornecer um padrão reconhecido globalmente, ajudando a garantir que o software desenvolvido atenda às expectativas de qualidade tanto dos desenvolvedores quanto dos usuários finais, o que resulta em produtos mais eficientes, seguros e satisfatórios, promovendo a confiança e a satisfação do cliente.
- a estrutura está organizada em dois modelos: modelo de qualidade em uso (composto por 5 características) e o modelo de qualidade do produto (composto por 8 características).

### 1.2.1 Modelo de qualidade em uso - ISO/IEC 25010:2011
- modelo de qualidade em uso analisa a qualidade de um sistema ou produto de software a partir da perspectiva do usuário final, em um contexto operacional específico. 
- esse modelo vai além das métricas técnicas e avalia como o software é percebido e utilizado na prática, levando em consideração diversos ***fatores essenciais para garantir uma experiência satisfatória e eficaz***; destacam-se:
  - `eficácia`:
    - mede a precisão com que os usuários atingem seus objetivos ao utilizar o software.
    - exemplo positivo: Google Search, que se destaca por fornecer resultados de pesquisa relevantes e precisos de forma rápida. 
    - exemplo de baixa eficácia: lançamento inicial do aplicativo de mapas da Apple em 2012, com direções imprecisas e dados cartográficos incorretos.
  - `eficiência`:
    - avalia o uso de recursos em relação à eficácia alcançada. 
    - exemplo de eficiência positiva: Amazon Prime, oferecendo entregas rápidas com um custo relativamente baixo para os usuários. 
    - exemplo de eficiência menor: sistema de check-out automatizado de algumas redes de supermercados, que frequentemente enfrenta problemas técnicos e atrasos.
  - `satisfação`:
    - avalia o conforto e as atitudes positivas dos usuários em relação ao software. 
    - exemplo de alta satisfação: aplicativo de mensagens e canais corporativo Slack , com sua interface intuitiva e experiência agradável. 
    - exemplo de baixa satisfação dos usuários: Windows Vista, lançado em 2007 e criticado por sua interface confusa e problemas de desempenho.
  - `segurança`:
    - considera o risco de consequências adversas, como problemas físicos ou financeiros. 
    - exemplo positivo: gerenciador e cofre de senhas LastPass, com suas robustas medidas de segurança. 
    - falha significativa em termos de segurança: vazamento de dados do Facebook em 2018, que expôs informações pessoais de milhões de usuários
  - `cobertura do contexto`:
    - refere-se à capacidade do software de funcionar bem em diferentes ambientes e cenários. 
    - exemplo de boa cobertura do contexto: Microsoft Office, que oferece suporte para diversas plataformas e dispositivos. 
    - exemplo negativo: versão inicial do Apple Maps, criticada por sua imprecisão e falta de suporte para diferentes contextos e usos, especialmente quando comparado ao Google Maps da época.

<div align="center">
<img src="./assets/modelo-qualidade-em-uso.png" width="80%"><br>
<em>Diagrama qualidade em uso.</em><br>
</div>

### 1.2.2 Modelo de qualidade do produto - ISO/IEC 25010:2011

- o modelo de qualidade do produto avalia as características internas e externas de um software.
- é dividido em oito principais categorias, onde cada uma delas oferece uma visão detalhada de como o software atende às expectativas e necessidades dos usuários, refletindo a sua eficácia geral:
  - 1. `Adequação funcional`: examina sua capacidade de atender às necessidades e expectativas dos usuários através de suas funções e recursos; pode ser analisado sob três principais dimensões:
    - A. Primeiramente, a ***completude funcional*** avalia se o software possui todas as funções necessárias para realizar as tarefas previstas. Exemplo: Microsoft Excel, que disponibiliza uma ampla gama de funções e ferramentas para a criação e análise de planilhas. Essa variedade de funcionalidades atende a diferentes necessidades, tanto empresariais quanto acadêmicas, garantindo que o Excel seja uma solução abrangente e versátil. Em contraste, muitos aplicativos de planilhas mais simples ou gratuitos, como o Google Sheets em sua versão inicial, apresentavam limitações em funcionalidades avançadas. Essas restrições poderiam restringir a capacidade dos usuários de realizar tarefas complexas, evidenciando uma lacuna na completude funcional.
    - B. A ***correção funcional*** refere-se à precisão dos resultados produzidos pelas funções do software. O Google Calculator é um exemplo, amplamente reconhecido por fornecer cálculos precisos e confiáveis, o que reforça a confiança dos usuários no software. Em contraste, algumas versões iniciais de calculadoras de software de código aberto ou menos maduras podem apresentar erros em suas operações matemáticas ou inconsistências, resultando em resultados incorretos e prejudicando a confiança dos usuários.
    - C. A ***pertinência funcional*** avalia se as funções do software são adequadas para as tarefas que se propõem a realizar. O Google Maps, por exemplo, possui uma alta pertinência funcional ao oferecer direções precisas e informações úteis para uma ampla gama de necessidades de navegação. Em contraste, o lançamento inicial do aplicativo de mapas da Apple enfrentou críticas significativas por não fornecer direções precisas e informações úteis, evidenciando uma inadequação na pertinência funcional para a navegação e a necessidade de melhorias substanciais.
  - `Desempenho`: avaliamos a rapidez com que o software responde e o quão eficientemente utiliza recursos; pode ser analisado sob três principais dimensões:
    - A. ***Comportamento em Tempo*** avalia a rapidez com que o software responde às ações dos usuários e executa suas funções. Exemplo positivo: serviço de streaming Netflix, e sua capacidade de carregar e reproduzir vídeos rapidamente, proporcionando uma experiência fluida e contínua para os usuários. Em contraste, muitos serviços de streaming mais antigos, com menos otimização, enfrentam problemas de buffering e atrasos, comprometendo a qualidade da experiência para os usuários.
    - B. ***Recursos Utilizados*** examina a eficiência com que o software utiliza recursos do sistema, como CPU e memória. O navegador Opera GX, projetado para gamers, exemplifica um uso eficiente de recursos ao oferecer ferramentas avançadas para gerenciar o consumo de CPU, memória e largura de banda, permitindo uma navegação mais eficiente e personalizável. Por outro lado, o navegador Google Chrome, apesar de sua popularidade, tem sido criticado por seu alto consumo de memória, o que demonstra uma gestão menos eficiente dos recursos do sistema.
    - C. ***Capacidade*** refere-se à habilidade do software em lidar com grandes volumes de dados e transações esperadas. O sistema de pagamento online PayPal é um exemplo positivo, sendo capaz de gerenciar eficazmente um grande volume de transações sem comprometer o desempenho. Em contraste, o lançamento inicial do jogo SimCity em 2013 apresentou um exemplo negativo, pois os servidores não conseguiram suportar o elevado número de jogadores simultâneos, resultando em uma experiência frustrante e insatisfatória para muitos usuários.
  - `Compatibilidade`: refere-se à capacidade do software de funcionar bem com outros sistemas e produtos. Esse conceito pode ser dividido em duas principais dimensões:
    - A. ***Coexistência***: refere-se à capacidade do software de operar sem conflitos junto a outros produtos no mesmo sistema. O Microsoft Office é um exemplo positivo, pois funciona de maneira eficiente em diversas versões do Windows e pode ser executado simultaneamente com muitos outros programas sem causar problemas. Por outro lado, o antivírus McAfee enfrentou problemas de coexistência no passado, resultando em conflitos e lentidão em sistemas que tinham outros softwares de segurança instalados.
    - B. ***Interoperabilidade***: diz respeito à habilidade do software em se comunicar e operar com outros sistemas ou produtos. O Slack exemplifica uma boa interoperabilidade, integrando-se facilmente com uma variedade de ferramentas de produtividade, como Google Drive, Trello e Zoom, o que permite uma comunicação e operação fluida entre diferentes sistemas. Em contraste, o Microsoft Internet Explorer teve dificuldades significativas de interoperabilidade, especialmente com padrões web modernos, o que levou a problemas de compatibilidade com muitos sites e aplicações web, gerando frustração entre usuários e desenvolvedores.
  - `Usabilidade`: analisamos se o software é fácil de entender e operar. Essa área pode ser dividida em cinco dimensões importantes:
    - A. ***Capacidade de ser entendido***: avalia se os usuários conseguem compreender como usar o software. Um exemplo positivo é o Gmail, que se destaca por sua interface clara e intuitiva, facilitando a navegação e o uso. Em contraste, sistemas de e-mail mais antigos, como o Outlook Express, eram frequentemente criticados por suas interfaces desatualizadas e complexas, o que tornava difícil para novos usuários aprenderem a utilizar o sistema de forma eficaz.
    - B. ***Capacidade de aprendizagem***: se refere à facilidade com que os usuários podem aprender a usar o software. O Canva é um exemplo notável aqui, oferecendo tutoriais interativos e uma interface amigável que permitem aos usuários aprender rapidamente a utilizar as funcionalidades do aplicativo. Por outro lado, softwares de design gráfico mais complexos, como o Adobe Photoshop, embora poderosos, podem apresentar uma curva de aprendizado acentuada devido à sua interface rica em recursos e à falta de tutoriais integrados.
    - C. ***Operacionalidade***: mede a facilidade com que os usuários podem operar e controlar o software. O Spotify ilustra bem essa característica, permitindo aos usuários navegar, buscar músicas e criar playlists de forma simples e direta. Em contraste, softwares de gerenciamento de mídia mais antigos, como o Winamp, tinham interfaces que, embora funcionais, poderiam ser menos intuitivas e mais difíceis de usar para alguns usuários.
    - D. ***Estética da interface do usuário***: considera se o software é visualmente atraente. O Apple iOS é um exemplo positivo, conhecido por seu design limpo e esteticamente agradável. Em contraste, alguns sistemas operacionais mais antigos, como o Windows XP, foram criticados por sua interface visualmente datada e menos elegante.
    - E. ***Acessibilidade***: analisa se o software é acessível a todos os usuários, incluindo aqueles com deficiências. O Windows 10 é um exemplo de boa prática, oferecendo várias ferramentas de acessibilidade, como o Narrador, opções de alto contraste e suporte a leitores de tela. Em contraste, sistemas operacionais mais antigos, como o Windows 98, ofereciam opções limitadas de acessibilidade, dificultando a interação dos usuários com deficiências com o sistema.
  - `Confiabilidade`: aborda a maturidade do software, a disponibilidade e a capacidade de recuperar-se de falhas; pode ser dividida em quatro dimensões importantes:
    - A. ***Maturidade***: refere-se à estabilidade e ao nível de refinamento do software ao longo do tempo. O sistema operacional macOS é um exemplo de alta maturidade, conhecido por sua estabilidade e contínuo aprimoramento ao longo dos anos. Em contraste, o lançamento inicial do Windows Vista exemplifica baixa maturidade, com inúmeros problemas e defeitos que marcaram seu início, afetando negativamente a confiança dos usuários.
    - B. ***Disponibilidade***: avalia se o software está acessível e operacional quando necessário. O serviço de e-mail Gmail é um exemplo de alta disponibilidade, mantendo uma taxa de uptime elevada e garantindo que os usuários possam acessá-lo quase sempre que precisarem. Em contraste, o serviço de internet da Comcast enfrentou críticas por interrupções frequentes e manutenção não programada, refletindo uma baixa disponibilidade e prejudicando a experiência dos usuários.
    - C. ***Tolerância a falhas***: mede a capacidade do software de lidar com falhas de maneira controlada. O Amazon Web Services (AWS) é um exemplo de boa tolerância a falhas, com mecanismos robustos para gerenciar falhas e assegurar a continuidade dos serviços. Por outro lado, a plataforma de rede social Orkut, desativada em 2014, teve dificuldades em gerenciar falhas e quedas, resultando em uma experiência negativa para os usuários.
    - D. ***Capacidade de recuperação***: considera a eficácia do software em se recuperar rapidamente de falhas. O sistema de banco de dados Oracle ilustra uma boa capacidade de recuperação, com funcionalidades avançadas que permitem uma rápida restauração após falhas. Em contraste, o serviço de streaming HBO Max enfrentou críticas devido à lentidão na recuperação de falhas durante picos de uso, como o lançamento de novos episódios de séries populares, o que resultou em uma experiência frustrante para os usuários.
  - e. `Segurança`: é crucial para proteger dados e informações contra acessos não autorizados; pode ser dividida em cinco dimensões importantes: 
    - A. ***Confidencialidade***: refere-se à proteção de informações contra acesso não autorizado. Um exemplo positivo é o LastPass, um gerenciador de senhas que emprega criptografia forte para assegurar que apenas o usuário autorizado possa acessar suas informações. Em contraste, o vazamento de dados do Equifax em 2017 revelou falhas significativas na proteção de informações confidenciais, permitindo o acesso não autorizado a dados sensíveis de milhões de pessoas.
    - B. ***Integridade***: capacidade do software de prevenir modificações não autorizadas nos dados. O sistema de gerenciamento de banco de dados PostgreSQL é um bom exemplo de integridade robusta, com controles de acesso e verificações de consistência que garantem a integridade dos dados. Por outro lado, o software de compartilhamento de arquivos Dropbox enfrentou preocupações sobre a integridade dos dados após incidentes de sincronização errônea que poderiam levar à perda ou corrupção de arquivos.
    - C. ***Não-repúdio***: envolve a capacidade do software de fornecer provas de ações realizadas. O blockchain do Bitcoin é um exemplo de sistema que oferece um registro imutável e verificável de todas as transações, garantindo que as partes envolvidas não possam negar as ações realizadas. Em contraste, muitos sistemas antigos de e-mail não forneciam logs detalhados ou mecanismos adequados de rastreamento, tornando difícil provar ações realizadas e gerando desafios em auditorias e investigações.
    - D. ***Autenticidade***: é a verificação da identidade dos usuários pelo software. O sistema de autenticação multifator (MFA), utilizado por serviços como Google e Microsoft, exige múltiplos métodos de verificação para garantir que o usuário seja quem afirma ser. Em contraste, o serviço de e-mail Yahoo enfrentou críticas por falhas na autenticação que permitiram a invasão de contas de usuários, comprometendo a segurança da identidade.
    - E. ***Responsabilidade***: refere-se à capacidade do software de rastrear ações dos usuários. O sistema de gestão de projetos JIRA é um exemplo positivo, fornecendo um histórico detalhado de ações e alterações feitas pelos usuários, o que permite a auditoria e rastreamento de atividades. Em contraste, muitos sistemas legados de gestão de conteúdo careciam de mecanismos adequados de rastreamento, dificultando a identificação de quem fez o quê em caso de problemas ou alterações inesperadas.
  - `Manutenibilidade`: característica crucial para garantir que o software possa ser facilmente ajustado e melhorado ao longo do tempo; pode ser avaliada em cinco dimensões:
    - A. ***Modularidade***: refere-se à estrutura do software em partes independentes, facilitando a manutenção e atualização. Um exemplo positivo é o sistema de gerenciamento de conteúdo WordPress, que é construído com uma arquitetura modular que permite a adição e remoção de plugins de forma independente, sem afetar o núcleo do sistema. Em contraste, softwares monolíticos dificultam a separação e manutenção de partes específicas do sistema, tornando as atualizações e correções mais complexas.
    - B. ***Reusabilidade***: capacidade de reutilizar componentes do software em diferentes contextos. A biblioteca Python NumPy é um exemplo, fornecendo ampla gama de funções matemáticas e operações em arrays que podem ser reutilizadas em diversos projetos de ciência de dados e cálculos numéricos. Em contraste, muitos sistemas antigos de CRM, com código altamente específico e não modular, apresentavam dificuldades para a reutilização, resultando em maior esforço e custo para adaptar o software a novas necessidades.
    - C. ***Analisabilidade***: refere-se à facilidade com que o software pode ser diagnosticado e corrigido. O serviço de monitoramento Datadog é um bom exemplo, oferecendo uma visão abrangente e detalhada do desempenho do software, permitindo a coleta de métricas, logs e rastreamentos. Isso facilita a identificação e resolução de falhas, bem como análise de problemas complexos. Por outro lado, sistemas legados que não utilizam ferramentas avançadas de monitoramento ou possuem documentação insuficiente podem ser difíceis de analisar e corrigir, aumentando o tempo e custo de manutenção.
    - D. ***Modificabilidade***: é a facilidade com que o software pode ser alterado. O framework de desenvolvimento ágil Scrum exemplifica essa característica ao permitir a adaptação contínua do software para atender a novas necessidades e mudanças de forma ágil e flexível. Em contraste, softwares desenvolvidos sem considerar boas práticas de engenharia, como o uso excessivo de código hard-coded, podem ser difíceis de modificar e atualizar, resultando em problemas adicionais durante as alterações.
    - E. ***Testabilidade***: refere-se à capacidade de testar o software de forma eficaz. O uso do BDD (Behavior-Driven Development) com Java é um exemplo positivo, utilizando ferramentas como Cucumber para criar testes baseados em comportamentos esperados do software, escritos em Gherkin, facilmente compreendidos por todas as partes interessadas. Isso facilita a validação das funcionalidades do software de forma colaborativa e acessível. Em contraste, sistemas legados com baixa cobertura de testes e alta complexidade podem ser difíceis de testar eficazmente, aumentando o risco de defeitos não detectados.
  - `Portabilidade`: avalia a facilidade de adaptação do software; pode ser avaliada em três dimensões:
    - A. ***Adaptabilidade***: descreve a habilidade do software de se ajustar a diferentes ambientes e plataformas. Um exemplo é o framework Flutter, desenvolvido pelo Google, que permite criar aplicações para web e mobile com um único código-base. Isso proporciona uma adaptação eficiente a diferentes plataformas e dispositivos. Em contraste, muitos aplicativos legados desenvolvidos com tecnologias desatualizadas enfrentam dificuldades significativas para se adaptar a novos ambientes ou plataformas. Esses aplicativos frequentemente requerem grandes esforços para ajustes e modificações, tornando o processo de adaptação mais oneroso e complexo.
    - B. ***Instalabilidade***: refere-se à capacidade do software de ser instalado em diferentes ambientes. O uso de Java, combinado com ferramentas como Maven ou Gradle, é um exemplo de boa prática. Essas ferramentas ajudam no gerenciamento de dependências e na construção de projetos, facilitando a instalação e configuração de aplicações Java em uma variedade de ambientes, desde servidores até ambientes de desenvolvimento e produção. Por outro lado, softwares antigos que exigem configurações complexas ou dependem de versões específicas de bibliotecas podem enfrentar desafios ao serem instalados em ambientes modernos. Esses desafios frequentemente resultam em problemas de compatibilidade e instalação, complicando o processo e gerando frustrações.
    - C. ***Substitutibilidade***: é a capacidade do software de substituir outro produto de software em um determinado ambiente. O navegador Firefox é um exemplo de software que pode substituir outros navegadores, como Internet Explorer ou Safari, oferecendo compatibilidade e funcionalidade semelhantes. Isso demonstra uma alta capacidade de substituição em vários ambientes de uso. Em contraste, sistemas de gerenciamento de banco de dados altamente específicos e proprietários podem ter dificuldades para substituir soluções concorrentes. Isso se deve às diferenças nas características e compatibilidades dos dados e funcionalidades, o que pode limitar a eficácia da substituição e exigir adaptações adicionais.

<div align="center">
<img src="./assets/modelo-qualidade-produto.png" width="80%"><br>
<em>Diagrama qualidade do produto.</em><br>
</div>

> A combinação desses dois modelos permite uma análise completa da qualidade do software, incluindo tanto a perspectiva do usuário final quanto os aspectos técnicos internos do produto.

## 1.3 Testes de Software - ISO/IEC 29119

- a ISO/IEC 29119 estabelece uma série de normas internacionais que uniformizam os processos de teste de software. 
- essas normas foram criadas para fornecer uma base de dados uniforme e consistente, com o objetivo de assegurar a qualidade e a eficiência dos processos de teste em diversos setores e contextos. A
- a série ISO/IEC 29119 abrange diversas áreas fundamentais do teste de software, tais como processos, documentação e técnicas de teste, contribuindo para a melhoria das práticas e facilitando a comunicação entre as partes interessadas.

### 1.3.1 Componentes principais - ISO/IEC 29119

- os termos e conceitos fundamentais que estão relacionados aos testes de software, estabelecendo uma base comum para a compreensão e comunicação entre profissionais da área.
- algumas recomendações de acordo com a ISO/IEC 29119:

	- `Teste funcional`:
		- é um método de verificação que se concentra em assegurar que o sistema esteja funcionando conforme as especificações estabelecidas. 
		- esse tipo de teste valida se o comportamento do sistema está alinhado com as especificações funcionais. 
		- durante a execução de testes funcionais, o foco está em confirmar se todas as funcionalidades do software operam de acordo com os requisitos definidos, o que pode incluir a verificação de funcionalidades específicas, como login do usuário, geração de relatórios e execução de operações básicas do sistema. 
		- o principal objetivo é garantir que o sistema atenda aos requisitos funcionais e realize as operações desejadas de maneira adequada.
	- `Teste não-funcional`:
		- avalia aspectos do sistema que não estão diretamente relacionados à sua funcionalidade principal, como desempenho, usabilidade e segurança. 
		- esses testes visam garantir que o software, além de funcionar corretamente, também se comporte adequadamente sob diferentes condições de carga, oferecendo uma experiência de usuário satisfatória e sendo seguro contra ameaças potenciais. 
		- por exemplo, testes de desempenho verificam a capacidade do sistema em lidar com grandes volumes de dados e usuários simultaneamente, enquanto testes de segurança avaliam as vulnerabilidades e a proteção de dados sensíveis. 
		- a garantia proporcionada por esses testes é que o sistema oferece uma experiência de uso eficiente e segura, mesmo em condições variadas.

- pensando no teste em si ele é um conjunto de condições ou variáveis que permite determinar se um sistema atende às especificações estabelecidas. 
- para realizar testes de forma eficaz, é necessário estabelecer claramente os critérios de aceitação e os resultados esperados. 
- os testes devem ser planejados e projetados de acordo com as necessidades, especificações e cenários de uso do sistema. 
- é essencial garantir que os testes avaliem tanto os aspectos funcionais quanto os não funcionais do software para uma avaliação completa do seu desempenho.
- outro ponto importante e o `relatório de teste`, um documento que descreve as atividades e os resultados dos testes realizados. 
	- um relatório de qualidade inclui informações detalhadas sobre o escopo dos testes, os casos de teste executados, os resultados obtidos e quaisquer defeitos encontrados. 
	- ele fornece uma visão clara do status do software e da sua qualidade geral, auxiliando os stakeholders na tomada de decisões informadas sobre a liberação do produto ou a necessidade de correções adicionais.

### 1.3.2 Maximizar resultados dos testes - ISO/IEC 29119

- em ambientes de desenvolvimento de software, a priorização e o foco dos testes são essenciais para garantir a qualidade do produto final. 
- dependendo da complexidade e das características do produto, diferentes áreas devem receber atenção especial:
	- para ***produtos de alta complexidade***, como sistemas de gerenciamento empresarial ou aplicações que envolvem integrações complexas, é crucial concentrar-se tanto em testes funcionais detalhados quanto em testes de integração e de sistema integrado. 
		- esses testes asseguram que a interação entre diferentes módulos e sistemas externos esteja funcionando corretamente, garantindo a integridade e a funcionalidade geral do sistema.
	- em ***produtos com grande visibilidade***, como redes sociais ou plataformas de e-commerce, a usabilidade e a experiência do usuário são fundamentais. 
		- além dos estes funcionais, é essencial investir em testes de usabilidade e de desempenho para assegurar uma experiência fluida e satisfatória para os usuários finais. 
		- esses testes ajudam a identificar e corrigir problemas que possam impactar negativamente a interação do usuário com a plataforma.
	- para ***produtos que lidam com dados sensíveis***, como sistemas bancários e de saúde, o foco deve ser em testes de segurança rigorosos. 
		- estes testes devem incluir a identificação de vulnerabilidades e a validação das medidas de proteção contra possíveis ataques, garantindo que o sistema esteja robusto e seguro contra ameaças externas.
- com essa estratégia, o que podemos garantir e que os testes verificam que o software atende aos requisitos estabelecidos e funciona de acordo com o esperado.
- eles fazem uma análise da qualidade do sistema, identificando e corrigindo defeitos antes de liberar. 
- além disso, os testes asseguram que o software é robusto, seguro e proporciona uma experiência de usuário satisfatória, o que contribui para a redução de riscos e melhoria da confiabilidade do produto final.

### 1.3.3 Processos de teste - ISO/IEC 29119

- os processos de teste descritos na ISO/IEC 29119 fornecem uma estrutura sistemática para a gestão e execução de testes de software. 
- são divididos em diversas tarefas principais, cada uma com suas próprias subatividades e saídas esperadas.
- algumas recomendações de acordo com a ISO/IEC 29119:
	- 1. para garantir uma abordagem eficaz aos testes, o `planejamento`é essencial.
		- inicialmente, é necessário definir os objetivos de teste, estabelecendo metas claras sobre o que se espera alcançar com as atividades de teste. 
		- em seguida, é importante desenvolver uma estratégia de teste, que delineia a abordagem geral para a execução dos testes, incluindo métodos e ferramentas a serem utilizados. 
		- o planejamento deve também envolver a determinação dos recursos necessários, como pessoal e ferramentas, e a criação de um cronograma detalhado para garantir que as atividades de teste sejam realizadas dentro dos prazos estabelecidos.
	- 2. durante a fase de execução dos testes, o `monitoramento` contínuo do progresso é crucial. 
		- isso envolve acompanhar o andamento das atividades de teste em relação ao plano estabelecido, assegurando que tudo esteja conforme o previsto.
		- o controle de mudanças também é uma parte fundamental, gerenciando quaisquer alterações no escopo ou nos requisitos dos testes que possam surgir.
		- relatórios de status de teste devem ser fornecidos regularmente aos stakeholders, oferecendo atualizações sobre o andamento dos testes e quaisquer problemas identificados.
	- 3. a `análise` e o `projeto dos testes` começam com a identificação das condições de teste, definindo os requisitos específicos que precisam ser avaliados. 
		- com base nessas condições, são desenvolvidos casos de teste detalhados, que guiarão a execução dos testes.
		- a preparação de dados de teste é outra etapa crítica, garantindo que todos os dados necessários estejam disponíveis e corretos para a realização dos testes.
	- 4. na fase de `implementação` e `execução` dos testes, o ambiente de teste deve ser configurado adequadamente para garantir que os testes sejam realizados em condições controladas. 
		- os casos de teste são então executados conforme o planejado, e os resultados são registrados cuidadosamente, incluindo qualquer defeito encontrado durante o processo.
	- 5. após a execução dos testes, é necessário avaliar se os critérios de saída foram satisfeitos e se os objetivos de teste foram atingidos; um `relatório` detalhado dos testes deve ser preparado, documentando os resultados obtidos e quaisquer problemas remanescentes. 
		- este relatório fornece uma visão clara do estado do software e ajuda na tomada de decisões sobre a continuidade do projeto.
	- 6. o encerramento dos testes envolve a `revisão` da `eficiência` e `eficácia` das atividades realizadas, identificando áreas para melhoria. 
		- toda a documentação de teste deve ser arquivada para referência futura, e as lições aprendidas devem ser documentadas para aprimorar futuros projetos de teste. 
		- esse processo finaliza a fase de teste e estabelece uma base sólida para o desenvolvimento contínuo e aprimoramento do software.

### 1.3.4 Documentação do teste - ISO/IEC 29119

- a elaboração e os tipos de documentação de teste são aspectos cruciais para o processo de teste de software, conforme definido pela norma ISO/IEC 29119. 
- a documentação é fundamental para garantir um teste eficaz e organizado, pois abrange uma série de documentos essenciais que suportam o planejamento, o acompanhamento e o relato dos testes e elas são divididas em:
***documentação organizacional***, ***projeto*** e ***nível de teste***. 

- 1. `Documentação organizacional`: inclui a Política de Teste e a Estratégia de Teste. 
	- ***Política de Teste***:
		- define a abordagem geral e os princípios orientadores para os testes em toda a organização.
		-  estabelece as diretrizes e normas que devem ser seguidas para garantir uma abordagem consistente e eficaz em todos os projetos de teste. 
	- ***Estratégia de Teste***: 
		- detalha a abordagem de teste para toda a organização, abrangendo as metodologias, ferramentas e processos a serem utilizados para atingir os objetivos de qualidade.

- 2. `Projeto`: dentro da documentação de projeto, destacam-se o Plano de Teste do Projeto e o Relatório de Conclusão do Projeto de Teste. 
	- ***Plano de Teste do Projeto***:
		- é um documento que planeja as atividades de teste para um projeto específico, incluindo a definição dos objetivos de teste, a criação de casos de teste e a programação das atividades. 
		- este plano é crucial para garantir que os testes sejam realizados de acordo com as especificações e requisitos do projeto. 
	- ***Relatório de Conclusão do Projeto de Teste***:
		-  resume os resultados e avalia a eficácia dos testes realizados. 
		- fornece uma visão geral do desempenho do software e da qualidade alcançada, ajudando os stakeholders a tomar decisões informadas sobre a liberação do produto e possíveis ações futuras.
		- essas recomendações ajudam a garantir que a documentação de teste seja completa, bem estruturada e alinhada com os objetivos e requisitos dos projetos de teste, contribuindo para a eficácia e a transparência do processo de teste de software.

- 3. `Nível de teste`:
	- crucial para garantir uma gestão eficaz dos testes em cada fase do processo de teste de software. 
	- de acordo com a norma ISO/IEC 29119, a documentação inclui vários tipos de documentos, cada um com um papel específico no planejamento, execução e análise dos testes.
	- lista dos tipos:
		- A. ***Plano de Teste***: detalha o plano para um nível específico de teste, estabelecendo os objetivos, o escopo e a abordagem do teste. A Especificação de Teste descreve os casos de teste que devem ser executados e os critérios de aceitação que definem o sucesso dos testes. Os Resultados de Teste documentam o desempenho do software durante a execução dos testes,  fornecendo uma visão clara sobre os resultados obtidos.
		- B.  ***Relatórios de Anomalias***: registram quaisquer defeitos ou problemas encontrados durante os testes, facilitando a rastreabilidade e a resolução das falhas. O Relatório de Status de Nível de Teste oferece atualizações sobre o progresso dos testes em um nível específico, informando sobre o andamento e quaisquer desvios em relação ao plano original.
		- C. ***Relatório do Ambiente de Teste***: descreve as características e configurações do ambiente onde os testes foram realizados, garantindo que os resultados sejam interpretados no contexto adequado. Por fim, o Relatório de Conclusão de Nível de Teste fornece um resumo final dos resultados e da eficácia dos testes em um nível específico, oferecendo uma visão geral da qualidade do software e da conclusão das atividades de teste.

- em resumo, a documentação do teste desempenha um papel fundamental no processo de teste de software, conforme definido pela norma ISO/IEC 29119. 
- ela abrange uma variedade de documentos que são essenciais para garantir a organização, a eficiência e a eficácia dos testes. 
- a documentação de teste ajuda a estruturar o planejamento, o acompanhamento e a avaliação dos testes, assegurando que todas as etapas sejam bem gerenciadas e que os resultados sejam claros e compreensíveis.

### 1.3.5 Técnicas de teste - ISO/IEC 29119

- as técnicas de teste descritas na norma ISO/IEC 29119 são métodos sistemáticos utilizados para criar e testar situações de teste com o objetivo de identificar defeitos e validar o software. 
- algumas recomendações de acordo com a ISO/IEC 29119:
	- `técnicas de teste`: essenciais para garantir a qualidade do software e podem ser divididas em duas categorias principais: técnicas baseadas em especificações e técnicas baseadas na estrutura do código. Cada abordagem oferece métodos distintos para identificar e corrigir defeitos, proporcionando uma avaliação mais abrangente do sistema. 
	- `técnicas baseadas em especificações` incluem a análise de valor limite, que consiste em testar as bordas dos intervalos de entrada para verificar como o sistema lida com valores extremos e limites de dados. Isso ajuda a identificar problemas que podem ocorrer em pontos críticos. Os grafos de causa-efeito relacionam causas e seus efeitos para determinar quais combinações de condições e ações devem ser testadas, visualizando a relação entre diferentes fatores que podem influenciar o comportamento do sistema. O método da árvore de classificação utiliza uma estrutura hierárquica para organizar e testar diferentes combinações de variáveis e suas possíveis interações, facilitando a cobertura de diferentes cenários e combinações.
	- `teste combinatório`: foca na combinação de diferentes entradas para explorar como essas combinações afetam o comportamento do sistema, sendo útil para verificar a interação entre múltiplas variáveis. Os testes de tabela de decisão avaliam combinações de condições e ações, utilizando tabelas para representar e testar todas as possíveis situações que podem ocorrer no sistema. O particionamento de equivalência divide as entradas possíveis em classes de equivalência, testando uma amostra representativa de cada classe para garantir que o sistema funcione corretamente para todos os casos da classe. A adivinhação de erros baseia-se na experiência e intuição do testador para prever onde erros podem ocorrer, ajudando a identificar áreas críticas que podem não ser cobertas por outras técnicas.
	- `testes aleatórios`: selecionam entradas de forma aleatória para testar o sistema, descobrindo problemas inesperados e garantindo uma cobertura ampla sem depender de uma estrutura específica. Os testes de cenário baseiam-se em histórias ou cenários de uso real para testar o sistema, simulando como os usuários interagem com o software em diferentes situações. Os testes de transição de estado verificam as mudanças de estado do sistema para garantir que ele transita corretamente entre diferentes condições e realiza as ações esperadas. Por fim, os testes de sintaxe avaliam a conformidade do sistema com as regras sintáticas específicas, verificando se o software segue as normas e padrões definidos para a linguagem ou formato.
	- `técnicas baseadas na estrutura do código` incluem o teste de ramificação ou decisão, que verifica todos os ramos e decisões do código, assegurando que cada caminho possível seja testado para identificar falhas em diferentes ramificações do fluxo de controle. O teste de condição de ramificação foca na verificação de todas as combinações possíveis de condições dentro das ramificações do código, garantindo que todas as condições sejam testadas adequadamente. A cobertura de declaração testa cada declaração no código para assegurar que todas as partes do código sejam executadas pelo menos uma vez durante os testes.

- essas técnicas oferecem uma abordagem estruturada e sistemática para a realização de testes, garantindo que diferentes aspectos do software sejam cuidadosamente verificados e avaliados.

### 1.3.6 Testes baseados em palavras chaves - ISO/IEC 29119

- testes baseados em keywords na norma ISO/IEC 29119 é uma abordagem em que as ações de teste são representadas por palavras-chave. 
- essas palavras-chave são associadas a operações específicas que o sistema deve realizar, e o teste é estruturado usando essas palavras-chave para definir o fluxo do teste e as verificações a serem feitas.
- algumas recomendações de acordo com a ISO/IEC 29119:
	- o processo de automação de testes usando palavras-chave segue uma abordagem que facilita a criação e manutenção de testes de forma eficiente. 
	- o funcionamento deste método começa com a definição de palavras-chave que representam ações e verificações comuns no teste, como "clicar", "preencher" e "verificar". 
	- cada uma dessas palavras-chave está associada a uma função específica no código de teste, permitindo que os casos de teste sejam descritos de maneira mais intuitiva e próxima da linguagem natural.
	- a criação de casos de teste é então realizada utilizando essas palavras-chave, o que simplifica o processo de desenvolvimento dos testes. 
	- testadores, mesmo aqueles com menos experiência técnica, podem criar testes de forma mais acessível, sem a necessidade de escrever código complexo. 
	- palavras-chave facilitam a comunicação dos requisitos e das ações esperadas, tornando a criação de testes mais direta e compreensível.
- entre as principais vantagens desse método estão a simplicidade, a reutilização e a manutenção facilitada. 
	- a simplicidade é uma característica notável, pois permite que testes sejam criados e mantidos de maneira mais acessível, especialmente para testadores que não possuem um profundo conhecimento técnico. 
	- a reutilização das palavras-chave em diferentes testes contribui para uma maior eficiência e consistência, já que uma única palavra-chave pode ser aplicada em vários cenários de teste.
	- a manutenção é facilitada, pois atualizações nas funcionalidades ou nas interfaces do software podem ser realizadas apenas nas implementações das palavras-chave, sem a necessidade de modificar todos os casos de teste individualmente.

- exemplo: considere um caso de teste para verificar o login em uma aplicação:
	- 1) Palavras-chave definidas.
	- 2) Abrir Navegador.
	- 3) Ir para URL.
	- 4) Preencher Campo.
	- 5) Clicar Botão.
	- 6) Verificar Texto.

<div align="center">

Ação | Parâmetro 1 | Parâmetro 2
-------|----------------|------------
Abrir Navegador | | 
Ir para URL | https://example.com/login | 
Preencher Campo | username | user123
Preencher Campo| password | pass123
Clicar Botão | login | 
Verificar Texto | Bem-vindo | user123

</div>

- ou seja, a norma ISO/IEC 29119 é uma ferramenta valiosa para qualquer empresa que queira aprimorar a qualidade do seu software e a eficiência dos seus testes. 
- a aplicação das diretrizes e práticas recomendadas pela norma não só aumenta a confiabilidade do software, como também cria uma cultura de qualidade e excelência nas equipes de desenvolvimento e teste.

## 1.4 Custo e benefício no processo de qualidade

- a implementação de um processo de qualidade robusto pode envolver custos significativos, mas frequentemente resulta em economias substanciais a longo prazo.
- investir em práticas e processos de qualidade pode demandar investimentos substanciais em diversas áreas, incluindo ferramentas e tecnologias, treinamento e desenvolvimento, além de tempo e recursos.
- a aquisição de ferramentas avançadas para testes de software é uma das principais áreas de investimento. 
- plataformas de automação de testes, ferramentas de gerenciamento de defeitos e soluções de monitoramento podem representar um custo considerável. 
- ferramentas como Selenium, Postman e Datadog, por exemplo, são essenciais para garantir uma abordagem abrangente e eficiente, mas podem exigir um investimento financeiro significativo.
- além disso, o treinamento e o desenvolvimento da equipe são fundamentais para a eficácia de um processo de qualidade. 
- o treinamento contínuo das equipes e a contratação de especialistas em qualidade, com expertise em metodologias como Test-Driven Development (TDD) e Behavior-Driven Development (BDD), representam custos adicionais. 
- outro aspecto relevante é o tempo e os recursos dedicados ao processo de teste: planejamento, execução e revisão dos testes exigem um investimento considerável de tempo e esforço. 
- apesar desses custos iniciais, os benefícios de implementar um processo de qualidade robusto são evidentes a longo prazo: redução de defeitos, a melhoria da satisfação do cliente e a minimização de retrabalho são apenas algumas das vantagens que podem compensar os investimentos feitos, resultando em economias e ganhos operacionais significativos.

### 1.4.1 Economias e benefícios a longo prazo

- investir em qualidade pode envolver um custo inicial elevado, mas os benefícios a longo prazo frequentemente compensam esses investimentos. 
- o aprimoramento da qualidade de software oferece economias significativas e diversos benefícios que impactam positivamente a sustentabilidade e o sucesso de uma organização.
- uma das principais vantagens é a redução de defeitos e retrabalho. Implementar um processo de qualidade eficaz permite identificar e corrigir problemas nas fases iniciais do desenvolvimento, o que é geralmente muito mais econômico do que resolver falhas após o lançamento do produto. 
- a correção de defeitos durante o desenvolvimento é consideravelmente mais barata do que as correções necessárias após a liberação, o que pode reduzir significativamente os custos associados a ajustes posteriores.
- além disso, produtos de alta qualidade tendem a aumentar a satisfação do cliente e a reduzir a taxa de churn, que é a taxa de abandono de clientes ou usuários de um produto ou serviço. 
	- quando um produto atende ou supera as expectativas dos usuários, a satisfação do cliente aumenta, o que resulta em maior lealdade e menores taxas de abandono. 
	- isso não apenas melhora a percepção da marca, mas também contribui para a fidelização do cliente e para a construção de uma base de usuários mais estável.
- outro benefício importante é a redução dos custos de suporte e manutenção: produtos com menor número de defeitos e maior confiabilidade exigem menos suporte técnico e manutenção, o que reduz os custos operacionais associados a essas atividades. 
	- empresas líderes no setor, como Microsoft e Google, reconhecem a importância desse investimento e aplicam práticas rigorosas de qualidade para minimizar problemas e reduzir a demanda por suporte.
- por fim, processos de qualidade bem definidos podem melhorar a eficiência operacional. 
	- ao implementar métodos eficazes de teste e controle de qualidade, é possível reduzir o tempo de desenvolvimento e acelerar o lançamento de novos produtos. 
	- essa eficiência não só melhora a capacidade de resposta da empresa às demandas do mercado, mas também otimiza o uso de recursos e melhora a agilidade organizacional.
- portanto, apesar do custo inicial, os benefícios a longo prazo de investir em qualidade gera a redução de defeitos, aumento da satisfação do cliente, diminuição dos custos de suporte e manutenção, e melhoria da eficiência operacional que frequentemente superam os investimentos feitos. 
- a qualidade não só garante um produto final mais confiável, mas também proporciona uma vantagem competitiva significativa e contribui para a sustentabilidade e sucesso da empresa.

--- 

## FAST TEST

### 1. Assinale a alternativa que completa corretamente a frase a seguir: "O _____________ se concentra nas funcionalidades do software sem considerar sua estrutura interna. O testador não possui conhecimento sobre o código-fonte e foca apenas nas entradas e saídas para verificar se o software atende aos requisitos definidos.".
> Teste de caixa preta.

### 2. O que são testes de regressão?
> Testes que verificam se alterações no código introduziram novos defeitos em partes já testadas do software.

### 3. O que são testes de unidade?
> Testes realizados no nível do código-fonte e focados em métodos e funções individuais.

### 4. Leia a frase a seguir: "Alguns testes de software oferecem uma abordagem diferenciada, sem seguir um roteiro predefinido. Esse tipo de teste costuma utilizar uma abordagem criativa e intuitiva. Estamos nos referindo a qual tipo de teste?
> Testes exploratórios.

--- 

[Voltar ao início!](https://github.com/monicaquintal/smart_cities)